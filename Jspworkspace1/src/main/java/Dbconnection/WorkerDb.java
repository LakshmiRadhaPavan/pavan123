package Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class WorkerDb {
private static final String driver="com.mysql.cj.jdbc.Driver";
private static final String url = "jdbc:mysql://localhost:3306/database2";
private static final String username = "root";
private static final String password = "21551A05C6";
private static Connection con;
public static Connection getcon() {
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url,username,password);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;
}


}
