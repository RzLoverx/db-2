package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connections.JDBCCon;
import dao.TrialDAO;
import domain.TrialDOM;

public class TrialDAOIMPL implements TrialDAO {
	
	private String readSummary="SELECT customer.Name ,trial.Date ,trial.LoanAmount, trial.NoOfPeiriods ,trial.IR ,trial.Rental FROM customer,trial WHERE customer.NIC=trial.CNIC;";
	private String write="INSERT INTO `trial` (`CNIC`, `Date`, `LoanAmount`, `NoOfPeiriods`, `IR`, `Rental`, `TrialID`) VALUES (?, ?, ?, ?, ?, ?, NULL);";
	@Override
	public void insert(TrialDOM trialdom) {
		JDBCCon newj=new JDBCCon();
		Connection conn= newj.get_connection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(this.write);
			statement.setString(1, trialdom.getcNIC());
			statement.setString(2, trialdom.getDate());
			statement.setBigDecimal(3, trialdom.getLoanAmount());
			statement.setInt(4, trialdom.getNoOfPeiriods());
			statement.setDouble(5, trialdom.getInterestRate()*100);
			statement.setBigDecimal(6, trialdom.getRentelAmount());	 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("");
				System.out.println("Your Trail Calculation is save ");
			}
			else {
				System.out.println("");
				System.out.println("Your Trail Calculation isn't save ");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet select() {
		ResultSet result=null;	
		JDBCCon newj=new JDBCCon();
		Connection conn= newj.get_connection();
		PreparedStatement statement;
		
		try {
			statement = conn.prepareStatement(this.readSummary);
			result = statement.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

}
