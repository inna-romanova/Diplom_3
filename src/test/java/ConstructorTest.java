import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу 'Булки' в Конструкторе")
    @Description("Проверка, что можно перейти в раздел 'Булки'")
    public void openCatalogBunsTest() {
        mainSteps
                .isHomePageDisplayed()
                .clickSaucesBtn()
                .clickBunBtn()
                .isBunsDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы' в Конструкторе")
    @Description("Проверка, что можно перейти в раздел 'Соусы'")
    public void openCatalogSaucesTest() {
        mainSteps
                .isHomePageDisplayed()
                .clickFillingsBtn()
                .clickSaucesBtn()
                .isSaucesDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки' в Конструкторе")
    @Description("Проверка, что можно перейти в раздел 'Начинки'")
    public void openCatalogFillingsTest() {
        mainSteps
                .isHomePageDisplayed()
                .clickSaucesBtn()
                .clickFillingsBtn()
                .isFillingsDisplayed();
    }
}
