import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainScooterGeneralPage;


public class MainTests {
    private WebDriver driver;

    @Before
    public void beforeTest() {
        // драйвер для браузера
        ChromeOptions options = new ChromeOptions();
        driver = new FirefoxDriver();
        //driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Проверяет название раздела с вопросами
    @Test
    public void checkQuestionsHeaderTitle() {
        // объект класса главной страницы
        MainScooterGeneralPage objScooterPage = new MainScooterGeneralPage(driver);
        // Проверить соответствие текста подзаголовка
        objScooterPage.checkQuestionsHeader();
    }

    //Нажимает верхнюю кнопку оформления заказа
    @Test
    public void clickUpperOrderButtonOpensOrderPage() {
        // объект класса главной страницы
        MainScooterGeneralPage objScooterPage = new MainScooterGeneralPage(driver);
        // Нажать на верхнюю кнопку
        objScooterPage.clickHeaderOrderButton();
        // убедиться, что есть переход на страницу заказа
        objScooterPage.checkOrderPageOpened();
    }

    //Нажимает нижнюю кнопку оформления заказа
    @Test
    public void clickLowerOrderButtonOpensOrderPage() {
        // объект класса главной страницы
        MainScooterGeneralPage objScooterPage = new MainScooterGeneralPage(driver);
        // Нажать на нижнюю кнопку
        objScooterPage.clickFooterOrderButton();
        // убедиться, что есть переход на страницу заказа
        objScooterPage.checkOrderPageOpened();
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
