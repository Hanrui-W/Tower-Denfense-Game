package model;

public class GameObject {
    private int xPosition;
    private int yPosition;

    public GameObject(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public GameObject() {
        this.xPosition = 0;
        this.yPosition = 0;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    @Override
    public String toString() {
        return "Position{"
                + "xPosition=" + xPosition
                + ", yPosition=" + yPosition
                + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof GameObject) {
            return (this.xPosition == ((GameObject) object).getxPosition()
                    && this.yPosition == ((GameObject) object).getyPosition());
        } else {
            return false;
        }
    }
}
