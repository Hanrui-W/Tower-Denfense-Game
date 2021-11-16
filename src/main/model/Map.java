package model;

import java.util.ArrayList;

public class Map {
    private ArrayList<GameObject> gameObjects;
    private int[][] map;
    private int mapWidth;
    private int mapHeight;
    private ArrayList<GameObject> enemyPath;
    private Monument monument;
    private static int[][] defaultMap =
        {{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2},
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};

    public Map() {
        this(new ArrayList<>(), defaultMap, new Monument());
    }

    public Map(ArrayList<GameObject> gameObjects, int[][] map, Monument monument) {
        this.gameObjects = gameObjects;
        this.monument = monument;
        this.map = map;
        this.mapWidth = this.map[0].length;
        this.mapHeight = this.map.length;
        findPath(map);
    }

    public void findPath(int[][] map) {
        enemyPath = new ArrayList<>();
        int row = 0;
        while (row < map.length && map[row][0] != 1) {
            row++;
        }
        int col = 0;
        while (col < map[0].length) {
            if (map[row][col + 1] == 1) {
                while (col < map[0].length && map[row][col + 1] == 1) {
                    enemyPath.add(new GameObject(row, col));
                    col++;
                }
                continue;
            }
            if (row > 0 && map[row - 1][col] == 1) {
                while (row > 0 && (map[row - 1][col] == 1)) {
                    enemyPath.add(new GameObject(row, col));
                    row--;
                }
                continue;
            }
            if (row < map.length - 1 && map[row + 1][col] == 1) {
                while (row < map.length - 1 && (map[row + 1][col] == 1)) {
                    enemyPath.add(new GameObject(row, col));
                    row++;
                }
                continue;
            }
            break;
        }
        enemyPath.add(new GameObject(row, col));
        enemyPath.add(monument);

    }

    public ArrayList<GameObject> getEnemyPath() {
        return enemyPath;
    }

    public void setEnemyPath(ArrayList<GameObject> enemyPath) {
        this.enemyPath = enemyPath;
    }

    public Monument getMonument() {
        return monument;
    }

    public void setMonument(Monument monument) {
        this.monument = monument;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }
}
