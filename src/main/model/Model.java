package model;

import java.util.LinkedList;

public class Model {
    private Player player;
    private Map map;
    private LinkedList<Enemy> enemies;
    private GameSetting setting;
    private Monument monument;

    public Model() {
        player = new Player();
        map = new Map();
        enemies = new LinkedList<>();
        setting = new GameSetting();
        monument = new Monument();
    }

    public boolean initGame(String name, GameDifficultyLevel level) {
        if (name == null || name.equals("")) {
            return false;
        }
        player.setName(name);
        switch (level) {
            case EASY:
                player.setMoney(1000);
                monument.setHealth(1000);
                break;
            case MEDIUM:
                player.setMoney(700);
                monument.setHealth(500);
                break;
            case HARD:
                player.setMoney(500);
                monument.setHealth(250);
                break;
            case HELL:
                player.setMoney(300);
                monument.setHealth(125);
                break;
        }
        setting.setLevel(level);
        return true;
    }

    public int getMoney() {
        return player.getMoney();
    }

    public int[][] getMap() {
        return map.getMap();
    }

    public int getMonumentHealth() {
        return monument.getHealth();
    }
}
