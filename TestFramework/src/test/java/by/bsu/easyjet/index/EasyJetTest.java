package by.bsu.easyjet.index;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EasyJetTest {
    WebDriver driver;
    private static final int timeout = 5;

    @Test(enabled = false)
    public void isHideReturnDateChoiceAfterOneWayTiketChoice() {
        IndexPage page = new IndexPage(driver, timeout);
        page.clickOneWay();
        Assert.assertFalse(page.isReturnDateInputVisible());
    }

    @Test(enabled = false)
    public void isRestrictToMaxAllowedAdultBookingQuantity() {
        IndexPage page = new IndexPage(driver, timeout);
        page.setAdultNumber(40);
        page.addAdult();
        Assert.assertTrue(page.isMaxPassangersWarningDrawerVisible());
    }

    @Test(enabled = false)
    public void isRestrictInfantPerAdultQuantity() {
        IndexPage page = new IndexPage(driver, timeout);
        page.addInfant();
        page.addInfant();
        Assert.assertTrue(page.isMaxInfantPerAdultWarningDrawerVisible());
    }

    @Test(enabled = false)
    public void isRestrictChildrenPerAdultQuantity() {
        IndexPage page = new IndexPage(driver, timeout);
        page.setChildrenNumber(10);
        page.addChildren();
        Assert.assertTrue(page.isChildrenPerAdultWarningDrawerVisible());
    }

    @Test(enabled = false)
    public void preventsBookingWithSameOriginAndDestination() {
        IndexPage page = new IndexPage(driver, timeout);
        page.setOriginAirport("Lublin (LUZ)");
        page.setDestinationAirport("Lublin (LUZ)");
        page.submitForm();
        Assert.assertTrue(page.isDestinationRequestDisplayed());
    }

    @DataProvider
    private Object[][] checkOutDate() {
        return new Object[][] { { LocalDate.now(), false }, { LocalDate.now().plusDays(1L), true },
                { LocalDate.now().plusYears(1L).plusDays(1L), false } };
    }

    @Test(dataProvider = "checkOutDate", enabled = false)
    public void isAbleToBookHotelOnlyWithinAllowedRange(LocalDate checkOutDate, boolean isCanBeClicked) {
        IndexPage page = new IndexPage(driver, timeout);
        page.openHotelsTab();
        page.getCalendar().pickHotelCheckInDate(LocalDate.now());
        Assert.assertEquals(page.getCalendar().isCheckOutButtonCanBeClicked(checkOutDate), isCanBeClicked);
    }

    @Test
    public void isRestrictOnlyOneInfantPerAdultOnHolliday() {
        IndexPage page = new IndexPage(driver, timeout);
        page.openHolidaysTab();
        page.addHollidayInfants(2);
        Assert.assertFalse(page.isHollidayInfantsCanBeAdded());
    }

    @Test(enabled = false)
    public void isPreventsInfantWithoutAdult() {
        IndexPage page = new IndexPage(driver, timeout);
        page.addInfant();
        page.removeAdult();
        Assert.assertTrue(page.isMoreInfantsThanAdultsDrawerVisible());
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
