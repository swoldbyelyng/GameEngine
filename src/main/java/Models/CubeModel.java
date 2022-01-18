package Models;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class CubeModel {

    public static float[] CROSSHAIR_POS = {

            -0.5f,0.5f,0.0f,
            -0.5f,-0.5f,0.0f,
            0.5f,-0.5f,0.0f,
            0.5f,-0.5f,0.0f,
            0.5f,0.5f,0.0f,
            -0.5f,0.5f,0.0f

    };

    public static float[] CROSSHAIR_UVS = {

            0.f, 0.f,
            0.f, 1.f,
            1.f, 1.f,
            1.f, 1.f,
            1.f, 0.f,
            0.f, 0.f

    };

    public static Vector3f[] PX_POS = {

            new Vector3f(0.5f,0.5f,-0.5f),
            new Vector3f(0.5f,-0.5f,-0.5f),
            new Vector3f(0.5f,-0.5f,0.5f),
            new Vector3f(0.5f,-0.5f,0.5f),
            new Vector3f(0.5f,0.5f,0.5f),
            new Vector3f(0.5f,0.5f,-0.5f)

    };

    public static Vector3f[] NX_POS = {

            new Vector3f(-0.5f,0.5f,-0.5f),
            new Vector3f(-0.5f,-0.5f,-0.5f),
            new Vector3f(-0.5f,-0.5f,0.5f),
            new Vector3f(-0.5f,-0.5f,0.5f),
            new Vector3f(-0.5f,0.5f,0.5f),
            new Vector3f(-0.5f,0.5f,-0.5f)

    };

    public static Vector3f[] PY_POS = {

            new Vector3f(-0.5f,0.5f,0.5f),
            new Vector3f(-0.5f,0.5f,-0.5f),
            new Vector3f(0.5f,0.5f,-0.5f),
            new Vector3f(0.5f,0.5f,-0.5f),
            new Vector3f(0.5f,0.5f,0.5f),
            new Vector3f(-0.5f,0.5f,0.5f)

    };

    public static Vector3f[] NY_POS = {

            new Vector3f(-0.5f,-0.5f,0.5f),
            new Vector3f(-0.5f,-0.5f,-0.5f),
            new Vector3f(0.5f,-0.5f,-0.5f),
            new Vector3f(0.5f,-0.5f,-0.5f),
            new Vector3f(0.5f,-0.5f,0.5f),
            new Vector3f(-0.5f,-0.5f,0.5f)

    };

    public static Vector3f[] PZ_POS = {

            new Vector3f(-0.5f,0.5f,0.5f),
            new Vector3f(-0.5f,-0.5f,0.5f),
            new Vector3f(0.5f,-0.5f,0.5f),
            new Vector3f(0.5f,-0.5f,0.5f),
            new Vector3f(0.5f,0.5f,0.5f),
            new Vector3f(-0.5f,0.5f,0.5f)

    };

    public static Vector3f[] NZ_POS = {

            new Vector3f(-0.5f,0.5f,-0.5f),
            new Vector3f(-0.5f,-0.5f,-0.5f),
            new Vector3f(0.5f,-0.5f,-0.5f),
            new Vector3f(0.5f,-0.5f,-0.5f),
            new Vector3f(0.5f,0.5f,-0.5f),
            new Vector3f(-0.5f,0.5f,-0.5f)

    };

    public static Vector2f[] UV_PX = {

            // GRASS
            new Vector2f(1.f / 16.f, 0.f),
            new Vector2f(1.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f / 16.f),
            new Vector2f(1.f / 16.f, 0.f),

            // DIRT
            new Vector2f(2.f / 16.f, 0.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f),

            // STONE
            new Vector2f(3.f / 16.f, 0.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 0.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f),

            // TREEBARK
            new Vector2f(4.f / 16.f, 0.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 0.f / 16.f),
            new Vector2f(4.f / 16.f, 0.f),

            // TREELEAF
            new Vector2f(6.f / 16.f, 0.f),
            new Vector2f(6.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 0.f / 16.f),
            new Vector2f(6.f / 16.f, 0.f)

    };

    public static Vector2f[] UV_NX = {

            // GRASS
            new Vector2f(1.f / 16.f, 0.f),
            new Vector2f(1.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f / 16.f),
            new Vector2f(1.f / 16.f, 0.f),

            // DIRT
            new Vector2f(2.f / 16.f, 0.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f),

            // STONE
            new Vector2f(3.f / 16.f, 0.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 0.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f),

            // TREEBARK
            new Vector2f(4.f / 16.f, 0.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 0.f / 16.f),
            new Vector2f(4.f / 16.f, 0.f),

            // TREELEAF
            new Vector2f(6.f / 16.f, 0.f),
            new Vector2f(6.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 0.f / 16.f),
            new Vector2f(6.f / 16.f, 0.f)

    };

    public static Vector2f[] UV_PY = {

            // GRASS
            new Vector2f(0.f, 0.f),
            new Vector2f(0.f, 1.f / 16.f),
            new Vector2f(1.f / 16.f, 1.f / 16.f),
            new Vector2f(1.f / 16.f, 1.f / 16.f),
            new Vector2f(1.f / 16.f, 0.f),
            new Vector2f(0.f, 0.f),

            // DIRT
            new Vector2f(2.f / 16.f, 0.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f),

            // STONE
            new Vector2f(3.f / 16.f, 0.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 0.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f),

            // TREEBARK
            new Vector2f(5.f / 16.f, 0.f),
            new Vector2f(5.f / 16.f, 1.f / 16.f),
            new Vector2f(6.f / 16.f, 1.f / 16.f),
            new Vector2f(6.f / 16.f, 1.f / 16.f),
            new Vector2f(6.f / 16.f, 0.f / 16.f),
            new Vector2f(5.f / 16.f, 0.f),

            // TREELEAF
            new Vector2f(6.f / 16.f, 0.f),
            new Vector2f(6.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 0.f / 16.f),
            new Vector2f(6.f / 16.f, 0.f)

    };

    public static Vector2f[] UV_NY = {

            // GRASS
            new Vector2f(2.f / 16.f, 0.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f),

            // DIRT
            new Vector2f(2.f / 16.f, 0.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f),

            // STONE
            new Vector2f(3.f / 16.f, 0.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 0.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f),

            // TREEBARK
            new Vector2f(5.f / 16.f, 0.f),
            new Vector2f(5.f / 16.f, 1.f / 16.f),
            new Vector2f(6.f / 16.f, 1.f / 16.f),
            new Vector2f(6.f / 16.f, 1.f / 16.f),
            new Vector2f(6.f / 16.f, 0.f / 16.f),
            new Vector2f(5.f / 16.f, 0.f),

            // TREELEAF
            new Vector2f(6.f / 16.f, 0.f),
            new Vector2f(6.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 0.f / 16.f),
            new Vector2f(6.f / 16.f, 0.f)

    };

    public static Vector2f[] UV_PZ = {

            // GRASS
            new Vector2f(1.f / 16.f, 0.f),
            new Vector2f(1.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f / 16.f),
            new Vector2f(1.f / 16.f, 0.f),

            // DIRT
            new Vector2f(2.f / 16.f, 0.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f),

            // STONE
            new Vector2f(3.f / 16.f, 0.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 0.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f),

            // TREEBARK
            new Vector2f(4.f / 16.f, 0.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 0.f / 16.f),
            new Vector2f(4.f / 16.f, 0.f),

            // TREELEAF
            new Vector2f(6.f / 16.f, 0.f),
            new Vector2f(6.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 0.f / 16.f),
            new Vector2f(6.f / 16.f, 0.f)

    };

    public static Vector2f[] UV_NZ = {

            // GRASS
            new Vector2f(1.f / 16.f, 0.f),
            new Vector2f(1.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f / 16.f),
            new Vector2f(1.f / 16.f, 0.f),

            // DIRT
            new Vector2f(2.f / 16.f, 0.f),
            new Vector2f(2.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f / 16.f),
            new Vector2f(2.f / 16.f, 0.f),

            // STONE
            new Vector2f(3.f / 16.f, 0.f),
            new Vector2f(3.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(4.f / 16.f, 0.f / 16.f),
            new Vector2f(3.f / 16.f, 0.f),

            // TREEBARK
            new Vector2f(4.f / 16.f, 0.f),
            new Vector2f(4.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 1.f / 16.f),
            new Vector2f(5.f / 16.f, 0.f / 16.f),
            new Vector2f(4.f / 16.f, 0.f),

            // TREELEAF
            new Vector2f(6.f / 16.f, 0.f),
            new Vector2f(6.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 1.f / 16.f),
            new Vector2f(7.f / 16.f, 0.f / 16.f),
            new Vector2f(6.f / 16.f, 0.f)

    };

    public static Vector3f[] NORMALS = {

            new Vector3f(0, 0, -1),     //nz
            new Vector3f(0, 0, 1),      //pz
            new Vector3f(1, 0 , 0),      //px
            new Vector3f(-1, 0 , 0),     //nx
            new Vector3f(0, 1, 0),      //py
            new Vector3f(0, -1, 0)      //ny

    };

    public static float[] vertices = {

            -0.5f,0.5f,-0.5f,   //back
            -0.5f,-0.5f,-0.5f,
            0.5f,-0.5f,-0.5f,
            0.5f,0.5f,-0.5f,

            -0.5f,0.5f,0.5f,    //front
            -0.5f,-0.5f,0.5f,
            0.5f,-0.5f,0.5f,
            0.5f,0.5f,0.5f,

            0.5f,0.5f,-0.5f,    //right
            0.5f,-0.5f,-0.5f,
            0.5f,-0.5f,0.5f,
            0.5f,0.5f,0.5f,

            -0.5f,0.5f,-0.5f,   //left
            -0.5f,-0.5f,-0.5f,
            -0.5f,-0.5f,0.5f,
            -0.5f,0.5f,0.5f,

            -0.5f,0.5f,0.5f,    //top
            -0.5f,0.5f,-0.5f,
            0.5f,0.5f,-0.5f,
            0.5f,0.5f,0.5f,

            -0.5f,-0.5f,0.5f,   //bottom
            -0.5f,-0.5f,-0.5f,
            0.5f,-0.5f,-0.5f,
            0.5f,-0.5f,0.5f

    };

    public static int[] indices = {

            0,1,3,
            3,1,2,
            4,5,7,
            7,5,6,
            8,9,11,
            11,9,10,
            12,13,15,
            15,13,14,
            16,17,19,
            19,17,18,
            20,21,23,
            23,21,22

    };

    public static float[] uv = {

            0, 0,
            0, 1,
            1, 1,
            1, 0,
            0, 0,
            0, 1,
            1, 1,
            1, 0,
            0, 0,
            0, 1,
            1, 1,
            1, 0,
            0, 0,
            0, 1,
            1, 1,
            1, 0,
            0, 0,
            0, 1,
            1, 1,
            1, 0,
            0, 0,
            0, 1,
            1, 1,
            1, 0
    };
}
