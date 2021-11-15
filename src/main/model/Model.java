package model;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Model {

    private static Model model = new Model();

    private Player player;
    private Map map;
    private GameSetting setting;
    private Monument monument;
    private LinkedList<Enemy> listOfEnemies;
    private ArrayList<Tower> listOfTowers;
    private ArrayList<TowerType> listOfTowerTypes;
    private int towerPriceBaseValue;
    private GameDifficultyLevel level;
    private int enemyHealth;
    private int enemyDamage;
    private int newEnemyCounter;
    private boolean isWin;

    private Model() {
        player = new Player();
        map = new Map();
        setting = new GameSetting();
        monument = new Monument();
        listOfEnemies = new LinkedList<>();
        listOfTowers = new ArrayList<>();
        listOfTowerTypes = new ArrayList<>();
        initTowerTypes();
        newEnemyCounter = 0;
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
                towerPriceBaseValue, 1, 1, 1, 1));

        listOfTowerTypes.add(new TowerType("Pew Pew Pea",
                new Image(new File("src/main/resources/pea.gif")
                        .toURI()
                        .toString()),
                towerPriceBaseValue * 2, 2, 2, 2, 2));

        listOfTowerTypes.add(new TowerType("Wag Wag Mushroom",
                new Image(new File("src/main/resources/mushroom.gif")
                        .toURI()
                        .toString()),
                towerPriceBaseValue * 3, 3, 3, 3, 3));
    }

    public void generateNewEnemy() {
        int enemyType = new Random().nextInt(3);
        switch (enemyType) {
            case 0:
                listOfEnemies.add(new Enemy(enemyHealth, enemyDamage, ))
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

    public LinkedList<Enemy> getListOfEnemies() {
        return listOfEnemies;
    }

    public void setListOfEnemies(LinkedList<Enemy> listOfEnemies) {
        this.listOfEnemies = listOfEnemies;
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

    public int getNewEnemyCounter() {
        return newEnemyCounter;
    }

    public void setNewEnemyCounter(int newEnemyCounter) {
        this.newEnemyCounter = newEnemyCounter;
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
