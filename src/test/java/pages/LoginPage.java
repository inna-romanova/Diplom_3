package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //Локатор поля Email
    private final By email = By.xpath("//label[contains(text(),'Email')]/../input");
    //Локатор поля Пароль
    private final By password = By.xpath("//label[contains(text(),'Пароль')]/../input");
    //Локатор кнопки Войти
    private final By loginSubmitBtn = By.xpath(".//button[text()='Войти']");
    //Локатор кнопки Зарегистрироваться
    private final By registrationBtn = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    //Локатор кнопки восстановить пароль
    private final By forgottenPasswordBtn = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Восстановить пароль')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    private WebElement getClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement getVisibleElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void setEmail(String userEmail) {
        getVisibleElement(email).sendKeys(userEmail);
    }

    private void setPassword(String userPassword) {
        getVisibleElement(password).sendKeys(userPassword);
    }

    private void clickLoginSubmitBtn() {
        getClickableElement(loginSubmitBtn).click();
    }

    public void loginUser(String userEmail, String userPassword){
        setEmail(userEmail);
        setPassword(userPassword);
        clickLoginSubmitBtn();
    }

    public void clickRegistrationBtn() {
        WebElement element = driver.findElement(registrationBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        getClickableElement(registrationBtn).click();
    }

    public void clickForgottenPasswordBtn() {
        WebElement element = driver.findElement(forgottenPasswordBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        getClickableElement(forgottenPasswordBtn).click();
    }

    public boolean isLoginPageDisplayed() {
        return getVisibleElement(loginSubmitBtn).isDisplayed();
    }
}
