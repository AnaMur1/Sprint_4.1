package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static constants.URL.ORDER_PAGE;


public class MainScooterGeneralPage {
    private WebDriver driver;

    // Кнопка "Заказать" вверху страницы
    private final By headerOrderButton = By.cssSelector(".Button_Button__ra12g");
    // Кнопка "Заказать" внизу страницы
    private final By footerOrderButton = By.cssSelector(".Button_Middle__1CSJM");
    //Подзаголовок вопросов
    private final By questionsTitle = By.cssSelector(".Home_FourPart__1uthg > div:nth-child(1)");
    //Ожидаемый текст названия раздела вопросов
    private static final String QUESTIONS_HEADER_TEXT = "Вопросы о важном";
    public static final String UPPER_BUTTON = "upper";
    public static final String LOWER_BUTTON = "lower";


    //Конструктор
    public MainScooterGeneralPage(WebDriver driver) {
        this.driver = driver;
    }

    //Проверить корректность текста подзаголовка
    public void checkQuestionsHeader() {
        WebElement questionsTitleElement = driver.findElement(questionsTitle);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", questionsTitleElement);

        Assert.assertEquals("Заголовок раздела вопросов неверный: ожидался " + QUESTIONS_HEADER_TEXT + ", фактический " +
                questionsTitleElement.getText(), QUESTIONS_HEADER_TEXT, questionsTitleElement.getText());
    }

    //Проверить, что открылась страница оформления заказа
    public void checkOrderPageOpened(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assert.assertEquals("Страница оформления заказа не открылась!", ORDER_PAGE, driver.getCurrentUrl());
    }

    public void clickHeaderOrderButton() {
        //Найти верхнюю кнопку
        WebElement upperButton = driver.findElement(headerOrderButton);
        //Подскроллить к ней и нажать
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", upperButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        upperButton.click();
    }

    public void clickFooterOrderButton() {
        //Найти верхнюю кнопку
        WebElement lowerButton = driver.findElement(footerOrderButton);
        //Подскроллить к ней и нажать
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", lowerButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        lowerButton.click();
    }

}
