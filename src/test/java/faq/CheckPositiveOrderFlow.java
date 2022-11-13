package faq;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.FirstOrderFormPage;
import pom.MainPage;
import pom.SecondOrderFormPage;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class CheckPositiveOrderFlow {
    private WebDriver driver;
    private final By twinOrderButton;
    private final String testName;
    private final String testLastname;
    private final String testAddress;
    private final String testSubway;
    private final String testPhone;
    private final String testDate;
    private final String testComment;

    public CheckPositiveOrderFlow(By twinOrderButton, String testName, String testLastname, String testAddress, String testSubway, String testPhone, String testDate, String testComment) {
        this.twinOrderButton = twinOrderButton;
        this.testName = testName;
        this.testLastname = testLastname;
        this.testAddress = testAddress;
        this.testSubway = testSubway;
        this.testPhone = testPhone;
        this.testDate = testDate;
        this.testComment = testComment;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {MainPage.topOrderButton, "Лариса", "Сиротина", "Адрес,22", "Лубянка", "89052853412", "01.12.2022", "Последнее поле!"},
                {MainPage.topOrderButton, "Абдуррахман", "ИбнХоттабыч", "Индийская,66", "Черкизовская", "89052857454", "01.12.2022", "Еще раз последнее поле!"},
                {MainPage.bottomOrderButton, "Лариса", "Сиротина", "Адрес,22", "Лубянка", "89052853412", "28.11.2022", "Последнее поле!"},
                {MainPage.bottomOrderButton, "Абдуррахман", "ИбнХоттабыч", "Индийская,66", "Черкизовская", "89052857454", "28.11.2022", "Еще раз последнее поле!"},
        };
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void userCanMakeOrder() {

        MainPage mainPage = new MainPage(driver);
        FirstOrderFormPage firstOrderFormPage = new FirstOrderFormPage(driver);
        SecondOrderFormPage secondOrderFormPage = new SecondOrderFormPage(driver);

        mainPage.openBrowser();
        mainPage.clickOnOkCookieButton();
        driver.findElement(twinOrderButton).click();
        firstOrderFormPage.fillFirstFormAndGoNext(testName, testLastname, testAddress, testSubway, testPhone);
        secondOrderFormPage.fillSecondFormAndMakeOrder(testDate, testComment);
        secondOrderFormPage.orderCreationCheck();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
