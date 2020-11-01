package cli;

import java.util.Scanner;

import service.ipl.ProspectSERVICE;
import service.ipl.TrialSERVICE;

public class Run {

	public static void main(String[] args) {
		String input;
		Scanner s1= new Scanner(System.in);
		ProspectSERVICE prospectservice = new ProspectSERVICE();
		TrialSERVICE trialservice = new TrialSERVICE();
		System.out.println();
		System.out.println("\t | Enter 1 For Do a Trail Calculation");
		System.out.println("\t | Enter 2 For Look Trail Calculation Summary");
		System.out.println("\t | Enter 3 For Do a Exit");
		System.out.println();
		System.out.print("Enter you choice : ");
		input=s1.nextLine();
		int x=1;
		while(x>0) {
			if(input.equals("1")) {
				System.out.println("You select Do a Trail Calculation ");
				prospectservice.getCustomerData();
				System.out.println("");
				
			}
			else if(input.equals("2")) {
				System.out.println("You select Look Trail Calculation Summary ");
				trialservice.printTrile();
				System.out.println("");
				
			}
			else if(input.equals("3")){
				x=-1;
				break;
			}
			else {
				System.out.println("wrong input");
				System.out.println("");
				
			}
			System.out.println("------------------------------- New Sesion -------------------------------------------");
			System.out.println();
			System.out.println("\t | Enter 1 For Do a Trail Calculation");
			System.out.println("\t | Enter 2 For Look Trail Calculation Summary");
			System.out.println("\t | Enter 3 For Do a Exit");
			System.out.println();
			System.out.print("Enter you choice : ");
			input=s1.nextLine();
				
		}
		s1.close();
		System.out.println();
		System.out.println("system off");
	}
}
