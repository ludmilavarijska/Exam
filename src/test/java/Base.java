import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class Base {

    @BeforeClass
    public static void setUp() {
        Browser.setUp();
    }

    @AfterClass
    public static void quit() {
        Browser.quit();
    }

}
