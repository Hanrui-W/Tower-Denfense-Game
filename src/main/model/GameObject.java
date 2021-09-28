package model;

public abstract class GameObject extends Position {

    public GameObject(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    public GameObject() {
        super();
    }
}
