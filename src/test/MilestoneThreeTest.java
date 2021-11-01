import controller.AppLauncher;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

public class MilestoneThreeTest extends ApplicationTest {
    private Stage stage;
    public MilestoneThreeTest() {

    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        AppLauncher launcher = new AppLauncher();
        launcher.start(primaryStage);
    }

    @Test
    public void testTowersAttacks() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Easy");
        this.clickOn("Next");
        FxAssert.verifyThat("Attack: 1.0", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Attack: 2.0", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Attack: 3.0", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowersRange() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Easy");
        this.clickOn("Next");
        FxAssert.verifyThat("Range: 1", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Range: 2", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Range: 3", NodeMatchers.isNotNull());
    }

    @Test
    public void testEasyLevelTowerCosts() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Easy");
        this.clickOn("Next");
        FxAssert.verifyThat("Cost: 50", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Cost: 100", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Cost: 150", NodeMatchers.isNotNull());
    }

    @Test
    public void testMediumLevelTowerCosts() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Medium");
        this.clickOn("Next");
        FxAssert.verifyThat("Cost: 100", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Cost: 200", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Cost: 300", NodeMatchers.isNotNull());
    }

    @Test
    public void testHardLevelTowerCosts() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hard");
        this.clickOn("Next");
        FxAssert.verifyThat("Cost: 150", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Cost: 300", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Cost: 450", NodeMatchers.isNotNull());
    }

    @Test
    public void testHellLevelTowerCosts() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        FxAssert.verifyThat("Cost: 200", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Cost: 400", NodeMatchers.isNotNull());
        FxAssert.verifyThat("Cost: 600", NodeMatchers.isNotNull());
    }

    @Test
    public void testPurchaseTower() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Purchase");
        FxAssert.verifyThat("Funds: ", NodeMatchers.isNotNull());
        FxAssert.verifyThat("You purchased flowy\nflower", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerCostsOfFunds() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        FxAssert.verifyThat("300", NodeMatchers.isNotNull());
        this.clickOn("Purchase");
        FxAssert.verifyThat("100", NodeMatchers.isNotNull());
        FxAssert.verifyThat("You purchased flowy\nflower", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerPurchaseWithoutPlacing() {
        this.clickOn("Start");
        this.write("Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Purchase");
        this.clickOn("Purchase");
        FxAssert.verifyThat("Have not placed purchased tower.", NodeMatchers.isNotNull());
        this.clickOn("OK");
    }

    @Test
    public void testPlacingTowerCorrectly() {
        this.clickOn("Start");
        this.write("Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Purchase");
        this.clickOn(".available");
        FxAssert.verifyThat("Tower is placed.", NodeMatchers.isNotNull());
    }

    @Test
    public void testPlacingTowerWrongly() {
        this.clickOn("Start");
        this.write("Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Purchase");
        this.clickOn(".unavailable");
        FxAssert.verifyThat("It is not available.\n"
                +  "Place the tower\n"
                + "on the while areas.", NodeMatchers.isNotNull());
    }

    @Test
    public void testInsufficientFunds() {
        this.clickOn("Start");
        this.write("George P. Burdell");
        this.clickOn("Easy");
        this.clickOn("Hell");
        this.clickOn("Next");
        this.clickOn("Purchase");
        this.clickOn(".available");
        FxAssert.verifyThat("100", NodeMatchers.isNotNull());
        this.clickOn("Purchase");
        FxAssert.verifyThat("Insufficient funds.", NodeMatchers.isNotNull());
        this.clickOn("OK");
    }
}
