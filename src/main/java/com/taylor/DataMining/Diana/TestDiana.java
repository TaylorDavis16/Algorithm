package com.taylor.DataMining.Diana;

import com.taylor.DataMining.Point;
import org.junit.Test;

import java.util.ArrayList;

public class TestDiana {
    public static void main(String[] args) {
        ArrayList<Point> pointList = new ArrayList<>();
        pointList.add(new Point("X1",1,0));
        pointList.add(new Point("X2",4,0));
        pointList.add(new Point("X3",0,1));
        pointList.add(new Point("X4",1,1));
        pointList.add(new Point("X5",3,1));
        pointList.add(new Point("X6",5,0));
        pointList.add(new Point("X7",4,2));
        pointList.add(new Point("X8",1,3));
        Diana diana = new Diana(5,pointList);
        diana.operate();
    }
    
    @Test
    public void testHomework(){
        ArrayList<Point> pointList = new ArrayList<>();
        pointList.add(new Point("X1",1,1));
        pointList.add(new Point("X2",1,2));
        pointList.add(new Point("X3",2,1));
        pointList.add(new Point("X4",2,2));
        pointList.add(new Point("X5",3,4));
        pointList.add(new Point("X6",3,5));
        pointList.add(new Point("X7",4,4));
        pointList.add(new Point("X8",4,5));
        Diana diana = new Diana(2,pointList);
        diana.operate();
    }
}
