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

    public boolean setPlayersName(String name) {
        if (name == null || name.trim().equals("")) {
            return false;
        }
        player.setName(name.trim());
        return true;
    }

    public void setDifficulty(GameDifficultyLevel level) {
        setting.setLevel(level);
    }

    public void setStartingMoney() {
        switch (setting.getLevel()) {
            case EASY:
                player.setMoney(1000);
                break;
            case MEDIUM:
                player.setMoney(700);
                break;
            case HARD:
                player.setMoney(500);
                break;
            case HELL:
                player.setMoney(300);
                break;
        }
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
