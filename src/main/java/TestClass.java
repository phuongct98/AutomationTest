import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

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
//    System.out.println("Hello Em la Phuongct");
    //body
        chromeDriver.get("https://auto.fresher.dev/lessons/lession7/index.html");
        sleep(1000);//chạy trình duyệt chrome
//        chromeDriver.findElement() trả về 1 web element mà có thể tìm được trả về thẻ đầu tiên tìm thấy
//        chromeDriver.findElements() trả về 1 danh sách các web element mà tìm được
        WebElement button1 = chromeDriver.findElement(By.id("btnExample1"));
        button1.click();
        WebElement lbStatusButton = chromeDriver.findElement(By.id("lbStatusButton"));
        lbStatusButton.getText(); //Hàm gettext hỗ trợ lấy ra các text bên trong thẻ đó trả về kiểu dl string
        String lbStatusButtonValue = lbStatusButton.getText();
        Assert.assertEquals(lbStatusButtonValue, "Click on Button 1");
        WebElement input1 = chromeDriver.findElement(By.id("txtInput1"));
        String inputValue = input1.getAttribute("value");//lấy value của ô input vì có biến value ở html nên mới
        Assert.assertEquals( inputValue, "Default value of input" );
        String newValue = "ABC";
        input1.clear();
        input1.sendKeys(newValue);
        String newInput3 = "ABC123.11%%%";
        String expect = "123.11";
        WebElement input3 = chromeDriver.findElement(By.id("txtInput3"));
        sendText(input3, newInput3);
        sleep(100);
        String actual = getValue(input3);
        Assert.assertEquals(actual, expect);
        WebElement select1 = chromeDriver.findElement(By.id("exampleSelect1"));
        Select select = new Select(select1);
        select.selectByVisibleText("Option 4"); //Truyền vào cái Text của option mà chúng ta mong muốn
//        select.selectByValue(""); //truyền value vào
//        select.selectByIndex(1);// đếm vị trí của option đếm từ số 0
        WebElement selectOption = select.getFirstSelectedOption(); // trả về webelement lấy đc weblement của option mà select sau đó lấy value
        String value = getValue(selectOption);
        String text = getText(selectOption);
        System.out.println(value);
        System.out.println(text);

        WebElement check = chromeDriver.findElement(By.id("defaultCheck3"));
        boolean isChecked = check.isSelected(); //isSelected trạng thái của checkbox là đang đc check hay k đc check
        System.out.println(isChecked);


//        by.name thường sử dụng ô textbox để nhập liệu hay là selectbox
//          List<WebElement> button = chromeDriver.findElements(By.className("btn-success"));
////          for (int i = 0; i < buttons.size(); i ++)
////        {
////            buttons.get(i).click();
////            sleep(3000);
////        }
//        button1.sendKeys(); //nhập
//        button1.click ( ) ;// click trái
//        button1.clear ( ) ;// xóa giá trị đang có ở ô textbox
//        button1.submit ( ) ; //trỏ vào đối tượng form đồng ý form đó
//        Actions action = new Actions(chromeDriver);

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

    public String getValue ( WebElement element){
        return element.getAttribute("value");
    }
    public String getText (WebElement element){
        return element.getText();
    }
    public void sendText ( WebElement element, String input){
        element.clear();
        sleep(100);
        element.sendKeys(input);
        sleep(100);
    }

    @AfterMethod // clear data
    public void CleanUp(){
        System.out.println("Hello Chong em la After Method NamNH");
//        chromeDriver.quit();
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
