package com.mindtree.rems3;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class rems3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href='/hovers']")).click();
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@alt='User Avatar']"))).build().perform();
		String disp1=driver.findElement(By.xpath("//div[@class='figcaption']/h5")).getText();
		System.out.println(disp1);
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/checkboxes']")).click();
		
		driver.findElement(By.xpath("//input[@type='checkbox'][2]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement checkbox1= driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		boolean select1=checkbox1.isEnabled();
		if(select1==true) {
			checkbox1.click();
		}
		WebElement checkbox2= driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		boolean select2=checkbox2.isEnabled();
		if(select1==true) {
			checkbox2.click();
		}
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/inputs']")).click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1234");
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/dropdown']")).click();
		driver.findElement(By.xpath("//select[@id='dropdown']//option[@value='2']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/upload']")).click();
		WebElement upload= driver.findElement(By.xpath("//input[@id='file-upload']"));
		upload.sendKeys("C:\\Users\\mindc1may144\\dummytext.txt");
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/tables']")).click();
		int count=driver.findElements(By.xpath("//tbody//tr//td")).size();
		//System.out.println(count);
		for(int i=0; i<count;i++) {
			String name=driver.findElements(By.xpath("//tbody//tr//td")).get(i).getText();
			if(name.equalsIgnoreCase("Tim")) {
				System.out.println(driver.findElement(By.xpath("//td[3]")).getText());
				System.out.println(driver.findElement(By.xpath("//td[5]")).getText());
				break;
			}
		}
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/key_presses']")).click();
		driver.findElement(By.xpath("//input[@id='target']")).sendKeys(Keys.ARROW_DOWN);
		String keydisp=driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(keydisp);
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> newpage=ids.iterator();
		String parenttab=newpage.next();
		String childtab=newpage.next();
		driver.switchTo().window(childtab);
		String text=driver.findElement(By.xpath("//h3")).getText();
		System.out.println(text);
		driver.switchTo().window(parenttab);
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/context_menu']")).click();
		a.moveToElement(driver.findElement(By.xpath("//div[@id='hot-spot']"))).contextClick().build().perform();
		driver.switchTo().alert().accept();
		
		
		
		
	}

}
