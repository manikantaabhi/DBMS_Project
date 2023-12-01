package com.crop.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crop.db.DatabaseConnection;

public class LoginService {
	public boolean authenticateUser(String username, String password) {
		Connection connection=null;
        try {
        	hashPassword(password);
        	System.out.println(username+" pass  "+password);
        	DatabaseConnection db= new DatabaseConnection();
            connection = db.getConnection();
            String query = "SELECT * FROM users WHERE username=? AND password_hash=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        	if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        }
        return false;
    }
	public String hashPassword(String password) {
		MessageDigest digest;
		StringBuilder sb=null;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(password.getBytes());
			byte[] resultByteArray = digest.digest();
			sb = new StringBuilder();
			for(byte b:resultByteArray)
				sb.append(b);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
