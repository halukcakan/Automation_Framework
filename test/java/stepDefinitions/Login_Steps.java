package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;


public class Login_Steps extends Base_PO {

    private Login_PO login_po;

    public Login_Steps (Login_PO login_po){
        this.login_po = login_po;
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        //navigateTo_URL("http://www.webdriveruniversity.com/Login-Portal/index.html");
        login_po.navigateTo_WebDriverUniversity_Login_Page();
    }

    @When("I enter a username {word}")
    public void i_enter_a_username_webdriver(String username) {
        //driver.findElement(By.xpath("//*[@id=\"text\"]")).sendKeys(username);
        //sendKeys(By.xpath("//*[@id=\"text\"]"),username);
        login_po.setUsername(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        //driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        login_po.setPassword(password);
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        //driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        login_po.clickOn_Login_Button();
    }

    @Then("I should be presented with the successful login message")
    public void i_shoud_be_presented_with_the_successful_login_message() {
        /*String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,"validation succeeded");*/
        login_po.validate_SuccessfulLogin_Message();
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_shoud_be_presented_with_the_unsuccessful_login_message() {
        /*String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,"validation failed");*/
        login_po.validate_UnsuccessfulLogin_Message();
    }

    /*
                yukaridaki ve asagidaki methodlarin ikiside assertion yapiyor fakat arasindaki fark :
                #   yukaridakine kontrol edilecek degeri Login_PO icinde veriyoruz
                #   asagidaki deger feature file da veriyoruz ki dogrudan
                    feature icinden ve senaryolari uygularak yapsin

     */

    @Then("I should be presented with following login validations message {}")
    public void i_should_be_presented_with_following_login_validations_message(String expectedValidation) {
        /*String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message,expectedValidation);*/
        waitForAlert_And_ValidateText(expectedValidation);
    }

}
