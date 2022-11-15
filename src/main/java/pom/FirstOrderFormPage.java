package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FirstOrderFormPage {

    // Локаторы полей первой части формы
    private final By nameField = By.cssSelector("[placeholder= '* Имя']");
    private final By surnameField = By.cssSelector("[placeholder= '* Фамилия']");
    private final By addressField = By.cssSelector("[placeholder= '* Адрес: куда привезти заказ']");;
    private final By metroField = By.cssSelector("[placeholder= '* Станция метро']");
    private final By numberField = By.cssSelector("[placeholder= '* Телефон: на него позвонит курьер']");
    // Локатор кнопки "Далее" для перехода на вторую часть формы
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private WebDriver driver;
    public FirstOrderFormPage (WebDriver driver){
        this.driver = driver;
    }

    public void fillFirstFormAndGoNext(String name, String lastname, String address, String subway, String phone){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(lastname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroField).sendKeys(subway);
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        driver.findElement(numberField).sendKeys(phone);
        driver.findElement(nextButton).click();
    }
}
