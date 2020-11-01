package service.ipl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import dao.TrialDAO;
import dao.imp.TrialDAOIMPL;
import domain.ProspectDOM;
import domain.TrialDOM;

public class TrialSERVICE {
	
	public void FindRental(ProspectDOM prospectdom) {
		TrialDOM trialdom= new TrialDOM();
		LocalDate date = LocalDate.now();
		trialdom.setDate(date.toString());
		trialdom.setcNIC(prospectdom.getNIC());
		String input;
		Scanner s2= new Scanner(System.in);
		//Loan amount
		System.out.print("Enter Loan Amount : Rs.");
		input=s2.nextLine();
		while(!this.validatendouble(input)) {
			System.out.print("Enter Loan Amount : Rs.");
			input=s2.nextLine();
		}
		trialdom.setLoanAmount(new BigDecimal(input));
		//Number of periods
		System.out.print("Enter Repayment Period in months : ");
		input=s2.nextLine();
		while(!this.validatenint(input)) {
			System.out.print("Enter Repayment Period in months : ");
			input=s2.nextLine();
		}
		trialdom.setNoOfPeiriods(Integer.parseInt(input));
		
		//Interest Rate
		System.out.print("Enter Annum Interest Rate : ");
		input=s2.nextLine();
		while(!this.validatendouble(input)) {
			System.out.print("Enter Annum Interest Rate : ");
			input=s2.nextLine();
		}
		//convert to percentage
		trialdom.setInterestRate(Double.parseDouble(input)/100);
		BigDecimal x1, x2, x3;
		x1=new BigDecimal(trialdom.getInterestRate()/12).multiply(trialdom.getLoanAmount());
		x2=new BigDecimal((1-(1/Math.pow((1+trialdom.getInterestRate()/12), trialdom.getNoOfPeiriods()))));
		x3=x1.divide(x2,2, RoundingMode.CEILING);
		trialdom.setRentelAmount(x3);
		
		//save trail
		TrialDAOIMPL trialdaoimpl = new TrialDAOIMPL();
		trialdaoimpl.insert(trialdom);
		
		//output
		System.out.println("");
		System.out.println("Loan Amount : Rs."+trialdom.getLoanAmount());
		System.out.println("Repayment Period : "+trialdom.getNoOfPeiriods()+" months");
		System.out.println("Annum Interest Rate : "+trialdom.getInterestRate()*100+"%");
		System.out.println("Rental Value : Rs."+trialdom.getRentelAmount());
		//trialDaoImpl.Printtable(trialDaoImpl.loanAmount, trialDaoImpl.noOfPeriods, trialDaoImpl.intrestRate,Math.round(trialDaoImpl.rental*100)/100.00);
	}
	public boolean validatendouble(String number) {
		boolean validate=true;
		int size =number.length();
		for(int index=0;index<size;index++) {
			char numberchar=number.charAt(index);
			if (numberchar=='0'||numberchar=='1'||numberchar=='2'||numberchar=='3'||numberchar=='4'||numberchar=='5'||numberchar=='6'||numberchar=='7'||numberchar=='8'||numberchar=='9'||numberchar=='.') {
				
			}
			else {
				validate=false;
				System.out.println("Wrong input");
				break;
			}
		}
		
		return validate;
	}
	
	public boolean validatenint(String number) {
		boolean validate=true;
		int size =number.length();
		for(int index=0;index<size;index++) {
			char numberchar=number.charAt(index);
			if (numberchar=='0'||numberchar=='1'||numberchar=='2'||numberchar=='3'||numberchar=='4'||numberchar=='5'||numberchar=='6'||numberchar=='7'||numberchar=='8'||numberchar=='9') {
				
			}
			else {
				validate=false;
				System.out.println("Wrong input");
				break;
			}
		}
		
		return validate;
	}

	public void printTrile() {
		TrialDAOIMPL t2= new TrialDAOIMPL();
		System.out.println("_____________________________________________________________________________________________");
		System.out.println("| Customer name | Date \t     | Loan Amount | No Of Periouds | Interest Rate | Rentel Amount |");
		System.out.println("|---------------|------------|-------------|----------------|---------------|---------------|");
		ResultSet result =  t2.select();
		try {
			while (result.next()){
				System.out.println("| "+result.getString(1)+" \t| "+result.getString(2)+" | "+result.getString(3)+"    | "+result.getString(4)+" \t    | "+result.getString(5)+"%2 \t    | "+result.getString(6)+" \t    |");
			}
			System.out.println("|_______________|____________|_____________|________________|_______________|_______________|");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
