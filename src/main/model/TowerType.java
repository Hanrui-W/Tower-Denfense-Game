package model;

import javafx.scene.image.Image;

public class TowerType {
    private String name;
    private Image image;
    private int cost;
    private double attackDamage;
    private double attackSpeed;
    private double attackMode;
    private int range;

    public TowerType() {
    }

    public TowerType(String name, Image image, int cost, double attackDamage,
                     double attackSpeed, double attackMode, int range) {
        this.name = name;
        this.image = image;
        this.cost = cost;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.attackMode = attackMode;
        this.range = range;
    }

    @Override
    public String toString() {
        return "TowerType {\n"
                + "cost=" + cost + "\n"
                + "attackDamage=" + attackDamage + "\n"
                + ", attackSpeed=" + attackSpeed + "\n"
                + ", attackMode=" + attackMode + "\n"
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
