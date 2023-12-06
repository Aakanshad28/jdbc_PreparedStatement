package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentUpdate {
	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the id:");
		int id=scanner.nextInt();
		System.out.println("Enter the name:");
		String name=scanner.next();
		System.out.println("Enter the phone:");
		long phone=scanner.nextLong();
		System.out.println("Enter the address:");
		String address=scanner.next();
		System.out.println("Enter the marks:");
		int marks=scanner.nextInt();
		
		//1.load or register the Driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//2.establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root");
		
		//3.create Prepared Statement
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE STUDENT SET NAME=?,MARKS=?,PHONE=?,ADDDRESS=? WHERE ID=?");
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, marks);
		preparedStatement.setLong(3, phone);
		preparedStatement.setString(4, address);
		preparedStatement.setInt(5, id);
		
		//4.Execute the statement or process the result 
		int count=preparedStatement.executeUpdate();
		if (count!=0) {
			System.out.println("Data Updated");
		} else {
            System.out.println("Data not Updated");
		}
		connection.close();
		scanner.close();
		
		
		
	}
	

}
