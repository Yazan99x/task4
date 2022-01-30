package com.vsu.cgcourse.myobjwriter;

import com.vsu.cgcourse.model.Mesh;
import com.vsu.cgcourse.myvecmath.Vector2f;
import com.vsu.cgcourse.myvecmath.Vector3f;

import java.util.ArrayList;

public class ObjWriter {
    Mesh mesh;
    public String WriteFile(Mesh mesh){
        this.mesh=mesh;
        String lines="";
        lines+=Vertex(mesh.vertices);
        lines+="# "+mesh.vertices.size()+" vertices\n\n";
        lines+=Normal(mesh.normals);
        lines+="# "+mesh.normals.size()+" vertex normals\n\n\n";
        lines+=Texture(mesh.textureVertices);
        lines+="# "+mesh.textureVertices.size()+" texture coords\n\n";
        lines+=Face();
        lines+="# "+mesh.polygonVertexIndices.size()+"\n\n";
    return lines;
    }

    private static String Vertex(ArrayList<Vector3f> vectors){
        String str="";
        for (int i=0;i< vectors.size();i++)
            str+="v "+vectors.get(i).x+" "+vectors.get(i).y+" "+ vectors.get(i).z+"\n";
        return str;
    }

    private static String Texture(ArrayList<Vector2f> vectors){
        String str="";
        for (int i=0;i< vectors.size();i++)
            str+="vt "+vectors.get(i).x+" "+vectors.get(i).y+"\n";
        return str;
    }

    private static String Normal(ArrayList<Vector3f> vectors){
        String str="";
        for (int i=0;i< vectors.size();i++)
            str+="vn "+vectors.get(i).x+" "+vectors.get(i).y+" "+ vectors.get(i).z+"\n";
        return str;
    }

    private String Face() {
        String str="";
        for (int i=0;i<mesh.polygonVertexIndices.size();i++) {
            str+="f ";
            for (int j = 0; j < mesh.polygonVertexIndices.get(i).size(); j++) {
                str += (mesh.polygonVertexIndices.get(i).get(j) + 1) + "/" + (mesh.polygonTextureVertexIndices.get(i).get(j) + 1) + "/" + (mesh.polygonNormalIndices.get(i).get(j) + 1);
                if (j!=mesh.polygonVertexIndices.get(i).size()-1) str+=" ";
            }
            str+="\n";
        }
        return str;
    }
}
