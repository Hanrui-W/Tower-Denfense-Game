import controller.AppLauncher;
import controller.GameController;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import model.Model;

import java.util.Timer;

public class MilestoneSixTest extends ApplicationTest {
    public MilestoneSixTest() {

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
    public void testPlaceTowerStatistics() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase1");
        this.clickOn(".available");
        this.clickOn(".unavailable");
        Timer timer = ((GameController) launcher.getController()).getTimer();
        wait(50);
        FxAssert.verifyThat("Total number of towers placed: " + Model.getInstance().getTowersPlaced(),
                NodeMatchers.isNotNull());
        this.clickOn("Exit");
        timer.cancel();
    }

    @Test
    public void testEnemiesKilledStatistics() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase1");
        this.clickOn(".available");
        this.clickOn(".unavailable");
        Timer timer = ((GameController) launcher.getController()).getTimer();
        wait(50);
        FxAssert.verifyThat("Total number of enemies killed: "  + Model.getInstance().getEnemiesKilled(),
                NodeMatchers.isNotNull());
        this.clickOn("Exit");
        timer.cancel();
    }

    @Test
    public void testNumberOfUpgradesStatistics() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase1");
        this.clickOn(".available");
        this.clickOn(".tower");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        Timer timer = ((GameController) launcher.getController()).getTimer();
        wait(10);
        FxAssert.verifyThat("Total number of upgrades: " + Model.getInstance().getTowersUpgraded(),
                NodeMatchers.isNotNull());
        this.clickOn("Exit");
        timer.cancel();
    }

    @Test
    public void testBossAppearEasyLevel() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        wait(10);
        FxAssert.verifyThat("2500.0", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testBossAppearMediumLevel() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Medium");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        wait(10);
        FxAssert.verifyThat("2500.0", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testBossAppearHardLevel() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hard");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        wait(10);
        FxAssert.verifyThat("2500.0", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testBossAppearHellLevel() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        wait(10);
        FxAssert.verifyThat("2500.0", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testUpgradeEasyLevel() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase1");
        this.clickOn(".available");
        this.clickOn(".tower");
        this.clickOn("Upgrade");
        FxAssert.verifyThat("Level: 2", NodeMatchers.isNotNull());
        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testWinGameMessage() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase1");
        this.clickOn(".available");
        this.clickOn(".tower");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        Timer timer = ((GameController) launcher.getController()).getTimer();
        wait(10);
        FxAssert.verifyThat("Congratulations. You win!", NodeMatchers.isNotNull());
        this.clickOn("Exit");
        timer.cancel();
    }

    @Test
    public void testRestartGameFormWinPage() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase1");
        this.clickOn(".available");
        this.clickOn(".tower");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        this.clickOn("Upgrade");
        Timer timer = ((GameController) launcher.getController()).getTimer();
        wait(10);
        FxAssert.verifyThat("Congratulations. You win!", NodeMatchers.isNotNull());
        timer.cancel();
        this.clickOn("Restart");
        FxAssert.verifyThat("Start", NodeMatchers.isNotNull());
    }
}
