package Shaders;

import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src/main/java/Shaders/vertexShader.txt";
    private static final String FRAGMENT_FILE = "src/main/java/Shaders/fragmentShader.txt";

    int location_transformationMatrix;
    int location_projectionMatrix;

    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute("position", 0);
        super.bindAttribute("textureCoords", 1);

    }

    @Override
    protected void getAllUniformLocations() {

        location_transformationMatrix = super.getUniformLocation("transformationMatrix");
        location_projectionMatrix = super.getUniformLocation("projectionMatrix");
    }

    public void loadTransformationMatrix(Matrix4f mat){
        super.loadMatrix(location_transformationMatrix, mat);
    }

    public void loadProjectionMatrix(Matrix4f mat){
        super.loadMatrix(location_projectionMatrix, mat);
    }
}
