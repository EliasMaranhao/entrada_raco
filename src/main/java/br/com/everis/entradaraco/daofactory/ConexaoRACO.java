package br.com.everis.entradaraco.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConexaoRACO {

	protected static void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void closePreparedStatement(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected PreparedStatement prepareStatement(Connection connection, String query, int queryTimeout)
			throws SQLException {
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setQueryTimeout(queryTimeout);
		return statement;
	}
	
	protected static Connection getConnection() throws Exception {
		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Properties props = new Properties();
			props.put("user", "uraraco");
			props.put("password", "todo2014");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = orahx04-scan.interno)(PORT = 1549))(CONNECT_DATA =(SERVER = DEDICATED)(SID = urahml)))",
					props);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	protected static Connection getConnectionAcessoLocal() throws Exception {
		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			Properties props = new Properties();
			props.put("user", "OIURAFIXA");
			props.put("password", "Ur4fixa1320");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = 10.61.195.173)(PORT = 1600))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = urahml)))",
					props);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
