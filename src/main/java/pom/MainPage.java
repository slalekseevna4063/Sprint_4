package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage {

    //Ссылка на главную страницу сайта
    public final String mainPageUrl = "https://qa-scooter.praktikum-services.ru/";
    // Кнопка для закрытия куки-уведомления
    public final By okCookie = By.xpath(".//button[@id='rcc-confirm-button']");
    // Кнопки-стрелочки для разворачивания вопросов
    public static final By questionButton1 = By.xpath(".//div[@id='accordion__heading-0']");
    public static final By questionButton2 = By.xpath(".//div[@id='accordion__heading-1']");
    public static final By questionButton3 = By.xpath(".//div[@id='accordion__heading-2']");
    public static final By questionButton4 = By.xpath(".//div[@id='accordion__heading-3']");
    public static final By questionButton5 = By.xpath(".//div[@id='accordion__heading-4']");
    public static final By questionButton6 = By.xpath(".//div[@id='accordion__heading-5']");
    public static final By questionButton7 = By.xpath(".//div[@id='accordion__heading-6']");
    public static final By questionButton8 = By.xpath(".//div[@id='accordion__heading-7']");
    // Локаторы текстовок всех ответов
    public static final By answerText1 = By.xpath(".//div[@id='accordion__panel-0']");
    public static final By answerText2 = By.xpath(".//div[@id='accordion__panel-1']");
    public static final By answerText3 = By.xpath(".//div[@id='accordion__panel-2']");
    public static final By answerText4 = By.xpath(".//div[@id='accordion__panel-3']");
    public static final By answerText5 = By.xpath(".//div[@id='accordion__panel-4']");
    public static final By answerText6 = By.xpath(".//div[@id='accordion__panel-5']");
    public static final By answerText7 = By.xpath(".//div[@id='accordion__panel-6']");
    public static final By answerText8 = By.xpath(".//div[@id='accordion__panel-7']");
    // Переменные, содержащие тексты ОР
    public static final String text1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String text2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String text3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String text4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String text5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String text6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String text7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String text8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    // Верхняя и нижняя кнопки "Заказать"
    public static final By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    public static final By bottomOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private WebDriver driver;
    public MainPage (WebDriver driver){
        this.driver = driver;
   }
    public void openBrowser(){
        driver.get(mainPageUrl);
   }
    public void clickOnOkCookieButton() {
        driver.findElement(okCookie).click();
    }
    public void scrollUntilFirstButton () {
        WebElement element = driver.findElement(questionButton1);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    }


