package Swoldcraft;

import Entities.Camera;
import Entities.Entity;
import Models.CubeModel;
import Models.RawModel;
import Models.TexturedModel;
import RenderEngine.DisplayManager;
import RenderEngine.Loader;
import RenderEngine.MasterRenderer;
import Shaders.StaticShader;
import Textures.ModelTexture;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class MainGameLoop {

    public static Loader loader1 = null;
    public static StaticShader shader1 = null;
    static List<Entity> entitiesList = Collections.synchronizedList(new ArrayList<Entity>());
    static Vector3f camPos = new Vector3f(0, 0, 0);
    static List<Vector3f> occupiedPos = new ArrayList<Vector3f>();
    static final int WORLD_SIZE = 75;

    public static void main(String[] args) {
        DisplayManager.createDisplay();
        Loader loader = new Loader();
        loader1 = loader;
        StaticShader shader = new StaticShader();
        shader1 = shader;
        MasterRenderer masterRenderer = new MasterRenderer();

        RawModel model = loader.loadToVAO(CubeModel.vertices, CubeModel.indices, CubeModel.uv);
        ModelTexture texture = new ModelTexture(loader.loadTexture("pinkBlock"));
        TexturedModel texModel = new TexturedModel(model, texture);


        Camera camera = new Camera(new Vector3f(0, 0, 0), 0, 0, 0);
        camPos = camera.getPosition();

        new Thread(() -> {

            while (!Display.isCloseRequested()) {
                try {
                    for (int x = (int) camPos.x; x < camPos.x + WORLD_SIZE; x++) {
                        for (int z = (int) camPos.z - WORLD_SIZE; z < camPos.z; z++) {
                            if (!occupiedPos.contains(new Vector3f(x, 0, z))) {
                                entitiesList.add(new Entity(texModel, new Vector3f(x, 0, z), 0, 0, 0, 1));
                                occupiedPos.add(new Vector3f(x, 0, z));
                            }
                        }
                    }
                    for (int x = (int) camPos.x; x < camPos.x + WORLD_SIZE; x++) {
                        for (int z = (int) camPos.z; z < camPos.z + WORLD_SIZE; z++) {
                            if (!occupiedPos.contains(new Vector3f(x, 0, z))) {
                                entitiesList.add(new Entity(texModel, new Vector3f(x, 0, z), 0, 0, 0, 1));
                                occupiedPos.add(new Vector3f(x, 0, z));
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Something went wring in Thread 1");
                    System.exit(0);
                }
            }
        }).start();

        new Thread(() -> {
            while (!Display.isCloseRequested()) {
                try {
                    for (int x = (int) camPos.x - WORLD_SIZE; x < camPos.x; x++) {
                        for (int z = (int) camPos.z; z < camPos.z + WORLD_SIZE; z++) {
                            if (!occupiedPos.contains(new Vector3f(x, 0, z))) {
                                entitiesList.add(new Entity(texModel, new Vector3f(x, 0, z), 0, 0, 0, 1));
                                occupiedPos.add(new Vector3f(x, 0, z));
                            }
                        }
                    }
                    for (int x = (int) camPos.x - WORLD_SIZE; x < camPos.x; x++) {
                        for (int z = (int) camPos.z - WORLD_SIZE; z < camPos.z; z++) {
                            if (!occupiedPos.contains(new Vector3f(x, 0, z))) {
                                entitiesList.add(new Entity(texModel, new Vector3f(x, 0, z), 0, 0, 0, 1));
                                occupiedPos.add(new Vector3f(x, 0, z));
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Something went wrong in thread 2");
                    System.exit(0);
                }
            }
        }).start();

        /*new Thread(() -> {

        }).start(); */

        while (!Display.isCloseRequested()) {
            camera.move();
            camPos = camera.getPosition();


            for (int i = 0; i < entitiesList.size(); i++) {
                int distX = (int) (camPos.x - entitiesList.get(i).getPosition().x);
                int distZ = (int) (camPos.z - entitiesList.get(i).getPosition().z);

                if (distX < 0) {
                    distX = -distX;
                }
                if (distZ < 0) {
                    distZ = -distZ;
                }
                if ((distX >= WORLD_SIZE) || (distZ <= WORLD_SIZE)) {
                    masterRenderer.addEntity(entitiesList.get(i));
                }


            }
            masterRenderer.render(camera);

            DisplayManager.updateDisplay();
        }

        DisplayManager.closeDisplay();
    }


    private void updateTerrain() {

    }
}
