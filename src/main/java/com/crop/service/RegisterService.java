package com.crop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crop.db.DatabaseConnection;

public class RegisterService {

	public void register(String firstName, String lastName, String username, String password, int doorNo,
			String street, String city, String state, String postalCode, String otherInfo, String size, String type,
			String status, String location) {
		Connection connection = null;
		DatabaseConnection databaseConnection = new DatabaseConnection();
		try {
			connection = databaseConnection.getConnection();
			connection.setAutoCommit(false);

			long addressId = registerAddress(connection, doorNo, street, city, state, postalCode, otherInfo);

			long landId = registerLand(connection, size, type, status, location);
			
			String userId = registerUser(connection, username, password);

			registerFarmer(connection,userId, firstName, lastName,addressId,landId);

			connection.commit();
		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.setAutoCommit(true);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static int registerAddress(Connection connection, int doorNo, String street, String city, String state,
			String postalCode, String otherInfo) throws SQLException {

		String sql = "INSERT INTO addresses(doorNo,street,city,state,postal_code,other_info) VALUES (?,?,?,?,?,?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setInt(1, doorNo);
			preparedStatement.setString(2,street);
			preparedStatement.setString(3,city);
			preparedStatement.setString(4,state);
			preparedStatement.setInt(5, Integer.parseInt(postalCode));
			preparedStatement.setString(6, otherInfo);
			int rows=preparedStatement.executeUpdate();
			System.out.println("rows affected:"+rows);
			if(rows>0) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				System.out.println(resultSet);
				if(resultSet.next())
				{
					System.out.println("address id= "+resultSet.getInt(1));
					 return resultSet.getInt(1);
				}
			}
		}
		return 0;
	}

	private static int registerLand(Connection connection, String size, String type, String status, String location)
			throws SQLException {

		String sql = "INSERT INTO land(size,type,status,location) VALUES (?,?,?,?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setDouble(1, Double.parseDouble(size));
			preparedStatement.setString(2, type);
			preparedStatement.setString(3, status);
			preparedStatement.setString(4, location);
			int rows=preparedStatement.executeUpdate();
			System.out.println("land rows="+rows);
			if(rows>0) {
				try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
				if(resultSet.next())
					System.out.println("land id= "+resultSet.getInt(1));
					return (int) resultSet.getInt(1);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		return 0;
	}

	private static void registerFarmer(Connection connection,String userId, String firstName, String lastName, long addressId,
			long landId) throws SQLException {

		String sql = "INSERT INTO farmers(user_id,first_name,last_name,address_id,land_id) VALUES (?,?,?,?,?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setLong(4, addressId);
			preparedStatement.setLong(5, landId);
			preparedStatement.executeUpdate();
		}
	}
	private static String registerUser(Connection connection,String username,String password) throws SQLException
	{
		LoginService loginService = new LoginService();
		
		String sql = "INSERT INTO users(username,password_hash	) VALUES (?,?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, loginService.hashPassword(password));
			int rows=preparedStatement.executeUpdate();
			if(rows>0) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if(resultSet.next())
					return (String) resultSet.getString(1);
			}
		}
		return null;
	}
}