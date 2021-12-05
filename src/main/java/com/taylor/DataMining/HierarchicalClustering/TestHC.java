package com.taylor.DataMining.HierarchicalClustering;

import java.util.ArrayList;
import java.util.List;
import com.taylor.DataMining.Point;
import org.junit.Test;
public class TestHC {
    static List<Point> pointList =new ArrayList<>();
    static {
        pointList.add(new Point("p1",0.4005,0.5306));
        pointList.add(new Point("p2",0.2148,0.3854));
        pointList.add(new Point("p3",0.3457,0.3156));
        pointList.add(new Point("p4",0.2652,0.1875));
        pointList.add(new Point("p5",0.0789,0.4139));
        pointList.add(new Point("p6",0.4548,0.3022));
    }
    public static void main(String[] args) {
        List<Point> pointList =new ArrayList<>();
        pointList.add(new Point("A",16.9,0));
        pointList.add(new Point("B",38.5,0));
        pointList.add(new Point("C",39.5,0));
        pointList.add(new Point("D",80.8,0));
        pointList.add(new Point("E",82,0));
        pointList.add(new Point("F",34.6,0));
        pointList.add(new Point("G",116.1,0));
        HierarchicalCluster hierarchicalCluster = new HierarchicalCluster(pointList);
        hierarchicalCluster.setMethod(HierarchicalCluster.MAX);
        hierarchicalCluster.operate();
    }
    
    @Test
    public void testMin(){
        HierarchicalCluster hierarchicalCluster = new HierarchicalCluster(pointList);
        hierarchicalCluster.setMethod(HierarchicalCluster.MIN);
        hierarchicalCluster.operate();
    }
    
    @Test
    public void testMax(){
        HierarchicalCluster hierarchicalCluster = new HierarchicalCluster(pointList);
        hierarchicalCluster.setMethod(HierarchicalCluster.MAX);
        hierarchicalCluster.operate();
    }

    @Test
    public void testAverage(){
        HierarchicalCluster hierarchicalCluster = new HierarchicalCluster(pointList);
        hierarchicalCluster.operate();
    }
    
    
    @Test
    public void testHomeworkMin(){
        HCWithDistanceMatrix hc= getProblem();
        hc.setMethod(HCWithDistanceMatrix.MIN);
        hc.operate();
    }

    @Test
    public void testHomeworkMax(){
        HCWithDistanceMatrix hc= getProblem();
        hc.setMethod(HCWithDistanceMatrix.MAX);
        hc.operate();
    }

    @Test
    public void testHomeworkAverage(){
        HCWithDistanceMatrix hc= getProblem();
        hc.setMethod(HCWithDistanceMatrix.AVERAGE);
        hc.operate();
    }

    private HCWithDistanceMatrix getProblem() {
        double[][] data = new double[5][5];
        double[] datum = {0.10,0.41,0.55,0.35,0.64,0.47,0.98,0.44,0.85,0.76};
        int k=0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i+1; j < data[i].length; j++) {
                data[i][j]=datum[k];
                data[j][i]=datum[k++];
            }
        }
        return new HCWithDistanceMatrix(data);
    }
}
