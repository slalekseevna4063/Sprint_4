package faq;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPage;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckAnswersText {
    private WebDriver driver;

    private final By questionButton;
    private final By answerText;
    private final String expectedText;

    public CheckAnswersText(By questionButton, By answerText, String expectedText) {
        this.questionButton = questionButton;
        this.answerText = answerText;
        this.expectedText = expectedText;
    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {MainPage.questionButton1, MainPage.answerText1, MainPage.text1},
                {MainPage.questionButton2, MainPage.answerText2, MainPage.text2},
                {MainPage.questionButton3, MainPage.answerText3, MainPage.text3},
                {MainPage.questionButton4, MainPage.answerText4, MainPage.text4},
                {MainPage.questionButton5, MainPage.answerText5, MainPage.text5},
                {MainPage.questionButton6, MainPage.answerText6, MainPage.text6},
                {MainPage.questionButton7, MainPage.answerText7, MainPage.text7},
                {MainPage.questionButton8, MainPage.answerText8, MainPage.text8},
        };
    }

    @Before
    public void setUp(){
         System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         driver.manage().window().maximize();
    }
    @Test
    public void answersTextsFromFaqAreCorrect() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openBrowser();
        mainPage.clickOnOkCookieButton();
        mainPage.scrollUntilFirstButton();
        driver.findElement(questionButton).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(answerText));
        assertEquals(
                "Текст ответа не совпадает с ожидаемым",
                expectedText,
                driver.findElement(answerText).getText());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
