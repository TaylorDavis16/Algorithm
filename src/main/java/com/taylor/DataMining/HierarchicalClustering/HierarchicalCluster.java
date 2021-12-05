package com.taylor.DataMining.HierarchicalClustering;

import com.taylor.DataMining.Cluster;
import com.taylor.DataMining.Point;

import java.util.*;
/**
 * @author Li Xingdong
 * 2020.10.21
 */
public class HierarchicalCluster {
    public static final String MIN = "Min";
    public static final String MAX = "Max";
    public static final String AVERAGE = "Average";
    private List<Cluster> clusters;
    private String method;
    private int time;

    {
        method = HierarchicalCluster.AVERAGE;
    }

    public HierarchicalCluster(List<Point> pointList) {
        if (pointList == null || pointList.size() == 0)
            throw new IllegalArgumentException("ValueList cannot be null or empty!");
        initialClusters(pointList);
    }

    public HierarchicalCluster(Point[] points) {
        if (points == null || points.length == 0)
            throw new IllegalArgumentException("Values cannot be null or empty!");
        List<Point> pointList = Arrays.asList(points);
        initialClusters(pointList);
    }

    private void initialClusters(List<Point> pointList) {
        clusters = new ArrayList<>();
        for (Point point : pointList) {
            Cluster cluster = new Cluster();
            cluster.add(point);
            clusters.add(cluster);
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void operate() {
        System.out.println("Method: "+method);
        double shortest;
        Cluster[] shortestClusters=new Cluster[2];
        switch (method) {
            case HierarchicalCluster.MAX:
                while (clusters.size() > 1) {
                    shortest=Double.MAX_VALUE;
                    show();
                    for (int i = 0; i < clusters.size(); i++) {
                        for (int j = i + 1; j < clusters.size(); j++) {
                            Cluster cluster1 = clusters.get(i);
                            Cluster cluster2 = clusters.get(j);
                            double distance = Max(cluster1, cluster2);
                            if (shortest > distance) {
                                shortest = distance;
                                shortestClusters = new Cluster[]{cluster1, cluster2};
                            }
                        }
                    }
                    System.out.println("Shortest: "+shortest);
                    refreshCluster(shortestClusters[0], shortestClusters[1]);
                }
                break;
            case HierarchicalCluster.MIN:
                while (clusters.size() > 1) {
                    shortest=Double.MAX_VALUE;
                    show();
                    for (int i = 0; i < clusters.size(); i++) {
                        for (int j = i + 1; j < clusters.size(); j++) {
                            Cluster cluster1 = clusters.get(i);
                            Cluster cluster2 = clusters.get(j);
                            double distance = Min(cluster1, cluster2);
                            if (shortest > distance) {
                                shortest = distance;
                                shortestClusters = new Cluster[]{cluster1, cluster2};
                            }
                        }
                    }
                    System.out.println("Shortest: "+shortest);
                    refreshCluster(shortestClusters[0], shortestClusters[1]);
                }
                break;
            case HierarchicalCluster.AVERAGE:
                while (clusters.size() > 1) {
                    shortest=Double.MAX_VALUE;
                    show();
                    for (int i = 0; i < clusters.size(); i++) {
                        for (int j = i + 1; j < clusters.size(); j++) {
                            Cluster cluster1 = clusters.get(i);
                            Cluster cluster2 = clusters.get(j);
                            double distance = Average(cluster1, cluster2);
                            if (shortest > distance) {
                                shortest = distance;
                                shortestClusters = new Cluster[]{cluster1, cluster2};
                            }
                        }
                    }
                    System.out.println("Shortest: "+shortest);
                    refreshCluster(shortestClusters[0], shortestClusters[1]);
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong method!");
        }
    }
    
    private void refreshCluster(Cluster cluster1, Cluster cluster2){
        clusters.remove(cluster1);
        clusters.remove(cluster2);
        cluster1.getPointList().addAll(cluster2.getPointList());
        Cluster newCluster = new Cluster(cluster1.getPointList());
        clusters.add(newCluster);
    }
    
    public double Min(Cluster cluster1, Cluster cluster2) {
        List<Point> clusterList1 = cluster1.getPointList();
        List<Point> clusterList2 = cluster2.getPointList();
        double minVal = Double.MAX_VALUE;
        for (Point point1 : clusterList1) {
            for (Point point2 : clusterList2) {
                double x= point1.getX() - point2.getX();
                double y= point1.getY() - point2.getY();
                double length = Math.sqrt(x*x+y*y);
                minVal = Math.min(minVal,length);
            }
        }
        return minVal;
    }

    public double Max(Cluster cluster1, Cluster cluster2) {
        List<Point> clusterList1 = cluster1.getPointList();
        List<Point> clusterList2 = cluster2.getPointList();
        double maxVal = 0;
        for (Point point1 : clusterList1) {
            for (Point point2 : clusterList2) {
                double x= point1.getX() - point2.getX();
                double y= point1.getY() - point2.getY();
                double length = Math.sqrt(x*x+y*y);
                maxVal = Math.max(maxVal,length);
            }
        }
        return maxVal;
    }

    public double Average(Cluster cluster1, Cluster cluster2) {//按Average方法计算两个簇的距离
        List<Point> clusterList1 = cluster1.getPointList();
        List<Point> clusterList2 = cluster2.getPointList();
        double distance = 0;
        for (Point point1 : clusterList1) {
            for (Point point2 : clusterList2) {
                double x= point1.getX() - point2.getX();
                double y= point1.getY() - point2.getY();
                double length = Math.sqrt(x*x+y*y);
                distance += length;
            }
        }
        //平均
        return distance / (clusterList1.size() * clusterList2.size());
    }
    
    private void show(){
        System.out.println(++time+" -------------------------------------------------");
        clusters.forEach(System.out::println);
    }
}
