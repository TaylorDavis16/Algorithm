package com.taylor.other;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarParkingRoof {
    public static void main(String[] args) {
        List<Long> list = Arrays.asList(6L, 2L, 12L, 7L);
        System.out.println(carParkingRoof(list,4));
    }
    public static long carParkingRoof(List<Long> cars, int k) {
        // Write your code here
        Collections.sort(cars);
        System.out.println(cars);
//        long first = cars.get(0), last = cars.get(cars.size()-1);
//        if (k==cars.size()) return last-first+1;
        long distance = Long.MAX_VALUE;
        for (int i = 0; i < cars.size(); i++) {
            int end = i + k - 1;
            if (end>=cars.size()) break;
            distance = Math.min(distance,cars.get(end)-cars.get(i)+1);
        }
        return distance;
    }
}
