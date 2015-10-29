package pn.com.ua.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton_Savostytskyi on 10/29/2015.
 */
public class PnGoodsPage extends PageObject {

  public static final String FILTERS = "//div[@class='is_empty_items']//a";
  public static final String FILTER_BY_VALUE = FILTERS + "[text()='%s']";
  public static final String MIN_PRICE = "//a[contains(@href,'fp1=%s')]";
  public static final String MAX_PRICE = "//a[contains(@href,'fp2=%s')]";
  public static final By GOODS_PRICES = By.xpath("//div[@class='price']/strong");
  public static final By RESULT_GOODS_COUNT = By.xpath("//div[@class='total']/b");
  public static final By RESULT_NAMES = By.xpath("//div[@class='name']/a");
  public static final By SORT_BY_PRICE_LINK = By.xpath("//a[contains(@href,'sort=price')]");


  public void selectMinimumPrice(String price){
    find(By.xpath(String.format(MIN_PRICE, price))).click();
  }

  public void selectMaximumPrice(String price){
    find(By.xpath(String.format(MAX_PRICE, price))).click();
  }

  public void selectFilter (String filterValue) {
    waitForPresenceOf(String.format(FILTER_BY_VALUE, filterValue));
    find(By.xpath(String.format(FILTER_BY_VALUE, filterValue))).click();
  }

  public List<Integer> getListOfPrices() {
    List<Integer> values = new ArrayList<Integer>();
    List<WebElementFacade> prices = findAll(GOODS_PRICES);
    for (WebElementFacade price: prices) {
      values.add(Integer.parseInt(price.getText().replaceAll("\\D", "")));
    }
    return values;
  }

  public int getResultCount(){
    return Integer.valueOf(find(RESULT_GOODS_COUNT).getText());
  }

  public List<String> getResultsNames(){
    List<WebElementFacade> elements = findAll(RESULT_NAMES);
    List<String> elementsNames = new ArrayList<String>();
    for(WebElementFacade element: elements){
      elementsNames.add(element.getText());
    }
    return elementsNames;
  }

  public List<String> getManufacturerFromNames(){
    List<String> names = getResultsNames();
    List<String> results = new ArrayList<String>();
    for(String name: names){
      results.add(name.split("\\s+")[0]);
    }
    return results;
  }

  public void sortByPrice(){
    find(SORT_BY_PRICE_LINK).click();
  }

  public String getFirstResultName(){
    return findAll(RESULT_NAMES).get(0).getText();
  }

}
