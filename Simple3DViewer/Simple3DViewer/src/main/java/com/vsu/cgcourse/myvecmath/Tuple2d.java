package com.vsu.cgcourse.myvecmath;

import java.io.Serializable;

abstract public class Tuple2d implements Serializable {
    public double x;
    public double y;

    public Tuple2d(){this.x=0;this.y=0;}
    public Tuple2d(double x, double y){this.x=x;this.y=y;}
    public Tuple2d(double[] t){
        if (t.length!=2)return;
        this.x=t[0];
        this.y=t[1];
    }
    public Tuple2d(Tuple2d t1){this.x=t1.x;this.y=t1.y;}
    public Tuple2d(Tuple2f f){this.x=f.x;this.y=f.y;}

    public final void set(double x,double y){this.x=x;this.y=y;}
    public final void set(double[] t){
        if (t.length!=2) return;
        this.x=t[0];this.y=t[1];
    }
    public final void set(Tuple2d t1){this.x=t1.x;this.y=t1.y;}
    public final void set(Tuple2f t1){this.x=t1.x;this.y=t1.y;};

    public final void get(double[] t){
        if (t.length!=2)return;
        t[0]=x;t[1]=y;
    }

    public final void add(Tuple2d t1,Tuple2d t2){this.x=t1.x+t2.x;this.y=t1.y+ t2.y;}
    public final void add(Tuple2d t1){this.x=this.x+ t1.x;this.y=this.y+ t1.y;}

    public final void sub(Tuple2d t1,Tuple2d t2){this.x=t1.x-t2.x;this.y=t1.y- t2.y;}
    public final void sub(Tuple2d t1){this.x-=t1.x;this.y-= t1.y;}

    public final void negate(Tuple2d t1){this.x=-t1.x;this.y=-t1.y;}

    public final void scale(double s,Tuple2d t1){this.x=s* t1.x;this.y=s* t1.y;}
    public final void scale(double s){this.x*=s;this.y*=s;}

    public final void scaleAdd(double s,Tuple2d t1,Tuple2d t2){this.x=s*t1.x+t2.x;this.y=s*t1.y+t2.y;}
    public final void scaleAdd(double s,Tuple2d t1){this.x=this.x*s+t1.x;this.y=this.y*s+t1.y;}

    public int hashCode(){return (int) (this.x*this.y);}

    public boolean equals(Tuple2d t1){return t1.x == this.x && t1.y == this.y;}

    public boolean epsilonEquals(Tuple2d t1, double epsilon){
        double thisEpsilon=Math.max(Math.abs(this.x-t1.x),Math.abs(this.y-t1.y));
        return epsilon>=thisEpsilon;
    }

    @Override public String toString(){return "("+this.x+", "+this.y+")";}

    public final void clamp(double min, double max) {
        clampMin(min);
        clampMax(max);
    }
    public final void clamp(double min, double max, Tuple2d t){
        set(t);
        clamp(min, max);
    }

    public final void clampMin(double min){
        if (this.x<min)this.x=min;
        if (this.y<min)this.y=min;
    }
    public final void clampMin(double min,Tuple2d t){
        set(t);
        clampMin(min);
    }

    public final void clampMax(double max) {
        if(this.x > max)this.x = max;
        if(this.y > max)this.y=max;
    }
    public final void clampMax(double max,Tuple2d t){
        set(t);
        clampMax(max);
    }


    public final void absolute(){
        if (x < 0.0) this.x = -this.x;
        if (y < 0.0) this.y = -this.y;
    }

    public final void interpolate(Tuple2d t1, Tuple2d t2, double alpha) {
        set(t1);
        interpolate(t2, alpha);
    }

    public final void interpolate(Tuple2d t1, double alpha) {
        x = (1 - alpha)*x + alpha*t1.x;
        y = (1 - alpha)*y + alpha*t1.y;
    }

    abstract public Object clone();
}
