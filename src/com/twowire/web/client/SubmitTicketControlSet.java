package com.twowire.web.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.ListBox;

public class SubmitTicketControlSet {

	ListBox severityListBox;
	ListBox ticketTypeListBox;
	ListBox priorityListBox;
	FileUpload attachment;
	CheckBox emailNotify;
	Button previewButton;
	Button finishButton;
	TwowireServiceAsync twowireService;
	
	public SubmitTicketControlSet() {
		createListBoxes();
		attachment = new FileUpload();
		emailNotify = new CheckBox();
		createButtons();
	}
	
	private TwowireServiceAsync getTwowireServiceInstance() {
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

	private void createButtons() {
		previewButton = createButton("Preview");
		finishButton = new Button("Finish", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String severity = severityListBox.getValue(severityListBox.getSelectedIndex());
				System.out.println(severity);
				String ticketType = ticketTypeListBox.getValue(ticketTypeListBox.getSelectedIndex());
				System.out.println(ticketType);
				String priority = priorityListBox.getValue(priorityListBox.getSelectedIndex());
				System.out.println(priority);
				getTwowireServiceInstance().submitIssue(severity, ticketType, priority, false, 
						new AsyncCallback() {
				    
					@Override	
					public void onFailure(Throwable caught) {
						Window.alert("You are a colossal failure! " + caught.getMessage());
					}

					@Override
					public void onSuccess(Object result) {
						Window.alert("That worked.");
						
					}
				});
			}
		});
	}

	private void createListBoxes() {
		severityListBox = createSeverityListBox();
		ticketTypeListBox = createTicketTypeListBox();
		priorityListBox = createPriorityListBox();
	}
	
	private Button createButton(String text) {
		Button previewButton = new Button();
		previewButton.setText(text);
		return previewButton;
	}

	private ListBox createPriorityListBox() {
		ListBox priorityLB = new ListBox();
		/*
		priorityLB.addItem("P1");
		priorityLB.addItem("P2");
		priorityLB.addItem("P3");
		*/
		priorityLB.addItem("Blocker");
		priorityLB.addItem("Critical");
		priorityLB.addItem("Major");
		priorityLB.addItem("Minor");
		priorityLB.addItem("Trivial");
		return priorityLB;
		
	}

	private ListBox createTicketTypeListBox() {
		ListBox ticketTypeLB = new ListBox();
		
// Jira's test instance only allows certain ticket types. The below don't qualify.
		ticketTypeLB.addItem("Select One");
		/*
		ticketTypeLB.addItem("General Question");
		ticketTypeLB.addItem("Problem Report");
		ticketTypeLB.addItem("Feature Request");
		ticketTypeLB.addItem("Documentation Request");
		ticketTypeLB.addItem("Account Issue");
		ticketTypeLB.addItem("Other");
		*/
		ticketTypeLB.addItem("Bug");
		ticketTypeLB.addItem("New Feature");
		ticketTypeLB.addItem("Improvement");
		return ticketTypeLB;
	}

	private ListBox createSeverityListBox() {
		ListBox severityLB = new ListBox();
		severityLB.addItem("Select One");
		
		severityLB.addItem("Critical: Major Function Unavailable");
		severityLB.addItem("Critical: Major Function Unavailable");
		severityLB.addItem("Major: Critical But Has Workaround");
		severityLB.addItem("Minor: Some Business Impact");
		severityLB.addItem("Not Severe");
		

		return severityLB;
		
	}

	public ListBox getSeverityListBox() {
		return severityListBox;
	}

	public ListBox getTicketTypeListBox() {
		return ticketTypeListBox;
	}

	public ListBox getPriorityListBox() {
		return priorityListBox;
	}

	public FileUpload getAttachment() {
		return attachment;
	}

	public CheckBox getEmailNotify() {
		return emailNotify;
	}

	public Button getPreviewButton() {
		return previewButton;
	}

	public Button getFinishButton() {
		return finishButton;
	}
}
