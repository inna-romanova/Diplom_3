package pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class ForgottenPasswordPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginBtn = By.xpath(".//a[text()='Войти']"); //Локатор кнопки войти
    private final By pageTitle = By.xpath("//h2[text()='Восстановление пароля']"); //Локатор заголовка страницы
    public ForgottenPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    public void clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }
    public boolean isForgottenPasswordPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }
}
