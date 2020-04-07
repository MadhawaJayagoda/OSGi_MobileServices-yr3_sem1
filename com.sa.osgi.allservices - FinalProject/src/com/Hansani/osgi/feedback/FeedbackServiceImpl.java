package com.Hansani.osgi.feedback;

import java.util.Scanner;

public class FeedbackServiceImpl implements FeedbackService {

	String[] feedBack = {"Feedbacks"};
	
	@Override
	public void makeFeedBack() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Feedback session now available of the Animal Clinic");
		System.out.println();
		System.out.println("Add your Feedback : ");
		String inFeedback = sc.nextLine();
		feedBack[feedBack.length] = inFeedback;
		
		System.out.println("You added your feedback successfully!!!");
		System.out.println();

	}

}
