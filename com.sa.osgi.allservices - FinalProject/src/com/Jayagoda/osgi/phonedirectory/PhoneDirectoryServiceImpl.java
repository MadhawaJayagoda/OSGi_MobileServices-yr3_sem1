package com.Jayagoda.osgi.phonedirectory;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PhoneDirectoryServiceImpl implements PhoneDirectoryService {
	
	/**
	 * 
	 * Student Name : Jayagoda N.M.
	 * Software Engineering Weekday batch
	 * 
	 */

	private Map<String, String> directory = new HashMap<String, String>();

	{
		directory.put("Madhawa Jayagoda", "0773423769");
		directory.put("Saman Weerasinghe", "0775468987");
		directory.put("Kamal Kodithuwakku", "0775798987");
		directory.put("Jinod Gunawardhena", "0775778021");
		directory.put("Kevin Wijethumga", "0712468759");

	}

	public boolean isValid(String number) {

		/**
		 * This function is used to validate the format of the phone number
		 * 
		 * @param number
		 *            to be checked.
		 * @return true if the number is in the valid format, Valid format considered is
		 *         the number should start from 0 and also the number should have 10
		 *         numbers in total, false otherwise.
		 * 
		 **/

		String phoneNumber = number;
		String regex = "[0][0-9]{9}";
		System.out.println("The phone number is: " + phoneNumber);
		return (phoneNumber.matches(regex));

	}

	@Override
	public void addEntrytoDirectory(String name, String number) {
		Boolean res = this.isValid(number);
		if (res == true) {
			for (Entry<String, String> e : directory.entrySet()) {
				if (e.getValue().equals(number)) {
					System.out.println("Number already exists in the Database ...!");
					return;
				}
			}
			directory.put(name, number);
			System.out.println("Number added successfully to the directory");
			System.out.println("Thank you ...!");
		} else {
			System.out.println("Number entered is Invalid format...! ");
		}
	}

	@Override
	public boolean checkNumber(String phoneNumber) {

		/**
		 * Implements FindNUmberService.checkNumber(). Determines if the passed in
		 * number is contained in the directory.
		 * 
		 * @param number
		 *            to be checked.
		 * @return true if the number is in the directory, false otherwise.
		 **/

		if (phoneNumber != null && phoneNumber != "") {
			if (isValid(phoneNumber) == true) {
				for (Entry<String, String> e : directory.entrySet()) {
					if (e.getValue().equals(phoneNumber)) {
						System.out.println("Phone number exists in the database...");
						System.out.println("Number belongs to \'" + e.getKey() + "\'");
						return true;
					}
				}
				System.out.println("Sorry, Phone number does not exists in the database...! ");
				return false;
			} else {
				System.out.println("Sorry, the Phone number entered is InValid !!!");
				return false;
			}
		}
		return false;
	}
}
