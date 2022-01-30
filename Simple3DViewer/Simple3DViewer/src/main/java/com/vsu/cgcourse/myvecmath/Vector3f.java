package com.vsu.cgcourse.myvecmath;

import java.io.Serializable;

public class Vector3f extends Tuple3f implements Serializable {

    public Vector3f() {super();}
    public Vector3f(float x, float y, float z) {super(x, y, z);}
    public Vector3f(float v[]) {super(v);}
    public Vector3f(Vector3f v1) {super(v1);}
    public Vector3f(Vector3d v1) {super(v1);}
    public Vector3f(Tuple3d t1) {super(t1);}
    public Vector3f(Tuple3f t1) {super(t1);}

    public final void cross(Vector3f v1, Vector3f v2) {
        set(v1.y*v2.z - v1.z*v2.y,v1.z*v2.x - v1.x*v2.z,v1.x*v2.y - v1.y*v2.x);
    }

    public final void normalize(Vector3f v1) {
        set(v1);
        normalize();
    }

    public final void normalize() {
        float d = length();
        x /= d;
        y /= d;
        z /= d;
    }

    public final float dot(Vector3f v1) {
        return x*v1.x + y*v1.y + z*v1.z;
    }

    public final float lengthSquared() {
        return x*x + y*y + z*z;
    }

    public final float length() {
        return (float)Math.sqrt(lengthSquared());
    }

    public final float angle(Vector3f v1) {
        float xx = y * v1.z - z * v1.y;
        float yy = z * v1.x - x * v1.z;
        float zz = x * v1.y - y * v1.x;
        double cross =Math.sqrt(xx * xx + yy * yy + zz * zz);
        return (float)Math.abs(Math.atan2(cross, dot(v1)));
    }

    @Override
    public Object clone() {
        return new Vector3f(this.x,this.y,this.z);
    }
}
