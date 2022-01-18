package Chunks;

import Cube.Block;
import Cube.Vertex;
import Models.CubeModel;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;

public class ChunkMesh {

    private List<Vertex> vertices;

    private List<Float> positionList, uvList, normalsList;
    public float[] positions, uvs, normals;

    public Chunk chunk;

    public ChunkMesh(Chunk chunk) {
        this.chunk = chunk;

        vertices = new ArrayList<Vertex>();
        positionList = new ArrayList<Float>();
        uvList = new ArrayList<Float>();
        normalsList = new ArrayList<Float>();

        buildMesh();
        populateLists();
    }

    public void update(Chunk chunk) {
        this.chunk = chunk;

        buildMesh();
        populateLists();
    }

    private void buildMesh() {
        // Loop through block in chunk and determine which faces are visible

        for (int i = 0; i < chunk.blocks.size(); i++) {

            Block blockI = chunk.blocks.get(i);
            boolean px = false, nx = false, py = false, ny = false, pz = false, nz = false;

            for (int j = 0; j < chunk.blocks.size(); j++) {
                Block blockJ = chunk.blocks.get(j);
                // PX
                if (((blockI.x + 1) == (blockJ.x)) && ((blockI.y) == (blockJ.y)) && ((blockI.z) == (blockJ.z))) {
                    px = true;
                }
                //NX
                if (((blockI.x - 1) == (blockJ.x)) && ((blockI.y) == (blockJ.y)) && ((blockI.z) == (blockJ.z))) {
                    nx = true;
                }
                //PY
                if (((blockI.x) == (blockJ.x)) && ((blockI.y + 1) == (blockJ.y)) && ((blockI.z) == (blockJ.z))) {
                    py = true;
                }
                //NY
                if (((blockI.x) == (blockJ.x)) && ((blockI.y - 1) == (blockJ.y)) && ((blockI.z) == (blockJ.z))) {
                    ny = true;
                }
                //PZ
                if (((blockI.x) == (blockJ.x)) && ((blockI.y) == (blockJ.y)) && ((blockI.z + 1) == (blockJ.z))) {
                    pz = true;
                }
                //NZ
                if (((blockI.x) == (blockJ.x)) && ((blockI.y) == (blockJ.y)) && ((blockI.z - 1) == (blockJ.z))) {
                    nz = true;
                }
            }

            //Add visible faces to the chunk mesh
            if (!px) {
                for (int k = 0; k < 6; k++) {
                    vertices.add(new Vertex(new Vector3f(CubeModel.PX_POS[k].x + blockI.x, CubeModel.PX_POS[k].y + blockI.y, CubeModel.PX_POS[k].z + blockI
                            .z), CubeModel.UV_PX[(blockI.type * 6) + k], CubeModel.NORMALS[2]));
                }
            }
            if (!nx) {
                for (int k = 0; k < 6; k++) {
                    vertices.add(new Vertex(new Vector3f(CubeModel.NX_POS[k].x + blockI.x, CubeModel.NX_POS[k].y + blockI.y, CubeModel.NX_POS[k].z + blockI
                            .z), CubeModel.UV_NX[(blockI.type * 6) + k], CubeModel.NORMALS[3]));
                }
            }
            if (!py) {
                for (int k = 0; k < 6; k++) {
                    vertices.add(new Vertex(new Vector3f(CubeModel.PY_POS[k].x + blockI.x, CubeModel.PY_POS[k].y + blockI.y, CubeModel.PY_POS[k].z + blockI
                            .z), CubeModel.UV_PY[(blockI.type * 6) + k], CubeModel.NORMALS[4]));
                }
            }
            if (!ny) {
                for (int k = 0; k < 6; k++) {
                    vertices.add(new Vertex(new Vector3f(CubeModel.NY_POS[k].x + blockI.x, CubeModel.NY_POS[k].y + blockI.y, CubeModel.NY_POS[k].z + blockI
                            .z), CubeModel.UV_NY[(blockI.type * 6) + k], CubeModel.NORMALS[5]));
                }
            }
            if (!pz) {
                for (int k = 0; k < 6; k++) {
                    vertices.add(new Vertex(new Vector3f(CubeModel.PZ_POS[k].x + blockI.x, CubeModel.PZ_POS[k].y + blockI.y, CubeModel.PZ_POS[k].z + blockI
                            .z), CubeModel.UV_PZ[(blockI.type * 6) + k], CubeModel.NORMALS[1]));
                }
            }
            if (!nz) {
                for (int k = 0; k < 6; k++) {
                    vertices.add(new Vertex(new Vector3f(CubeModel.NZ_POS[k].x + blockI.x, CubeModel.NZ_POS[k].y + blockI.y, CubeModel.NZ_POS[k].z + blockI
                            .z), CubeModel.UV_NZ[(blockI.type * 6) + k], CubeModel.NORMALS[0]));
                }
            }

        }
    }


    private void populateLists() {
        for (int i = 0; i < vertices.size(); i++) {
            positionList.add(vertices.get(i).positions.x);
            positionList.add(vertices.get(i).positions.y);
            positionList.add(vertices.get(i).positions.z);
            uvList.add(vertices.get(i).uvs.x);
            uvList.add(vertices.get(i).uvs.y);
            normalsList.add(vertices.get(i).normals.x);
            normalsList.add(vertices.get(i).normals.y);
            normalsList.add(vertices.get(i).normals.z);
        }

        positions = new float[positionList.size()];
        uvs = new float[uvList.size()];
        normals = new float[normalsList.size()];

        for (int i = 0; i < positionList.size(); i++) {
            positions[i] = positionList.get(i);
        }
        for (int i = 0; i < uvList.size(); i++) {
            uvs[i] = uvList.get(i);
        }
        for (int i = 0; i < normalsList.size(); i++) {
            normals[i] = normalsList.get(i);
        }

        positionList.clear();
        uvList.clear();
        normalsList.clear();

    }
}
