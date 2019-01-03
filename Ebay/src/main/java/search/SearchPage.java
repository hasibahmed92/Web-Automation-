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

}
