//package pages;
//
//import lombok.AllArgsConstructor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//@AllArgsConstructor
//public class ProfilePage {
//
//    //Локатор поля текст в профиле при авториизации
//    private final By accountText = By.xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");
//    //Локатор кнопки выхода
//    private final By singOutBtn = By.xpath(".//button[text()='Выход']");
//    //Локатор кнопки конструктора
//    private final By constructorBtn = By.xpath(".//p[text()='Конструктор']");
//    //Локатор кнопки лого
//    private final By logoBtn = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
//    private final WebDriver driver;
//
//    public MainPage clickConstructorBtn() {
//        driver.findElement(constructorBtn).click();
//        return new MainPage(driver);
//    }
//
//    public MainPage clickLogoBtn() {
//        driver.findElement(logoBtn).click();
//        return new MainPage(driver);
//    }
//}
