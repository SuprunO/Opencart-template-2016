package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technical.BasePage;

/**
 * Created by alex on 21.02.2017.
 */
public class CategoriesPage extends BasePage {

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }
     private String CATEGORY1_1_LINK=".col-sm-3.col-xs-6:first-child>a>img";
    private String PRODUCT_1LINK = ".image.col-sm-3>a>img";

    public WebElement click_On_Category1(){
        return driver.findElement(By.linkText("Clothing Sets"));
    }

    public  void  ClickOnProduct1(){
        clickOn(PRODUCT_1LINK);
    }


    // TODO: 21.02.2017 Как организовать последовательное выполнение тестов? Тоесть сначала мы регистрируем нового пользователя, далее покупаем товар, далее проходим чекаут и потом заполняем карту
    // TODO: 21.02.2017 Написать проверку на битые ссылки / картинки
    // TODO: 21.02.2017 Как распределить по папкам функциаональное / УИ тестирование
    // TODO: 21.02.2017 Как найти в тексте определенную цифру / слово?
    // TODO: 21.02.2017 Аннотации для Allure
    // TODO: 21.02.2017 Организация проверок большого количества страниц
    // TODO: 21.02.2017 Тестирование верстки (основы)

}
