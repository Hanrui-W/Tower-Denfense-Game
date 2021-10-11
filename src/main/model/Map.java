package model;

import java.util.ArrayList;

public class Map {
    private ArrayList<GameObject> gameObjects;
    private int[][] map;
    private int mapWidth;
    private int mapHeight;
    private ArrayList<GameObject>[] enemyPaths;
    private Monument monument;

    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 40;
    private static final int DEFAULT_PATHS = 1;

    public Map() {
        this(new ArrayList<>(), new int[Map.DEFAULT_HEIGHT][Map.DEFAULT_WIDTH],
                new ArrayList[Map.DEFAULT_PATHS], new Monument());
    }

    public Map(ArrayList<GameObject> gameObjects, int[][] map,
               ArrayList<GameObject>[] enemyPaths, Monument monument) {
        this.gameObjects = gameObjects;
        this.map = map;
        this.mapWidth = this.map[0].length;
        this.mapHeight = this.map.length;
        this.enemyPaths = enemyPaths;
        this.monument = monument;
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
