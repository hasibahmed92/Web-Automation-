package search;

import base.CommonAPI;

public class SearchPage extends CommonAPI {

    public void searchMenu(){
        typeOnElementNEnter("#global-search-input", "water");
        navigateBack();
        typeOnElementNEnter("#global-search-input", "books");
        navigateBack();
    }
    public void choosePasta(){
        typeOnElementNEnter("#global-search-input", "pasta");
        clickCSS("#global-search-input");
        clickCSS("#searchProductResult > ul > li.Grid-col.u-size-6-12.u-size-1-4-m.u-size-1-5-xl.search-gridview-first-col-item.search-gridview-first-grid-row-item > div > div.search-result-gridview-item.clearfix.arrange-fill > div:nth-child(12) > a > span");
        clickCSS("body > div.js-content > div > div.atf-content > div > div.atf-content > div > div:nth-child(2) > div > div > div.Grid > div.Grid > div:nth-child(2) > div:nth-child(1) > div > div > div > div.prod-VariantsSection.hf-BotRow > div > div > div > div.variant-options-container > span:nth-child(2) > div > div.variant-option-inner-container > div.option-overlay");
        clickCSS("body > div.js-content > div > div.atf-content > div > div.atf-content > div > div:nth-child(2) > div > div > div.Grid > div.Grid > div:nth-child(2) > div:nth-child(1) > div > div > div > div.prod-CallToActionSection.hf-BotRow > div > div > div > button > span > span");
        navigateBack();
    }

//    public void createAccount() { //error
//        clickCSS("#BubblesSlidePanel-wrapper > div > nav > div > div");
//        clickCSS("#BubblesSlidePanel-wrapper > div > nav > div > ul > li:nth-child(1) > a > div.GlobalAccountMenu-linkDescription > div");
//        typeCSS("#email", "hg2423@gmail.com");
//        typeOnCss("#password", "abc123");

    public void createAccount () {
        clickCSS(".BubbleButton-hoverLabel");
        clickCSS(".GlobalAccountMenu-linkTitle");
        typeCSS("#email", "hg2423@gmail.com");
        typeOnCss("#password", "abc123");
    }
    public void xbox () {
        typeOnElementNEnter("//*[@id=\"global-search-input\"]", "xbox one");
    }
}
