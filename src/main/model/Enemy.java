package model;

public class Enemy extends Position implements GameObject{
    private double speed;
    private double health;

    public Enemy() {
        this(0, 0, 0.0, 1);
    }

    public Enemy(int xPosition, int yPosition, double speed, double health) {
        super(xPosition, yPosition);
        this.speed = speed;
        this.health = health;
    }

    public String toString() {
        return "Enemy{" +
                "xPosition=" + getxPosition() +
                ", yPosition=" + getyPosition() +
                ", speed=" + speed +
                '}';
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
