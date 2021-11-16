import controller.AppLauncher;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;


public class MilestoneFourTest extends ApplicationTest {

    private Stage stage;
    public MilestoneFourTest() {

    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        AppLauncher launcher = new AppLauncher();
        launcher.start(primaryStage);
    }

    @Test
    public void testStartCombatButton() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");

        FxAssert.verifyThat("Start Combat", NodeMatchers.isVisible());
    }

    @Test
    public void testEnemyAppearance() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");

        FxAssert.verifyThat(".enemy", NodeMatchers.isInvisible());
        this.clickOn("Start Combat");
        FxAssert.verifyThat(".enemy", NodeMatchers.isVisible());


        Thread.sleep(37500);
    }
    @Test
    public void testEasyEnemyDamage() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Easy");
        this.clickOn("Next");
        this.clickOn("Start Combat");

        Thread.sleep(12500);

        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("700", NodeMatchers.isNotNull());

        Thread.sleep(25000);
    }

    @Test
    public void testMediumEnemyDamage() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Medium");
        this.clickOn("Next");
        this.clickOn("Start Combat");

        Thread.sleep(12500);

        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("350", NodeMatchers.isNotNull());

        Thread.sleep(25000);
    }

    @Test
    public void testHardEnemyDamage() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hard");
        this.clickOn("Next");
        this.clickOn("Start Combat");

        Thread.sleep(12500);

        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("175", NodeMatchers.isNotNull());

        Thread.sleep(25000);
    }

    @Test
    public void testHellEnemyDamage() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Start Combat");

        Thread.sleep(12500);

        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("89", NodeMatchers.isNotNull());

        Thread.sleep(25000);
    }

    @Test
    public void testLoseGame() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Start Combat");

        Thread.sleep(37500);

        FxAssert.verifyThat("Game Over", NodeMatchers.isNotNull());
        FxAssert.verifyThat("You Lose", NodeMatchers.isNotNull());
    }

    @Test
    public void testRestartGame() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Start Combat");

        Thread.sleep(37500);

        FxAssert.verifyThat("Game Over", NodeMatchers.isNotNull());

        this.clickOn("Restart");
        FxAssert.verifyThat("Welcome Screen", NodeMatchers.isNotNull());
    }

    @Test
    public void testValueBeingResetAfterRestart() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Start Combat");

        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("125", NodeMatchers.isNotNull());

        Thread.sleep(37500);

        FxAssert.verifyThat("Game Over", NodeMatchers.isNotNull());

        this.clickOn("Restart");
        this.clickOn("Start");
        this.write("George");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");

        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("125", NodeMatchers.isNotNull());
    }

    @Test
    public void testExitGame() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Start Combat");

        Thread.sleep(37500);

        FxAssert.verifyThat("Game Over", NodeMatchers.isNotNull());

        Assertions.assertTrue(stage.isShowing());
        this.clickOn("Exit");
        Assertions.assertFalse(stage.isShowing());
    }

}
