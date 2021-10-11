package model;

import java.util.ArrayList;

public class TowerMenu {
    private ArrayList<TowerType> menu;

    public TowerMenu() {
        menu = new ArrayList<>();
        menu.add(new TowerType("1", "1st TowerType", 100, 10, 2, 1));
    }

    public ArrayList<TowerType> getMenu() {
        return menu;
    }
}
