package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static pageobject.MainScooterGeneralPage.LOWER_BUTTON;
import static pageobject.MainScooterGeneralPage.UPPER_BUTTON;

public class OrderScooterPage {
    private final WebDriver driver;

    // Поле ввода имени
    private final By inputName = By.cssSelector("div.Order_Form__17u6u > div:nth-child(1) > input");
    // Поле вводе фамилии
    private final By inputSurname = By.cssSelector("div.Order_Form__17u6u > div:nth-child(2) > input");
    // Поле ввода адреса
    private final By inputAddress = By.cssSelector("div.Order_Form__17u6u > div:nth-child(3) > input");
    // Выпадающий список станции метро
    private final By dropdownSubway = By.cssSelector("div.select-search");
    private final By dropdownSubwayElement = By.cssSelector("div.select-search__select > ul > li");
    // Поле ввода номера телефона
    private final By inputPhone = By.cssSelector("div.Order_Form__17u6u > div:nth-child(5) > input");
    // Кнопка "Далее"
    private final By buttonNext = By.cssSelector("div.Order_NextButton__1_rCA > button");
    //Date-picker
    private final By datePicker = By.cssSelector("div.Order_MixedDatePicker__3qiay > div.react-datepicker-wrapper > div > input");
    private final By selectedMonthDays = By.cssSelector(".react-datepicker__month .react-datepicker__day");
    //Дропдаун сроков аренды
    private final By dropdownTerm = By.cssSelector("div.Dropdown-root");
    private final By dropdownTerms = By.cssSelector("div.Dropdown-root.is-open > div.Dropdown-menu > div");
    //Боксы выбора цвета
    private final By boxBlackColor = By.cssSelector("#black");
    private final By boxGrayColor = By.cssSelector("#grey");
    //Коммент для курьера
    private final By inputComment = By.cssSelector("div.Order_Form__17u6u > div.Input_InputContainer__3NykH > input");
    //Кнопка "Заказать"
    private final By buttonOrder = By.cssSelector("div.Order_Buttons__1xGrp > button:nth-child(2)");
    //Заголовок "Хотите?" на модалке подтверждения
    private final By titleDoYouReallyWant = By.cssSelector(".Order_ModalHeader__3FDaJ");
    private static final String TITLE_DO_YOU_REALLY_WANT_TO_ORDER = "Хотите оформить заказ?\n" + " ";
    //Кнопка Да
    private final By buttonYes = By.cssSelector("div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button:nth-child(2)");
    //Заголовок "Заказ оформлен"
    private final By titleOrderReceived = By.cssSelector(".Order_ModalHeader__3FDaJ");
    private static final String TITLE_ORDER_PROCESSED = "Заказ оформлен";
    //Кнопка "Посмотреть статус"
    private final By buttonStatus = By.cssSelector(".Order_NextButton__1_rCA > button:nth-child(1)");
    //Logo-button
    private final By buttonLogoSamokat = By.cssSelector(".Header_LogoScooter__3lsAR");

    //Конструктор
    public OrderScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        WebElement nameInputElement = driver.findElement(inputName);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", nameInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nameInputElement)).click();

        nameInputElement.clear();
        nameInputElement.sendKeys(name);

