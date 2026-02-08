package com.base;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public abstract class Base_Class {
	
	public static WebDriver driver;
	
	
	protected static void launchBrowser(String browserName) {             //BROWSER LAUNCH   OK
		try {
			if(browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("edge")) {
				driver= new EdgeDriver();
			}else if (browserName.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING BROWSER LAUNCH");	
		}
		driver.manage().window().maximize();	
	}
	protected static void launchUrl(String url) {                                 //URL LAUNCH   OK
		try {driver.get(url);
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING URL LAUNCH");
		}}
	protected static void navigate(String input) {                               //NAVIGATE BACK,FORWARD,REFRESH
		try {                                                                          //  OK
			if(input.equalsIgnoreCase("back")) {
				driver.navigate().back();
		}else if(input.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}else if(input.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING NAVIGATE");
		}}
	
	protected static void navigateTo(String url) {                               //NAVIGATE TO URL  OK
		try {
			driver.navigate().to(url);;
			} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING NAVIGATE TO URL");
			}}
		protected static void browserQuit() {                                   //BROWSER QUIT   OK
			try {
				driver.quit();	
			} catch (Exception e) {
				Assert.fail("ERROR: OCCURE DURING BROWSER QUIT");
			}}
		protected static void browserClose() {                                  //BROWSER CLOSE   OK
			try {
				driver.close();
				
			} catch (Exception e) {
				Assert.fail("ERROR: OCCURE DURING BROWSER CLOSE");
			}}
		protected static void selectOptions(WebElement element,String type,String value) {    //SELECT
		try {
			Select select = new Select(element);
			if(type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			}else if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			}else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}} catch (Exception e) {
			Assert.fail("ERROR: OCCURE DURING SELECT OPTIONS");
			}}
		protected static void deselectOptions(WebElement element,String type,String value) {   //DESELECT
			try {
				Select select = new Select(element);
				if(type.equalsIgnoreCase("text")) {
					select.deselectByVisibleText(value);
				}else if (type.equalsIgnoreCase("index")) {
					select.deselectByIndex(Integer.parseInt(value));
				}else if (type.equalsIgnoreCase("value")) {
					select.deselectByValue(value);
				}} catch (Exception e) {
				Assert.fail("ERROR: OCCURE DURING DESELECT OPTIONS");
				}}
			protected static void windowHandles(int num) {                                  //WINDOW HANDLES
				try {
					List<String> allWindow= new ArrayList(driver.getWindowHandles());
					driver.switchTo().window(allWindow.get(num));
					
				} catch (Exception e) {
					Assert.fail("ERROR: OCCURE DURING WINDOW HANDLES");
				}}
			
			protected static void windowHandle() {
				try {
					String parenttab = driver.getWindowHandle();
					driver.switchTo().window(parenttab);
				} catch (Exception e) {
					Assert.fail("ERROR: OCCURE DURING WINDOW HANDLE");                    //WINDOW HANDLE
				}}
			
			protected static void elementClick(WebElement element) {                       //CLICK  OK
				try {
					element.click();	
				} catch (Exception e) {
					Assert.fail("ERROR: OCCURE DURING ELEMENT CLICK");
				}}	
			protected static void elementClear(WebElement element) {                        //CLEAR  OK
				try {
					element.clear();	
				} catch (Exception e) {
					Assert.fail("ERROR: OCCURE DURING ELEMENT CLEAR");
				}}	
			protected static void passInput(WebElement element,String input) {             //PASS INPUT  OK
				try { 
					element.sendKeys(input);	
				} catch (Exception e) {
					Assert.fail("ERROR: OCCURE DURING PASS INPUT");
				}}
				protected static void accessibility(WebElement element) {                 //ACCESSIBILITY
					try {
						element.isDisplayed();
						element.isEnabled();
						element.isSelected();	
					} catch (Exception e) {
						Assert.fail("ERROR: OCCURE DURING ACCESSIBILITY");
					}}
				
				protected static void getTitle() {                                      //GET TITLE 
						try {
							String title = driver.getTitle();
							System.out.println("TITLE:"+title);
						} catch (Exception e) {
							Assert.fail("ERROR: OCCURE DURING GET TITLE");               
						}}
				protected static void getText(WebElement element) {                        //GET TEXT
					try {
						String text = element.getText();
						System.out.println(text);
						
					} catch (Exception e) {
						Assert.fail("ERROR: OCCURE DURING GET TEXT");            
					}}
					
				protected static void implicitWait(int seconds) {                           //IMPLICIT WAIT
					try {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
				}catch(Exception e) {
					Assert.fail("ERROR: OCCURE DURING IMPLICIT WAIT");  

				}}
				protected static void waitForVisibility(WebElement element, int seconds) {    //ELEMENT VISIBLE WAIT
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
					 wait.until(ExpectedConditions.visibilityOf(element));
				}
				protected static void waitForClickable(WebElement element, int seconds) {      //ELEMENT CLICK WAIT
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
					wait.until(ExpectedConditions.elementToBeClickable(element));
				}
				
				
				protected static void waitAndGetAlertText(int seconds) {                 //WAIT FOR ALERT ANG GET TEXT
				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
					Alert alert = wait.until(ExpectedConditions.alertIsPresent());
					String text = alert.getText();
					System.out.println(text);
				    
				}
				
				protected static void waitAndAcceptAlert(int seconds) {                        //WAIT FOR ALERT ANG ACCEPT
				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
				    wait.until(ExpectedConditions.alertIsPresent()).accept();
				}
				
				protected static void handlePromptAlert(String value) {                          //HANDLE PROMPT ALERT
					try {
						driver.switchTo().alert().sendKeys(value);
						driver.switchTo().alert().accept();
					} catch (Exception e) {
						Assert.fail("ERROR: OCCURRED DURING PROMPT ALERT HANDLING");
					}
				}

				                           // Frames
				protected static void switchToFrameById(String frameId) {
					try {
						driver.switchTo().frame(frameId);
					} catch (Exception e) {
						Assert.fail("ERROR: OCCURRED WHILE SWITCHING FRAME BY ID");
					}
				}

				protected static void switchToFrameByName(String frameName) {
					try {
						driver.switchTo().frame(frameName);
					} catch (Exception e) {
						Assert.fail("ERROR: OCCURRED WHILE SWITCHING FRAME BY NAME");
					}
				}

				protected static void switchToFrameByIndex(int index) {
					try {
						driver.switchTo().frame(index);
					} catch (Exception e) {
						Assert.fail("ERROR: OCCURRED WHILE SWITCHING FRAME BY INDEX");
					}
				}

				protected static void switchToFrameByElement(WebElement frameElement) {
					try {
						driver.switchTo().frame(frameElement);
					} catch (Exception e) {
						Assert.fail("ERROR: OCCURRED WHILE SWITCHING FRAME BY WEBELEMENT");
					}
				}

				protected static void switchToDefaultContent() {
					try {
						driver.switchTo().defaultContent();
					} catch (Exception e) {
						Assert.fail("ERROR: OCCURRED WHILE SWITCHING TO DEFAULT CONTENT");
					}
				}

				protected static void waitToSee() {                            //THREAD.SLEEP
				    try {
				        Thread.sleep(3000);
				    } catch (InterruptedException e) {
				        e.printStackTrace();
				    }
				}

				                                                                             //screenshot
				protected static void takeScreenshot(String fileName) {
				    try {
				        TakesScreenshot ts = (TakesScreenshot) driver;
				        File src = ts.getScreenshotAs(OutputType.FILE);
				        File dest = new File("ScreenshotsMaven/" + fileName + ".png");
				        FileHandler.copy(src, dest);
				       
				    } catch (Exception e) {
				        e.printStackTrace();
				        Assert.fail("ERROR OCCURRED DURING SCREENSHOT");
				    }
				}
				
				
				

				}

					
					
					


				
				
				




					
					
					
				
				
				
					
				
			
				
				
				
				
				
				
			
		
		
		
		
	
	
	
	
	
	
	
	
	
