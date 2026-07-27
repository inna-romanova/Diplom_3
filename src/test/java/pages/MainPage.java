package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //Локатор кнопки личный кабинет
    private final By personalAccountBtn = By.xpath(".//p[contains(text(),'Личный Кабинет')]");
    //Локатор кнопки Войти в аккаунт на главной странице
    private final By loginMainPageBtn = By.xpath(".//button[text()='Войти в аккаунт']");
    // Локатор заголовка страницы
    private final By mainPageTitle = By.xpath("//h1[text()='Соберите бургер']");
    //Локатор вкладки Булки
    private final By bunBtn = By.xpath(".//div[span[text()='Булки']]");
    //Локатор вкладки Соусы
    private final By saucesBtn = By.xpath(".//div[span[text()='Соусы']]");
    //Локатор вкладки Начинки
    private final By fillingsBtn = By.xpath(".//div[span[text()='Начинки']]");
    //Локатор булок
    private final By bun = By.xpath("//div[contains(span/text(),'Булки') and contains(@class,'current')]");
    //Локатор соусов
    private final By sauces = By.xpath("//div[contains(span/text(),'Соусы') and contains(@class,'current')]");
    //Локатор начинок
    private final By fillings = By.xpath("//div[contains(span/text(),'Начинки') and contains(@class,'current')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    private WebElement getClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement getVisibleElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickPersonalAccountBtn(){
        getClickableElement(personalAccountBtn).click();
    }

    public void clickLoginCentralBtn() {
        getClickableElement(loginMainPageBtn).click();
    }

    public void clickBunBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(bunBtn));
        getClickableElement(bunBtn).click();
    }

    public void clickSaucesBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(saucesBtn));
        getClickableElement(saucesBtn).click();
    }

    public void clickFillingsBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(fillingsBtn));
        getClickableElement(fillingsBtn).click();
    }
    public boolean isBunsDisplayed() {
        return getVisibleElement(bun).isDisplayed();
    }

    public boolean isSaucesDisplayed() {
        return getVisibleElement(sauces).isDisplayed();
    }

    public boolean isFillingsDisplayed() {
        return getVisibleElement(fillings).isDisplayed();
    }

    public boolean isHomePageDisplayed() {
        return getVisibleElement(mainPageTitle).isDisplayed();
    }

}
