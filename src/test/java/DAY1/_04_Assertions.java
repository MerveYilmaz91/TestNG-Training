package DAY1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Assertions {
    @Test
    public void assertTest() {
        String a = "abc";
        String b = "def";

        /*

        Assert.assertEquals();
        Assert.assertNotEquals();
        Assert.assertNull();

         */
    }
    @Test(priority = 1)
    public void assertEquals1() {
        String a = "abc";
        String b = "def";

        Assert.assertEquals(a, b, "mesajlar birbirine eşit değil.");
        System.out.println("test 1");
    }

    @Test(priority = 2)
    public void assertEquals2() {
        String a = "abc";
        String b = "abc";

        Assert.assertEquals(a, b, "mesajlar birbirine eşit değil.");
        System.out.println("test 2");
    }
    @Test(priority = 3)
    public void assertNotEquals() {
        String a="abc";
        String b="abc";
        Assert.assertEquals(a,b,"mesajlar birbirine eş.");
        System.out.println("test 3");

    }
    @Test(priority = 4)
    public void assertNull() {
        String a = null;
        Assert.assertNull(a);
    }
    @Test(priority = 5)
    public void assertNotNull() {
        String a = null;
        Assert.assertNull(a);
    }
    @Test(priority = 6)
    public void assertFail() {Assert.fail();}
}
