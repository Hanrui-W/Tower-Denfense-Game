import controller.AppLauncher;
import controller.GameController;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

public class MilestoneFiveTest extends ApplicationTest {
    public MilestoneFiveTest() {

    }

    private void wait(int seconds) {
        long start = System.currentTimeMillis();
        long elapsedTimeMillis = System.currentTimeMillis() - start;
        while (elapsedTimeMillis / 1000F <= seconds) {
            elapsedTimeMillis = System.currentTimeMillis() - start;
        }
    }

    private AppLauncher launcher;
    @Override
    public void start(Stage primaryStage) {
        launcher = new AppLauncher();
        launcher.start(primaryStage);
    }

    @Test
    public void testEnemyAppearEasyLevel() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        wait(5);
        FxAssert.verifyThat(".enemy", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testEnemyAppearMediumLevel() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Medium");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        wait(5);
        FxAssert.verifyThat(".enemy", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testEnemyAppearHardLevel() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hard");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        wait(5);
        FxAssert.verifyThat(".enemy", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testEnemyAppearHellLevel() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        wait(5);
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testGameOver() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        wait(20);
        FxAssert.verifyThat("Game Over", NodeMatchers.isNotNull());
    }

    @Test
    public void testMoneyGainEasyLevel() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        wait(5);
        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testMoneyGainMediumLevel() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Medium");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        wait(5);
        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testMoneyGainHardLevel() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hard");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        wait(5);
        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testMoneyGainHellLevel() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase0");
        this.clickOn(".available");
        wait(3);
        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testPlaceTowers() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Next");
        this.clickOn(".purchase0");
        this.clickOn(".available");
        this.clickOn(".purchase1");
        this.clickOn(".available");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        FxAssert.verifyThat(".unavailable: ", NodeMatchers.isNotNull());

    }

    @Test
    public void testTowerAttack() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        wait(5);
        FxAssert.verifyThat(".available", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

}
