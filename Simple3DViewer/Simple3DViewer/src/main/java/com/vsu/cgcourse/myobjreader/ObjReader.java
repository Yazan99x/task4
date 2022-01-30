package com.vsu.cgcourse.myobjreader;

import com.vsu.cgcourse.model.Mesh;
import com.vsu.cgcourse.myvecmath.Vector2f;
import com.vsu.cgcourse.myvecmath.Vector3f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ObjReader {

    private static final String objV = "v";
    private static final String objVT = "vt";
    private static final String objVN = "vn";
    private static final String objF = "f";

    private Mesh mesh;

    public Mesh ReadFile(String file) {
         mesh= new Mesh();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            ArrayList<String> arrayWords = Split(scanner.nextLine());
            if (arrayWords.isEmpty()) continue;
            switch (arrayWords.remove(0)) {
                case objV -> mesh.vertices.add(Vertex(arrayWords));
                case objVT -> mesh.textureVertices.add(Texture(arrayWords));
                case objVN -> mesh.normals.add(Normal(arrayWords));
                case objF -> Face(arrayWords);
                default -> {}
            }
        }
        return mesh;
    }

     private static ArrayList <String>  Split(String str){
        return new ArrayList<String>(Arrays.asList(str.split("\\s+")));
     }

    private static Vector3f Vertex(ArrayList<String> str){
        return new Vector3f(Float.parseFloat(str.get(0)),Float.parseFloat(str.get(1)),Float.parseFloat(str.get(2)));
    }

    private static Vector2f Texture(ArrayList<String> str){
        return new Vector2f(Float.parseFloat(str.get(0)),Float.parseFloat(str.get(1)));
    }

    private static Vector3f Normal(ArrayList<String> str){
        return new Vector3f(Float.parseFloat(str.get(0)),Float.parseFloat(str.get(1)),Float.parseFloat(str.get(2)));
    }

    private void Face(final ArrayList<String> wordsInLineWithoutToken) {
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<Integer>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<Integer>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<Integer>();

        for (String s : wordsInLineWithoutToken) {
            FaceWord(s, onePolygonVertexIndices, onePolygonTextureVertexIndices, onePolygonNormalIndices);
        }

        mesh.polygonVertexIndices.add(onePolygonVertexIndices);
        mesh.polygonTextureVertexIndices.add(onePolygonTextureVertexIndices);
        mesh.polygonNormalIndices.add(onePolygonNormalIndices);
    }

    private static void FaceWord(
            String wordInLine,
            ArrayList<Integer> PolygonVertexIndices,
            ArrayList<Integer> PolygonTextureVertexIndices,
            ArrayList<Integer> PolygonNormalIndices) {

        String[] wordIndices = wordInLine.split("/");
        switch (wordIndices.length) {
            case 1 -> PolygonVertexIndices.add(Integer.parseInt(wordIndices[0]) - 1);
            case 2 -> {
                PolygonVertexIndices.add(Integer.parseInt(wordIndices[0]) - 1);
                PolygonTextureVertexIndices.add(Integer.parseInt(wordIndices[1]) - 1);
            }
            case 3 -> {
                PolygonVertexIndices.add(Integer.parseInt(wordIndices[0]) - 1);
                PolygonNormalIndices.add(Integer.parseInt(wordIndices[2]) - 1);
                if (!wordIndices[1].equals("")) {
                    PolygonTextureVertexIndices.add(Integer.parseInt(wordIndices[1]) - 1);
                }
            }
        }
    }
 }

