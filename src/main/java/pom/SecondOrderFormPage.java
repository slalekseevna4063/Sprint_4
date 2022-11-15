package pom;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.containsString;

public class SecondOrderFormPage {

    // Локаторы полей второй части формы
    private final By deliveryDateField = By.cssSelector("[placeholder= '* Когда привезти самокат']");
    private final By durationOfRentField = By.cssSelector("[class= 'Dropdown-placeholder']");
    private final By chooseDurationClick = By.cssSelector("div.Dropdown-option:nth-child(1)");
    private final By colourCheckBox = By.cssSelector("[class= 'Checkbox_Input__14A2w']");
    private final By commentField = By.cssSelector("[placeholder= 'Комментарий для курьера']");
    // Локаторы кнопок "Заказать" для итогового оформления заказа
    private final By makeOrderButton = By.cssSelector("button.Button_Middle__1CSJM:nth-child(2)");
    private final By popupYesButton = By.cssSelector("div.Order_Buttons__1xGrp:nth-child(2)>button:nth-child(2)");
    // Локатор модалки
    private final By modalTextAboutSuccess = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]");

    private WebDriver driver;
    public SecondOrderFormPage (WebDriver driver){
        this.driver = driver;
    }

    public void fillSecondFormAndMakeOrder(String testDate, String testComment){
        driver.findElement(deliveryDateField).sendKeys(testDate, Keys.ENTER);
        driver.findElement(durationOfRentField).click();
        driver.findElement(chooseDurationClick).click();
        driver.findElement(colourCheckBox).click();
        driver.findElement(commentField).sendKeys(testComment);
        driver.findElement(makeOrderButton).click();
        driver.findElement(popupYesButton).click();
    }
    public void orderCreationCheck(){
        String expected = "Заказ оформлен";
        String actual =  driver.findElement(modalTextAboutSuccess).getText();
        MatcherAssert.assertThat(actual, containsString(expected));
    }
}
