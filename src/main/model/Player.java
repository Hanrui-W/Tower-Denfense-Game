package model;

import java.util.ArrayList;

public class Player extends GameObject {
    private String name;
    private double money;
    private ArrayList<Tower> towers;

    public Player(String name) {
        this(name, 0, new ArrayList<>());
    }

    public Player(String name, double money) {
        this(name, money, new ArrayList<>());
    }

    public Player(String name, double money, ArrayList<Tower> towers) {
        super();
        this.name = name;
        this.money = money;
        this.towers = towers;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", towers=" + towers +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public void setTowers(ArrayList<Tower> towers) {
        this.towers = towers;
    }
}
