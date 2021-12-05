package com.taylor.DataMining.HierarchicalClustering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author Li Xingdong
 * 2020.10.21
 */
public class HCWithDistanceMatrix {
    public static final String MIN = "Min";
    public static final String MAX = "Max";
    public static final String AVERAGE = "Average";
    private double[][] data;
    private ArrayList<ArrayList<Integer>> clusterList;
    private String method;
    private int time;

    {
        method = HCWithDistanceMatrix.AVERAGE;
    }

    public HCWithDistanceMatrix(double[][] data) {
        this.data = data;
        clusterList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            clusterList.add(list);
        }
    }

    public void operate() {
        System.out.println("Method: "+method);
        ArrayList<Integer>[] lists = new ArrayList[2];
        switch (method) {
            case HCWithDistanceMatrix.MIN:
                while (clusterList.size() > 1) {
                    show();
                    double shortest = Double.MAX_VALUE;
                    for (int i = 0; i < clusterList.size(); i++) {
                        for (int j = i + 1; j < clusterList.size(); j++) {
                            ArrayList<Integer> list1 = clusterList.get(i);
                            ArrayList<Integer> list2 = clusterList.get(j);
                            double distance = Min(list1, list2);
                            System.out.println("distance:"+distance);
                            if (shortest > distance) {
                                shortest = distance;
                                lists = new ArrayList[]{list1, list2};
                            }
                        }
                    }
                    refreshCluster(lists[0], lists[1]);
                }
                break;
            case HCWithDistanceMatrix.MAX:
                while (clusterList.size() > 1) {
                    show();
                    double shortest = Double.MAX_VALUE;
                    for (int i = 0; i < clusterList.size(); i++) {
                        for (int j = i + 1; j < clusterList.size(); j++) {
                            ArrayList<Integer> list1 = clusterList.get(i);
                            ArrayList<Integer> list2 = clusterList.get(j);
                            double distance = Max(list1, list2);
                            System.out.println("distance:"+distance);
                            if (shortest > distance) {
                                shortest = distance;
                                lists = new ArrayList[]{list1, list2};
                            }
                        }
                    }
                    refreshCluster(lists[0], lists[1]);
                }
                break;
            case HCWithDistanceMatrix.AVERAGE:
                while (clusterList.size() > 1) {
                    show();
                    double shortest = Double.MAX_VALUE;
                    for (int i = 0; i < clusterList.size(); i++) {
                        for (int j = i + 1; j < clusterList.size(); j++) {
                            ArrayList<Integer> list1 = clusterList.get(i);
                            ArrayList<Integer> list2 = clusterList.get(j);
                            double distance = Average(list1, list2);
                            System.out.println("distance:"+distance);
                            if (shortest > distance) {
                                shortest = distance;
                                lists = new ArrayList[]{list1, list2};
                            }
                        }
                    }
                    refreshCluster(lists[0], lists[1]);
                }
                break;
            default:
                throw new IllegalArgumentException("Illegal method!");
        }
    }

    private void show() {
        System.out.println(++time + " -------------------------------------------------");
        clusterList.forEach(e -> {
            int[] cluster = new int[e.size()];
            AtomicInteger i = new AtomicInteger();
            e.forEach(e1 -> cluster[i.getAndIncrement()] = e1 + 1);
            System.out.println(Arrays.toString(cluster));
        });
    }

    private void refreshCluster(ArrayList<Integer> cluster1, ArrayList<Integer> cluster2) {
        clusterList.remove(cluster1);
        clusterList.remove(cluster2);
        cluster1.addAll(cluster2);
        clusterList.add(cluster1);
    }

    public double Min(ArrayList<Integer> cluster1, ArrayList<Integer> cluster2) {
        double minVal = Double.MAX_VALUE;
        for (Integer integer1 : cluster1) {
            for (Integer integer2 : cluster2) {
                minVal = Math.min(data[integer1][integer2], minVal);
            }
        }
        return minVal;
    }

    public double Max(ArrayList<Integer> cluster1, ArrayList<Integer> cluster2) {
        double maxVal = 0;
        for (Integer integer1 : cluster1) {
            for (Integer integer2 : cluster2) {
                maxVal = Math.max(data[integer1][integer2], maxVal);
            }
        }
        return maxVal;
    }

    public double Average(ArrayList<Integer> cluster1, ArrayList<Integer> cluster2) {
        double distance = 0;
        for (Integer integer1 : cluster1) {
            for (Integer integer2 : cluster2) {
                distance += data[integer1][integer2];
            }
        }
        return distance/(cluster1.size()*cluster2.size());
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }

    public ArrayList<ArrayList<Integer>> getClusterList() {
        return clusterList;
    }

    public void setClusterList(ArrayList<ArrayList<Integer>> clusterList) {
        this.clusterList = clusterList;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
