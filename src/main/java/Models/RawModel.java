package Models;

public class RawModel {

    int vaoID;
    int indexCount;

    public RawModel(int vaoID, int indexCount){
        this.vaoID = vaoID;
        this.indexCount = indexCount;
    }

    public int getVaoID() {
        return vaoID;
    }

    public int getIndexCount() {
        return indexCount;
    }
}
