package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;

public class User {
	
	private int id;
	private String username;
	private String password;
	
	public static boolean CreateUser(String username, String password) {
		Database db = Database.getInstance();
		String query = "INSERT INTO users(username, password) VALUES (?, ?)";
		PreparedStatement ps = db.prepareStatement(query);
		
		try {
			ps.setString(1, username);
			ps.setString(2, password);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static User getUserByUsername(String username) {
		Database db = Database.getInstance();
		String query = "SELECT * FROM users where username = ?";
		PreparedStatement ps = db.prepareStatement(query);
		User user = null;
		
		try {
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("Id");
				String username1 = rs.getString("username");
				String password = rs.getString("password");
				
				
				user = new User(id, username1, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

}
