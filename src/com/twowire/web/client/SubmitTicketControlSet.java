package com.twowire.web.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.ListBox;
import com.twowire.create.TicketFactory;

public class SubmitTicketControlSet {

	ListBox severityListBox;
	ListBox ticketTypeListBox;
	ListBox priorityListBox;
	FileUpload attachment;
	CheckBox emailNotify;
	Button previewButton;
	Button finishButton;
	TicketFactory factory = new TicketFactory();
	
	public SubmitTicketControlSet() {
		createListBoxes();
		attachment = new FileUpload();
		emailNotify = new CheckBox();
		createButtons();
	}

	private void createButtons() {
		previewButton = createButton("Preview");
		finishButton = new Button("Finish", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String severity = severityListBox.getValue(severityListBox.getSelectedIndex());
				System.out.println(severity);
				String type = ticketTypeListBox.getValue(ticketTypeListBox.getSelectedIndex());
				System.out.println(type);
				String priority = priorityListBox.getValue(priorityListBox.getSelectedIndex());
				System.out.println(priority);
				factory.createTicket(severity, type, priority, null, true);
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
		priorityLB.addItem("P1");
		priorityLB.addItem("P2");
		priorityLB.addItem("P3");
		return priorityLB;
	}

	private ListBox createTicketTypeListBox() {
		ListBox ticketTypeLB = new ListBox();
		ticketTypeLB.addItem("Select One");
		ticketTypeLB.addItem("General Question");
		ticketTypeLB.addItem("Problem Report");
		ticketTypeLB.addItem("Feature Request");
		ticketTypeLB.addItem("Documentation Request");
		ticketTypeLB.addItem("Account Issue");
		ticketTypeLB.addItem("Other");
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
