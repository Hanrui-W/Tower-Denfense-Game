package model;

public class Tower extends GameObject {
    private TowerType type;

    public Tower() {
        this(0, 0, new TowerType());
    }

    public Tower(int xPosition, int yPosition, TowerType type) {
        super(xPosition, yPosition);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tower{"
                + "xPosition=" + getxPosition()
                + ", yPosition=" + getyPosition()
                + ", type=" + type
                + '}';
    }

    public TowerType getType() {
        return type;
    }

    public void setType(TowerType type) {
        this.type = type;
    }
}

