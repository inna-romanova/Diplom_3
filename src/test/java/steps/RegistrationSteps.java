package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

import static org.junit.Assert.assertTrue;

public class RegistrationSteps {
    private final RegistrationPage registrationPage;

    public RegistrationSteps(WebDriver driver) {
        this.registrationPage = new RegistrationPage(driver);
    }

    @Step("Нажать на кнопку 'Войти' на странице регистрации и перейти на страницу входа")
    public RegistrationSteps clickLoginBtn() {
        registrationPage.clickLoginBtn();
        return this;
    }

    @Step("Зарегистрировать пользователя и перейти на страницу входа")
    public RegistrationSteps registerUser(String name, String email, String password) {
        registrationPage.registerUser(name, email, password);
        return this;
    }

    @Step("Проверить, что отображается страница регистрации")
    public RegistrationSteps isRegistrationPageDisplayed() {
        assertTrue("Страница регистрации не отображается", registrationPage.isRegistrationPageDisplayed());
        return this;
    }

    @Step("Проверить, что отображается ошибка о некорректном пароле на странице регистрации")
    public RegistrationSteps isInvalidPasswordErrorDisplayed() {
        assertTrue("Ошибка о некорректном пароле не отображается", registrationPage.isInvalidPasswordErrorDisplayed());
        return this;
    }
}
