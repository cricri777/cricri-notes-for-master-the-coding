package ca.cricri.mtc.structurededonnee;

import java.util.*;

/**
 * Directed vs Undirected
 * Weighted vs Unweighted
 * Cyclic vs Acyclic
 *
 *
 * i.e edge list : graph = [[0,2], [2,3], [2,1], [1,3]]
 * adjacent list : graph = [[2], [2,3], [0,1,3], [1,2]]
 * adjacent matrix : graphe = [
 *                              [0,0,1,0]
 *                              [0,0,1,1]
 *                              [1,1,0,1]
 *                              [0,1,1,0]
 *                            ]
 */
public class Graph {
    private final HashMap<String, List<String>> adjacentList;
    private int numberOfNodes;

    public Graph(){
        this.numberOfNodes = 0;
        this.adjacentList = new HashMap<>();
    }

    public void addVertex(String node) {

        if(adjacentList.containsKey(node)){
            System.out.println("addVerted node [" + node + "] already exists");
        } else {
            List<String> connectedNode = new ArrayList<>();
            adjacentList.put(node, connectedNode);
            numberOfNodes++;
        }
    }

    public void addConnection(String node1, String node2) {
        if(adjacentList.containsKey(node1) && adjacentList.containsKey(node2)) {
            if(!adjacentList.get(node1).contains(node2)){
                adjacentList.get(node1).add(node2);
            }
            if(!adjacentList.get(node2).contains(node1)){
                adjacentList.get(node2).add(node1);

            }
        } else {
            System.out.println("addConnection node [" + node1 + "] and/or node [" + node2 + "] not in graph, need to be added");
        }
    }

    public void showConnections() {
        Set<Map.Entry<String, List<String>>> entry = adjacentList.entrySet();
        for (Map.Entry<String, List<String>> adjacentListEntry : entry) {
            System.out.println("Node:[" + adjacentListEntry.getKey() + "], ListNodeConnected " + Arrays.toString(adjacentListEntry.getValue().toArray()));
        }

    }
}

class MainGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addConnection("3", "1");
        graph.addConnection("3", "4");
        graph.addConnection("4", "2");
        graph.addConnection("4", "5");
        graph.addConnection("1", "2");
        graph.addConnection("1", "0");
        graph.addConnection("0", "2");
        graph.addConnection("6", "5");

        graph.showConnections();


    }
}