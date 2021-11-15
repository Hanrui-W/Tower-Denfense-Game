package model;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class Model {

    private static Model model = new Model();

    private Player player;
    private Map map;
    private GameSetting setting;
    private Monument monument;
    private ArrayList<Tower> listOfTowers;
    private ArrayList<TowerType> listOfTowerTypes;
    private int towerPriceBaseValue;
    private GameDifficultyLevel level;
    private int enemyHealth;
    private int enemyDamage;
    private int time;
    private boolean isWin;

    private Model() {
        player = new Player();
        map = new Map();
        setting = new GameSetting();
        monument = new Monument();
        listOfTowers = new ArrayList<>();
        listOfTowerTypes = new ArrayList<>();
        initTowerTypes();
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

    public void initTowerTypes() {
        listOfTowerTypes.add(new TowerType("Flowy Flower",
                new Image(new File("src/main/resources/sunflower.gif")
                        .toURI()
                        .toString()),
                model.getTowerPriceBaseValue(), 1, 1, 1, 1));

        listOfTowerTypes.add(new TowerType("Pew Pew Pea",
                new Image(new File("src/main/resources/pea.gif")
                        .toURI()
                        .toString()),
                model.getTowerPriceBaseValue() * 2, 2, 2, 2, 2));

        listOfTowerTypes.add(new TowerType("Wag Wag Mushroom",
                new Image(new File("src/main/resources/mushroom.gif")
                        .toURI()
                        .toString()),
                model.getTowerPriceBaseValue() * 3, 3, 3, 3, 3));
    }
    public void generateNewEnemy() {
        if (time % 50 == 0) {

        }
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

    public ArrayList<Tower> getListOfTowers() {
        return listOfTowers;
    }
    public ArrayList<TowerType> getListOfTowerTypes() {
        return listOfTowerTypes;
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

    public void addTower(Tower tower) {
        listOfTowers.add(tower);
    }
}
