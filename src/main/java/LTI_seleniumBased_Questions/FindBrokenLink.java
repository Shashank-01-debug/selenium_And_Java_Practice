package LTI_seleniumBased_Questions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenLink {
	
	
public static void main(String[] args) throws IOException  {
	
	 WebDriver driver = new ChromeDriver();
     driver.get("https://demoqa.com/broken");

     List<WebElement> linksList = driver.findElements(By.tagName("a"));
     
     for(WebElement element:linksList) {
    	 
    	 String url= element.getDomAttribute("href");
    	 checkBrokenLink(url);   	 
     } 	
}

private static void checkBrokenLink(String url) throws IOException {
	//checking whether url is broken or not
	//API request from java
	//head method in postman only gives meta information but get method gives you information about meta and body content which we don't need here..
	try {
	URL urlLink = new URL(url);
	HttpURLConnection connection = (HttpURLConnection)urlLink.openConnection();
	connection.setRequestMethod("HEAD");
	connection.connect();
	
	int statusCode = connection.getResponseCode();
	
	if(statusCode>=400) {
		System.out.println("broken link:"+url);
		
	}
	else if(statusCode<400 && statusCode>200) {
		System.out.println("valid link:"+url);
	}
	}
	
	catch(Exception e){
		
		System.err.println("caught the exception"+e.getMessage());
	}
	
}

}
