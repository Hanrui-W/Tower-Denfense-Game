import controller.AppLauncher;
import controller.GameController;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

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
    public void testLoseGameStatistic() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        wait(40);
        FxAssert.verifyThat("Exit", NodeMatchers.isNotNull());
//        ((GameController) launcher.getController()).getTimer().cancel();
    }

    @Test
    public void testBossAppearEasyLevel() throws Exception {
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
    public void testBossAppearMediumLevel() throws Exception {
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
    public void testBossAppearHardLevel() throws Exception {
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
    public void testBossAppearHellLevel() throws Exception {
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
    public void testUpgradeEasyLevel() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase1");
        this.clickOn(".available");
        this.clickOn(".unavailable");
        ((GameController) launcher.getController()).getTimer().cancel();
    }


}
