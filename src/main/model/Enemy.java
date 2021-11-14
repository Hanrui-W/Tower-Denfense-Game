package model;

public class Enemy extends GameObject {
    protected double attackDamage;
    protected double health;
    protected int iteration;
    protected int counter;

    public Enemy(double health, double attackDamage, int iteration) {
        this.health = health;
        this.attackDamage = attackDamage;
        this.iteration = iteration;
        this.counter = 0;
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

    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }
}
