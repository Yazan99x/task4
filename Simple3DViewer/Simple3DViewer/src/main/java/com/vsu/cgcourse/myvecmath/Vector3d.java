package com.vsu.cgcourse.myvecmath;

import java.io.Serializable;

public class Vector3d extends Tuple3d implements Serializable{

    public Vector3d() {super();}
    public Vector3d(double x, double y, double z) {super(x, y, z);}
    public Vector3d(double v[]) {super(v);}
    public Vector3d(Vector3f v1) {super(v1);}
    public Vector3d(Vector3d v1) {super(v1);}
    public Vector3d(Tuple3d t1) {super(t1);}
    public Vector3d(Tuple3f t1) {super(t1);}

    public final void cross(Vector3d v1, Vector3d v2) {
        set(v1.y*v2.z - v1.z*v2.y,v1.z*v2.x - v1.x*v2.z,v1.x*v2.y - v1.y*v2.x);
    }

    public final void normalize(Vector3d v1) {
        set(v1);
        normalize();
    }

    public final void normalize() {
        double d = length();
        x /= d;
        y /= d;
        z /= d;
    }

    public final double dot(Vector3d v1) {
        return x*v1.x + y*v1.y + z*v1.z;
    }

    public final double lengthSquared() {
        return x*x + y*y + z*z;
    }

    public final double length() {
        return Math.sqrt(lengthSquared());
    }

    public final double angle(Vector3d v1) {
        double xx = y * v1.z - z * v1.y;
        double yy = z * v1.x - x * v1.z;
        double zz = x * v1.y - y * v1.x;
        double cross = Math.sqrt(xx * xx + yy * yy + zz * zz);
        return Math.abs(Math.atan2(cross, dot(v1)));
    }

    @Override
    public Object clone() {
        return new Vector3d(this.x,this.y,this.z);
    }
}
