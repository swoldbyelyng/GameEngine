package Cube;

public class Block {

    public int x, y, z;
    public TYPE type;

    public static enum TYPE {
        DIRT,
        GRASS;
    };

    public Block(int x, int y, int z, TYPE type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
    }
}
