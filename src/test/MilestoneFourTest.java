import controller.Controller;
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
        Controller controller = new Controller();
        controller.start(primaryStage);
    }

    @Test
    public void testEasyEnemyDamage() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Easy");
        this.clickOn("Next");

        Thread.sleep(12500);

        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("700", NodeMatchers.isNotNull());
    }

    @Test
    public void testMediumEnemyDamage() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Medium");
        this.clickOn("Next");

        Thread.sleep(12500);

        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("350", NodeMatchers.isNotNull());
    }

    @Test
    public void testHardEnemyDamage() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hard");
        this.clickOn("Next");

        Thread.sleep(12500);

        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("175", NodeMatchers.isNotNull());
    }

    @Test
    public void testHellEnemyDamage() throws Exception {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");

        Thread.sleep(12500);

        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("89", NodeMatchers.isNotNull());
    }
}
