package com.comprog.ds.graph;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;



public class Graph<T> {
    Map<Vertex, List<Vertex<T>>> adjVertices;

    public Graph() {
        adjVertices = new HashMap<>();
    }

    public Map<Vertex, List<Vertex<T>>> get() {
        return adjVertices;
    }

    public List<Vertex<T>> getAdjVertices(T v) {
        return adjVertices.get(new Vertex(v));
    }

    public int getVertexCount() {
        return adjVertices.size();
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

    public void removeEdge(T labelA, T labelB) {

        Vertex v1 = new Vertex(labelA);
        Vertex v2 = new Vertex(labelB);

        List<Vertex<T>> edgesFromV1 = adjVertices.get(v1);
        List<Vertex<T>> edgesFromV2 = adjVertices.get(v2);

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
            System.out.println(entry.getValue().stream().map(v -> v.toString()).collect(Collectors.joining(", ", "[", "]")));
        });
    }


}
