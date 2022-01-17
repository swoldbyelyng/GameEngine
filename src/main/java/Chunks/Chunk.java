package Chunks;

import Cube.Block;
import Entities.Entity;
import org.lwjgl.util.vector.Vector3f;

import java.util.List;

public class Chunk {

    public List<Entity> blocks;
    public Vector3f origin;

    public Chunk(List<Entity> blocks, Vector3f origin) {
        this.blocks = blocks;
        this.origin = origin;
    }

    public List<Entity> getBlocks() {
        return blocks;
    }

    public Vector3f getOrigin() {
        return origin;
    }
}
