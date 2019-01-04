package search;

import base.CommonAPI;

public class SearchPage extends CommonAPI {

    public void searchMenu(){
        typeOnElementNEnter("#gh-ac","book");
        navigateBack();
        typeOnElementNEnter("#gh-ac","cow");
        navigateBack();
        typeOnElementNEnter("#gh-ac","dog");
        navigateBack();
        typeOnElementNEnter("#gh-ac","monkey");
    }
    public void signIn () {
        clickCSS("#gh-ug > a");
        typeCSS("#userid","hasib123");
        typeOnCss("#pass","abcd1234");
    }
    public void toys () {
        clickCSS("#mainContent > div.hl-cat-nav > ul > li:nth-child(9) > a");
        navigateBack();
        clickCSS("#mainContent > div.hl-cat-nav > ul > li:nth-child(9) > a");
        navigateBack();
    }

}
