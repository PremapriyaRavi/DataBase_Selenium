package org.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DBConnection {
	 static WebDriver driver;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","admin");
		String query = "select * from Sample";
		PreparedStatement st = con.prepareStatement(query);
		
		ResultSet rs = st.executeQuery();
		//System.out.println("Done!!!!!!!!");
		//String string = rs.getString("username");
		//String string2 = rs.getString("password");
		while(rs.next()) {

			System.setProperty("webdriver.chrome.driver","C:\\Users\\PREMA\\eclipse-workspace\\DataBase_Selenium\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://login.salesforce.com");
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rs.getString("username"));
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(rs.getString("password"));
			driver.close();
		}
		System.out.println("Done...");	
	}
}
