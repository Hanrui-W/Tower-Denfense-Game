package model;

public class TowerType {
    private String name;
    private String description;
    private int cost;
    private double attackDamage;
    private double attackSpeed;
    private double attackMode;

    public TowerType() {
    }

    public TowerType(String name, String description, int cost, double attackDamage,
                     double attackSpeed, double attackMode) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.attackMode = attackMode;
    }

    @Override
    public String toString() {
        return "TowerType{"
                + "cost=" + cost
                + "attackDamage=" + attackDamage
                + ", attackSpeed=" + attackSpeed
                + ", attackMode=" + attackMode
                + '}';
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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
