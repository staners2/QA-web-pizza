package ru.pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    String nameSyte = "https://пиццуля42.рф";
    private WebDriver driver;

    By linkCloseModalWindow = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/a");
    By linkBlockSet = By.xpath("//*[@id=\'appContainer\']/div/div[3]/div[2]/div/div[3]/div[2]/span[1]/a/span/span[3]/span[2]/span");
    By divSetsBlock = By.xpath("//*[@id=\'appContainer\']/div/div[3]/div[2]/div/div[3]");
    By linkSetInMenu = By.xpath("//*[@id=\"appContainer\"]/div/div[3]/div[1]/div/div/div/div/a[3]");
    By textTitleSet = By.xpath("//*[@id=\'appContainer\']/div/div[3]/div[2]/div/div[3]/div[2]/span[1]/a/span/span[2]/span[1]");
    By textSubtitleSet = By.xpath("//*[@id=\'appContainer\']/div/div[3]/div[2]/div/div[3]/div[2]/span[1]/a/span/span[2]/span[2]");

    public MainPage(WebDriver driver){
        driver.get(nameSyte);
        this.driver = driver;
    }

    public MainPage closeModalWindow(){
        driver.findElement(linkCloseModalWindow).click();
        return this;
    }

    public FiftyOnFiftyPage openFiftyOnFiftySet(){
        driver.findElement(linkBlockSet).click();
        return new FiftyOnFiftyPage(driver);
    }

    public String getTitleSyte(){
        return driver.getTitle();
    }

    public boolean menuIsHaveSet(){
        return driver.findElement(linkSetInMenu).getText().contains("Наборы");
    }

    // TODO Переделать
    public boolean menuIsHaveSetsBlock(){
        return driver.findElement(divSetsBlock) != null;
    }

    public String getTitleSet(){
        return driver.findElement(textTitleSet).getText();
    }

    public String getSubtitleSet(){
        return driver.findElement(textSubtitleSet).getText();
    }
}
