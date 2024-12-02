import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	
	private static String url =
"jdbc:mysql://localhost/testdb";
	
	private static String user = "root"; 
	private static String password = ""; 
	
//	１５、１６行目は公式として覚える
	public Connection getConnection() { 
	Connection con = null; 
	
//	ドライバーがロードされ使えるような状態にしている。２０，２１行目は覚える
	try{ 
	Class.forName(driverName); 
	con = DriverManager.getConnection(url,user,password); 
	} catch (ClassNotFoundException e) { 
	e.printStackTrace() ; 
	} catch (SQLException e) { 

		e.printStackTrace() ; 
	} 
	return con; 
	}
	
	
	
}
