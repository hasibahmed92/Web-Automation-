import org.testng.annotations.Test;
import search.SearchPage;

public class TestHome extends SearchPage {

    @Test
    public void test1(){
        searchMenu();
    }
    @Test
    public void test2() {
        signIn();
    }
}
