package RenderEngine;

import Entities.Entity;
import Models.TexturedModel;
import Shaders.StaticShader;
import Textures.ModelTexture;
import Toolbox.Maths;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;

import java.util.List;
import java.util.Map;

public class EntityRenderer {

    StaticShader shader = new StaticShader();

    //perhaps unnecessary to bind the texture during every draw, since all blocks are using the same texture.
    public void render(Map<TexturedModel, List<Entity>> entities) {
        for (TexturedModel model : entities.keySet()) {
            GL30.glBindVertexArray(model.getModel().getVaoID());
            GL20.glEnableVertexAttribArray(0);
            GL20.glEnableVertexAttribArray(1);
            GL20.glEnableVertexAttribArray(2);
            ModelTexture texture = model.getTexture();
            shader.loadShineVariables(texture.getShineDamper(), texture.getReflectivity());

            GL13.glActiveTexture(GL13.GL_TEXTURE0);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getTextureID());

            List<Entity> batch = entities.get(model);

            for (Entity entity : batch) {
                Matrix4f transformationMatrix = Maths.createTransformationMatrix(entity.getPosition(), entity.getRotX(), entity.getRotY(), entity.getRotZ(), entity.getScale());
                shader.loadTransformationMatrix(transformationMatrix);

                GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getModel().getIndexCount());

            }

            GL20.glDisableVertexAttribArray(0);
            GL20.glDisableVertexAttribArray(1);
            GL20.glDisableVertexAttribArray(2);
            GL30.glBindVertexArray(0);

        }
    }
}
