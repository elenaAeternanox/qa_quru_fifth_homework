package fifthHomework.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import fifthHomework.pages.RegistrationPage;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void maximizeWindow() {
        Configuration.startMaximized = true;
    }
}
