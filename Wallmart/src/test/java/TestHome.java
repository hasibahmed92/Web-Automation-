import org.testng.annotations.Test;
import search.SearchPage;

public class TestHome extends SearchPage {

    @Test
    public void test1(){
        searchMenu();
    }
    @Test
    public void test2(){
        choosePasta();
    }
    @Test
    public void test3(){
        createAccount();
    }
    @Test
    public void test4(){
        xbox();
    }
}
