package net.codejava.sql;

import java.sql.*;
import javax.swing.*;

public class ConnectToSql {
	
	Connection conn;
	public static Connection dbconnect()
	{
		String url = "jdbc:sqlserver://DESKTOP-833S8KU\\\\SQLEXPRESS01:1433;databaseName=HospitalManagement";
		String user = "sa";
		String password = "123456";
		
		try {
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
		}catch(Exception e) {
			return null;
		}
	}
}
