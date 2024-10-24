import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
}