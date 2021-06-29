package advance.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class JDBC {

    WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
 @Test
 public static void selectQuery() throws SQLException, ClassNotFoundException {
     String dbURL = "jdbc:sqlserver://ipAddress:portNumber/dbName";
     String username = "";
     String password = "";
     //Load MS SQL JDBC Driver
     Class.forName("net.sourceforge.jtds.jdbc.Driver");
     //Creating connection to the database
     Connection con = DriverManager.getConnection(dbURL,username,password);
     //Creating statement object
     Statement st = con.createStatement();
     String selectquery = "SELECT * FROM <tablename> WHERE <condition>";
     //Executing the SQL Query and store the results in ResultSet
     ResultSet rs = st.executeQuery(selectquery);
     //While loop to iterate through all data and print results
     while (rs.next()) {
         System.out.println(rs.getString("transaction_datetime"));
     }
     //Closing DB Connection
     con.close();
 }

}
