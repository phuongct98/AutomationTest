import org.testng.Assert;
import org.testng.annotations.*;

public class TestClass {

    @BeforeClass
    @AfterClass
    @BeforeGroups
    @BeforeSuite
    @BeforeMethod
    public void Setup(){
        System.out.println("Hello Em la  Before Method Phuongct");
    }
    @AfterMethod
    public void CleanUp(){
        System.out.println("Hello Chong em la After Method NamNH");
    }

    @Test
    public void Run(){
    System.out.println("Hello Em la Phuongct");
        Assert.assertEquals(1, 2, "1 not equals 2");
        Assert.assertNotEquals("a", "A"); //pass khi giá trị thực tế và mong đợi k bằng nhau có thể truyền giá trị khác nhau
        Assert.assertTrue(true); //pass khi biểu thức truyền vào là true
        Assert
    }
    public int TinhTong(int a, int b)
    {
        return a + b;
    }
    @Test
    public void Run2(){
        System.out.println("Hello Chong em la NamNH");
    }

}
