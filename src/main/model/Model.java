package model;

import java.util.LinkedList;

public class Model {

    private static Model model = new Model();

    private Player player;
    private Map map;
    private LinkedList<Enemy> enemies;
    private GameSetting setting;
    private Monument monument;
    private LinkedList<TowerType> towerTypes;
    private int towerPriceBaseValue;
    private GameDifficultyLevel level;
    private int enemyHealth;
    private int enemyDamage;
    private boolean isWin;

    private Model() {
        player = new Player();
        map = new Map();
        enemies = new LinkedList<>();
        setting = new GameSetting();
        monument = new Monument();
        towerTypes = new LinkedList<>();
    }

    public static Model getInstance() {
        return model;
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
                enemyHealth = 50;
                enemyDamage = 100;
                break;
            case MEDIUM:
                player.setMoney(700);
                monument.setHealth(500);
                towerPriceBaseValue = 100;
                enemyHealth = 100;
                enemyDamage = 50;
                break;
            case HARD:
                player.setMoney(500);
                monument.setHealth(250);
                towerPriceBaseValue = 150;
                enemyHealth = 150;
                enemyDamage = 25;
                break;
            case HELL:
                player.setMoney(300);
                monument.setHealth(125);
                towerPriceBaseValue = 200;
                enemyHealth = 200;
                enemyDamage = 12;
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

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyDamage() {
        return enemyDamage;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}
