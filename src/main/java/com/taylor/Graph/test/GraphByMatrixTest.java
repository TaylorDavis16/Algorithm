package com.taylor.Graph.test;


import com.taylor.Graph.GraphByMatrix;

public class GraphByMatrixTest {
    public static void main(String[] args) {
        GraphByMatrix<String> stringGraph = new GraphByMatrix<String>(5);
        String[] vertex={"A","B","C","D","E"};
        //Insert vertex first, then add edges
        for (String s : vertex) {
            stringGraph.insertVertex(s);
        }
        stringGraph.insertEdge(0,1,1);
        stringGraph.insertEdge(0,2,1);
        stringGraph.insertEdge(1,2,1);
        stringGraph.insertEdge(1,3,1);
        stringGraph.insertEdge(1,4,1);
        stringGraph.showGraph();
        System.out.println("Edges: "+stringGraph.getEdge());
        System.out.println("NumOfVertex: "+stringGraph.getNumOfVertex());
        for (int i = 0; i <vertex.length; i++) {
            String value = stringGraph.getValueByIndex(i);
            System.out.println(i+": "+value);
        }
        stringGraph.DFS(0);

        GraphByMatrix<String> s2=new GraphByMatrix<>(7);
        String[] strings={"A","B","C","D","E","F","G"};
        for (String s : strings) {
            s2.insertVertex(s);
        }
        s2.insertEdge(0,6,1);
        s2.insertEdge(0,1,1);
        s2.insertEdge(1,2,1);
        s2.insertEdge(1,3,1);
        s2.insertEdge(2,3,1);
        s2.insertEdge(2,5,1);
        s2.insertEdge(4,6,1);
        s2.showGraph();
        s2.DFS(0);
        s2.reSet();
        s2.BFS(0);
    }
}
