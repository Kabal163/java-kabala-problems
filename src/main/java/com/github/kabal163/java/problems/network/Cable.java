package com.github.kabal163.java.problems.network;

import java.util.Objects;
import java.util.Optional;

public class Cable {

    private final int id;
    private Port left;
    private Port right;

    public Cable(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }

    public void connect(Port port) {
        if (left == null) {
            left = port;
            return;
        }

        if (right == null) {
            right = port;
            return;
        }

        throw new IllegalStateException(
            "Impossible to connect cable = %s. Cable is already in use.".formatted(id)
        );
    }

    public Optional<Port> otherSide(Port thisSide) {
        Port otherSide = thisSide.equals(right) ? left : right;

        return Optional.ofNullable(otherSide);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cable cable = (Cable) o;
        return Objects.equals(id, cable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cable{" +
            "id=" + id +
            '}';
    }
}
