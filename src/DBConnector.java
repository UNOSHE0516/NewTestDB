import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	
//	JDBC のドライバーの名前を変数に代入しています。ちなみにドライバーとはJavaとデータベースを繋げる工具箱の様な物です。 
	private static String url =
"jdbc:mysql://localhost/testdb";
	
//	rootアカウントに対するパスワードを”mysql”に指定しています。 
	private static String user = "root"; 
	private static String password = ""; 
	
//★18、20行目の二つは接続しかしないクラス。公式として覚えておく
//	接続状態にする	
	public Connection getConnection() { 
//	一度状態を初期化している
	Connection con = null; 
	
//	
	try{ 
	Class.forName(driverName); 
//★26行目ここではドライバーがロードされ使えるような状態にしている。覚える
	con = DriverManager.getConnection(url,user,password); 
	} catch (ClassNotFoundException e) { 
	e.printStackTrace() ; 
	} catch (SQLException e) { 

		e.printStackTrace() ; 
	} 
	return con; 
	}
	
	
	
}
