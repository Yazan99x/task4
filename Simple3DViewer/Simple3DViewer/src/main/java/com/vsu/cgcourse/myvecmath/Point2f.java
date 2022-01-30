package com.vsu.cgcourse.myvecmath;

import java.io.Serializable;

public class Point2f extends Tuple2f implements Serializable {

    public Point2f(float x, float y) {super(x, y);}
    public Point2f(float p[]) {super(p);}
    public Point2f(Point2f p1) {super(p1);}
    public Point2f(Tuple2f t1) {super(t1);}
    public Point2f(Tuple2d t1) {super(t1);}


    public final float distanceSquared(Point2f p1) {
        double dx = x - p1.x;
        double dy = y - p1.y;
        return (float)(dx*dx + dy*dy);
    }

    public final float distance(Point2f p1) {
        return (float)Math.sqrt(distanceSquared(p1));
    }

    public final float distanceL1(Point2f p1) {
        return Math.abs(x-p1.x) + Math.abs(y-p1.y);
    }

    public final float distanceLinf(Point2f p1) {
        return Math.max(Math.abs(x-p1.x), Math.abs(y-p1.y));
    }

    @Override
    public Object clone() {
        return new Point2f(this.x,this.y);
    }
}
