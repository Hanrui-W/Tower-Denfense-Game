package model;

public class GameSetting {

    private GameDifficultyLevel level;

    public GameSetting() {
        this.level = GameDifficultyLevel.EASY;
    }

    public GameSetting(GameDifficultyLevel level) {
        this.level = level;
    }

    public GameDifficultyLevel getLevel() {
        return level;
    }

    public void setLevel(GameDifficultyLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "GameSetting{"
                + "level=" + level
                + '}';
    }
}
