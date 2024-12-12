package controller;

import model.User;

public class UserController {
	
	public static boolean Register(String username, String password) {
		if (username.isEmpty() || password.isEmpty()) {
			System.out.println("All fields must be filled");
			return false;
		}
		
		if (User.getUserByUsername(username) != null) {
			System.out.println("username is not unique");
			return false;
		}
		return User.CreateUser(username, password);
	}

	public static User Login(String username, String password) {
		User user = User.getUserByUsername(username);
		
		if (user == null) {
			return null;
		} else {
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				System.out.println("wrong password");
				return null;
			}
		}
	}

}
