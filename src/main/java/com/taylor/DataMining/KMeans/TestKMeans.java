package com.taylor.DataMining.KMeans;

import com.taylor.DataMining.Point;
import org.junit.Test;

import java.util.ArrayList;

public class TestKMeans {
    public static void main(String[] args) {
        ArrayList<Point> centers = new ArrayList<>();
        centers.add(new Point("A1",2,10));
        centers.add(new Point("B1",5,8));
        centers.add(new Point("C1",1,2));
//        centers.add(new Point(1,6));
        ArrayList<Point> data = new ArrayList<>();
        data.add(new Point("A2",2,5));
        data.add(new Point("A3",8,4));
        data.add(new Point("B2",7,5));
        data.add(new Point("B3",6,4));
        data.add(new Point("C2",4,9));
        KMeans kMeans = new KMeans(centers,data);
        kMeans.classify();
    }
    
    @Test
    public void test1(){
        ArrayList<Point> centers = new ArrayList<>();
        centers.add(new Point("P1",0,0));
        centers.add(new Point("P2",1,2));
//        centers.add(new Point(1,6));
        ArrayList<Point> data = new ArrayList<>();
        data.add(new Point("P3",3,1));
        data.add(new Point("P4",8,8));
        data.add(new Point("P5",9,10));
        data.add(new Point("P6",10,7));
        KMeans kMeans = new KMeans(centers,data);
        kMeans.classify();
    }
}
