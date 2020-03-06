package page_obj;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Helpers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ResultsPage extends DriverManager {

    @FindBy(css = ".findability-facet__rating-label")
    private List<WebElement> ratingWebElements;
    @FindBy(css = "div[data-test='component-ratings']")
    private List<WebElement> ratingStars;
    @FindBy(css = ".findability-facet__filter-text")
    private List<WebElement> categoryWebelements;
    @FindBy(css = ".search-title")
    private WebElement categoryTitle;
    @FindBy(css = "label[name='brands']")
    private List<WebElement> brandWebelements;
    @FindBy(css = "a[data-test='component-product-card-title']")
    private List<WebElement> productTitles;
    @FindBy(css = "label[name='price']")
    private List<WebElement> priceWebElements;
    @FindBy(css = ".ProductCardstyles__PriceContainer-l8f8q8-13.lcxskn")
    private List<WebElement> individualPrice;
    @FindBy(css="button[data-test='component-att-button']")
    private List<WebElement>productsWebElements;
    @FindBy(css="a[data-test='component-att-button-basket']")
    private WebElement goToTrolleyWebElement;

    Helpers helpers=new Helpers();
    public void selectFilter(String filterOption) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".findability-facet__rating-label"),5));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".findability-facet__rating-label"), 5));
        for (WebElement review : ratingWebElements) {
            String availableFilter = review.getText();
            if (availableFilter.equalsIgnoreCase(filterOption)) {
                review.click();
                break;
            }
        }
    }

    public List<Double> getProductRating() {

        List<Double> ratingList = new ArrayList<>();
        sleep(5000);
        for (WebElement rating : ratingStars) {
            String ratingInString = rating.getAttribute("data-star-rating");
            double ratingInDouble = Double.parseDouble(ratingInString);
            ratingList.add(ratingInDouble);
        }
        return ratingList;
    }

    public void selectFilterCategory(String selectCategoryOption) {
        sleep(5000);
        for (WebElement category : categoryWebelements) {
            String availableCategory = category.getText();
            if (availableCategory.equalsIgnoreCase(selectCategoryOption)) {
                category.click();
                break;
            }
        }
    }

    public String getTitleOfCategoryPage() {
        sleep(5000);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        return pageTitle;
    }

    public void selectFilterBrand(String selectFilterBrand) {

        sleep(5000);
        //new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfAllElements((List<WebElement>) By.cssSelector("label[name='brands']")));
        for (WebElement brands : brandWebelements) {
            String selectedBrand = brands.getAttribute("value");
            System.out.println(selectedBrand);
            if (selectedBrand.equalsIgnoreCase(selectFilterBrand)) {
                brands.click();
                break;
            }

        }

    }

    public List<String> getAllProductsOfABrand() {
        sleep(5000);
        List<String> productNames = new ArrayList<>();
        for (WebElement productsWithBrand : productTitles) {
            String productTitlesInString = productsWithBrand.getText();
            productNames.add(productTitlesInString);
        }
        return productNames;
    }

    public void filterPrice(String selectedPrice) {
        sleep(5000);
        for (WebElement prices : priceWebElements) {
            String price = prices.getAttribute("value");
            System.out.println(price);
            if (price.equalsIgnoreCase(selectedPrice)) {
                prices.click();
                break;
            }
        }

    }

    public List<Double> getProductsByFilterPrice() {
        sleep(5000);
        List<Double> indPrice = new ArrayList<>();
        for (WebElement indProductPrice : individualPrice) {
            String priceListInString = indProductPrice.getText();
            priceListInString=priceListInString.replaceFirst("[£]","");
            double priceListInDouble=Double.parseDouble(priceListInString);
            indPrice.add(priceListInDouble);
        }
        return indPrice;
    }
    public void selectARandomProduct(){
        sleep(5000);
        List<WebElement>randomProducts=isProductsAvailable();
        int productSize=randomProducts.size();
        int randomNumber=helpers.randomNumberGenerator(productSize);
        WebElement anyRandomProduct=productsWebElements.get(randomNumber);
        //String selectedProduct=anyRandomProduct.getText();
        anyRandomProduct.click();
        //return selectedProduct;


    }
    public List<WebElement> isProductsAvailable(){
    if(priceWebElements.size()==0){
     throw new RuntimeException("zero products found");
    }
    return productsWebElements;
    }

    public void goToTrolley(){
        goToTrolleyWebElement.click();
    }

}




