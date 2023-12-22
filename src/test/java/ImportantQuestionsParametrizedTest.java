import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainScooterQuestionsPage;

import static constants.URL.HOME_PAGE;
import static pageobject.MainScooterQuestionsPage.*;

@RunWith(Parameterized.class)
public class ImportantQuestionsParametrizedTest {
    // Элемент выпадающего списка - вопрос и ответ
    private final By importantQuestionLocator;
    private final By importantAnswerLocator;
    private final String questionExpectedText;
    private final String questionExpectedAnswer;

    //Конструктор
    public ImportantQuestionsParametrizedTest(By importantQuestionLocator, By importantAnswerLocator,
                                    String questionText, String questionAnswer) {
        this.importantQuestionLocator = importantQuestionLocator;
        this.importantAnswerLocator = importantAnswerLocator;
        this.questionExpectedText = questionText;
        this.questionExpectedAnswer = questionAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        return new Object[][] {
                {QUESTION1, ANSWER1, TEXT_QUESTION1, TEXT_ANSWER1},
                {QUESTION2, ANSWER2, TEXT_QUESTION2, TEXT_ANSWER2},
                {QUESTION3, ANSWER3, TEXT_QUESTION3, TEXT_ANSWER3},
                {QUESTION4, ANSWER4, TEXT_QUESTION4, TEXT_ANSWER4},
                {QUESTION5, ANSWER5, TEXT_QUESTION5, TEXT_ANSWER5},
                {QUESTION6, ANSWER6, TEXT_QUESTION6, TEXT_ANSWER6},
                {QUESTION7, ANSWER7, TEXT_QUESTION7, TEXT_ANSWER7},
                {QUESTION8, ANSWER8, TEXT_QUESTION8, TEXT_ANSWER8},
        };
    }

    // Проверить соответствие текстов вопроса и ответа
    @Test
    public void shouldCheckQuestionAndAnswer() {
        ChromeOptions options = new ChromeOptions();
        //WebDriver driver = new ChromeDriver(options);;
        WebDriver driver = new FirefoxDriver();
        driver.get(HOME_PAGE);

        MainScooterQuestionsPage questionsPage = new MainScooterQuestionsPage(driver);

        String questionActualText = questionsPage.getQuestionActualText(importantQuestionLocator);
        questionsPage.clickQuestion(importantQuestionLocator);
        String answerActualText = questionsPage.getAnswerActualText(importantAnswerLocator);

        // Проверить соответствие текста вопроса и ответа ожидаемым значениям
        Assert.assertEquals("Текст вопроса не соответствует ожидаемому: ", questionExpectedText, questionActualText);
        Assert.assertEquals("Текст ответа не соответствует ожидаемому: ", questionExpectedAnswer, answerActualText);
        driver.quit();
    }
}
