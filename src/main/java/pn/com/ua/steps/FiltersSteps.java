package pn.com.ua.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import pn.com.ua.pages.PnGoodsPage;
import pn.com.ua.pages.PnHomePage;

/**
 * @author Anton_Savostytskyi on 10/29/2015.
 */
public class FiltersSteps extends ScenarioSteps {

  PnHomePage pnHomePage;
  PnGoodsPage pnGoodsPage;
  int productCount;
  String productName;

  @Step
  public void openPnHomePage() {
    pnHomePage.open();
  }

  @Step
  public void selectCategory(String categoryName) {
    pnHomePage.selectCategory(categoryName);
  }

  @Step
  public void selectSubCategory(String subCategoryName) {
    pnHomePage.selectSubCategory(subCategoryName);
  }

  @Step
  public void selectMinimalPriceFilter(String price) {
    pnGoodsPage.selectMinimumPrice(price);
  }

  @Step
  public void selectMaximalPriceFilter(String price) {
    pnGoodsPage.selectMaximumPrice(price);
  }

  @Step
  public void checkPriceFilterResult(Integer min, Integer max) {
    List<Integer> prices = pnGoodsPage.getListOfPrices();
    assertThat(prices, everyItem(greaterThan(min)));
    assertThat(prices, everyItem(lessThan(max)));
  }

  @Step
  public void selectManufacturer(String manufacturer) {
    pnGoodsPage.selectFilter(manufacturer);
  }

  @Step
  public void checkProductCount() {
    assertThat(pnGoodsPage.getResultCount(), equalTo(productCount));
  }

  @Step
  public void checkProductNames(String producer) {
    assertThat(pnGoodsPage.getManufacturerFromNames(), everyItem(equalTo(producer)));
  }

  @Step
  public void sortByPrice() {
    pnGoodsPage.sortByPrice();
  }

  @Step
  public void getFirstResult() {
    productName = pnGoodsPage.getFirstResultName();
  }

  @Step
  public void searchProduct() {
    pnHomePage.searchOnHomePage(productName);
  }

  @Step
  public void verifyProductAmount(Integer number) {
    assertThat(pnGoodsPage.getResultCount(), equalTo(number));
  }

  @Step
  public void verifyFirstProductName() {
    assertThat(pnGoodsPage.getFirstResultName(), equalTo(productName));
  }

}
