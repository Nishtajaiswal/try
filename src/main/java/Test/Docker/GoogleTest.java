package Test.Docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {
	
	 private WebDriver driver;
	    private GooglePage google;

	    @BeforeTest
	    public void setUp() throws MalformedURLException {
	        DesiredCapabilities dc = DesiredCapabilities.chrome();
	        driver = new RemoteWebDriver(new URL("http://my-selenium-grid-ip:4444/wd/hub"), dc);
	        google = new GooglePage(driver);
	    }

	    @Test
	    public void googleTest() throws InterruptedException {
	        google.goTo();
	        google.searchFor("automation");
	        Assert.assertTrue(google.getResults().size() >= 10);
	    }
	    
	    @AfterTest
	    public void tearDown() throws InterruptedException {
	        driver.quit();
	    }    


}
