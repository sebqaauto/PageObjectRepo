package PageObjectsModel.PageObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class JDBCHelper {
	
	public void interactWithDB() throws SQLException, ClassNotFoundException {
		
		//Class.forName("com.mysql.jdbc.Driver");
		
		// 1) Establish the connection with the data base
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college2", "college2", "password");
		
		// 2) Create a Statement to run a query in db
		Statement stmt = connection.createStatement();
		
		// 3) Execute the query and store it in a result object 
		ResultSet rs = stmt.executeQuery("select * from Students where city='Chennai'");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3) + " "+rs.getInt(4) + " "+rs.getString(5));
			
		}
		//connection.close();
			
	}
	
	

}
