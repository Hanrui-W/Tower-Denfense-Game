import controller.AppLauncher;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

public class AppTest extends ApplicationTest {

    public AppTest() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AppLauncher launcher = new AppLauncher();
        launcher.start(primaryStage);
    }

    @Test
    public void testPlay() {
        this.clickOn("Start");
        FxAssert.verifyThat("Init Config Screen", NodeMatchers.isNotNull());
    }

    @Test
    public void testTypeName() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Next");
        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
    }

    @Test
    public void testEmptyName() {
        this.clickOn("Start");
        this.clickOn("Next");
        FxAssert.verifyThat("OK", NodeMatchers.isNotNull());
        this.clickOn("OK");
        this.clickOn("");
        this.write(" ");
        this.clickOn("Next");
        FxAssert.verifyThat("OK", NodeMatchers.isNotNull());
        this.clickOn("OK");
        this.clickOn(" ");
        this.push(KeyCode.BACK_SPACE);
        this.write("George P. Burdell");
        this.clickOn("Next");
        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
    }

    @Test
    public void testGameLabels() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Monument Health: ", NodeMatchers.isNotNull());
    }

    @Test
    public void testEasyLevel() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Next");
        FxAssert.verifyThat("1000", NodeMatchers.hasChildren(2, "1000"));
    }

    @Test
    public void testMediumLevel() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Medium");
        this.clickOn("Next");
        FxAssert.verifyThat("700", NodeMatchers.isNotNull());
        FxAssert.verifyThat("500", NodeMatchers.isNotNull());
    }

    @Test
    public void testHardLevel() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hard");
        this.clickOn("Next");
        FxAssert.verifyThat("500", NodeMatchers.isNotNull());
        FxAssert.verifyThat("250", NodeMatchers.isNotNull());
    }

    @Test
    public void testHellLevel() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        FxAssert.verifyThat("300", NodeMatchers.isNotNull());
        FxAssert.verifyThat("125", NodeMatchers.isNotNull());
    }

}
