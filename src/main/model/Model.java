package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

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
    private int enemyHealthBaseValue;
    private int enemyDamageBaseValue;
    private int enemyIterationBaseValue;
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
            enemyHealthBaseValue = 50;
            enemyDamageBaseValue = 100;
            enemyIterationBaseValue = 10;
            break;
        case MEDIUM:
            player.setMoney(700);
            monument.setHealth(500);
            towerPriceBaseValue = 100;
            enemyHealthBaseValue = 100;
            enemyDamageBaseValue = 50;
            enemyIterationBaseValue = 10;
            break;
        case HARD:
            player.setMoney(500);
            monument.setHealth(250);
            towerPriceBaseValue = 150;
            enemyHealthBaseValue = 150;
            enemyDamageBaseValue = 25;
            enemyIterationBaseValue = 10;
            break;
        case HELL:
            player.setMoney(300);
            monument.setHealth(125);
            towerPriceBaseValue = 200;
            enemyHealthBaseValue = 200;
            enemyDamageBaseValue = 12;
            enemyIterationBaseValue = 10;
            break;
        default:
            break;
        }
        setting.setLevel(level);
        return true;
    }

    public boolean updateListOfEnemies() {
        boolean updated = false;

        for (int j = 0; j < listOfEnemies.size(); j++) {
            Enemy enemy = listOfEnemies.get(j);
            if (enemy.moveEnemy()) {
                for (int i = 0; i < map.getEnemyPath().size() - 1; i++) {
                    if (map.getEnemyPath().get(i).equals(enemy)) {
                        enemy.setxPosition(map.getEnemyPath().get(i + 1).getxPosition());
                        enemy.setyPosition(map.getEnemyPath().get(i + 1).getyPosition());
                        updated = true;
                        break;
                    }
                }
                if (enemy.equals(monument)) {
                    listOfEnemies.remove(j);
                    j--;
                    monument.setHealth(monument.getHealth()-enemy.getAttackDamage());
                    System.out.println(listOfEnemies.size());
                }
            }
        }

        return updated;
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
        // Generate a new enemy after every 50 iterations of the timer
        if (newEnemyCounter++ < 50) {
            return;
        }

        newEnemyCounter = 0;
        int enemyType = new Random().nextInt(3);
        switch (enemyType) {
            case 0:
                listOfEnemies.add(new Enemy(enemyHealthBaseValue,
                        enemyDamageBaseValue, 10, Color.VIOLET));
                break;
            case 1:
                listOfEnemies.add(new Enemy((int) (enemyHealthBaseValue * 1.5),
                        (int) (enemyDamageBaseValue * 0.5), 10, Color.RED));
                break;

            case 2:
                listOfEnemies.add(new Enemy((int) (enemyHealthBaseValue * 0.5),
                        enemyDamageBaseValue * 2, 10, Color.BLUE));
                break;
            default:
                break;
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
    public Map getMapObject() {
        return map;
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

    public int getEnemyHealthBaseValue() {
        return enemyHealthBaseValue;
    }

    public int getNewEnemyCounter() {
        return newEnemyCounter;
    }

    public void setNewEnemyCounter(int newEnemyCounter) {
        this.newEnemyCounter = newEnemyCounter;
    }

    public int getenemyDamageBaseValue() {
        return enemyDamageBaseValue;
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
