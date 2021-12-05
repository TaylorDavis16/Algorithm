package com.taylor.DataMining.Diana;

import com.taylor.DataMining.Cluster;
import com.taylor.DataMining.Point;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Li Xingdong
 * 2020.10.21
 */
public class Diana {
    private final ArrayList<Cluster> clusterList;
    private final int clusterNum;
    private int time;
    public Diana(int clusterNum, List<Point> pointList) {
        this.clusterNum=clusterNum;
        clusterList = new ArrayList<>();
        Cluster cluster = new Cluster(pointList);
        clusterList.add(cluster);//初始只有一个cluster,默认是全部的点
    }
    
    public void operate(){
        for (int i = 0; i < clusterNum; i++) {
            show();
            double longest=0;
            //找到最大直径的簇,这是后来的oldParty
            Cluster cluster=clusterList.get(0);
            int j;
            for (j = 0; j < clusterList.size(); j++) {
                Cluster cluster1 = clusterList.get(j);
                double longestDiameter = findClusterDiameter(cluster1);
                if (longest<longestDiameter){
                    longest=longestDiameter;
                    cluster=cluster1;
                }
            }
            //最大直径的簇已确定,为cluster,现在查找该簇中最大相异度的点的坐标
            int index = findLargestDissimilarity(cluster);//最大相异度的点的坐标
            if (index==-1){
                continue;
            }
            Cluster splinter = new Cluster();
            Point removePoint = cluster.getPointList().remove(index);
            splinter.add(removePoint);
            //cluster就是后来的oldParty
            //因为oldParty可能会一直更新，所以先移除oldParty
            Cluster oldParty = clusterList.remove(--j);
            int newRemovePointIndex = getNewRemovePointIndex(oldParty, splinter);
            while (newRemovePointIndex!=-1){
                splinter.add(oldParty.getPointList().remove(newRemovePointIndex));
                newRemovePointIndex = getNewRemovePointIndex(oldParty, splinter);
            }

            clusterList.add(splinter);
            clusterList.add(oldParty);
            System.out.println("Old party is "+(oldParty.size()==0?"EMPTY":"Not EMPTY"));
        }
        
    }
    
    private int getNewRemovePointIndex(Cluster oldParty, Cluster splinter){
        List<Point> oldPartyPoints = oldParty.getPointList();
        List<Point> splinterPoints = splinter.getPointList();
        for (int i = 0; i < oldPartyPoints.size(); i++) {
            Point pointInOP = oldPartyPoints.get(i);
            //该点（i）到它的簇中的其他点的最小距离
            double shortestForThis = findShortestDistanceInCluster(pointInOP, oldParty);
            //在old party里找出**到splinter group中点的最近距离** <= **到old party中点的最近距离的点**
            double osDistance = findShortestDistanceOfOS(pointInOP, splinter);
            if (osDistance <= shortestForThis) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找一个簇中的直径
     * @param cluster 一个簇
     * @return 该簇的直径
     */
    private double findClusterDiameter(Cluster cluster){
        List<Point> pointList = cluster.getPointList();
        //若只有一个点,则直径为0
        double longest=0;
        for (int i = 0; i < pointList.size(); i++) {
            for (int j = i+1; j < pointList.size(); j++) {
                longest = Math.max(longest,Point.getDistanceBetween(pointList.get(i),pointList.get(j)));
            }
        }
        return longest;
    }

    /**
     * 查找一个点在它所在的簇中于其它的点的最小距离
     * @param point 一个点
     * @param cluster 该点所在的簇
     * @return 该点到所有其它点的距离中的最小值
     */
    private double findShortestDistanceInCluster(Point point, Cluster cluster){
        List<Point> pointList = cluster.getPointList();
        double shortest=Double.MAX_VALUE;
        for (Point point1 : pointList) {
            if (!point.equals(point1)){
                shortest = Math.min(shortest,Point.getDistanceBetween(point,point1));
            }
        }
        return shortest;
    }

    /**
     * 查找一个oldParty点到splinter group的最小距离
     * @param point 一个点
     * @param cluster 该点所在的簇
     * @return 该点到所有其它点的距离中的最小值
     */
    private double findShortestDistanceOfOS(Point point, Cluster cluster){
        List<Point> pointList = cluster.getPointList();
        double shortest=Double.MAX_VALUE;
        for (Point point1 : pointList) {
            shortest = Math.min(shortest,Point.getDistanceBetween(point,point1));
        }
        return shortest;
    }

    /**
     * 产找这个簇中最大差异度最大的点(坐标)
     * @param cluster
     * @return
     */
    private int findLargestDissimilarity(Cluster cluster){
        List<Point> pointList = cluster.getPointList();
        int size = pointList.size();
        //若只有一个点则返回-1
        if (size==1){
            return -1;
        }
        double longest=0;
        int index=0;
        for (int i = 0; i < size; i++) {
            Point point1 = pointList.get(i);
            double lengths = 0;
            for (Point point2 : pointList) {
                if (!point1.equals(point2)) {
                    lengths += Point.getDistanceBetween(point1, point2);
                }
            }
            double average = lengths/(size -1);
            if (longest<average){
                longest=average;
                index=i;
            }
        }
        return index;
    }

    private void show(){
        System.out.println(++time+" -------------------------------------------------");
        clusterList.forEach(System.out::println);
    }
}
