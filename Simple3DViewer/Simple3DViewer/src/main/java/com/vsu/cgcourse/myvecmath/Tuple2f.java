package com.vsu.cgcourse.myvecmath;

import java.io.Serializable;

public abstract class Tuple2f implements Serializable {
    public float x;
    public float y;

    public Tuple2f(){this.x=0f;this.y=0f;}
    public Tuple2f(float x, float y){this.x=x;this.y=y;}
    public Tuple2f(float[] t){
        if (t.length!=2)return;
        this.x=t[0];
        this.y=t[1];
    }
    public Tuple2f(Tuple2f t1){this.x=t1.x;this.y=t1.y;}
    public Tuple2f(Tuple2d d){this.x=(float)d.x;this.y=(float)d.y;}

    public final void set(float x,float y){this.x=x;this.y=y;}
    public final void set(float[] t){
        if (t.length!=2) return;
        this.x=t[0];this.y=t[1];
    }
    public final void set(Tuple2f t1){this.x=t1.x;this.y=t1.y;}
    public final void set(Tuple2d d){this.x=(float)d.x;this.y=(float)d.y;};

    public final void get(float[] t){
        if (t.length!=2)return;
        t[0]=x;t[1]=y;
    }

    public final void add(Tuple2f t1,Tuple2f t2){this.x=t1.x+t2.x;this.y=t1.y+ t2.y;}
    public final void add(Tuple2f t1){this.x=this.x+ t1.x;this.y=this.y+ t1.y;}

    public final void sub(Tuple2f t1,Tuple2f t2){this.x=t1.x-t2.x;this.y=t1.y- t2.y;}
    public final void sub(Tuple2f t1){this.x=this.x- t1.x;this.y=this.y- t1.y;}

    public final void negate(Tuple2f t1){this.x=(-1)* t1.x;this.y=(-1)*t1.y;}

    public final void scale(float s,Tuple2f t1){this.x=s* t1.x;this.y=s* t1.y;}
    public final void scale(float s){this.x=this.x*s;this.y=this.y*s;}

    public final void scaleAdd(float s,Tuple2f t1,Tuple2f t2){this.x=s*t1.x+t2.x;this.y=s*t1.y+t2.y;}
    public final void scaleAdd(float s,Tuple2f t1){this.x=this.x*s+t1.x;this.y=this.y*s+t1.y;}

    public int hashCode(){return (int) (this.x*this.y);}

    public boolean equals(Tuple2f t1){return t1.x == this.x && t1.y == this.y;}

    public boolean epsilonEquals(Tuple2f t1, float epsilon){
        float thisEpsilon=Math.max(Math.abs(this.x-t1.x),Math.abs(this.y-t1.y));
        return epsilon>=thisEpsilon;
    }

    @Override public String toString(){return "("+this.x+", "+this.y+")";}

    public final void clamp(float min, float max) {
        clampMin(min);
        clampMax(max);
    }
    public final void clamp(float min, float max, Tuple2f t){
        set(t);
        clamp(min, max);
    }

    public final void clampMin(float min){
        if (this.x<min)this.x=min;
        if (this.y<min)this.y=min;
    }
    public final void clampMin(float min,Tuple2f t){
        set(t);
        clampMin(min);
    }

    public final void clampMax(float max) {
        if(this.x > max)this.x = max;
        if(this.y > max)this.y=max;
    }
    public final void clampMax(float max,Tuple2f t){
        set(t);
        clampMax(max);
    }

    public final void absolute(){
        if (x < 0.0) this.x = -this.x;
        if (y < 0.0) this.y = -this.y;
    }

    public final void interpolate(Tuple2f t1, Tuple2f t2, float alpha) {
        set(t1);
        interpolate(t2, alpha);
    }

    public final void interpolate(Tuple2f t1, float alpha) {
        x = (1 - alpha)*x + alpha*t1.x;
        y = (1 - alpha)*y + alpha*t1.y;
    }

    abstract public Object clone();
}
