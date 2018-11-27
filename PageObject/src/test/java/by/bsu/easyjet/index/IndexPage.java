package by.bsu.easyjet.index;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    private final WebDriver driver;

    @FindBy(xpath = "//label[@for='one-way']")
    private WebElement oneWayCheckbox;
    @FindBy(xpath = "//div[contains(@class, 'return-date-picker')]")
    private WebElement returnDateInputField;
    @FindBy(xpath = "//input[starts-with(@id, 'origin-')]")
    private WebElement originInput;
    @FindBy(xpath = "//input[starts-with(@id, 'destination-')]")
    private WebElement destinationInput;
    @FindBy(xpath = "//button[contains(@class, 'search-submit')]")
    private WebElement submitButton;
    @FindBy(xpath = "//form[@name='searchPodForm']/*[contains(text(),'Please select a destination')]")
    private WebDriver destinationRequest;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.easyjet.com/en/");
        PageFactory.initElements(driver, this);
    }

    public void clickOneWay() {
        oneWayCheckbox.click();
    }

    public boolean isReturnDateInputVisible() {
        return returnDateInputField.isDisplayed();
    }

    public void setOriginAirport(String origin) {
        originInput.sendKeys(origin);
    }

    public void setDestinationAirport(String destination) {
        destinationInput.sendKeys(destination);
    }

    public void submitForm() {
        submitButton.click();
    }

    public boolean isDestinationRequestDisplayed() {
        return destinationInput.isDisplayed();
    }
}
