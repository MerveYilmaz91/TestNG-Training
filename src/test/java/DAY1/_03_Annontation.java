package DAY1;

import org.testng.annotations.*;

public class _03_Annontation {

    @BeforeClass
    public void beforeClass(){ System.out.println("Before Class çalıştı");}

    @Test
    public void test1(){System.out.println("Test 1 çalıştı");}

    @Test
    public void test2(){System.out.println("Test 2 çalıştı");}

    @AfterClass
    public void afterClass(){System.out.println("After Class çalıştı");}

    @Test
    public void test3(){System.out.println("Test 3 çalıştı");}

    @Test
    public void test4(){System.out.println("Test 4 çalıştı");}

    @Test
    public void test5(){System.out.println("Test 5 çalıştı");}

    @BeforeMethod
    public void beforeMethod(){System.out.println("Before method çalıştı");}

    @AfterMethod
    public void afterMethod(){System.out.println("After method çalıştı");}

    @BeforeTest
    public void beforeTest(){System.out.println("Before Test Çalıştı");}

    @AfterTest
    public void afterTest(){System.out.println("After Test Çalıştı");}

    @BeforeSuite
    public void beforeSuit(){System.out.println("Before Suit Çalıştı");}

    @AfterSuite
    public void afterSuit(){System.out.println("After Suit Çalıştı");}

    @BeforeGroups
    public void beforeGroups(){System.out.println("Before Group Çalıştı");}

    @AfterGroups
    public void afterGroups(){System.out.println("After Group Çalıştı");}
}


