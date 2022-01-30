package com.vsu.cgcourse.myvecmath;

import java.io.Serializable;

abstract public class Tuple3d implements Serializable {
    public double x;
    public double y;
    public double z;

    public Tuple3d() {x = 0.0f;y = 0.0f;z = 0.0f;}
    public Tuple3d(double x, double y, double z) {this.x = x;this.y = y;this.z = z;}
    public Tuple3d(double t[]) {
        if (t.length<3)return;
        this.x = t[0];
        this.y = t[1];
        this.z = t[2];
    }
    public Tuple3d(Tuple3d t1) {this.x = t1.x;this.y = t1.y;this.z = t1.z;}
    public Tuple3d(Tuple3f t1) {this.x = t1.x;this.y = t1.y;this.z = t1.z;}

    public final void set(double x, double y, double z) {this.x = x;this.y = y;this.z = z;}
    public final void set(double t[]) {
        if (t.length<3)return;
        this.x = t[0];
        this.y = t[1];
        this.z = t[2];
    }
    public final void set(Tuple3d t1) {this.x = t1.x;this.y = t1.y;this.z = t1.z;}
    public final void set(Tuple3f t1) {this.x = t1.x;this.y = t1.y;this.z = t1.z;}

    public final void get(double t[]) {
        if (t.length<3)return;
        t[0] = this.x;
        t[1] = this.y;
        t[2] = this.z;
    }
    public final void get(Tuple3d t) {t.x = x;t.y = y;t.z = z;}

    public final void add(Tuple3d t1, Tuple3d t2) {this.x = t1.x + t2.x;this.y = t1.y + t2.y;this.z = t1.z + t2.z;}
    public final void add(Tuple3d t1) {this.x += t1.x;this.y += t1.y;this.z += t1.z;}
    public final void sub(Tuple3d t1, Tuple3d t2) {this.x = t1.x - t2.x;this.y = t1.y - t2.y;this.z = t1.z - t2.z;}

    public final void sub(Tuple3d t1) {this.x -= t1.x;this.y -= t1.y;this.z -= t1.z;}
    public final void negate(Tuple3d t1) {this.x = -t1.x;this.y = -t1.y;this.z = -t1.z;}

    public final void negate() {this.x = -x;this.y = -y;this.z = -z;}

    public final void scale(double s, Tuple3d t1) {this.x = s*t1.x;this.y = s*t1.y;this.z = s*t1.z;}
    public final void scale(double s) {this.x *= s;this.y*= s;this.z *= s;}

    public final void scaleAdd(double s, Tuple3d t1, Tuple3d t2) {x = s*t1.x + t2.x;y = s*t1.y + t2.y;z = s*t1.z + t2.z;}
    public final void scaleAdd(double s, Tuple3d t1) {x = s*x + t1.x;y = s*y + t1.y;z = s*z + t1.z;}

    public int hashCode() {return (int)(this.x*this.y*this.z);}

    public boolean equals(Tuple3d t1) {return t1 != null && x == t1.x && y == t1.y && z == t1.z;}

    public boolean epsilonEquals(Tuple3d t1, double epsilon) {
        double thisEpsilon=Math.fma(Math.abs(this.x-t1.x),Math.abs(this.y-t1.y),Math.abs(this.z-t1.z));
        return epsilon>=thisEpsilon;
    }

    public String toString() {return "(" + x + ", " + y + ", " + z +")";}

    public final void absolute(Tuple3d t) {
        set(t);
        absolute();
    }

    public final void absolute() {
        if (x < 0.0) x = -x;
        if (y < 0.0) y = -y;
        if (z < 0.0) z = -z;
    }


    public final void clamp(double min, double max) {
        clampMin(min);
        clampMax(max);
    }
    public final void clamp(double min, double max, Tuple3d t) {
        set(t);
        clamp(min, max);
    }

    public final void clampMin(double min) {
        if (x < min) x = min;
        if (y < min) y = min;
        if (z < min) z = min;
    }
    public final void clampMin(double min, Tuple3d t) {
        set(t);
        clampMin(min);
    }

    public final void clampMax(double max, Tuple3d t) {
        set(t);
        clampMax(max);
    }
    public final void clampMax(double max) {
        if (x > max) x = max;
        if (y > max) y = max;
        if (z > max) z = max;
    }

    public final void interpolate(Tuple3d t1, Tuple3d t2, double alpha) {
        set(t1);
        interpolate(t2, alpha);
    }
    public final void interpolate(Tuple3d t1, double alpha) {
        x = (1 - alpha)*x + alpha*t1.x;
        y = (1 - alpha)*y + alpha*t1.y;
        z = (1 - alpha)*z + alpha*t1.z;
    }

    abstract public Object clone();
}
