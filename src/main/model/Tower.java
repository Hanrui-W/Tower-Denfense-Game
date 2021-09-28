package model;

public class Tower extends GameObject{
    private int xPosition;
    private int yPosition;
    private int level;
    private TowerType type;
    private int attackRange;

    public Tower() {
        this(0, 0, 0, new TowerType(), 0);
    }

    public Tower(int xPosition, int yPosition, int level, TowerType type, int attackRange) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.level = level;
        this.type = type;
        this.attackRange = attackRange;
    }

    @Override
    public String toString() {
        return "Tower{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", level=" + level +
                ", type=" + type +
                ", attackRange=" + attackRange +
                '}';
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

class TowerType {
    private double attackDamage;
    private double attackSpeed;
    private double attackMode;

    public TowerType() {
        this(0.0, 0.0, 0.0);
    }

    public TowerType(double attackDamage, double attackSpeed, double attackMode) {
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.attackMode = attackMode;
    }

    @Override
    public String toString() {
        return "TowerType{" +
                "attackDamage=" + attackDamage +
                ", attackSpeed=" + attackSpeed +
                ", attackMode=" + attackMode +
                '}';
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getAttackMode() {
        return attackMode;
    }

    public void setAttackMode(double attackMode) {
        this.attackMode = attackMode;
    }
}
