import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SAInvoice {
    ChromeDriver chromeDriver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Downloads\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
    }
    @Test
    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
        }
    }
    @Test // sử dụng để viết body testscript
    public void Run(){
        String user1 = "quynhln";
        String pass1 = "123456";
        chromeDriver.get("https://app.easybooks.vn/#/");
        sleep(1000);
        WebElement user = chromeDriver.findElement(By.id("username"));
        user.sendKeys(user1);
        WebElement pass = chromeDriver.findElement(By.id("password"));
        pass.sendKeys(pass1);
        WebElement Dangnhap = chromeDriver.findElement(By.className("login-button"));
        Dangnhap.click();
        sleep(1000);
        WebElement Dangnhap1 = chromeDriver.findElement(By.className("login-button"));
        Dangnhap1.click();
        sleep(3000);
        WebElement Banhang = chromeDriver.findElement(By.xpath("/html/body/eb-main/div/app-sidebar/div[1]/div/app-sidebar-menu/perfect-scrollbar/div/div[1]/div[1]/ul/li[3]/a/span[1]/span[1]"));
        Banhang.click();
        WebElement Chungtubanhang = chromeDriver.findElement(By.xpath("/html/body/eb-main/div/app-sidebar/div[1]/div/app-sidebar-menu/perfect-scrollbar/div/div[1]/div[1]/ul/li[3]/div/ul/li[3]/a/span"));
        Chungtubanhang.click();
        sleep(1000);
        List<WebElement> Them = chromeDriver.findElements(By.className("button-navigation"));
        for(int i =0;i<Them.size();i++){
            try{
                WebElement element = Them.get(i).findElement(By.tagName("span"));
                if(element.getText().equals("Thêm")){
                    Them.get(i).click();
                }
            }catch(Exception e){

            }
        }
    }
}
