package com.MercuryAutoDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ConceptMaven {
	
	public WebDriver driver;
	
  @Test
  public void Test() 
  {
	  driver.findElement(By.name("userName")).sendKeys("Pranali@1");
	  driver.findElement(By.name("password")).sendKeys("Passw@rd1");
	  driver.findElement(By.name("login")).click();
	  System.out.println("Valid User logged in");
	  boolean flag= driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  System.out.println("Flight finder icon is visible: "+flag);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("cookies");
  }

  @AfterMethod
  public void afterMethod() throws IOException 
  {
	  System.out.println("In captureScreenshot method under AfterMethod");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src,new File("E:\\eclipse\\MavenConcept\\src\\test\\resources\\Screenshots\\"));
  }

  @BeforeClass
  public void beforeClass() 
  {
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("delete cookies");
  }

  @BeforeTest
  public void beforeTest() 
  {
	  driver.get("http://www.newtours.demoaut.com/mercurywelcome.php");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("db connction closed");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Selenum\\29062019\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
  }

  @AfterSuite
  public void afterSuite() 
  {
	  driver.quit();
  }

}
