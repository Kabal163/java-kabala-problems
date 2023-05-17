package com.github.kabal163.java.problems.network;

import java.util.Objects;
import java.util.Optional;

public class Port {

    private final String id;
    private final PC pc;
    private Cable cable;

    public Port(String id, PC pc) {
        this.id = id;
        this.pc = pc;
    }

    public String id() {
        return id;
    }

    public PC pc() {
        return pc;
    }

    public boolean isAvailable() {
        return cable == null;
    }

    public void connect(Cable cable) {
        if (isAvailable()) {
            this.cable = cable;
            this.cable.connect(this);
            return;
        }

        throw new IllegalStateException(
            "Impossible to connect cable = %s with port. Port is already in use".formatted(cable.id())
        );
    }

    public Optional<PC> connectedPc() {
        return Optional.ofNullable(cable)
            .flatMap(cable -> cable.otherSide(this))
            .map(Port::pc);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Port port = (Port) o;
        return Objects.equals(id, port.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Port{" +
            "id=" + id +
            '}';
    }
}
