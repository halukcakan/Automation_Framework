package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Global_Vars;

public class Contact_Us_PO extends Base_PO{
    private @FindBy(how = How.XPATH, using = "//*[@id=\"contact_form\"]/input[1]")
    WebElement firstName_TextField;

    private @FindBy(xpath = "//*[@id=\"contact_form\"]/input[2]")
    WebElement lastName_TextField;

    private @FindBy(xpath = "//*[@id='contact_form']/input[3]")
    WebElement emailAddress_TextField;

    private @FindBy(xpath = "//*[@id=\"contact_form\"]/textarea")
    WebElement comment_TextField;

    private @FindBy(xpath = "//*[@id=\"form_buttons\"]/input[2]")
    WebElement submit_Button;

    private @FindBy(xpath = "//*[@id=\"contact_reply\"]/h1")
    WebElement successfulSubmission_Message_Text;

    public Contact_Us_PO(){
        super();
    }

    public void navigateTo_WebDriverUniversity_Contact_Us_Page(){
        navigateTo_URL(Global_Vars.WEBDRIVER_UNIVERSITY_HOMEPAGE_URL + "/Contact-Us/contactus.html");
    }

    public void setUnique_FirstName (){
        sendKeys(firstName_TextField, "AutoFN"+generateRandomNumber(5));
    }

    public void setUnique_LastName (){
        sendKeys(lastName_TextField, "AutoLN"+generateRandomNumber(7));
    }

    public void setUnique_EmailAddress (){
        sendKeys(emailAddress_TextField, "AutoEmail"+generateRandomNumber(10)+ "@mail.com");
    }

    public void setUnique_Comment (){
        sendKeys(comment_TextField, "Hi,\n"+generateRandomNumber(20));
    }

    public void setSpecific_FirstName (String firstName){
        sendKeys(firstName_TextField, firstName);
    }

    public void setSpecific_LastName (String lastName){
        sendKeys(lastName_TextField, lastName);
    }

    public void setSpecific_EmailAddress (String emailAddress){
        sendKeys(emailAddress_TextField, emailAddress);
    }

    public void setSpecific_Comment (String comment){
        sendKeys(comment_TextField, comment);
    }

    public void clickOn_Submit_Button(){
        waitForWebElementAndClick(submit_Button);
    }

    public void validate_Successful_SubmissionMessage_Text(){
        waitFor(successfulSubmission_Message_Text);
        Assert.assertEquals(successfulSubmission_Message_Text.getText(),"Thank You for your Message!");
    }

}