        wait.until(ExpectedConditions.attributeToBe(nameInputElement, "value", name));
    }

    public void enterSurname(String surname) {
        WebElement surnameInputElement = driver.findElement(inputSurname);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", surnameInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(surnameInputElement)).click();

        surnameInputElement.clear();
        surnameInputElement.sendKeys(surname);

        wait.until(ExpectedConditions.attributeToBe(surnameInputElement, "value", surname));
    }

    public void enterAddress(String address) {
        WebElement addressInputElement = driver.findElement(inputAddress);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", addressInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addressInputElement)).click();

        addressInputElement.clear();
        addressInputElement.sendKeys(address);

        wait.until(ExpectedConditions.attributeToBe(addressInputElement, "value", address));
    }

    public void selectSubway(String subwayName) {
        WebElement subwayDropdown = driver.findElement(dropdownSubway);
        subwayDropdown.click();

        WebDriverWait ulWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ulWait.until(ExpectedConditions.visibilityOfElementLocated(dropdownSubwayElement));

        List<WebElement> options = driver.findElements(dropdownSubwayElement);
        for (WebElement option : options) {
            if (option.getText().equals(subwayName)) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", option);
                option.click();
                break;
            }
        }
    }

    public void enterPhone(String phone) {
        WebElement phoneInputElement = driver.findElement(inputPhone);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", phoneInputElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(phoneInputElement)).click();

        phoneInputElement.clear();
        phoneInputElement.sendKeys(phone);
    }

    public void clickNextButton() {
        WebElement nextButtonElement = driver.findElement(buttonNext);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", nextButtonElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(nextButtonElement)).click();
    }

    public void selectDate(String date) {
        WebElement datePickerElement = driver.findElement(datePicker);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", datePickerElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(datePickerElement)).click();
        datePickerElement.sendKeys(date);

        List<WebElement> allSelectedMonthDays = driver.findElements(selectedMonthDays);
        String day = date.substring(0, 2);
        if (day.substring(0,1).equals("0")) {
            day = date.substring(1, 2);
        }
        for (WebElement option : allSelectedMonthDays) {
            if (option.getText().equals(day)) {
                option.click();
                break;
            }
        }
    }

    public void selectTerm(String term) {
        WebElement lengthDropdown = driver.findElement(dropdownTerm);
        lengthDropdown.click();

        List<WebElement> allTermsFromDropdown = driver.findElements(dropdownTerms);

        for (WebElement option : allTermsFromDropdown) {
            if (option.getText().equals(term)) {
                option.click();
                break;
            }
        }
    }

    public void selectColor(String color) {
        if (color.equalsIgnoreCase("black")) {
            WebElement blackColorBox = driver.findElement(boxBlackColor);
            blackColorBox.click();
        } else if (color.equalsIgnoreCase("gray")) {
            WebElement grayColorBox = driver.findElement(boxGrayColor);
            grayColorBox.click();
        }
    }

    public void enterComment(String comment) {
        WebElement commentInputElement = driver.findElement(inputComment);
        commentInputElement.sendKeys(comment);
    }

    public void clickOrderButton() {
        WebElement orderButtonElement = driver.findElement(buttonOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", orderButtonElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonElement)).click();
    }

    public String getDoYouReallyWantTitle() {
        WebElement titleElement = driver.findElement(titleDoYouReallyWant);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", titleElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(titleElement)).getText();
    }

    public void clickYesButton() {
        WebElement yesButtonElement = driver.findElement(buttonYes);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", yesButtonElement);

        yesButtonElement.click();
    }

    public void clickStatusButton() {
        WebElement statusButtonElement = driver.findElement(buttonStatus);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", statusButtonElement);

        statusButtonElement.click();
    }

    public void goToMain() {
        WebElement logoButtonElement = driver.findElement(buttonLogoSamokat);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", logoButtonElement);

        logoButtonElement.click();
    }

    public String getOrderReceivedTitle() {
        WebElement titleElement = driver.findElement(titleOrderReceived);
        return titleElement.getText().substring(0, 14);
    }

    // Выбираем, с какой кнопки запустить форму заказа
    // В ревью была информация, что запускаем только с верхней, но в задаче в постановке написано
    // учесть обе точки входа, поэтому данный метод всё же оставлю
    public OrderScooterPage chooseTheOrderButtonToClick(String button) throws InterruptedException {
        // объект класса главной страницы для нажатия на кнопку
        MainScooterGeneralPage objScooterPage = new MainScooterGeneralPage(driver);
        Thread.sleep(3000);
        switch (button) {
            case UPPER_BUTTON:
                objScooterPage.clickHeaderOrderButton();
                break;
            case LOWER_BUTTON:
                objScooterPage.clickFooterOrderButton();
                break;
            default: objScooterPage.clickHeaderOrderButton();
        }
        return this;
        /*if (button.equalsIgnoreCase(UPPER_BUTTON)) {
            objScooterPage.clickHeaderOrderButton();
        } else if (button.equalsIgnoreCase(LOWER_BUTTON)) {
            objScooterPage.clickFooterOrderButton();
        }*/
        }

    public OrderScooterPage fillInUserPersonalData(String name,String surname,String address,String subway,String phone) throws InterruptedException {
        Thread.sleep(3000);
        enterName(name);
        Thread.sleep(3000);
        enterSurname(surname);
        Thread.sleep(3000);
        selectSubway(subway);
        Thread.sleep(3000);
        enterAddress(address);
        Thread.sleep(3000);
        enterPhone(phone);
        Thread.sleep(3000);
        clickNextButton();
        Thread.sleep(3000);
        return this;
    }

    public OrderScooterPage fillInOrderDetails(String date,String term,String color,String comment) throws InterruptedException {
        Thread.sleep(3000);
        selectDate(date);
        Thread.sleep(3000);
        selectTerm(term);
        Thread.sleep(3000);
        selectColor(color);
        Thread.sleep(3000);
        enterComment(comment);
        Thread.sleep(3000);
        clickOrderButton();
        Thread.sleep(3000);
        return this;
    }

    public void checkOrderConfirmationModal() throws InterruptedException {
        // Проверка результатов заполнения
        String confirmationTitle = getDoYouReallyWantTitle();
        Thread.sleep(3000);
        Assert.assertEquals("Заголовок модального окна подтверждения неверный: ",TITLE_DO_YOU_REALLY_WANT_TO_ORDER, confirmationTitle);
        clickYesButton();
    }

    public void checkOrderStatusModal() {
        String orderReceivedTitle = getOrderReceivedTitle();
        Assert.assertEquals("Не получилось оформить заказ!", TITLE_ORDER_PROCESSED, orderReceivedTitle);
        clickStatusButton();
    }

}
