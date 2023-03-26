package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Contact_Us_PO;


public class Contact_Us_Steps extends Base_PO {

    private WebElement driver;
    private Contact_Us_PO contact_us_po;

    public Contact_Us_Steps(Contact_Us_PO contact_us_po){
        this.contact_us_po = contact_us_po;
    }


    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contacy_us_page() {
        contact_us_po.navigateTo_WebDriverUniversity_Contact_Us_Page();
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[1]")).sendKeys("AutoFN"+generateRandomNumber(5));
        //sendKeys(By.xpath("//*[@id=\\\"contact_form\\\"]/input[1]"),"AutoFN"+generateRandomNumber(5));
        contact_us_po.setUnique_FirstName();
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        //driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[2]")).sendKeys("AutoLN"+generateRandomNumber(5));
        contact_us_po.setUnique_LastName();
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        //driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys("AutoEmail"+generateRandomNumber(10)+ "@mail.com");
        contact_us_po.setUnique_EmailAddress();
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        //driver.findElement(By.xpath("//*[@id=\"contact_form\"]/textarea")).sendKeys("Hi,\n"+generateRandomNumber(20));
        contact_us_po.setUnique_Comment();
    }

    @And("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        //driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[1]")).sendKeys(firstName);
        contact_us_po.setSpecific_FirstName(firstName);
    }

    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        //driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[2]")).sendKeys(lastName);
        contact_us_po.setSpecific_LastName(lastName);
    }

    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        //driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys(email);
        contact_us_po.setSpecific_EmailAddress(email);
    }

    @And("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        //driver.findElement(By.xpath("//*[@id=\"contact_form\"]/textarea")).sendKeys(comment);
        contact_us_po.setSpecific_Comment(comment);
    }

    @And("I click on submit button")
    public void i_click_on_submit_button() {
        //driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]")).click();
        contact_us_po.clickOn_Submit_Button();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_shoud_be_presented_with_a_successful_contact_us_submission_message() {
        /*WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//*[@id=\"contact_reply\"]/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(),"Thank You for your Message!");*/
        contact_us_po.validate_Successful_SubmissionMessage_Text();
    }

}
