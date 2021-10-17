package model;

public class TowerType {
    private String name;
    private String description;
    private String imagePath;
    private int cost;
    private double attackDamage;
    private double attackSpeed;
    private double attackMode;
    private int range;

    public TowerType() {
    }

    public TowerType(String name, String description, String imagePath, int cost, double attackDamage,
                     double attackSpeed, double attackMode, int range) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.cost = cost;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.attackMode = attackMode;
        this.range = range;
    }

    @Override
    public String toString() {
        return "TowerType {\n"
                + "image path: " + imagePath + "\n"
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getRange() {
        return range;
    }
}
