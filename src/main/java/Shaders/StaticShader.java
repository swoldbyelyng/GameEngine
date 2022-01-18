package Shaders;

import Entities.Camera;
import Entities.Light;
import Toolbox.Maths;
import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src/main/java/Shaders/vertexShader.txt";
    private static final String FRAGMENT_FILE = "src/main/java/Shaders/fragmentShader.txt";

    private int location_transformationMatrix;
    private int location_projectionMatrix;
    private int location_viewMatrix;
    private int location_lightPosition;
    private int location_lightColor;
    private int location_shineDamper;
    private int location_reflectivity;


    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute("position", 0);
        super.bindAttribute("textureCoords", 1);
        super.bindAttribute("normal", 2);

    }

    @Override
    protected void getAllUniformLocations() {

        location_transformationMatrix = super.getUniformLocation("transformationMatrix");
        location_projectionMatrix = super.getUniformLocation("projectionMatrix");
        location_viewMatrix = super.getUniformLocation("viewMatrix");
        location_lightColor = super.getUniformLocation("lightColor");
        location_lightPosition = super.getUniformLocation("lightPosition");
        location_shineDamper = super.getUniformLocation("shineDamper");
        location_reflectivity = super.getUniformLocation("reflectivity");
    }

    public void loadShineVariables(float damper, float reflectivity) {
        super.loadFloat(location_shineDamper, damper);
        super.loadFloat(location_reflectivity, reflectivity);
    }

    public void loadTransformationMatrix(Matrix4f mat) {
        super.loadMatrix(location_transformationMatrix, mat);
    }

    public void loadProjectionMatrix(Matrix4f mat) {
        super.loadMatrix(location_projectionMatrix, mat);
    }

    public void loadLight(Light light) {
        super.load3DVector(location_lightPosition, light.getPosition());
        super.load3DVector(location_lightColor, light.getColor());
    }

    public void loadViewMatrix(Camera camera) {
        super.loadMatrix(location_viewMatrix, Maths.createViewMatrix(camera));
    }
}
