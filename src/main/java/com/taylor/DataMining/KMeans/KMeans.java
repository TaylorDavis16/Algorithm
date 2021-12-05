package com.taylor.DataMining.KMeans;

import com.taylor.DataMining.Point;
import java.util.*;

/**
 * @author Li Xingdong
 * 2020.10.21
 */
public class KMeans {
    private int time = 0;
    private final ArrayList<Point> data;//除了质心的点
    private Map<Point, ArrayList<Point>> groups;//<质心点，属于该质心的组的点>
    private final Set<Point> pointSet;//保存所有的原始点
    private final Set<Point> lastCenters;//上一次的质心组合

    public KMeans(ArrayList<Point> centers, ArrayList<Point> data) {
        //分组数
        //质心
        this.data = data;
        groups = new HashMap<>();
        pointSet = new HashSet<>();
        lastCenters = new HashSet<>();
        pointSet.addAll(data);
        for (Point center : centers) {
            pointSet.add(center);
            groups.put(center, new ArrayList<>());
        }
    }

    public void classify() {
        while (true) {
            for (Point datum : data) {//对于每一个点，计算与所有质心的距离，加入最小的那个
                double shortest = Double.MAX_VALUE;
                double length;
                Point newCenter = new Point();
                for (Point center : groups.keySet()) {
                    length = Point.getDistanceBetween(datum,center);
                    if (shortest > length) {
                        shortest = length;
                        newCenter = center;
                    }
                }
                groups.get(newCenter).add(datum);
            }
            show();
            if (!isStable()) {
                reallocate();
            } else {
                break;
            }
        }

    }

    public void reallocate() {
        Set<Point> keyPoints = groups.keySet();
        Map<Point, ArrayList<Point>> newGroup = new HashMap<>();
        for (Point point : keyPoints) {//遍历每个质心
            ArrayList<Point> all = groups.get(point);
            double xs = 0, ys = 0;
            for (Point child : all) {//算新的质心
                xs += child.getX();
                ys += child.getY();
            }
            double x;
            double y;
            if (pointSet.contains(point)) {//如果质心属于原来的点，加上质心自己
                xs += point.getX();
                ys += point.getY();
                x = xs / (all.size() + 1);
                y = ys / (all.size() + 1);
            } else {
                x = xs / (all.size());
                y = ys / (all.size());
            }

            Point newPoint = new Point(x, y);//新的质心
//            System.out.println(newPoint);
            newGroup.put(newPoint, new ArrayList<>());
        }
        lastCenters.addAll(groups.keySet());//保存上次的质心
        groups = newGroup;
        //groups 已更新，现在更新data
        keyPoints = groups.keySet();
        data.clear();
        for (Point point : pointSet) {
            if (!keyPoints.contains(point)){
                data.add(point);
            }
        }
    }

    public boolean isStable() {
        for (Point center : groups.keySet()) {
            if (!lastCenters.contains(center)) {
                return false;
            }
        }
        return true;
    }

    public void show() {
        Set<Point> doubles = groups.keySet();
        System.out.println(++time+":   --------------------------------------------");
        for (Point aDouble : doubles) {
            System.out.print("\033[30m"+aDouble+": ");
            groups.get(aDouble).forEach((e) -> System.out.print("\033[32m"+e + " "));
            System.out.println();
        }
    }
}
