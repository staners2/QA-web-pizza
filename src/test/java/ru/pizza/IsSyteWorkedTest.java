package ru.pizza;

import com.sun.tools.javac.Main;
import info.esoft.SetFiftyOnFiftyPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IsSyteWorkedTest {

    public WebDriver driver;

    @Before
    public void Up(){
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void Close() {
        driver.quit();
    }

    @DisplayName("Открытие сайта")
    @Test
    public void syteIsWorkedTest(){
        MainPage page = new MainPage(driver);
        Assert.assertTrue(page.getTitleSyte().contains("Доставка пиццы в Кемерово - Пиццуля"));
    }

    @DisplayName("Пункт 'Наборы' присутствует в меню")
    @Test
    public void menuIsHaveSetTest(){
        MainPage page = new MainPage(driver);
        page = page.closeModalWindow();
        Assert.assertTrue(page.menuIsHaveSet());
    }

    @DisplayName("Наборы присутствуют как блок элементов на сайте")
    @Test
    public void menuIsHaveSetsBlockTest(){
        MainPage page = new MainPage(driver);
        page = page.closeModalWindow();
        Assert.assertTrue(page.menuIsHaveSetsBlock());
    }

    @DisplayName("Совпадение информации о товаре при просмотре и приобретении")
    @Test
    public void priceEqualsWhenViewedAndPurchasedTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();
        String titleView = mainPage.getTitleSet();
        String subtitleView = mainPage.getSubtitleSet();

        FiftyOnFiftyPage fiftyPage =  mainPage.openFiftyOnFiftySet();
        String titlePurchase = fiftyPage.getTitleSet();
        String subtitlePurchase = fiftyPage.getSubtitleSet();

        boolean result = titleView.equals(titlePurchase) && subtitleView.equals(subtitlePurchase);
        Assert.assertTrue(result);
    }

    @Test
    @DisplayName("Стадия выбора 'Набора', выбрав только одну пиццу")
    public void addOnePizzaWhenPurchasedSetTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();
        FiftyOnFiftyPage fiftyPage = mainPage.openFiftyOnFiftySet();

        fiftyPage = fiftyPage.addPizzaOne();

        Assert.assertTrue(fiftyPage.buttonBuyIsActive());
    }

    @Test
    @DisplayName("Стадия выбора 'Набора', выбрав только две пиццы")
    public void addTwoPizzaWhenPurchasedSetTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();
        FiftyOnFiftyPage fiftyPage = mainPage.openFiftyOnFiftySet();

        fiftyPage = fiftyPage.addPizzaOne();
        fiftyPage = fiftyPage.addPizzaTwo();

        Assert.assertTrue(fiftyPage.buttonBuyIsActive());
    }

    @Test
    @DisplayName("Стадия выбора 'Набора', выбрав только две пиццы и набор")
    public void addTwoPizzaAndSetWhenPurchasedTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();
        FiftyOnFiftyPage fiftyPage = mainPage.openFiftyOnFiftySet();

        fiftyPage = fiftyPage.addPizzaOne();
        fiftyPage = fiftyPage.addPizzaTwo();
        fiftyPage = fiftyPage.addSet();

        Assert.assertTrue(fiftyPage.buttonBuyIsActive());
    }

    @Test
    public void test(){
        MainPage mainPage = new MainPage(driver);
        mainPage = mainPage.closeModalWindow();
        AuthorizationPage authPage = new AuthorizationPage(driver);
        authPage.authorization();


        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
