package DAY2;

import Utility.BaseDriver;
import org.testng.annotations.Test;

public class _01_GroupsIntellijVersion extends BaseDriver {


    /*Groups: testlerini etiketlememe ve gruplandırmama yarar.
    birden fazla test tanımlanacaksa süslü paranteze alıyoruz

     */

    @Test(groups={"smoke", "regression"})
    public void test1 () {
        System.out.println("test1 çalıştı");
    }
    @Test(groups = {"smoke", "regression"})
    public void test2(){
        System.out.println("test2 çalıştı");
    }
    @Test
    public void test3(){
        System.out.println("test3 çalıştı");
    }
    @Test(groups = "regression")
    public void test4() {
        System.out.println("test4 çalıştı");
    }
    @Test(groups = "regression")
    public void test5() {
        System.out.println("test5 çalıştı");


    }


}
