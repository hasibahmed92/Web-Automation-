package base;

import org.apache.log4j.Level;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class CommonApi {
    public WebDriver driver = null;
    public Logger logger = Logger.getLogger(CommonApi.class);

    @Parameters({"OS","browser", "browserVersion", "url"})
    @BeforeClass
    public void setUp(@Optional("OS") String OS, @Optional("browser") String browser,
                      @Optional("browserVersion") String browserVersion,
                      @Optional("url") String url) throws IOException {


        //run on local
        logger.setLevel(Level.INFO);
        logger.info("Test is running on local env");
        getLocalDriver(OS, browser, browserVersion);

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    //driver to run on local
    public WebDriver getLocalDriver(String OS, String browser, String browserVersion) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/hasibahmed/Desktop/TeamAutomation2018-master/Generic/selenium-browser-driver/geckodriver");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            if (OS.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "/Users/hasibahmed/Desktop/TeamAutomation2018-master/Generic/selenium-browser-driver/chromedriver");
                driver = new ChromeDriver();
            } else if (OS.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\adibi\\Desktop\\nayna\\Team_Automation2018\\Generic\\selenium-browser-driver\\chromedriver.exe");
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "Generic\\selenium-browser-driver\\IEDriverServer.exe");
            driver = new ChromeDriver();
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }

        return driver;
    }


    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    //Helping methods
    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickById(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    public void clickByName(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys("value",Keys.ENTER);
    }
    public void keysInput(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public void typeByCssThenEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.CLEAR, value, Keys.ENTER);
    }

    public void clearInput(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }

    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();

        return st;
    }

    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();

        return st;
    }

    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();

    }

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();

        return st;
    }

    public WebElement getWebElementByCss(String locator) {
        return driver.findElement(By.cssSelector(locator));

    }

    public List<WebElement> getWebElementsByCss(String locator) {
        List<WebElement> elementList = new ArrayList<WebElement>();
        elementList = driver.findElements(By.cssSelector(locator));

        return elementList;
    }

    public WebElement getWebElementByXpath(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));

        return element;
    }

    //constant sleep time
    public void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
    }

    //Synchronization
    public void waitUntilClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    //get WebElements
    public List<WebElement> getWebElements(String locator) {
        List<WebElement> elements = driver.findElements(By.cssSelector(locator));
        return elements;
    }

    //get texts
    public List<String> getElementTexts(String locator) {
        List<String> texts = new ArrayList<String>();
        List<WebElement> element = new ArrayList<WebElement>();
        element = getWebElements(locator);
        for (WebElement st : element) {
            texts.add(st.getText());
        }
        return texts;
    }

    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }

    //handling Alert
    public void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //iFrame Handle
    public void iframeHandle(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void goBackToHomeWindow() {
        driver.switchTo().defaultContent();
    }

    //get Links
    public void getLinks(String locator) {
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    //Taking Screen shots
    public void takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenShots.png"));
    }

    //upload a file/image
    public void upLoad(String locator, String filePath) {
        WebElement element = driver.findElement(By.cssSelector(locator));
        element.sendKeys(filePath);
    }
}