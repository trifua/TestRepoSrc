package testproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void Test1(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.imobiliare.ro/vanzare-apartamente/timisoara?id=6923228");
        List<WebElement> listaPret = driver.findElements(By.className("pret-mare"));

        for (WebElement preturi:listaPret){
            System.out.print(preturi.getText()+ " ");

        }

        for (int i = 0; i < listaPret.size(); i++){
            double price = Double.parseDouble(listaPret.get(i).getText());
            assertThat(price).isBetween(50.000,80.000);

        }

        driver.close();
        driver.quit();
    }
}