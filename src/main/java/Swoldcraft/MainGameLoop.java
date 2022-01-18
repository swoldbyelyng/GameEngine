package Swoldcraft;

import Chunks.Chunk;
import Chunks.ChunkMesh;
import Cube.Block;
import Entities.Camera;
import Entities.Entity;
import Entities.Light;
import Models.AtlasCubeModel;
import Models.CubeModel;
import Models.RawModel;
import Models.TexturedModel;
import RenderEngine.DisplayManager;
import RenderEngine.Loader;
import RenderEngine.MasterRenderer;
import Shaders.StaticShader;
import Textures.ModelTexture;
import Toolbox.PerlinNoiseGenerator;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainGameLoop {

    public static Loader loader1 = null;
    public static StaticShader shader1 = null;
    static List<ChunkMesh> chunksList = Collections.synchronizedList(new ArrayList<ChunkMesh>());
    static Vector3f camPos = new Vector3f(0, 0, 0);
    static List<Vector3f> occupiedChunkPos = new ArrayList<Vector3f>();
    static List<Entity> entities = new ArrayList<>();

    static final int WORLD_CHUNKS = 10;
    static final int CHUNK_SIZE = 32;
    static final int WORLD_SIZE = ((CHUNK_SIZE) * (WORLD_CHUNKS)) / 2;

    static boolean closeDisplay = false;

    public static void main(String[] args) {
        DisplayManager.createDisplay();
        Loader loader = new Loader();
        loader1 = loader;
        StaticShader shader = new StaticShader();
        shader1 = shader;
        MasterRenderer masterRenderer = new MasterRenderer();

        RawModel model = loader.loadToVAO(CubeModel.vertices, CubeModel.indices, CubeModel.uv);
        ModelTexture texture = new ModelTexture(loader.loadTexture("DefaultPack"));
        texture.setReflectivity(0.5f);
        texture.setShineDamper(10);
        TexturedModel texModel = new TexturedModel(model, texture);



        Camera camera = new Camera(new Vector3f(0, 15, 0), 0, 0, 0);
        camPos = camera.getPosition();
        Light light = new Light(new Vector3f(0, 30, 0), new Vector3f(1, 1, 1));

        PerlinNoiseGenerator generator = new PerlinNoiseGenerator();

        new Thread(() -> { //Thread-1

            while (!Display.isCloseRequested()) {
                try {
                    for (int x = (int) (camPos.x - WORLD_SIZE) / CHUNK_SIZE; x < (camPos.x + WORLD_SIZE) / CHUNK_SIZE; x++) {
                        for (int z = (int) (camPos.z - WORLD_SIZE) / CHUNK_SIZE; z < (camPos.z + WORLD_SIZE) / CHUNK_SIZE; z++) {

                            if (!occupiedChunkPos.contains(new Vector3f(x * CHUNK_SIZE, 0, z * CHUNK_SIZE))) {
                                List<Block> blocks = new ArrayList<Block>();

                                for (int i = 0; i < CHUNK_SIZE; i++) {
                                    for (int j = 0; j < CHUNK_SIZE; j++) {
                                        blocks.add(new Block(i, (int) generator.generateHeight(i + (x * CHUNK_SIZE), j + (z * CHUNK_SIZE)), j, Block.GRASS));
                                    }
                                }

                                Chunk chunk = new Chunk(blocks, new Vector3f(x * CHUNK_SIZE, 0, z * CHUNK_SIZE));
                                ChunkMesh chunkMesh = new ChunkMesh(chunk);
                                chunksList.add(chunkMesh);
                                occupiedChunkPos.add(new Vector3f(x * CHUNK_SIZE, 0, z * CHUNK_SIZE));
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Something went wrong in thread-1");
                    System.exit(-1);
                }
            }
        }).start();
/*
        List<Block> blocks = new ArrayList<Block>();
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                for(int z = 0; z < 10; z++){
                    blocks.add(new Block(x, y, z, Block.TYPE.DIRT));
                }
            }
        }
        Chunk chunk = new Chunk(blocks, new Vector3f(0, 0, 0));
        ChunkMesh chunkMesh = new ChunkMesh(chunk);

        RawModel model123 = loader.loadToVAO(chunkMesh.positions, chunkMesh.uvs);
        TexturedModel texturedModel123 = new TexturedModel(model123, texture);
        Entity entity = new Entity(texturedModel123, new Vector3f(0, 0, 0), 0, 0, 0, 1);
*/
        //Main game loop:
        int index = 0;
        while (!Display.isCloseRequested()) {
            camera.move();
            camPos = camera.getPosition();
            //light.setPosition(camPos);

            if (index < chunksList.size()) {

                RawModel model123 = loader.loadToVAO(chunksList.get(index).positions, chunksList.get(index).uvs, chunksList.get(index).normals);
                TexturedModel texturedModel123 = new TexturedModel(model123, texture);


                Entity entity123 = new Entity(texturedModel123, chunksList.get(index).chunk.origin, 0.f, 0.f, 0.f, 1.f);
                entities.add(entity123);

                chunksList.get(index).positions = null;
                chunksList.get(index).normals = null;
                chunksList.get(index).uvs = null;
                index++;
            }

            for (int i = 0; i < entities.size(); i++) {

                Vector3f origin = entities.get(i).getPosition();
                int distX = (int) (camPos.x - origin.x);
                int distZ = (int) (camPos.z - origin.z);

                if (distX < 0) {
                    distX = -distX;
                }
                if (distZ < 0) {
                    distZ = -distZ;
                }
                if ((distX <= WORLD_SIZE) && (distZ <= WORLD_SIZE)) {
                    masterRenderer.addEntity(entities.get(i));
                }
            }
            //masterRenderer.addEntity(entity);
            masterRenderer.render(camera, light);

            DisplayManager.updateDisplay();
        }

        DisplayManager.closeDisplay();
    }


    private void updateTerrain() {

    }
}
