package model;

import javafx.geometry.Pos;

import java.util.ArrayList;

public class Map {
    private ArrayList<GameObject> gameObjects;
    private int[][] map;
    private int mapLength;
    private int mapWidth;
    private ArrayList<Position>[] enemyPaths;
    private ArrayList<Position> mounments;

    static int DEFAULT_LENGTH = 100;
    static int DEFAULT_WIDTH = 100;
    static int DEFAULT_PATHS = 1;
    public Map() {
        this(new ArrayList<>(), new int[Map.DEFAULT_LENGTH][Map.DEFAULT_WIDTH], new ArrayList[Map.DEFAULT_PATHS], new ArrayList<>());
    }

    public Map(ArrayList<GameObject> gameObjects, int[][] map, ArrayList<Position>[] enemyPaths, ArrayList<Position> mounments) {
        this.gameObjects = gameObjects;
        this.map = map;
        this.mapLength = this.map.length;
        this.mapWidth = this.map[0].length;
        this.enemyPaths = enemyPaths;
        this.mounments = mounments;
    }

    public ArrayList<Position>[] getEnemyPaths() {
        return enemyPaths;
    }

    public void setEnemyPaths(ArrayList<Position>[] enemyPaths) {
        this.enemyPaths = enemyPaths;
    }

    public ArrayList<Position> getMounments() {
        return mounments;
    }

    public void setMounments(ArrayList<Position> mounments) {
        this.mounments = mounments;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapLength() {
        return mapLength;
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

    public void setMapLength(int mapLength) {
        this.mapLength = mapLength;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }
}
