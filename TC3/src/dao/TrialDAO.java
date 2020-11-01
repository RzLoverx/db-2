package dao;

import java.sql.ResultSet;

import domain.TrialDOM;

public interface TrialDAO {
	public  void insert(TrialDOM trialdom);
	public  ResultSet select();
}
