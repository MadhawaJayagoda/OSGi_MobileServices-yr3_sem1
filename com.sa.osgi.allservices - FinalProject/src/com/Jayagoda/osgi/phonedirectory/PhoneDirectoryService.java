package com.Jayagoda.osgi.phonedirectory;

public interface PhoneDirectoryService {
	
	/**
	 * 
	 * Student Name : Jayagoda N.M.
	 * Software Engineering Weekday batch
	 * 
	 */
	
	/**
     * Check for the existence of a Phone Number.
     * @param Phone Number to check in the phone number directory.
     * @return true if the phone number entered  exists in the phone number directory,
     *         false otherwise.
    **/
    public boolean checkNumber(String phoneNumber);
    public void addEntrytoDirectory(String name, String number);
   
}
