package model;

public class GameSetting {

    private GameDifficultLevel level;

    public GameSetting() {
        this.level = GameDifficultLevel.EASY;
    }

    public GameSetting(GameDifficultLevel level) {
        this.level = level;
    }

    public GameDifficultLevel getLevel() {
        return level;
    }

    public void setLevel(GameDifficultLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "GameSetting{" +
                "level=" + level +
                '}';
    }
}
