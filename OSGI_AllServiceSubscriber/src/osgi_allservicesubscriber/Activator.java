package osgi_allservicesubscriber;

import java.util.Scanner; 

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.Hansani.osgi.feedback.FeedbackService;
import com.Jayagoda.osgi.phonedirectory.PhoneDirectoryService;
import com.Thilini.osgi.broadband.BroadbandService;

public class Activator implements BundleActivator {

	ServiceReference directoryServiceRefrenece, broadbandServiceReference, feedbackServicereference;
	private String custNIC;
	private String custPhoneNo;
	private int inputOpt; 
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("\nSubscriber Service started ...\n");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1 - Phone Directory Service");
		System.out.println("Enter 2 - Broadband Service");
		System.out.println("Enter 3 - Feedback Service\n");
		inputOpt = sc.nextInt();
		sc.nextLine();
		
		if (inputOpt == 1) {
			directoryServiceRefrenece = context.getServiceReference(PhoneDirectoryService.class.getName());
			PhoneDirectoryService directoryService = (PhoneDirectoryService) context.getService(directoryServiceRefrenece);
			this.serviceExec(directoryService, context);
		} else if (inputOpt == 2) {
			broadbandServiceReference = context.getServiceReference(BroadbandService.class.getName());
			BroadbandService broadbandService = (BroadbandService) context.getService(broadbandServiceReference);
			this.broadbandServiceExec(broadbandService, context);
		} else if( inputOpt == 3) {
			feedbackServicereference = context.getServiceReference(FeedbackService.class.getName());
			FeedbackService feedbackService = (FeedbackService) context.getService(feedbackServicereference);
			
		
		}else {
			System.out.println("\n Invalid Input...! Please try again.");
			try {
				this.start(context);
			}catch(StackOverflowError err) {
				err.printStackTrace();
			}
		}
		
	}
	
	public void serviceExec(PhoneDirectoryService numberService, BundleContext context) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Select an option :  \n");
		System.out.print("Enter  1 -  Lookup phone number in the Directory\n");
		System.out.print("Enter  2 -  Add new entry to the Directory\n");
		System.out.println("Enter  3 -  Exit from the program\n");
		int option = sc.nextInt();
		sc.nextLine();

		if (option == 1) {
			System.out.println("Option selected  : " + option + "\n");
			System.out.println("Please enter the phone number to lookup : ");
			String inputNumber = sc.nextLine();
			numberService.checkNumber(inputNumber);
			System.out.println("");
			System.out.println(
					"------------------------------------------------------------------------------------------------\n");
			try {
				this.serviceExec(numberService, context);
			} catch (StackOverflowError err) {
				System.out.println("Exception : Stack over flowed ....!!!");
				err.printStackTrace();
			}
		} else if (option == 2) {
			System.out.println("Option selected  : " + option + "\n");
			System.out.println("Please enter the Name  : ");
			String inName = sc.nextLine();
			System.out.println("Please enter the phone number  : ");
			String inNumber = sc.nextLine();
			numberService.addEntrytoDirectory(inName, inNumber);
			System.out.println("");
			System.out.println(
					"------------------------------------------------------------------------------------------------\n");
			try {
				this.serviceExec(numberService, context);
			} catch (StackOverflowError err) {
				System.out.println("Exception : Stack over flowed ....!!!");
				err.printStackTrace();
			}
		} else if (option == 3) {
			System.out.println("Option selected  : " + option);
			System.out.println("Thank you for using Phone Directory Service....!\n\n");
			try {
				this.stop(context);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid option...! Please try again ...\n");
			try {
				this.serviceExec(numberService, context);
			} catch (StackOverflowError err) {
				System.out.println("Exception : Stack over flowed ....!!!");
				err.printStackTrace();
			}
		}
	}
	
	
	public void broadbandServiceExec(BroadbandService broadbandServ, BundleContext context) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your NIC: ");
		custNIC = sc.nextLine();
		System.out.print("Enter your Mobile No: ");
		custPhoneNo = sc.nextLine();
		
		System.out.println("-------------------------------------------------");
		System.out.println("Consumer "+custNIC+" Starting..");
		try {
			this.main(broadbandServ, context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void main(BroadbandService service, BundleContext context) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("1: Activate Data Packs" + "\n2: Ask for Loan" + "\n3: Send Credit" + "\n4: Exit \n");

		System.out.print("Enter Code: ");
		int serviceType = sc.nextInt();

		if (serviceType == 1) {
			dataPacks(service, context);
		} else if (serviceType == 2) {
			loan(service, context);
		} else if (serviceType == 3) {
			sendCredit(service, context);
		} else if (serviceType == 4) {
			stop(context);
		} else {
			System.out.println("Invalid Code!");
			main(service, context);
		}

	}

	public void loan(BroadbandService service, BundleContext context) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Activate LOAN! " + "\n1: Rs.20 Loan" + "\n2: Rs.40 Loan \n");

		System.out.print("Enter Code: ");
		int serviceType = sc.nextInt();
		service.askLoan(custPhoneNo, serviceType);
		main(service, context);

	}

	public void sendCredit(BroadbandService service, BundleContext context) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Send CREDIT! ");

		System.out.print("Enter Amount: ");
		int amount = sc.nextInt();
		System.out.print("Enter Mobile No: ");
		String sender = sc.next();

		service.sendCredit(custPhoneNo, sender, amount);
		main(service, context);
	}

	public void dataPacks(BroadbandService service, BundleContext context) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Activate DATAPACKS! " + "\n1: 29 Data Pack " + "\n2: 49 Data Pack " + "\n3: 99 Data Pack "
				+ "\n4: 199 Data Pack \n");

		System.out.print("Enter Code: ");
		int serviceType = sc.nextInt();
		service.dataPackageService(custNIC, custPhoneNo, serviceType);
		main(service, context);
	}
	
	public void feddback(FeedbackService service, BundleContext context) {
		System.out.println("\n");
		service.makeFeedBack();
		try {
			this.start(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Subscriber Service stopped ...");
		try {
			if(inputOpt == 1 ) {
				context.ungetService(directoryServiceRefrenece);
			}else if( inputOpt == 2) {
				context.ungetService(broadbandServiceReference);
			}else if( inputOpt == 3 ) {
				context.ungetService(feedbackServicereference);
			}
		}catch(NullPointerException err) {
			err.printStackTrace();
		}
	}

}
