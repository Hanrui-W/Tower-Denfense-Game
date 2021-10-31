package model;

import java.awt.image.PackedColorModel;

public class Enemy extends GameObject {
    private double speed; // square per second
    private double attackDamage;
    private double health;
    private GameDifficultyLevel level;

    public Enemy() {
        this(GameDifficultyLevel.EASY, 1, 1, 0);
    }

    public Enemy(GameDifficultyLevel level, double speed, double health, double attackDamage) {
        this.level = level;
        this.speed = speed + level.ordinal() * 0.5;
        this.health = health + level.ordinal() * 100;
        this.attackDamage = attackDamage + level.ordinal() * 0.7;
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

    public GameDifficultyLevel getLevel() {
        return level;
    }

    public void setLevel(GameDifficultyLevel level) {
        this.level = level;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }
}
