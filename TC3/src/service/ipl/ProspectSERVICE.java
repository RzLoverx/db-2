package service.ipl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dao.imp.ProspectADAOIMPL;
import domain.ProspectDOM;




public class ProspectSERVICE {
	
	public void getCustomerData() {
		String input;
		Scanner s1= new Scanner(System.in);
		ProspectDOM prospectdom = new ProspectDOM();	
		//get customer name
		System.out.print("Enter Customer Name : ");
		prospectdom.setName(s1.nextLine());
		
		//get and validate NIC
		System.out.print("Enter NIC Number : ");
		input=s1.nextLine();
		while(!this.validatenNIC(input)) {
			System.out.print("Enter NIC Number : ");
			input=s1.nextLine();
		}
		prospectdom.setNIC(input);
		this.checkIsCustomerAvailabel(prospectdom);
		TrialSERVICE trialservice =new TrialSERVICE();
		trialservice.FindRental(prospectdom);	
	}
	
	public boolean validatenNIC(String number) {
		boolean validate=true;
		int size =number.length();
		if(size==10) {
			for(int index=0;index<size;index++) {
				char numberchar=number.charAt(index);
				if (numberchar=='0'||numberchar=='1'||numberchar=='2'||numberchar=='3'||numberchar=='4'||numberchar=='5'||numberchar=='6'||numberchar=='7'||numberchar=='8'||numberchar=='9'||numberchar=='v') {		
				}
				else {
					validate=false;
					System.out.println("Wrong input");
					break;
				}
			}
		}
		else {
			validate= false;
		}
		
		return validate;
	}
	
	public void checkIsCustomerAvailabel(ProspectDOM prospectdom)  {
		try {
			ProspectADAOIMPL prospectdaoimpl= new ProspectADAOIMPL();
			ResultSet result = prospectdaoimpl.select(prospectdom);
			if(result.next()) {
				
			}
			else {
				System.out.println("New Customer");
				prospectdaoimpl.inser(prospectdom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
