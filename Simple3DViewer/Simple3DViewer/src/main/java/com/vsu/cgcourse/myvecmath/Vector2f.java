package com.vsu.cgcourse.myvecmath;

import java.io.Serializable;

public class Vector2f extends Tuple2f implements Serializable {

    public Vector2f(float x, float y) {super(x, y);}
    public Vector2f(float v[]) {super(v);}
    public Vector2f(Vector2f v) {super(v);}
    public Vector2f(Vector2d v) {super(v);}
    public Vector2f(Tuple2f t) {super(t);}
    public Vector2f(Tuple2d t) {super(t);}
    public Vector2f() {super();}

    public final float dot(Vector2f v) {return x*v.x + y*v.y;}

    public final float length() {return (float) Math.sqrt(x*x + y*y);}

    public final float lengthSquared() {return x*x + y*y;}

    public final void normalize() {
        double d = length();
        x /= d;
        y /= d;
    }

    public final void normalize(Vector2f v) {
        set(v);
        normalize();
    }

    public final float angle(Vector2f v) {return (float)Math.abs(Math.atan2(x*v.y - y*v.x , dot(v)));}

    @Override
    public Object clone() {return new Vector2f(this.x,this.y);}
}
