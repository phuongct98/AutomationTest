import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestClass {
    ChromeDriver chromeDriver;  // Đặt biến ChromeDriver là biến toàn cục để sử dụng trong tất cả các phương thức

//    @BeforeClass
//    @AfterClass
//    @BeforeGroups
//    @BeforeSuite
    @BeforeMethod // set up DB cbi trước khi chạy
    // Before khởi tạo ra trình duyejtr chrome
    public void Setup(){
        System.out.println("Hello Em la  Before Method Phuongct");
        WebDriverManager.chromedriver().setup(); //tự động ktra chrome là version bao nhiêu sau đó tự tải về
//        WebDriverManager.firefoxdriver().setup();
        chromeDriver = new ChromeDriver(); //mở trình duyệt chrome
//        FirefoxDriver firefoxDriver = new FirefoxDriver();
//        firefoxDriver.get("https://www.youtube.com/");
    }

    @Test // sử dụng để viết body testscript
        public void Run(){
    System.out.println("Hello Em la Phuongct");
    //body
        chromeDriver.get("https://www.youtube.com/");
        sleep(5000);//chạy trình duyệt chrome
//        chromeDriver.navigate().refresh(); // refresh lại trình duyệt
//        chromeDriver.navigate().back(); // trở lại
//        chromeDriver.navigate().forward(); // tiến lên trang mới
//        chromeDriver.executeScript() // Thực thi Java
//        chromeDriver.findElement() // tìm phần tử
//        chromeDriver.getPageSource()// lấy toàn bộ html của trang web
//        Assert.assertEquals(1, 2, "1 not equals 2");
//        Assert.assertNotEquals("a", "A"); //pass khi giá trị thực tế và mong đợi k bằng nhau có thể truyền giá trị khác nhau
//        Assert.assertTrue(true); //pass khi biểu thức truyền vào là true

    }

    @AfterMethod // clear data
    public void CleanUp(){
        System.out.println("Hello Chong em la After Method NamNH");
        chromeDriver.quit();
    }
    // Nghỉ một khoảng time nhất định nào đó vì trong quá trình thực hiện chạy code câu 1 nhanh thì nghỉ để xem thao tác như nào mới chạy code câu 2
    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
        }
    }
//    public int TinhTong(int a, int b)
//    {
//        return a + b;
//    }
//    @Test
//    public void Run2(){
//        System.out.println("Hello Chong em la NamNH");
//    }

}
