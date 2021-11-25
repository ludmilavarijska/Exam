import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;

public class RegisterPage {

    @FindBy(css = "li.dropdown>a>span:first-of-type")
    private static WebElement myAccount;

    @FindBy(css = "ul.dropdown-menu>li:first-of-type>a")
    private static WebElement register;

    @FindBy(id = "input-firstname")
    private static WebElement firstName;

    @FindBy(id = "input-lastname")
    private static WebElement lastName;

    @FindBy(id = "input-email")
    private static WebElement email;

    @FindBy(id = "input-telephone")
    private static WebElement phone;

    @FindBy(id = "input-password")
    private static WebElement password;

    @FindBy(id = "input-confirm")
    private static WebElement passConfirm;

    @FindBy(css = "input[name='agree']")
    private static WebElement privacyPolicyCheckbox;

    @FindBy(css = "input.btn-primary")
    private static WebElement continueButton;

    static {
        PageFactory.initElements(Browser.driver, RegisterPage.class);
    }

    public static void goToRegisterForm() {
        myAccount.click();
        register.click();
    }

    public static void createNewAccount(String first, String last, String telephone, String pass) {
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        email.sendKeys(RandomStringUtils.randomAlphabetic(5) + "@mail.com");
        phone.sendKeys(telephone);
        password.sendKeys(pass);
        passConfirm.sendKeys(pass);
        privacyPolicyCheckbox.click();
        continueButton.click();
    }

    public static void verify() {
        WebDriverWait wait = new WebDriverWait(Browser.driver, 5);
        wait.until(ExpectedConditions.titleContains("Your Account Has Been Created!"));
        String actualMessage = Browser.driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertEquals(actualMessage, "Your Account Has Been Created!");
    }

}
