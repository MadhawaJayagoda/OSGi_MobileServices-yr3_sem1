package com.Jayagoda.osgi.phonedirectory;

public interface PhoneDirectoryService {
	
	/**
	 * 
	 * Student Registration Number : IT17184304
	 * Student Name : Jayagoda N.M.
	 * Software Engineering Weekday batch ( Y3S1.20.1  )
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
