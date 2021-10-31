package model;

import java.util.ArrayList;

public class Map {
    private ArrayList<GameObject> gameObjects;
    private int[][] map;
    private int mapWidth;
    private int mapHeight;
    private ArrayList<GameObject>[] enemyPaths;
    private Monument monument;
    private static final int DEFAULT_PATHS = 1;
    private static int[][] defaultPath =
                    {{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {3, 1, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 1},
                    {3, 1, 0, 0, 0, 0, 0, 0, 0, 3, 1, 1, 1, 1, 2},
                    {3, 1, 0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0},
                    {3, 1, 3, 3, 3, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0},
                    {3, 1, 1, 1, 1, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0},
                    {0, 0, 0, 3, 1, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0},
                    {0, 0, 0, 3, 1, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0},
                    {0, 0, 0, 3, 1, 3, 3, 3, 3, 3, 1, 0, 0, 0, 0},
                    {0, 0, 0, 3, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};

    public Map() {
        this(new ArrayList<>(), defaultPath,
                new ArrayList[Map.DEFAULT_PATHS], new Monument());
    }

    public Map(ArrayList<GameObject> gameObjects, int[][] map,
               ArrayList<GameObject>[] enemyPaths, Monument monument) {
        this.gameObjects = gameObjects;
        this.enemyPaths = enemyPaths;
        this.monument = monument;
        this.map = map;
        this.mapWidth = this.map[0].length;
        this.mapHeight = this.map.length;
    }

    public ArrayList<GameObject>[] getEnemyPaths() {
        return enemyPaths;
    }

    public void setEnemyPaths(ArrayList<GameObject>[] enemyPaths) {
        this.enemyPaths = enemyPaths;
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
