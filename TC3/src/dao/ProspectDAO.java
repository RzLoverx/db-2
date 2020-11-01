package dao;

import java.sql.ResultSet;

import domain.ProspectDOM;



public interface ProspectDAO {
	
	//use to save data in customer table
	public void inser(ProspectDOM prospectdom);
		
	// select data from customer table
	public  ResultSet select(ProspectDOM prospectdom);

}
