package com.Thilini.osgi.broadband;

public interface BroadbandService {
	
	public void dataPackageService(String nic, String telephone, int type);
	public void askLoan(String telephone, int type);
	public void sendCredit(String telephone,String sender, int amount);

}
