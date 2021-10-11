package model;

public class Tower extends GameObject {
    private int level;
    private TowerType type;
    private int attackRange;

    public Tower() {
        this(0, 0, 0, new TowerType(), 0);
    }

    public Tower(int xPosition, int yPosition, int level, TowerType type, int attackRange) {
        super(xPosition, yPosition);
        this.level = level;
        this.type = type;
        this.attackRange = attackRange;
    }

    @Override
    public String toString() {
        return "Tower{"
                + "xPosition=" + getxPosition()
                + ", yPosition=" + getyPosition()
                + ", level=" + level
                + ", type=" + type
                + ", attackRange=" + attackRange
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

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }
}

