package model;

public class Tower extends GameObject {
    private TowerType type;
    private int level;

    public Tower() {
        this(0, 0, new TowerType());
    }

    public Tower(int xPosition, int yPosition, TowerType type) {
        super(xPosition, yPosition);
        this.type = type;
        this.level = 1;
    }

    @Override
    public String toString() {
        return "Tower{"
                + "xPosition=" + getxPosition()
                + ", yPosition=" + getyPosition()
                + ", type=" + type
                + '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TowerType getType() {
        return type;
    }

    public void setType(TowerType type) {
        this.type = type;
    }
}

