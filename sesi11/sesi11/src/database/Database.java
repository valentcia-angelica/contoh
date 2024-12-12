package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
	
	private String HOST = "localhost:3306";
	private String DATABASE = "sesi11";
	private String USER = "root";
	private String PASSWORD = "";
	private String URL = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
	private static Database instance = null;
	private Connection connect = null;
	
	private Database() {
		try {
			connect = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	public PreparedStatement prepareStatement(String query) {
		PreparedStatement ps = null;
		try {
			ps = connect.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}

}
