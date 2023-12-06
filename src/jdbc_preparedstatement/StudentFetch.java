package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentFetch {
	public static void main(String[] args) throws SQLException {
		
        Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the id:");
		int id=scanner.nextInt();
		 
		
		//1.load or register the Driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
				
		//2.establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root");
		
		//3.create preparedStatement
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM STUDENT WHERE ID=?");
		preparedStatement.setInt(1, id);
		
		//4.execute the statement and process the data
		ResultSet resultSet=preparedStatement.executeQuery();
		while (resultSet.next()) {
			
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString("name"));
			System.out.println(resultSet.getLong(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getInt("marks"));
			System.out.println("***********************");
			
		}
		resultSet.close();
		connection.close();
		scanner.close();
		
		
	}

}
