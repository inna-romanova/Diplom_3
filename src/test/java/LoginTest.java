import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Before
    @Override
    public void setUp() {
        super.setUp();
        userClient.create(user);
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти в аккаунт' на главной странице")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти в аккаунт' на главной странице")
    public void loginWithBtnOnHeadPageTest() {
        mainSteps
                .isHomePageDisplayed()
                .clickLoginCentralBtn();

        loginSteps
                .isLoginPageDisplayed()
                .loginUser(user.getEmail(), user.getPassword());

        mainSteps
                .isHomePageDisplayed();
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Личный кабинет'")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Личный кабинет'")
    public void loginWithProfileBtnTest() {
        mainSteps
                .isHomePageDisplayed()
                .clickPersonalAccountBtn();

        loginSteps
                .isLoginPageDisplayed()
                .loginUser(user.getEmail(), user.getPassword());

        mainSteps
                .isHomePageDisplayed();
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме регистрации")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void loginWithBtnOnRegistrationPageTest() {
        mainSteps
                .isHomePageDisplayed()
                .clickPersonalAccountBtn();

        loginSteps
                .isLoginPageDisplayed()
                .clickRegistrationBtn();

        registrationSteps
                .isRegistrationPageDisplayed()
                .clickLoginBtn();

        loginSteps
                .isLoginPageDisplayed()
                .loginUser(user.getEmail(), user.getPassword());

        mainSteps
                .isHomePageDisplayed();
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме восстановления пароля")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме восстановления пароля")
    public void loginWithBtnOnForgottenPasswordPageTest() {
        mainSteps
                .isHomePageDisplayed()
                .clickPersonalAccountBtn();

        loginSteps
                .isLoginPageDisplayed()
                .clickForgottenPasswordBtn();

        forgottenPasswordSteps
                .isForgottenPasswordPageDisplayed()
                .clickLoginBtn();

        loginSteps
                .isLoginPageDisplayed()
                .loginUser(user.getEmail(), user.getPassword());

        mainSteps
                .isHomePageDisplayed();
    }
}
