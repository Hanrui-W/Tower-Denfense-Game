package model;

public class Enemy extends GameObject{
    private double speed;

    public Enemy() {
        this(0, 0, 0.0);
    }

    public Enemy(int xPosition, int yPosition, double speed) {
        super(xPosition, yPosition);
        this.speed = speed;
    }

    public String toString() {
        return "Enemy{" +
                "xPosition=" + getxPosition() +
                ", yPosition=" + getyPosition() +
                ", speed=" + speed +
                '}';
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
