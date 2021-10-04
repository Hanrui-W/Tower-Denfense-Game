package model;

public class TowerType {
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
        return "TowerType{"
                + "attackDamage=" + attackDamage
                + ", attackSpeed=" + attackSpeed
                + ", attackMode=" + attackMode
                + '}';
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
