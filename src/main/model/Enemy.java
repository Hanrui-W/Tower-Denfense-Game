package model;

public class Enemy extends GameObject {
    private double speed;
    private double health;
    private double level;

    public Enemy() {
        this(0, 0, 0.0, 1, 1);
    }

    public Enemy(int xPosition, int yPosition, double speed, double health, double level) {
        super(xPosition, yPosition);
        this.level = level;
        this.speed = speed + (level * 5);
        this.health = health + (level * 100);
    }

    public String toString() {
        return "Enemy {"
                + "xPosition=" + getxPosition()
                + ", yPosition=" + getyPosition()
                + ", speed=" + speed
                + ", health=" + health
                + ", level=" + level
                + '}';
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

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }
}
