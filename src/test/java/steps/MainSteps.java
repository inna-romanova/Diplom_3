package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import static org.junit.Assert.assertTrue;

public class MainSteps {
    private final MainPage mainPage;

    public MainSteps(WebDriver driver) {
        this.mainPage = new MainPage(driver);
    }

    @Step("Нажать на кнопку 'Личный кабинет' и перейти на страницу входа ")
    public MainSteps clickPersonalAccountBtn() {
        mainPage.clickPersonalAccountBtn();
        return this;
    }

    @Step("Нажать на кнопку 'Войти в аккаунт' и перейти на страницу входа ")
    public MainSteps clickLoginCentralBtn() {
        mainPage.clickLoginCentralBtn();
        return this;
    }

    @Step("Перейти во вкладку 'Булки'")
    public MainSteps clickBunBtn() {
        mainPage.clickBunBtn();
        return this;
    }

    @Step("Перейти во вкладку 'Соусы'")
    public MainSteps clickSaucesBtn() {
        mainPage.clickSaucesBtn();
        return this;
    }

    @Step("Перейти во вкладку 'Начинки'")
    public MainSteps clickFillingsBtn() {
        mainPage.clickFillingsBtn();
        return this;
    }

    @Step("Проверить, что вкладка 'Булки' отображается")
    public MainSteps isBunsDisplayed() {
        assertTrue("Вкладка 'Булки' не отображается", mainPage.isBunsDisplayed());
        return this;
    }

    @Step("Проверить, что вкладка 'Соусы' отображается")
    public MainSteps isSaucesDisplayed() {
        assertTrue("Вкладка 'Соусы' не отображается", mainPage.isSaucesDisplayed());
        return this;
    }

    @Step("Проверить, что вкладка 'Начинки' отображается")
    public MainSteps isFillingsDisplayed() {
        assertTrue("Вкладка 'Начинки' не отображается", mainPage.isFillingsDisplayed());
        return this;
    }

    @Step("Проверить, что отображается главная страница")
    public MainSteps isHomePageDisplayed() {
        assertTrue("Главная страница не отображается", mainPage.isHomePageDisplayed());
        return this;
    }
}
