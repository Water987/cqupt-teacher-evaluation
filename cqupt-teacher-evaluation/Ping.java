package com;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import com.sun.org.apache.bcel.internal.generic.Select;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.WebDriverWait;



public class Ping {

	


	
	public static void test(WebDriver driver) throws InterruptedException {
		
		
		// �˺�
		String counter = "�˺�";
		// ����
		String password = "����";
		System.out.println("����10s ��������֤�� �������¼");
		driver.manage().window().maximize();
		driver.get("http://gs.cqupt.edu.cn/Gstudent/Default.aspx");
		WebDriver login =  driver.switchTo().frame("PageFrame");
		login.findElement(By.id("ctl00_contentParent_UserName")).sendKeys(counter);
		login.findElement(By.id("ctl00_contentParent_PassWord")).sendKeys(password);
		
//		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(
//				By.cssSelector(""))
//				                );
		Thread.sleep(8000);
		driver.navigate().refresh();
		
		//ѡ������
		driver.switchTo().frame("topmenuFrame");
		driver.findElement(By.cssSelector("#DataList1_ctl03_hykMenu")).click();
		Thread.sleep(1000);
		// ѡ������
		Actions action = new Actions(driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("MenuFrame");
		Thread.sleep(1000);
		//���������Ϣ
		WebElement pingjiao =  driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div[2]/a"));
		action.moveToElement(pingjiao);
		pingjiao.click();
		//�������
		WebElement pingjia = driver.findElement(By.cssSelector("#tree2_2_a"));
		driver.get(pingjia.getAttribute("href")+"&msg=1");
		
		List<WebElement> table = driver.findElements(By.cssSelector("#ctl00_contentParent_dgData > tbody tr"));
		
		//�������е���Ŀ
		for(int i=1;i<table.size();i++) {
			List<WebElement> tatd = table.get(i).findElements(By.cssSelector("td"));
//			tatd.get(tatd.size()-3).getText();
//			System.out.print(tatd.get(tatd.size()-3).getText());
			if(tatd.get(tatd.size()-3).getText().compareTo("δ��")==0) {
				tatd.get(tatd.size()-1).findElement(By.cssSelector("a")).click();
				driver.switchTo().frame("pjEdit");
				List<WebElement> xiang = driver.findElements(By.cssSelector("#ctl00_contentParent_dgData > tbody  tr"));
				for(int j=1;j<xiang.size();j++) {
					WebElement element = xiang.get(j);
					Select select = new Select( element.findElement(By.tagName("select"))  );
					select.selectByValue("90");
				}
				driver.findElement(By.cssSelector("#lnkSave")).click();
				driver.switchTo().defaultContent();
				driver.findElement(By.cssSelector("body > div:nth-child(1) > table > tbody > tr:nth-child(2) > td.ui_c > div > table > tbody > tr:nth-child(1) > td > div > div.ui_title_buttons > a.ui_close")).click();
//				body > div:nth-child(1) > table > tbody > tr:nth-child(2) > td.ui_c > div > table > tbody > tr:nth-child(1) > td > div > div.ui_title_buttons > a.ui_close
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				
				//Thread.sleep(5000);
//				Select select = new Select( driver.findElement(By.cssSelector("#ctl00_contentParent_dgData_ctl02_drpPfdj")));
//				select.selectByValue("90");
				
//				
//				Thread.sleep(10000);
			}
		}
		System.out.println("���̽���");
		
		
		Thread.sleep(10000);
	}

    public static boolean isJudgingElement(WebElement element, By by) {
        try {
            element.findElement(by);
            return true;
        } catch (Exception e) {
            System.out.println("�����ڴ�Ԫ��");
            return false;
        }
    }
	
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		try {
			test(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
		
		
	}
}
