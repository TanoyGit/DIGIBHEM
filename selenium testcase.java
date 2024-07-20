import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SeleniumTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.digitalbhem.com");

        driver.manage().window().maximize();

        List<TestResult> testResults = new ArrayList<>();
        
        class TestResult {
            String description;
            String result;

            TestResult(String description, String result) {
                this.description = description;
                this.result = result;
            }
        }

        try {
            WebElement logo = driver.findElement(By.cssSelector("img[src*='logo']"));
            testResults.add(new TestResult("Logo exists", "Passed"));
        } catch (Exception e) {
            testResults.add(new TestResult("Logo exists", "Failed"));
        }

        try {
            WebElement navBar = driver.findElement(By.cssSelector("nav"));
            testResults.add(new TestResult("Navigation bar exists", "Passed"));
        } catch (Exception e) {
            testResults.add(new TestResult("Navigation bar exists", "Failed"));
        }

        try {
            WebElement aboutUsLink = driver.findElement(By.linkText("About Us"));
            aboutUsLink.click();
            testResults.add(new TestResult("'About Us' link works", "Passed"));
        } catch (Exception e) {
            testResults.add(new TestResult("'About Us' link works", "Failed"));
        }

        try {
            WebElement aboutUsName = driver.findElement(By.xpath("//h1[contains(text(), 'Digital Bhem')]"));
            testResults.add(new TestResult("Name on 'About Us' page is correct", "Passed"));
        } catch (Exception e) {
            testResults.add(new TestResult("Name on 'About Us' page is correct", "Failed"));
        }

        // Navigate back to the home page
        driver.navigate().back();

        try {
            WebElement contactLink = driver.findElement(By.linkText("Contact"));
            contactLink.click();
            WebElement contactForm = driver.findElement(By.cssSelector("form"));
            testResults.add(new TestResult("Contact form exists", "Passed"));
        } catch (Exception e) {
            testResults.add(new TestResult("Contact form exists", "Failed"));
        }

        try {
            WebElement footer = driver.findElement(By.cssSelector("footer"));
            testResults.add(new TestResult("Footer exists", "Passed"));
        } catch (Exception e) {
            testResults.add(new TestResult("Footer exists", "Failed"));
        }

        try {
            WebElement searchBar = driver.findElement(By.cssSelector("input[type='search']"));
            searchBar.sendKeys("test");
            searchBar.submit();
            testResults.add(new TestResult("Search bar exists and is functional", "Passed"));
        } catch (Exception e) {
            testResults.add(new TestResult("Search bar exists and is functional", "Failed"));
        }

        try {
            WebElement servicesLink = driver.findElement(By.linkText("Services"));
            servicesLink.click();
            testResults.add(new TestResult("'Services' link works", "Passed"));
        } catch (Exception e) {
            testResults.add(new TestResult("'Services' link works", "Failed"));
        }

        try {
            WebElement serviceItem = driver.findElement(By.xpath("//h2[contains(text(), 'Our Services')]"));
            testResults.add(new TestResult("Specific service item exists on 'Services' page", "Passed"));
        } catch (Exception e) {
            testResults.add(new TestResult("Specific service item exists on 'Services' page", "Failed"));
        }

        driver.navigate().back();

        try {
            WebElement blogSection = driver.findElement(By.cssSelector("section.blog"));
            testResults.add(new TestResult("Blog section exists", "Passed"));
        } catch (Exception e) {
            testResults.add(new TestResult("Blog section exists", "Failed"));
        }

        driver.quit();

        for (TestResult result : testResults) {
            System.out.println(result.description + ": " + result.result);
        }
    }
}
