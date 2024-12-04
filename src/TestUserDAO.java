import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestUserDAO {
	String name = ""; 
	String password = "";
	public void select(String name,String password) {
	
//★13、14行目DBへの接続準備　これでmysqlにログインできる。
	DBConnector db = new DBConnector(); 
	Connection con = db.getConnection(); 
	
	String sql ="select * from test_table where user_name=? and password=?"; 
	try {
		
//	PreparedStatementはDBまで運んでくれる箱
	PreparedStatement ps = con.prepareStatement(sql); 
	ps.setString(1, name); 
	ps.setString (2, password); 
	
//★executeQuery(); は実行で必ずResultSetが返ってくる
	ResultSet rs=ps.executeQuery(); 
//	1行づつデータを抽出してくれる
	if (rs.next()) { 
	System.out.println(rs.getString("user_name")); 
	System.out.println(rs.getString("password")); 
	} 
	} catch (SQLException e ) { 
	e.printStackTrace(); 
	} 
	try { 
//		36行目データベースの接続を終了させる。終わりには必ず入れる
	con.close() ; 
	} catch (SQLException e ) { 
	e.printStackTrace(); 
	} 
	} 
	
}
