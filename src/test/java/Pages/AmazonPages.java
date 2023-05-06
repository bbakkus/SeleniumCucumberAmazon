package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPages {
    static WebDriver driver;
    static ElementHelper elementHelper;
    WebDriverWait wait;

    //static By accept = By.id("sp-cc-accept");
    static By search = By.id("twotabsearchtextbox");
    static By searchButton = By.id("nav-search-submit-button");
    static By amazonFilter = By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[1]/ul[2]/span[1]");
    static By appleFilter = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/span[1]/li[1]/span[1]/a[1]/span[1]");
    static By firstProduct= By.cssSelector("img[alt='Apple AirPods (2.Nesil) ve Kablolu Şarj Kutusu']");
    static By add = By.id("add-to-cart-button");
    static By back = By.id("attach-close_sideSheet-link");
    static By cart = By.cssSelector("#nav-cart-count");
    static By check = By.cssSelector(".a-truncate-cut");
    public AmazonPages(WebDriver driver){
        this.driver =driver;
        this.wait = new WebDriverWait(driver,10);
        this.elementHelper= new ElementHelper(driver);

    }

    public static void HomePage() {
    }

    public static void acceptCookies() {
        By accept = By.id("sp-cc-accept");
         WebElement acceptButton = driver.findElement(accept);
        if (acceptButton.isEnabled()) {
            elementHelper.click(accept);
        }
    }

    public static void clickSearch() {
        elementHelper.click(search);
    }

    public static void writeProduct() {
        elementHelper.sendKey(search, "airpods");
    }

    public static void searchButton() {
        elementHelper.click(searchButton);
    }

    public static void filterAmazon() {
        elementHelper.click(amazonFilter);
    }

    public static void filterApple() {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,100)", "");

       elementHelper.click(appleFilter);
    }

    public static void firstProduct() {
        elementHelper.click(firstProduct);
    }

    public static void addCart() {
        elementHelper.click(add);
        elementHelper.click(back);
        elementHelper.click(cart);
    }

    public static void checkCart() {
        elementHelper.checkVisible(check);
    }
}
