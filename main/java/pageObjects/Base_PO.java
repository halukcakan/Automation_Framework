package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;

public class Base_PO {
    public Base_PO(){
        PageFactory.initElements(getDriver(),this);
    }

    public WebDriver getDriver (){
        return DriverFactory.getDriver();
    }
    //  belirlenen (firefox/chrome) drivera ulasmak icin bir method

    public void navigateTo_URL (String url){
        getDriver().get(url);
    }
    //  ... istenecek url gitmeyi saglar

    public String generateRandomNumber (int length){
        return RandomStringUtils.randomNumeric(length);
    }
    //  "istendigi kadar" ranstegele harflerden kelime uretip donduren method


//    public void sendKeys (By by,String textToType){
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
//        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
//    }

    public void sendKeys (WebElement element, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    /*
    Method :
    #   Text'i yazmadan once forumun uygun/musait olmasini bekler ve gerceklestirir
    #   iki deger ister
            1)   WebElement     ->  icindeki method ile gosterilen konum (xpath)
            2)      String      ->  Yazilacak metin
     */
    }


//    public void waitFor (By by){
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
//    }


    public void waitFor (WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
/*
        yanlizca webelementin ekranda gorulmesini bekler
        that's it
*/
    }


//    public void waitForWebElementClick (By by){
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
//        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
//    }


    public void waitForWebElementAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
/*
    Method :
    #   Button'a tiklamadan once uygun olmasi bekler ve tiklar
    #   Tek deger ister
            1)  WebElement ->   icindeki bir method ile gosterilen konumu (xpath)
*/
    }


    public void waitForAlert_And_ValidateText (String expectedText){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, expectedText);
    }
}
