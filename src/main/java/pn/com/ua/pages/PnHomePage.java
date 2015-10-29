package pn.com.ua.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import java.util.List;


/**
 * @author Anton_Savostytskyi on 10/29/2015.
 */
@DefaultUrl("http://pn.com.ua/")
public class PnHomePage extends PageObject {

  public static final String CATEGORIES = "//a[@class='main_page_link_catalog']";
  public static final String SUB_CATEGORIES = "//div[contains(@class, 'ct ')]/a";
  public static final String SUB_CATEGORIES_BY_TEXT = SUB_CATEGORIES + "[text()='%s']";
  public static final String CATEGORY_BY_TEXT = "//a[text()='%s']";
  public static final String SEARCH_FIELD = "//input[@id='edit-name-1']";
  public static final String SEARCH_BUTTON = "//input[@id='edit-submit-1']";

  @FindBy(xpath = CATEGORIES)
  private List<WebElementFacade> categories;

  @FindBy(xpath = SUB_CATEGORIES)
  private List<WebElementFacade> subcategories;

  public void selectCategory (String categoryName) {
    waitForPresenceOf(String.format(CATEGORY_BY_TEXT, categoryName));
    find(By.xpath(String.format(CATEGORY_BY_TEXT, categoryName))).click();
  }

  public void selectSubCategory (String subCategoryName) {
    waitForPresenceOf(String.format(SUB_CATEGORIES_BY_TEXT, subCategoryName));
    find(By.xpath(String.format(CATEGORY_BY_TEXT, subCategoryName))).click();
  }

  public void searchOnHomePage(String productName) {
    find(By.xpath(SEARCH_FIELD)).sendKeys(productName);
    find(By.xpath(SEARCH_BUTTON)).click();
  }

}
