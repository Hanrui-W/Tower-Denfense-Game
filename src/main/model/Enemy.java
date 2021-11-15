package model;

import javafx.scene.paint.Color;

public class Enemy extends GameObject {
    private int attackDamage;
    private double health;
    private int iteration;
    private int counter;
    private Color color;

    public Enemy(double health, int attackDamage, int iteration, Color color) {
        this.health = health;
        this.attackDamage = attackDamage;
        this.iteration = iteration;
        this.counter = 0;
        this.color = color;
    }

    public String toString() {
        return "Enemy {"
                + "xPosition=" + getxPosition()
                + ", yPosition=" + getyPosition()
                + ", health=" + health
                + '}';
    }

    public boolean moveEnemy() {
        counter++;
        if (counter >= iteration) {
            counter = 0;
            return true;
        } else {
            return false;
        }
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public Color getColor() {
        return this.color;
    }
}
