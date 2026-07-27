import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static user.TestUserDataGenerator.getInvalidPassword;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    @Description("Проверка, что можно успешно зарегистрировать пользователя")
    public void registerNewUserTest() {
        mainSteps
                .isHomePageDisplayed()
                .clickPersonalAccountBtn();

        loginSteps
                .isLoginPageDisplayed()
                .clickRegistrationBtn();

        registrationSteps
                .isRegistrationPageDisplayed()
                .registerUser(user.getName(),user.getEmail(), user.getPassword());

        loginSteps
                .isLoginPageDisplayed()
                .loginUser(user.getEmail(),user.getPassword());

        mainSteps
                .isHomePageDisplayed();
    }

    @Test
    @DisplayName("Регистрация пользователя с коротким паролем")
    @Description("Проверка, что нельзя зарегистрировать пользователя с паролем менее 6 символов")
    public void registerNewUserWithInvalidPasswordTest() {
        user.setPassword(getInvalidPassword());

        mainSteps
                .isHomePageDisplayed()
                .clickPersonalAccountBtn();

        loginSteps
                .isLoginPageDisplayed()
                .clickRegistrationBtn();

        registrationSteps
                .isRegistrationPageDisplayed()
                .registerUser(user.getName(),user.getEmail(), user.getPassword())
                .isInvalidPasswordErrorDisplayed();
    }
}
