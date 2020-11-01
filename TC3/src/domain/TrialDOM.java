package domain;

import java.math.BigDecimal;

public class TrialDOM {
	private String cNIC;
	private String date;
	private BigDecimal loanAmount;
	private int noOfPeiriods;
	private double interestRate;
	private BigDecimal rentelAmount;
	
	public String getcNIC() {
		return cNIC;
	}
	public void setcNIC(String cNIC) {
		this.cNIC = cNIC;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public int getNoOfPeiriods() {
		return noOfPeiriods;
	}
	public void setNoOfPeiriods(int noOfPeiriods) {
		this.noOfPeiriods = noOfPeiriods;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public BigDecimal getRentelAmount() {
		return rentelAmount;
	}
	public void setRentelAmount(BigDecimal rentelAmount) {
		this.rentelAmount = rentelAmount;
	}
}
