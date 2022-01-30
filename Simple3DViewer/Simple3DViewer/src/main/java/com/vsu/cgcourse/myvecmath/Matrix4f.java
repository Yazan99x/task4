package com.vsu.cgcourse.myvecmath;

import java.io.Serializable;

public class Matrix4f implements Serializable {
    public float[][] m=new float[4][4];

    public Matrix4f(float m00, float m01, float m02, float m03,
                    float m10, float m11, float m12, float m13,
                    float m20, float m21, float m22, float m23,
                    float m30, float m31, float m32, float m33)  {
        set(m00, m01, m02, m03,
                m10, m11, m12, m13,
                m20, m21, m22, m23,
                m30, m31, m32, m33);
    }
    public Matrix4f(float v[]) {
        set(v);
    }
    public Matrix4f(Matrix4f m1) {set(m1);}
    public Matrix4f() {
        setZero();
    }

    public String toString() {
        String s = System.getProperty("line.separator");
        String str="["+s+"[";
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++) {
                str += m[i][j];
                if (i==3 && j==3) str+="] ]";
                else if(j==3)str+="]"+s+" [";
                else str+="\t";
            }
        return str;
    }
    public final void setIdentity() {
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
                if (i==j)
                    m[i][j]=1.0f;
                else
                    m[i][j]=0.0f;
    }

    public final void set(Matrix4f m1) {
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
                this.m[i][j]=m1.m[i][j];
    }
    public final void set(float m[]) {
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
                this.m[i][j]=m[i*4+j];
    }

    public final void setZero() {
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
                this.m[i][j]=0.0f;
    }

    private void set(float m00, float m01, float m02, float m03,
                     float m10, float m11, float m12, float m13,
                     float m20, float m21, float m22, float m23,
                     float m30, float m31, float m32, float m33) {
        this.m[0][0] = m00; this.m[0][1] = m01; this.m[0][2] = m02; this.m[0][3] = m03;
        this.m[1][0] = m10; this.m[1][1] = m11; this.m[1][2] = m12; this.m[1][3] = m13;
        this.m[2][0] = m20; this.m[2][1] = m21; this.m[2][2] = m22; this.m[2][3] = m23;
        this.m[3][0] = m30; this.m[3][1] = m31; this.m[3][2] = m32; this.m[3][3] = m33;
    }

    public final void mul(Matrix4f m1) {
        mul(this, m1);
    }
    public final void mul(Matrix4f m1, Matrix4f m2) {
        set(
                m1.m[0][0]*m2.m[0][0] + m1.m[0][1]*m2.m[1][0] + m1.m[0][2]*m2.m[2][0] + m1.m[0][3]*m2.m[3][0],
                m1.m[0][0]*m2.m[0][1] + m1.m[0][1]*m2.m[1][1] + m1.m[0][2]*m2.m[2][1] + m1.m[0][3]*m2.m[3][1],
                m1.m[0][0]*m2.m[0][2] + m1.m[0][1]*m2.m[1][2] + m1.m[0][2]*m2.m[2][2] + m1.m[0][3]*m2.m[3][2],
                m1.m[0][0]*m2.m[0][3] + m1.m[0][1]*m2.m[1][3] + m1.m[0][2]*m2.m[2][3] + m1.m[0][3]*m2.m[3][3],

                m1.m[1][0]*m2.m[0][0] + m1.m[1][1]*m2.m[1][0] + m1.m[1][2]*m2.m[2][0] + m1.m[1][3]*m2.m[3][0],
                m1.m[1][0]*m2.m[0][1] + m1.m[1][1]*m2.m[1][1] + m1.m[1][2]*m2.m[2][1] + m1.m[1][3]*m2.m[3][1],
                m1.m[1][0]*m2.m[0][2] + m1.m[1][1]*m2.m[1][2] + m1.m[1][2]*m2.m[2][2] + m1.m[1][3]*m2.m[3][2],
                m1.m[1][0]*m2.m[0][3] + m1.m[1][1]*m2.m[1][3] + m1.m[1][2]*m2.m[2][3] + m1.m[1][3]*m2.m[3][3],

                m1.m[2][0]*m2.m[0][0] + m1.m[2][1]*m2.m[1][0] + m1.m[2][2]*m2.m[2][0] + m1.m[2][3]*m2.m[3][0],
                m1.m[2][0]*m2.m[0][1] + m1.m[2][1]*m2.m[1][1] + m1.m[2][2]*m2.m[2][1] + m1.m[2][3]*m2.m[3][1],
                m1.m[2][0]*m2.m[0][2] + m1.m[2][1]*m2.m[1][2] + m1.m[2][2]*m2.m[2][2] + m1.m[2][3]*m2.m[3][2],
                m1.m[2][0]*m2.m[0][3] + m1.m[2][1]*m2.m[1][3] + m1.m[2][2]*m2.m[2][3] + m1.m[2][3]*m2.m[3][3],

                m1.m[3][0]*m2.m[0][0] + m1.m[3][1]*m2.m[1][0] + m1.m[3][2]*m2.m[2][0] + m1.m[3][3]*m2.m[3][0],
                m1.m[3][0]*m2.m[0][1] + m1.m[3][1]*m2.m[1][1] + m1.m[3][2]*m2.m[2][1] + m1.m[3][3]*m2.m[3][1],
                m1.m[3][0]*m2.m[0][2] + m1.m[3][1]*m2.m[1][2] + m1.m[3][2]*m2.m[2][2] + m1.m[3][3]*m2.m[3][2],
                m1.m[3][0]*m2.m[0][3] + m1.m[3][1]*m2.m[1][3] + m1.m[3][2]*m2.m[2][3] + m1.m[3][3]*m2.m[3][3]
        );
    }
}
