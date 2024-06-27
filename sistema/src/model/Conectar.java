package model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conectar {

	
	public static Connection getConectar() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DM_meu;user=sa;password=abc@123");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return con;
		}
}
