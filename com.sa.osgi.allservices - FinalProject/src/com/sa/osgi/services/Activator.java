package com.sa.osgi.services;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.Hansani.osgi.feedback.FeedbackService;
import com.Hansani.osgi.feedback.FeedbackServiceImpl;
import com.Jayagoda.osgi.phonedirectory.PhoneDirectoryService;
import com.Jayagoda.osgi.phonedirectory.PhoneDirectoryServiceImpl;
import com.Thilini.osgi.broadband.BroadbandService;
import com.Thilini.osgi.broadband.BroadbandServiceImpl;


public class Activator implements BundleActivator {

	ServiceRegistration directoryServiceReg, broadbandServiceReg, feedbackServiceReg;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("OSGi Pubisher Service Bundle started ...");
		PhoneDirectoryService directoryService = new PhoneDirectoryServiceImpl();
		BroadbandService broadbandService = new BroadbandServiceImpl();
		FeedbackService feedbackService = new FeedbackServiceImpl();
		
		directoryServiceReg = context.registerService(PhoneDirectoryService.class.getName(), directoryService, null);
		broadbandServiceReg = context.registerService(BroadbandService.class.getName(), broadbandService, null);
		feedbackServiceReg = context.registerService(FeedbackService.class.getName(), feedbackService, null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("OSGi Publisher Service Bundle stopped...");
		directoryServiceReg.unregister();
		broadbandServiceReg.unregister();
		feedbackServiceReg.unregister();
	}
}
