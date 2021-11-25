import org.testng.annotations.Test;

public class NewRegistrationTest extends Base {

    @Test
    public static void newRegistration() {
        RegisterPage.goToRegisterForm();
        RegisterPage.createNewAccount("Niki", "Petrov", "9873455", "password123");
        RegisterPage.verify();
    }

}
