package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTest {
	
	protected WebDriver driver1;
	protected WebDriver driver2;
	
	 
	@BeforeClass
	 public static void setupClass() {
		 WebDriverManager.chromedriver().setup();
		 WebApp.start();
	 }
	
	@AfterClass
	public static void teardownClass() {
		WebApp.stop();
	}
 
	@Before
	public void setupTest() {
		driver1 = new ChromeDriver();
		driver2 = new ChromeDriver();
		driver1.get("http://localhost:8080/");
		driver2.get("http://localhost:8080/");
			
		
		WebElement webElementName1 = driver1.findElement(By.id("nickname"));
		webElementName1.sendKeys("Alfonso");
		
		WebElement webElementButtonPlay1 = driver1.findElement(By.id("startBtn"));
		webElementButtonPlay1.click();
		
		WebElement webElementName2 = driver2.findElement(By.id("nickname"));
		webElementName2.sendKeys("Ruben");

		WebElement webElementButtonPlay2 = driver2.findElement(By.id("startBtn"));
		webElementButtonPlay2.click();
	}
	
	@After
	public void teardown() {
		if (driver1 != null) {
		driver1.quit();
		}
		if (driver2 != null) {
			driver2.quit();
		}
	}
	
	@Test
	public void WinXtest () {
		//Given
		WebElement webElement3 = driver1.findElement(By.id("cell-0"));
		webElement3.click();
		WebElement webElement4 = driver2.findElement(By.id("cell-1"));
		webElement4.click();
		WebElement webElement5 = driver1.findElement(By.id("cell-3"));
		webElement5.click();
		WebElement webElement6 = driver2.findElement(By.id("cell-4"));
		webElement6.click();
		WebElement webElement7 = driver1.findElement(By.id("cell-6"));
		webElement7.click();
		WebDriverWait wait1 = new WebDriverWait(driver1, 5);
		WebDriverWait wait2 = new WebDriverWait(driver2, 5);
		
		//When
		String comp = "Alfonso"+" wins! "+"Ruben"+" looses.";
		
		//Then
		String message1 = driver1.switchTo().alert().getText();
		String message2 = driver2.switchTo().alert().getText();
		assertEquals(comp,message1);
		assertEquals(comp,message2);
	}
	
	@Test
	public void WinsOtest() {
		//Given
		WebElement webElement3 = driver1.findElement(By.id("cell-0"));
		webElement3.click();
		WebElement webElement4 = driver2.findElement(By.id("cell-1"));
		webElement4.click();
		WebElement webElement5 = driver1.findElement(By.id("cell-2"));
		webElement5.click();
		WebElement webElement6 = driver2.findElement(By.id("cell-4"));
		webElement6.click();
		WebElement webElement7 = driver1.findElement(By.id("cell-3"));
		webElement7.click();
		WebElement webElement8 = driver2.findElement(By.id("cell-7"));
		webElement8.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver1, 5);
		WebDriverWait wait2 = new WebDriverWait(driver2, 5);
		
		//When
		String comp = "Ruben"+" wins! "+"Alfonso"+" looses.";
		//Then
		String message1 = driver1.switchTo().alert().getText();
		String message2 = driver2.switchTo().alert().getText();
		assertEquals(comp,message1);
		assertEquals(comp,message2);
	}
	
	@Test
	public void checkDrawTest() {
		//Given
		WebElement webElement3 = driver1.findElement(By.id("cell-0"));
		webElement3.click();
		WebElement webElement4 = driver2.findElement(By.id("cell-1"));
		webElement4.click();
		WebElement webElement5 = driver1.findElement(By.id("cell-2"));
		webElement5.click();
		WebElement webElement6 = driver2.findElement(By.id("cell-5"));
		webElement6.click();
		WebElement webElement7 = driver1.findElement(By.id("cell-4"));
		webElement7.click();
		WebElement webElement8 = driver2.findElement(By.id("cell-6"));
		webElement8.click();
		WebElement webElement9 = driver1.findElement(By.id("cell-7"));
		webElement9.click();
		WebElement webElement10 = driver2.findElement(By.id("cell-8"));
		webElement10.click();
		WebElement webElement11 = driver1.findElement(By.id("cell-3"));
		webElement11.click();
				
		WebDriverWait wait1 = new WebDriverWait(driver1, 5);
		WebDriverWait wait2 = new WebDriverWait(driver2, 5);
				
		//When
		String comp = "Draw!";
		String message1 = driver1.switchTo().alert().getText();
		String message2 = driver2.switchTo().alert().getText();
		//Then
		assertEquals(message1, message2);
		assertEquals(comp,message1);
		assertEquals(comp,message2);
	}				
}


