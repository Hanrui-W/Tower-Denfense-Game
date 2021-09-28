package model;

public class Monument extends GameObject{
    private double health;

    public Monument() {
        this(0, 0, 0.0);
    }

    public Monument(int xPosition, int yPosition, double health) {
        super(xPosition, yPosition);
        this.health = health;
    }

    @Override
    public String toString() {
        return "Monument{" +
                "xPosition=" + getxPosition() +
                ", yPosition=" + getyPosition() +
                "health=" + health +
                '}';
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
