package com.comprog.ds.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

class Vertex {
    String label;
    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
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

public class Graph {
    Map<Vertex, List<Vertex>> adjVertices;

    public Graph() {
        adjVertices = new HashMap<>();
    }

    public void addEdge(String labelA, String labelB) {

        Vertex v1 = new Vertex(labelA);
        Vertex v2 = new Vertex(labelB);

        //Create Vertices if not present
        adjVertices.putIfAbsent(new Vertex(labelA), new ArrayList<>());
        adjVertices.putIfAbsent(new Vertex(labelB), new ArrayList<>());

        //Insert edge
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);

    }

    public void removeEdge(String labelA, String labelB) {

        Vertex v1 = new Vertex(labelA);
        Vertex v2 = new Vertex(labelB);

        List<Vertex> edgesFromV1 = adjVertices.get(v1);
        List<Vertex> edgesFromV2 = adjVertices.get(v2);

        if(edgesFromV1 != null)
            edgesFromV1.remove(v2);
        if(edgesFromV2 != null)
            edgesFromV2.remove(v1);

    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(edges -> edges.remove(v));
        adjVertices.remove(v);
    }

    public void printGraph() {
        adjVertices.entrySet().stream().forEach(entry -> {
            System.out.print(entry.getKey() + " > ");
            entry.getValue().forEach(v -> System.out.print(v + " "));
            System.out.println();
        });
    }


}
