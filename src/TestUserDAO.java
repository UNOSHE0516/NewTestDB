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
	
//⑥文章追加
	 public void selectAll() { 
	     DBConnector db = new DBConnector(); 
	     Connection con = db.getConnection(); 
	 
	     String sql ="select * from test_table"; 
	     try { 
	       PreparedStatement ps = con.prepareStatement(sql); 
	       ResultSet rs=ps.executeQuery(); 
	       
//	       カーソルを１行ずつ実行していき、データがなくなったら実行を終了して下さいという意味。
	       while (rs.next()) { 
	         System.out.println(rs.getString("user_name")); 
	         System.out.println(rs.getString("password")); 
	       } 
	     } catch (SQLException e ) { 
	       e.printStackTrace(); 
	     } 
		 try { 
		       con.close() ; 
		     } catch (SQLException e ) { 
		       e.printStackTrace(); 
		     } 
	  }
	 
	//⑦文章追加
	 public void selectByName(String name)
	 { 
		DBConnector db = new DBConnector(); 
		Connection con = db.getConnection(); 
		String sql ="select * from test_table where user_name=?"; 
		try { 
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1, name); 
			ResultSet rs=ps.executeQuery(); 
				while (rs.next()) { 
					System.out.println(rs.getString("user_name")); 
					System.out.println(rs.getString("password")); 
				} 
			} catch (SQLException e ) { 
			e.printStackTrace(); 
			} 
		try { 
			con.close() ; 
		} catch (SQLException e ) { 
			e.printStackTrace(); 
		} 
	} 

//	 ⑨文章追加
	 public void selectByPassword(String password) { 
	     DBConnector db = new DBConnector(); 
	     Connection con = db.getConnection(); 
	 
	     String sql ="select * from test_table where password=?"; 
	     try { 
	       PreparedStatement ps = con.prepareStatement(sql); 
	       ps.setString (1, password); 
	       ResultSet rs=ps.executeQuery(); 
	       while (rs.next()) { 
	         System.out.println(rs.getString("user_name")); 
	         System.out.println(rs.getString("password")); 
	       } 
	     } catch (SQLException e ) { 
	       e.printStackTrace(); 
	 } 
	 try { 
	       con.close() ; 
	     } catch (SQLException e ) { 
	       e.printStackTrace(); 
	     } 
	   }
//	 ⑪文章追加
	 public void updateUserNameByUserName(String oldName,String newName) { 
	     DBConnector db = new DBConnector(); 
	     Connection con = db.getConnection(); 
	 
	     String sql ="update test_table set user_name=? where user_name=?"; 
	     try { 
	       PreparedStatement ps = con.prepareStatement(sql); 
	       ps.setString(1, newName); 
	       ps.setString (2, oldName); 
	       int i=ps.executeUpdate(); 
	       if (i>0) { 
	         System.out.println(i + "件更新されました"); 
	       }else{ 
	         System.out.println("該当するデータはありませんでした"); 
	       } 
	     } catch (SQLException e ) { 
	       e.printStackTrace(); 
	 } 
	 try { 
	       con.close() ; 
	     } catch (SQLException e ) { 
	       e.printStackTrace(); 
	     } 
	 }
	 
//	 ⑬文章追加
	 public void insert(int user_id,String name, String password) {
	 DBConnector db = new DBConnector(); 
	Connection con = db.getConnection();
	
	String sql ="insert into test_table values(?,?,?)"; 
	try { 
		PreparedStatement ps = con.prepareStatement(sql); 
		ps.setInt(1, user_id); 
		ps.setString(2, name); 
		ps.setString (3, password); 
		int i=ps.executeUpdate(); 
		if (i>0) { 
	System.out.println(i + "件登録されました"); 
	} 
	} catch (SQLException e ) { 
	e.printStackTrace(); 
	}
	
	try { 
	con.close() ; 
	} catch (SQLException e ) { 
	e.printStackTrace(); 
	} 
	}
	 
//	 ⑮追加プログラム
	 public void delete(String name)
	 { 
		DBConnector db = new DBConnector(); 
		Connection con = db.getConnection(); 
		String sql ="delete from test_table where user_name=?"; 
		try { 
		PreparedStatement ps = con.prepareStatement(sql); 
		ps.setString(1, name); 
		int i=ps.executeUpdate(); 
		if (i>0) { 
		System.out.println(i + "件削除されました"); 
		} 
		} catch (SQLException e ) { 
		e.printStackTrace(); 
		} 
		try { 
		con.close() ; 
		} catch (SQLException e ) { 
		e.printStackTrace(); 
		} 
	}
	 
	 }	 
	 

