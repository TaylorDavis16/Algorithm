package com.taylor.DataMining;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cluster{
    
    private List<Point> pointList;
    {
        pointList = new ArrayList<>();
    }
    public Cluster() {
    }

    public Cluster(List<Point> pointList) {
        this.pointList.addAll(pointList);
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public void add(Point point){
        if (point==null){
            throw new NullPointerException();
        }
        this.pointList.add(point);
    }

    public void addAll(List<Point> pointLists){
        this.pointList.addAll(pointLists);
    }
    
    public int size(){
        return pointList.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Cluster{\n");
        for (int i = 0; i< pointList.size(); i++) {
            builder.append(pointList.get(i)).append(i!= pointList.size()-1 ? ",\n" : "}\n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cluster cluster = (Cluster) o;
        return Objects.equals(pointList, cluster.pointList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointList);
    }
}
