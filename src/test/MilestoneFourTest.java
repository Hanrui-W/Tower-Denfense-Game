import controller.AppLauncher;
import javafx.stage.Stage;
import org.junit.Test;
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

        this.clickOn("Start Combat");
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
    public void testExitGame() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Start Combat");

        Thread.sleep(37500);

        FxAssert.verifyThat("Game Over", NodeMatchers.isNotNull());

        this.clickOn("Exit");
    }
}
