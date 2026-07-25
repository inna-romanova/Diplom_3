package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    @Step("Нажать на кнопку 'Зарегистрироваться' и перейти на страницу регистрации ")
    public LoginSteps clickRegistrationBtn() {
        loginPage.clickRegistrationBtn();
        return this;
    }

    @Step("Выполнить вход и перейти на главную страницу")
    public LoginSteps loginUser(String userEmail, String userPassword) {
        loginPage.loginUser(userEmail, userPassword);
        return this;
    }

    @Step("Нажать на кнопку 'Зарегистрироваться' и перейти на страницу регистрации")
    public LoginSteps clickForgottenPasswordBtn() {
        loginPage.clickForgottenPasswordBtn();
        return this;
    }


    @Step("Проверить, что отображается страница входа")
    public LoginSteps isLoginPageDisplayed() {
        assertTrue("Страница входа не отображается", loginPage.isLoginPageDisplayed());
        return this;
    }
}
