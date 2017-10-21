package com.example.problems.geometry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(-1, 1),
                new Point(0, 0),
                new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(3, 4)
        };
        System.out.println("Maximum Point on a single Line :" + findMaxPointOnLine(points));
    }

    static int findMaxPointOnLine(Point[] points) {
        Map<Rational, Integer> map = new HashMap<>();
        int maxPointsOnLine = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int maxPoints = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (i == j) continue;
                Rational slope = new Rational(points[j].y - points[i].y, points[j].x - points[i].x);
                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
            }
            maxPoints = Math.max(Collections.max(map.values()) + 1, maxPoints);
            maxPointsOnLine = Math.max(maxPoints, maxPointsOnLine);
            map.clear();
        }

        return maxPointsOnLine;
    }
}
