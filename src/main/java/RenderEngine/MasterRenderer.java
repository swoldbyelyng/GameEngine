package RenderEngine;

import Entities.Entity;
import Shaders.StaticShader;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;


public class MasterRenderer {

    Matrix4f projectionMatrix;

    public MasterRenderer(StaticShader shader) {
        createProjectionMatrix();
        shader.start();
        shader.loadProjectionMatrix(projectionMatrix);
        shader.stop();
    }

    private static final float FOV = 90;
    private static final float NEAR_PLANE = 0.01f;
    private static final float FAR_PLANE = 20f;

    public void prepare() {
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glClearColor(1, 1, 0.6f, 0.2f);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    public void render(Entity entity, StaticShader shader) {
        EntityRenderer.render(entity, shader);
    }

    public void createProjectionMatrix() {

        projectionMatrix = new Matrix4f();

        float aspect = (float) Display.getWidth() / (float) Display.getHeight();
        float yScale = 1f / (float) Math.tan(Math.toRadians(FOV / 2f));
        float xScale = yScale / aspect;
        float zp = FAR_PLANE + NEAR_PLANE;
        float zm = FAR_PLANE - NEAR_PLANE;

        projectionMatrix.m00 = xScale;
        projectionMatrix.m11 = yScale;
        projectionMatrix.m22 = -zp / zm;
        projectionMatrix.m23 = -1;
        projectionMatrix.m32 = -(2 * FAR_PLANE * NEAR_PLANE) / zm;
        projectionMatrix.m33 = 0;
    }

}
