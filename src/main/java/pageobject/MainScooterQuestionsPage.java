package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MainScooterQuestionsPage {
    private final WebDriver driver;

    //Локаторы вопросов и ответов
    public static final By QUESTION1 = By.id("accordion__heading-0");
    public static final By ANSWER1 = By.id("accordion__panel-0");
    public static final By QUESTION2 = By.id("accordion__heading-1");
    public static final By ANSWER2 = By.id("accordion__panel-1");
    public static final By QUESTION3 = By.id("accordion__heading-2");
    public static final By ANSWER3 = By.id("accordion__panel-2");
    public static final By QUESTION4 = By.id("accordion__heading-3");
    public static final By ANSWER4 = By.id("accordion__panel-3");
    public static final By QUESTION5 = By.id("accordion__heading-4");
    public static final By ANSWER5 = By.id("accordion__panel-4");
    public static final By QUESTION6 = By.id("accordion__heading-5");
    public static final By ANSWER6 = By.id("accordion__panel-5");
    public static final By QUESTION7 = By.id("accordion__heading-6");
    public static final By ANSWER7 = By.id("accordion__panel-6");
    public static final By QUESTION8 = By.id("accordion__heading-7");
    public static final By ANSWER8 = By.id("accordion__panel-7");

    //Тексты вопросов и ответов
    public static final String TEXT_QUESTION1 = "Сколько это стоит? И как оплатить?";
    public static final String TEXT_ANSWER1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String TEXT_QUESTION2 = "Хочу сразу несколько самокатов! Так можно?";
    public static final String TEXT_ANSWER2 = "Пока что у нас так: один заказ — один самокат. Если хотите " +
            "покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String TEXT_QUESTION3 = "Как рассчитывается время аренды?";
    public static final String TEXT_ANSWER3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 " +
            "мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
            "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String TEXT_QUESTION4 = "Можно ли заказать самокат прямо на сегодня?";
    public static final String TEXT_ANSWER4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String TEXT_QUESTION5 = "Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String TEXT_ANSWER5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в " +
            "поддержку по красивому номеру 1010.";
    public static final String TEXT_QUESTION6 = "Вы привозите зарядку вместе с самокатом?";
    public static final String TEXT_ANSWER6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает " +
            "на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String TEXT_QUESTION7 = "Можно ли отменить заказ?";
    public static final String TEXT_ANSWER7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной " +
            "записки тоже не попросим. Все же свои.";
    public static final String TEXT_QUESTION8 = "Я живу за МКАДом, привезёте?";
    public static final String TEXT_ANSWER8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public MainScooterQuestionsPage(WebDriver driver){
        this.driver = driver;
    }

    // Найти элемент вопроса
    public String getQuestionActualText(By importantQuestionLocator){
        WebElement answerElement = driver.findElement(importantQuestionLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", answerElement);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
        return answerElement.getText();
    }

    // Найти элемент ответа
    public String getAnswerActualText(By importantAnswerLocator){
        WebElement answerElement = driver.findElement(importantAnswerLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", answerElement);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
        return answerElement.getText();
    }

    //Нажать на вопрос
    public void clickQuestion(By importantQuestionLocator){
        WebElement questionElement = driver.findElement(importantQuestionLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", questionElement);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        questionElement.click();
    }
}
