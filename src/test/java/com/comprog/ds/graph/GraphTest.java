package com.comprog.ds.graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private static Graph graph;

    @BeforeAll
    public static void init() {
        graph = new Graph();
        graph.addEdge("Priyanka", "Anmol");
        graph.addEdge("Anmol", "Pratik");
        graph.addEdge("Ankur", "Pritam");
        graph.addEdge("Pratibha", "Priyanka");
    }

    @Test
    public void whenVertexNotPresentAndNewEdgeIsAdded_thenNewVertexAndEdgeGetsAdded() {
        graph.addEdge("Priyanka", "Alexa");
        graph.printGraph();

        Vertex v1 = new Vertex("Priyanka");
        Vertex v2 = new Vertex("Alexa");
        assertTrue(graph.adjVertices.containsKey(v1));
        assertTrue(graph.adjVertices.containsKey(v2));
        assertTrue(graph.adjVertices.get(v1).contains(v2));
        assertTrue(graph.adjVertices.get(v2).contains(v1));
    }
}