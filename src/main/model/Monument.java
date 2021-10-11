package model;

public class Monument extends GameObject {
    private int health;

    public Monument() {
        this(0, 0, 0);
    }

    public Monument(int xPosition, int yPosition, int health) {
        super(xPosition, yPosition);
        this.health = health;
    }

    @Override
    public String toString() {
        return "Monument{"
                + "xPosition=" + getxPosition()
                + ", yPosition=" + getyPosition()
                + "health=" + health
                + '}';
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
