package RenderEngine;

import Models.TexturedModel;
import org.lwjgl.opengl.GL11;


public class MasterRenderer {

    public void prepare(){
        GL11.glClearColor(0.4f, 0.7f, 1.0f, 1);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

    public void render(TexturedModel model) {
        EntityRenderer.render(model);
    }

}
