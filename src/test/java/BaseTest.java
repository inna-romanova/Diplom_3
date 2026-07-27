import data.ApiConstants;
import io.restassured.response.Response;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import steps.ForgottenPasswordSteps;
import steps.LoginSteps;
import steps.MainSteps;
import steps.RegistrationSteps;
import user.UserClient;

import static user.TestUserDataGenerator.getRandomUser;

public class BaseTest {
    WebDriver driver;
    UserClient userClient;
    User user;
    protected MainSteps mainSteps;
    protected LoginSteps loginSteps;
    protected RegistrationSteps registrationSteps;
    protected ForgottenPasswordSteps forgottenPasswordSteps;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equalsIgnoreCase("chrome")) {
            initChromeDriver();
        }
        else {
            initYandexDriver();
        }

        user = getRandomUser();
        userClient = new UserClient();

        mainSteps = new MainSteps(driver);
        loginSteps = new LoginSteps(driver);
        registrationSteps = new RegistrationSteps(driver);
        forgottenPasswordSteps = new ForgottenPasswordSteps(driver);
    }

    @After
    public void teardown() {
        driver.quit();

        if (user != null) {
            Response response = userClient.login(user);
            String bearerToken = response.jsonPath().getString("accessToken");
            if (bearerToken != null) {
                userClient.delete(bearerToken);
            }
        }
    }

    protected void initChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to(ApiConstants.BASE_URL);
    }

    protected void initYandexDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
        ChromeOptions yandexOptions = new ChromeOptions();
        yandexOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(yandexOptions);
        driver.manage().window().maximize();
        driver.navigate().to(ApiConstants.BASE_URL);
    }
}
