package com.example.classes;

import java.sql.*;

public class MysqlAccess {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public ResultSet readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/user_account?user=root&password=adh1kar1");
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from account");
			
			preparedStatement = connect.prepareStatement("INSERT INTO account (id, username,password,phone,valid) VALUES (NULL, 'prem', 'prem', '9846042241', '0');");
			preparedStatement.executeUpdate();
			String result = null;
			while (resultSet.next()){
				String username = resultSet.getString("username");
				
				System.out.println("User:" + username);
			}
		}
		catch (Exception er) {
			System.out.println("Error:" + er);
		}
		finally	{
			connect.close();
		}
		return resultSet;
	}

}
