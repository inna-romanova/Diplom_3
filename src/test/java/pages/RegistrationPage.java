package pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class RegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //Локатор поля Имя
    private final By name = By.xpath("//label[contains(text(),'Имя')]/../input");
    //Локатор поля  Email
    private final By email = By.xpath("//label[contains(text(),'Email')]/../input");
    //Локатор поля Пароль
    private final By password = By.xpath("//label[contains(text(),'Пароль')]/../input");
    //Локатор кнопки Зарегистрироваться
    private final By registrationSubmitBtn = By.xpath(".//button[text()='Зарегистрироваться']");
    //Локатор кнопки Войти
    private final By loginBtn = By.xpath("//a[text()='Войти']");
    //Локатор информации о некорректном пароле
    private final By invalidPasswordErrorTitle = By.xpath(".//p[text() = 'Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    private WebElement getClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement getVisibleElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void setName(String userName) {
        getVisibleElement(name).sendKeys(userName);
    }

    private void setEmail(String userEmail) {
        getVisibleElement(email).sendKeys(userEmail);
    }

    private void setPassword(String userPassword) {
        getVisibleElement(password).sendKeys(userPassword);
    }

    private void clickRegisterSubmitBtn() {
        getClickableElement(registrationSubmitBtn).click();
    }

    public void registerUser(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterSubmitBtn();
    }

    public void clickLoginBtn() {
        WebElement element = driver.findElement(loginBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        getClickableElement(loginBtn).click();
    }

    public boolean isInvalidPasswordErrorDisplayed() {
        return getVisibleElement(invalidPasswordErrorTitle).isDisplayed();
    }

    public boolean isRegistrationPageDisplayed() {
        return getVisibleElement(registrationSubmitBtn).isDisplayed();
    }
}
