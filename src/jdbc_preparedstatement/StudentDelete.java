package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentDelete {
	public static void main(String[] args) throws SQLException {
        Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the id:");
		int id=scanner.nextInt();
		
		//1.load or register the Driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//2.establish connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root");
		
		//3.create PreparedStatement
	    PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM STUDENT WHERE ID=?");
	    preparedStatement.setInt(1, id);
	    
	    //4.
	    int count=preparedStatement.executeUpdate();
	    if (count!=0) {
			System.out.println("Data Deleted");
		} else {
            System.out.println("Data not Deleted");
		}
	    connection.close();
	    scanner.close();
	    
	}

}
