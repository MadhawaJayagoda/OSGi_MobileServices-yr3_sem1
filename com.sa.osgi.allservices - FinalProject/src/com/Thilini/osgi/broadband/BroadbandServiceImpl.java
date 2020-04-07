package com.Thilini.osgi.broadband;

public class BroadbandServiceImpl implements BroadbandService {

	@Override
	public void dataPackageService(String nic, String telephone, int type) {
		// TODO Auto-generated method stub
		
		if(type == 1) {
			System.out.println("Rs.29 Data Pack is Activated by "+telephone+".");
			
		}else if(type == 2) {
			System.out.println("Rs.49 Data Pack is Activated by "+telephone+".");
			
		}else if(type == 3) {
			System.out.println("Rs.99 Data Pack is Activated by "+telephone+".");
			
		}else if(type == 4) {
			System.out.println("Rs.199 Data Pack is Activated by "+telephone+".");
			
		}else {
			System.out.println("Invalid Code!");
		}
		
	}

	@Override
	public void askLoan(String telephone, int type) {
		// TODO Auto-generated method stub
		
		if(type == 1) {
			System.out.println("Rs.20 Loan Successfuly Credited to "+telephone+".");
			
		}else if(type == 2) {
			System.out.println("Rs.40 Loan Successfuly Credited to "+telephone+".");
			
		}else {
			System.out.println("Invalid Code!");
		}
		
	}

	@Override
	public void sendCredit(String telephone, String sender, int amount) {
		// TODO Auto-generated method stub
		
		System.out.println("Rs."+amount+" sended to "+sender+".");
		
	}

}
