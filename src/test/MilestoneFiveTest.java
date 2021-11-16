import controller.AppLauncher;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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

    @Override
    public void start(Stage primaryStage) {
        AppLauncher launcher = new AppLauncher();
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
    }

    @Test
    public void testGameOverMediumLevel() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Medium");
        this.clickOn("Next");
        this.clickOn("Start Combat");
        this.clickOn(".purchase2");
        this.clickOn(".available");
        wait(5);
        FxAssert.verifyThat("Game Over", NodeMatchers.isNotNull());
    }

//    @Test
//    public void testAttackEnemyHardLevel() throws Exception {
//        this.clickOn("Start");
//        this.write("George P. Burdell");
//        this.clickOn("Easy");
//        this.clickOn("Hard");
//        this.clickOn("Next");
//        this.clickOn("Start Combat");
//        this.clickOn(".purchase2");
//        this.clickOn(".available");
//        wait(5);
//        FxAssert.verifyThat(".enemy", NodeMatchers.isNotNull());
//    }

//    @Test
//    public void testMoneyGainEasyLevel() throws Exception {
//        this.clickOn("Start");
//        this.write("George P. Burdell");
//        this.clickOn("Next");
//        this.clickOn("Start Combat");
//        this.clickOn(".purchase2");
//        this.clickOn(".available");
//        this.clickOn(".purchase2");
//        this.clickOn(".available");
//        this.clickOn(".purchase2");
//        this.clickOn(".available");
//        this.clickOn(".purchase2");
//        this.clickOn(".available");
//        wait(5);
//        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
//    }

//    @Test
//    public void testMoneyGainMediumLevel() throws Exception {
//        this.clickOn("Start");
//        this.write("George P. Burdell");
//        this.clickOn("Easy");
//        this.clickOn("Medium");
//        this.clickOn("Next");
//        this.clickOn("Start Combat");
//        this.clickOn(".purchase2");
//        this.clickOn(".available");
//        this.clickOn(".purchase2");
//        this.clickOn(".available");
//        this.clickOn(".purchase2");
//        this.clickOn(".available");
//        wait(5);
//        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
//    }

//    @Test
//    public void testGameOverEasyLevel() throws Exception {
//        this.clickOn("Start");
//        this.write("George P. Burdell");
//        this.clickOn("Easy");
//        this.clickOn("Next");
//        this.clickOn("Start Combat");
//        this.clickOn(".purchase0");
//        this.clickOn(".available");
//        wait(18);
//        FxAssert.verifyThat("Game Over", NodeMatchers.isVisible());
//    }
//
//    @Test
//    public void testGameOverMediumLevel() throws Exception {
//        this.clickOn("Start");
//        this.write("George P. Burdell");
//        this.clickOn("Easy");
//        this.clickOn("Medium");
//        this.clickOn("Next");
//        this.clickOn(".purchase0");
//        this.clickOn(".available");
//    }
}
