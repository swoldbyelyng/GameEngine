package Entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
    Vector3f position;
    float rotX;
    float rotY;
    float rotZ;
    float speed = 0.1f;
    float mouseSensitivity = 0.1f;
    float forwardMove = 0;
    float lateralMove= 0;

    public Camera(Vector3f position, float rotX, float rotY, float rotZ) {
        this.position = position;
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
    }

    public void move(){

        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            forwardMove = -speed;
        }else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            forwardMove = speed;
        }else {
            forwardMove = 0;
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            lateralMove = -speed;
        }else if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            lateralMove = speed;
        }else {
            lateralMove = 0;
        }

        rotX += -Mouse.getDY();
        rotY += Mouse.getDX();

        float dx = (float) -(forwardMove * Math.sin(Math.toRadians(rotY)));
        float dy = (float) (forwardMove * Math.sin(Math.toRadians(rotX)));
        float dz = (float) (forwardMove * Math.cos(Math.toRadians(rotY)));

        float ldx = (float) -(lateralMove * Math.sin(Math.toRadians(rotY-90)));
        float ldz = (float) (lateralMove * Math.cos(Math.toRadians(rotY-90)));

        position.x += dx + ldx;
        position.y += dy;
        position.z += dz + ldz;
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getRotX() {
        return rotX;
    }

    public float getRotY() {
        return rotY;
    }

    public float getRotZ() {
        return rotZ;
    }
}
