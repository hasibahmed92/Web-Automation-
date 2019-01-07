package SearchPage;

import base.CommonApi;

public class SearchPage extends CommonApi {
    public void searchMenu(){
        clickByXpath("//a[@class='nav-menu-links__link'][contains(text(),'Business')]");
    }
}
