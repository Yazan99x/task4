package com.vsu.cgcourse.myvecmath;

import java.io.Serializable;

public class Vector2d extends Tuple2d implements Serializable {

    public Vector2d(double x, double y) {super(x, y);}
    public Vector2d(double v[]) {super(v);}
    public Vector2d(Vector2d v) {super(v);}
    public Vector2d(Vector2f v) {super(v);}
    public Vector2d(Tuple2f t) {super(t);}
    public Vector2d(Tuple2d t) {super(t);}
    public Vector2d() {super();}

    public final double dot(Vector2d v) {return x*v.x + y*v.y;}

    public final double length() {return (double) Math.sqrt(x*x + y*y);}

    public final double lengthSquared() {return x*x + y*y;}

    public final void normalize() {
        double d = length();
        x /= d;
        y /= d;
    }

    public final void normalize(Vector2d v) {
        set(v);
        normalize();
    }

    public final double angle(Vector2d v) {return (double)Math.abs(Math.atan2(x*v.y - y*v.x , dot(v)));}

    @Override
    public Object clone() {
        return new Vector2d(this.x,this.y);
    }
}
