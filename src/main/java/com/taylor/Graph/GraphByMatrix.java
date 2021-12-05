package com.taylor.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A graph sample made by adjacent matrix
 * @param <T>
 */
public class GraphByMatrix<T> {
    private int[][] matrix;
    private ArrayList<Point<T>> list;
    private int edge;
    private boolean[] isVisited;

    private static class Point<T>{
        T value;
        public Point(T value) {
            this.value = value;
        }
    }

    public GraphByMatrix(int n) {
        matrix=new int[n][n];
        list=new ArrayList<>(n);
        edge=0;
        isVisited=new boolean[n];
    }

    public int getNumOfVertex(){
        return list.size();
    }

    public int getEdge() {
        return edge;
    }

    public T getValueByIndex(int i){
        Point<T> point = list.get(i);
        return point==null ? null : point.value;
    }

    public int getWeight(int v1,int v2){
        if(v1<matrix.length && v2<matrix.length)
            return matrix[v1][v2];
        return -1;
    }

    public void insertVertex(T vertex){
        list.add(new Point<>(vertex));
    }

    public void insertEdge(int v1,int v2,int weight){
        matrix[v1][v2]=weight;
        matrix[v2][v1]=weight;
        edge++;
    }

    public void showGraph(){
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void reSet(){
        System.out.println();
        isVisited=new boolean[isVisited.length];
    }

    /**
     * Return the next point that available to reach
     * when first begin to detect the next point
     * @param v1 the index of current point
     * @param v2 the current column
     * @return the index of next point if existed, else return -1
     */
    public int indexOfNextPoint(int v1,int v2){
        int size=list.size();
        for (int j = v2+1; j <size ; j++) {
            if (matrix[v1][j]!=0){
                return j;
            }
        }
        return -1;
    }


    /**
     * Depth First Search
     * @param i the current index of
     */
    public void DFS(int i){
        if (!isVisited[i]){
            System.out.print(getValueByIndex(i)+"->");
            isVisited[i]=true;
            int nextPoint = indexOfNextPoint(i,-1);
            while (nextPoint!=-1){
                DFS(nextPoint);
                //只要能找到下一个连接点，都会去试一下进行访问
                nextPoint=indexOfNextPoint(i,nextPoint);
            }
        }
    }

    /**
     * If a graph is unconnected graph
     * This search strategy is useful
     */
    public void DFS(){
        for (int i = 0; i < list.size(); i++) {
            if (!isVisited[i])
                DFS(i);
        }
    }

    /**
     * Breadth First Search
     * @param i the index that starts to search
     */
    public void BFS(int i){
        if (i>=0 && i<list.size()){
            Queue<Integer> queue=new LinkedList<>();
            System.out.print(getValueByIndex(i)+"->");
            isVisited[i]=true;
            queue.offer(i);
            while (!queue.isEmpty()){
                Integer first = queue.poll();
                int point = indexOfNextPoint(i, -1);
                while (point!=-1){
                    if (!isVisited[point]){
                        System.out.print(getValueByIndex(point)+"->");
                        queue.offer(point);
                        isVisited[point]=true;
                    }
                    point = indexOfNextPoint(first, point);
                }
            }
        }
    }

    /**
     * If a graph is unconnected graph
     * This search strategy is useful
     */
    public void BFS(){
        for (int i = 0; i < list.size(); i++) {
            if (!isVisited[i])
                BFS(i);
        }
    }
}
