package com.github.kabal163.java.problems.network;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class PC {

    private static final int DEFAULT_PORTS_NUM = 1;
    private static final int MAX_PORTS_NUM = 5;
    private static final String PORT_NUMBER_FORMAT = "%s[%d]";

    private final String ip;
    private final List<Port> ports;

    public PC(String ip) {
        this(ip, DEFAULT_PORTS_NUM);
    }

    public PC(String ip, int portsNumber) {
        this.ip = ip;
        this.ports = newPorts(portsNumber);
    }

    public boolean hasAvailablePorts() {
        return ports.stream().anyMatch(Port::isAvailable);
    }

    public void connect(Cable cable) {
        ports.stream()
            .filter(Port::isAvailable)
            .findFirst()
            .ifPresentOrElse(
                port -> port.connect(cable),
                () -> {
                    throw new IllegalStateException(
                        "Impossible to connect cable = %s. No available ports".formatted(cable.id())
                    );
                }
            );
    }

    public List<PC> neighbors() {
        return ports.stream()
            .filter(port -> !port.isAvailable())
            .map(Port::connectedPc)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PC pc = (PC) o;
        return Objects.equals(ip, pc.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }

    @Override
    public String toString() {
        return "PC{" +
            "ip=" + ip +
            '}';
    }

    private List<Port> newPorts(int amount) {
        if (amount > MAX_PORTS_NUM) {
            throw new IllegalArgumentException(
                "Max amount of ports is %s, but actual is %s".formatted(MAX_PORTS_NUM, amount)
            );
        }

        return IntStream.range(0, amount)
            .boxed()
            .map(i -> new Port(PORT_NUMBER_FORMAT.formatted(ip, i), this))
            .toList();
    }
}
