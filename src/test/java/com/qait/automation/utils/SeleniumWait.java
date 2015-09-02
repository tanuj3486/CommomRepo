package com.qait.automation.utils;

import static com.qait.automation.utils.DataReadWrite.getProperty;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class SeleniumWait{
    
    WebDriver driver;
    WebDriverWait wait;
    
    public int timeout;
    
    public SeleniumWait(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Returns webElement found by the locator if element is visible
     *
     * @param locator
     * @return
     */
    public WebElement getWhenVisible(By locator) {
        WebElement element;
        element = wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator));
        return element;
    }
    
    public WebElement getWhenClickable(By locator) {
        WebElement element;
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }
    
    public boolean waitForPageTitleToBeExact(String expectedPagetitle) {
        return wait.until(ExpectedConditions.titleIs(expectedPagetitle));
    }
    
    public boolean waitForPageTitleToContain(String expectedPagetitle) {
        return wait.until(ExpectedConditions.titleContains(expectedPagetitle));
    }
    
    public WebElement waitForElementToBeVisible(WebElement element) {
    	return wait.until(ExpectedConditions.visibilityOf(element));

    }
    
    public void waitForFrameToBeAvailableAndSwitchToIt(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    
    public List<WebElement> waitForElementsToBeVisible(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    
    public boolean waitForElementToBeInVisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void clickWhenReady(By locator) {
        WebElement element = wait.until(ExpectedConditions
                .elementToBeClickable(locator));
        element.click();
    }
    
    
    public void resetImplicitTimeout(int newTimeOut) {
        try {
            driver.manage().timeouts().implicitlyWait(newTimeOut, TimeUnit.SECONDS);
        } catch (Exception e) {	
        }
    }

    // TODO Implement Wait for page load for page synchronisations
    public void waitForPageToLoadCompletely() {
    	hardWait(1);         
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("*")));
    }

    public void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    @FindBy(xpath = ".//div[@id='lightwindow_loading']/img")
    WebElement loaderProcesssing;
    
    public void waitForLoaderToDisappear() {
        int i = 0;
        resetImplicitTimeout(5);
        try {
            while (loaderProcesssing.isDisplayed() && i <= timeout) {
                hardWait(1);                
                i++;
            }
        } catch (Exception e) {	
        }
        if(i>Integer.parseInt(getProperty("Config.properties", "timeout"))){
    		Assert.fail("Assertion Failed : Loader does't disappear with in specific time interval "+timeout+" seconds");
    	}
        resetImplicitTimeout(timeout);        
    }
    
    public void waitForLoaderToAppearAndDisappear() {
    	resetImplicitTimeout(1);
        try {
            driver.findElements(By.xpath("//div[@class='pageContainer']//div[@class='blockUI blockMsg blockElement']")).get(0).isDisplayed();
        } catch (Exception e) {
        	resetImplicitTimeout(timeout);
            return;
        }

        int k = 200, j=0;
        int size = 10;
        
        try{
        for (j = 1; j < k; j++) {
            size = driver.findElements(By.xpath("//div[@class='pageContainer']//div[@class='blockUI blockMsg blockElement']")).size();
            if (size == 0) {
                break;
            } else {
                hardWait(1);
                continue;
            }
        }}
        catch(Exception e) {
        	System.out.println("Loader disappeared in "+j+" secs");
        }
        Assert.assertTrue(j<200,"Loader does not disappear in 200 secs");
        Reporter.log("Loader disappeared in "+j+" secs", true);
        resetImplicitTimeout(timeout);
    }
    
    public void resetExplicitTimeout(int newTimeout){
   	 wait = new WebDriverWait(driver, newTimeout);
   }
    
    @FindBy(xpath = "//div[@id='courseTable_processing' and @style='visibility: visible;']")
    WebElement processingMessage;
    
    /**
     * Wait untill loader with Message 'processing'
     */
    public void waitForProcessingMessageToDisappear() {
        int i = 0;
        resetImplicitTimeout(5);
        try {
        	//WebElement processingMessage = driver.findElement(By.xpath("//div[@id='courseTable_processing' and @style='visibility: visible;']"));
            while (processingMessage.isDisplayed() && i <= timeout) {
                hardWait(1);                
                i++;
            }
        } catch (Exception e) {
        }
        if(i>Integer.parseInt(getProperty("Config.properties", "timeout"))){
    		Assert.fail("Assertion Failed : Processing message does not disappear in specific time interval : - "+ timeout+" seconds");
    	}
        resetImplicitTimeout(timeout);        
    }
    
  //div[@id='modalContainer' and @style='display: block']
    
    @FindBy(xpath = "//div[@id='modalContainer']//h1")
    WebElement loadingBlock;//=driver.findElement(By.xpath("//div[@id='modalContainer' and @style='display: block']"));
    
    /**
     * Wait untill loadin block with Message 'Please wait'
     */
    public void waitForLoadingBlockToDisappear() {
        int i = 0;
        hardWait(3);
        resetImplicitTimeout(5);
        try {
            while (loadingBlock.isDisplayed() && i <= this.timeout) {
                hardWait(1);                
                i++;
                System.out.println("waiting for loading block to disappear..."+i+",");
            }
        } catch (Exception e) {	
        }
        resetImplicitTimeout(timeout);        
    }
    
    public int getTimeout() {
    	return timeout;
    }
}
