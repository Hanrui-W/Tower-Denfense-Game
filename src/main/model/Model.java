package model;

import java.util.LinkedList;

public class Model {

    private static Model model = new Model();

    private Player player;
    private Map map;
    private LinkedList<Enemy> listOfEnemies;
    private GameSetting setting;
    private Monument monument;
    private LinkedList<TowerType> towerTypes;
    private int towerPriceBaseValue;
    private GameDifficultyLevel level;
    private int enemyHealth;
    private int enemyDamage;
    private int time;
    private boolean isWin;

    private Model() {
        player = new Player();
        map = new Map();
        listOfEnemies = new LinkedList<>();
        setting = new GameSetting();
        monument = new Monument();
        towerTypes = new LinkedList<>();
        time = 0;
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

    public boolean updateListOfEnemies() {
        boolean updated = false;

        for (Enemy enemy : listOfEnemies) {
            if (enemy.moveEnemy()) {
                for (int i = 0; i < map.getEnemyPath().size() - 1; i++) {
                    if (map.getEnemyPath().get(i).equals(enemy)) {
                        enemy.setxPosition(map.getEnemyPath().get(i + 1).getxPosition());
                        enemy.setyPosition(map.getEnemyPath().get(i + 1).getyPosition());
                        updated = true;
                    }
                }
            }
        }

        return updated;
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
    public Map getMapObject() {
        return map;
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

    public LinkedList<Enemy> getListOfEnemies() {
        return listOfEnemies;
    }

    public void setListOfEnemies(LinkedList<Enemy> listOfEnemies) {
        this.listOfEnemies = listOfEnemies;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
