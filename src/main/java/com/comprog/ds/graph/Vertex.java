package com.comprog.ds.graph;

import java.util.Objects;

public class Vertex<T> {
    T label;
    public Vertex(T label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return label == vertex.label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
