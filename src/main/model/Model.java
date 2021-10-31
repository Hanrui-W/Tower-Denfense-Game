package model;

import java.util.LinkedList;

public class Model {
    private Player player;
    private Map map;
    private LinkedList<Enemy> enemies;
    private GameSetting setting;
    private Monument monument;
    private LinkedList<TowerType> towerTypes;
    private int towerPriceBaseValue;
    private GameDifficultyLevel level;

    public Model() {
        player = new Player();
        map = new Map();
        enemies = new LinkedList<>();
        setting = new GameSetting();
        monument = new Monument();
        towerTypes = new LinkedList<>();
    }

    public boolean initGame(String name, GameDifficultyLevel level) {
        if (name == null || name.equals("")) {
            return false;
        }
        this.level = level;
        player.setName(name);
        switch (level) {
            case EASY:
                player.setMoney(1000);
                monument.setHealth(1000);
                towerPriceBaseValue = 50;
                break;
            case MEDIUM:
                player.setMoney(700);
                monument.setHealth(500);
                towerPriceBaseValue = 100;
                break;
            case HARD:
                player.setMoney(500);
                monument.setHealth(250);
                towerPriceBaseValue = 150;
                break;
            case HELL:
                player.setMoney(300);
                monument.setHealth(125);
                towerPriceBaseValue = 200;
                break;
            default:
                break;
        }
        setting.setLevel(level);
        return true;
    }

    public GameDifficultyLevel getLevel() {
        return level;
    }

    public int getMoney() {
        return player.getMoney();
    }

    public void setMoney(int money) {
        this.player.setMoney(money);
    }

    public int[][] getMap() {
        return map.getMap();
    }

    public int getMonumentHealth() {
        return monument.getHealth();
    }

    public void setMonumentHealth(int health) {
        monument.setHealth(health);
    }

    public LinkedList<TowerType> getTowerTypes() {
        return towerTypes;
    }

    public String getPlayerName() {
        return player.getName();
    }

    public void setTowerPriceBaseValue(int price) {
        towerPriceBaseValue = price;
    }

    public int getTowerPriceBaseValue() {
        return towerPriceBaseValue;
    }

    public LinkedList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(LinkedList<Enemy> enemies) {
        this.enemies = enemies;
    }
}
