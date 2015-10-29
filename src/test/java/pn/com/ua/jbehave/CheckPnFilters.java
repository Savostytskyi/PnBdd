package pn.com.ua.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pn.com.ua.steps.FiltersSteps;

/**
 * @author Anton_Savostytskyi on 10/29/2015.
 */
public class CheckPnFilters {

  @Steps
  FiltersSteps filtersSteps;

  @Given("site pn.com.ua opened")
  public void givenSitePncomuaOpened() {
    filtersSteps.openPnHomePage();
  }

  @When("I select category $category")
  public void whenISelectSomeCategory(String category) {
    filtersSteps.selectCategory(category);
  }

  @When("I select subcategory $subcategory")
  public void whenISelectSomeSubcategory(String subcategory) {
    filtersSteps.selectSubCategory(subcategory);
  }

  @When("I select minimal price $price")
  public void whenISelectMinimalPrice(String price) {
    filtersSteps.selectMaximalPriceFilter(price);
  }

  @When("I select maximal price $price")
  public void whenISelectMaximalPrice(String price) {
    filtersSteps.selectMaximalPriceFilter(price);
  }

  @Then("search result prices is between $minPrice and $maxPrice")
  public void thenICanSeeGoodsCorrespondingToSelectedParameters(int minPrice, int maxPrice) {
    filtersSteps.checkPriceFilterResult(minPrice, maxPrice);
  }

  @When("I select manufacturer $manufacturer")
  public void whenISelectManufacturer(String manufacturer) {
    filtersSteps.selectManufacturer(manufacturer);
  }

  @Then("search result amount is equal to number beside manufacturer")
  public void thenSearchResultAmountIsEqualToNumberBesideManufacturer() {
    filtersSteps.checkProductCount();
  }

  @Then("search result names start with selected manufacturer $manufacturer")
  public void thenSearchResultNamesStartWithSelectedManufacturerName(String manufacturer) {
    filtersSteps.checkProductNames(manufacturer);
  }

  @When("I sort products by price")
  public void whenISortProductByPrice() {
    filtersSteps.sortByPrice();
  }

  @When("I choose the first product in result")
  public void whenIChooseTheFirstProductInResult() {
    filtersSteps.getFirstResult();
  }

  @When("I type product name to search")
  public void whenITypeProductNameToSearch() {
    filtersSteps.searchProduct();
  }

  @Then("search result amount equals to 1")
  public void thenSearchResultAmountEqualsTo1() {
    filtersSteps.checkProductCount();
  }

  @Then("search result name is equal to product name")
  public void thenSearchResultNameIsEqualToProductName() {
    filtersSteps.verifyFirstProductName();
  }
}
