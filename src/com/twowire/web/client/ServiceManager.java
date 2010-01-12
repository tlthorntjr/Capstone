package com.twowire.web.client;

import com.google.gwt.core.client.GWT;

public class ServiceManager {
	
	private static TwowireServiceAsync twowireService;
	
	public static TwowireServiceAsync getTwowireServiceInstance() {
		  if (twowireService == null) {
		    // Instantiate the service 
			  twowireService = (TwowireServiceAsync) GWT.create(TwowireService.class);
		    // Specify the URL at which the service implementation is running.
		    // The target URL must reside on the same domain and port from
		    // which the host page was served.
			  System.out.println(GWT.getModuleBaseURL());
		   // ((ServiceDefTarget) twowireService).setServiceEntryPoint( GWT.getModuleBaseURL() +
		     //                                                          "TwoWireService");
		   }
		   return twowireService;
		}
}
