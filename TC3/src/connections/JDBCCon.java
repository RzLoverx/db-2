package connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCCon {
		
	public  Connection get_connection() {
		Connection connection =null;
		try {			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");
		} 
		catch (Exception e) {
			System.out.print(e);
		}
		return connection;
	}

}
