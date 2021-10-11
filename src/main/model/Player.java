package model;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private ArrayList<Tower> towers;

    public Player() {
        this("", 0, new ArrayList<>());
    }

    public Player(String name) {
        this(name, 0, new ArrayList<>());
    }

    public Player(String name, int money) {
        this(name, money, new ArrayList<>());
    }

    public Player(String name, int money, ArrayList<Tower> towers) {
        super();
        this.name = name;
        this.money = money;
        this.towers = towers;
    }

    @Override
    public String toString() {
        return "Player{"
                + "name='" + name + '\''
                + ", money=" + money
                + ", towers=" + towers
                + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public void setTowers(ArrayList<Tower> towers) {
        this.towers = towers;
    }
}
