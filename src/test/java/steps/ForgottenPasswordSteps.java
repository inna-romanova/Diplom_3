package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ForgottenPasswordPage;

import static org.junit.Assert.assertTrue;

public class ForgottenPasswordSteps {
    private final ForgottenPasswordPage forgottenPasswordPage;

    public ForgottenPasswordSteps(WebDriver driver) {
        this.forgottenPasswordPage = new ForgottenPasswordPage(driver);
    }

    @Step("Нажать на кнопку 'Войти' на странице восстановления пароля и перейти на страницу входа")
    public ForgottenPasswordSteps clickLoginBtn() {
        forgottenPasswordPage.clickLoginBtn();
        return this;
    }

    @Step("Проверить, что отображается страница восстановления пароля")
    public ForgottenPasswordSteps isForgottenPasswordPageDisplayed() {
        assertTrue("Страница восстановления пароля не отображается", forgottenPasswordPage.isForgottenPasswordPageDisplayed());
        return this;
    }
}
