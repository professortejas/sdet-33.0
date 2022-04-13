package generic_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	static Connection connection ;
	static ArrayList<String> ls=new ArrayList<String>();
	public static void getMySqlDatabaseConnection(String url, String username, String password) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(url, username, password);
	}
	
	public static String getDataFromDatabase(String query, int colNo) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		String data=null;
		while(rs.next()) {
			data = rs.getString(colNo);
		}
		return data;
	}
	
	public static ArrayList<String> getMultipleDataFromDatabase(String query, String columnName) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()) {
			ls.add(rs.getString(columnName));
		}
		statement.close();
		return ls;
		
	}
	
	public static String getDataFromDatabase(String query, String columnName) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		String data=null;
		while(rs.next()) {
			data = rs.getString(columnName);
		}
		statement.close();
		return data;
	}
	
	public static void updateDataIntoDatabase(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		statement.close();
	}
	
	public static void closeTheDatabase() throws SQLException {
		connection.close();
	}
	
	public static boolean verifyData(String query, String columnNameOrColumnName, String expectedData) throws SQLException {
		boolean flag=false;
		ArrayList<String> stringData=getMultipleDataFromDatabase(query, columnNameOrColumnName);
		for (String string : stringData) {
			if(string.equalsIgnoreCase(expectedData)) {
				flag=true;
				break;
			}
		}
		return flag;
	}
}
