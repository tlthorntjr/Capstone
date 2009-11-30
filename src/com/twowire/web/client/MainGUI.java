package com.twowire.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.twowire.web.client.SearchSidebar;
import com.google.gwt.user.client.ui.RootPanel;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MainGUI implements EntryPoint {
	private DockPanel guiPanel = new DockPanel();
	private SearchSidebar search = new SearchSidebar();
	private VerticalPanel searchPanel = new VerticalPanel();
	private DecoratedTabPanel navPanel = new DecoratedTabPanel();
	//put these in another class later
	private VerticalPanel recentTicketsPanel = new VerticalPanel();
	private VerticalPanel submitTicketPanel = new VerticalPanel();
	private VerticalPanel submitFeedbackPanel = new VerticalPanel();
	private VerticalPanel contactUsPanel = new VerticalPanel();
public void onModuleLoad() {
		searchPanel = search.getSearchPanel();
		getNavPanel();
		guiPanel.setSpacing(10);
		guiPanel.add(searchPanel, DockPanel.WEST);
		guiPanel.add(navPanel, DockPanel.EAST);
		RootPanel.get().add(guiPanel);
	}

	private void getNavPanel(){
		//initialize all the panels
		navPanel.add(recentTicketsPanel, "Recent Tickets");
		navPanel.add(submitTicketPanel, "Submit a Ticket");
		navPanel.add(submitFeedbackPanel, "Submit Feedback");
		navPanel.add(contactUsPanel, "Contact Us");
		navPanel.selectTab(0);
		setOnlineSupport();
		setSubmitTicket();
		setSubmitFeedBack();
		setContactUs();
	}

	private void setOnlineSupport(){
		VerticalPanel main = new VerticalPanel();
		main.add(new HTML("<h1>Recent Tickets</h1>"));
		main.add(new HTML("<b1>This is where we will put recent tickets.</b1>"));
		recentTicketsPanel.add(main);
	}
	private void setSubmitTicket(){
		VerticalPanel main = new VerticalPanel();
		main.add(new HTML("<h1>Submit a Ticket</h1>"));
		main.add(new HTML("<b1>The Ticket System enables you to directly submit a support ticket to a technical specialist whose expertise matches your inquiry. " +
				"This online tool provides an alternative to phone and e-mail and helps expedite the resolution of your issue. " +
				"You can track the status of your ticket in My Support.</b1></br>"));
		main.add(new HTML("<l1>Contact Info</l1>"));
		FlexTable layout = new FlexTable();
			layout.setHTML(0, 0, "<l1>*Full Name: </l1>");
			layout.setHTML(0, 1, "<b1>contactNameFromDatabase: </b1>");
			layout.setHTML(1, 0, "<l1>*User ID:<l1>");
			layout.setHTML(1, 1, "<b1>userIDFromDatabase</b1>");
			layout.setHTML(2, 0, "<l1>*Severity</l1>");
			ListBox severityLB = new ListBox();
			severityLB.addItem("Select One");
			severityLB.addItem("Critical: Major Function Unavailable");
			severityLB.addItem("Critical: Major Function Unavailable");
			severityLB.addItem("Major: Critical But Has Workaround");
			severityLB.addItem("Minor: Some Business Impact");
			severityLB.addItem("Not Severe");
			layout.setWidget(2, 1, severityLB);
			layout.setHTML(3, 0, "<l1>Product:</l1>");
			layout.setHTML(3, 1, "<b1>associatedProductsFromDatabase</b1>");
			layout.setHTML(4, 0, "<l1>*Ticket Type</l1>");
			ListBox ticketTypeLB = new ListBox();
			ticketTypeLB.addItem("Select One");
			ticketTypeLB.addItem("General Question");
			ticketTypeLB.addItem("Problem Report");
			ticketTypeLB.addItem("Feature Request");
			ticketTypeLB.addItem("Documentation Request");
			ticketTypeLB.addItem("Account Issue");
			ticketTypeLB.addItem("Other");
			layout.setWidget(4, 1, ticketTypeLB);
			layout.setHTML(5, 0, "<l1>Priority:</l1>");
			ListBox priorityLB = new ListBox();
			priorityLB.addItem("P1");
			priorityLB.addItem("P2");
			priorityLB.addItem("P3");
			layout.setWidget(5, 1, priorityLB);
		layout.setHTML(6, 0, "<l1>Options</l1>");
			
			layout.setHTML(7, 0, "<l1>Attachment:</l1>");
			FileUpload attachFile = new FileUpload();
			layout.setWidget(7, 1, attachFile);
			layout.setHTML(8, 0, "<l1>Email Notification:</l1>");
			CheckBox emailNotifyBox = new CheckBox();
			layout.setWidget(8, 1, emailNotifyBox);
			Button previewButton = new Button();
			previewButton.setText("Preview");
			layout.setWidget(9, 0, previewButton);
			Button finishButton = new Button();
			finishButton.setText("Finish");
			layout.setWidget(9, 1, finishButton);
			layout.setCellPadding(4);
			main.add(layout);
		submitTicketPanel.add(main);
	}
	private void setSubmitFeedBack(){
		VerticalPanel main = new VerticalPanel();;
		main.add(new HTML("<h1>Submit Feedback</h1>"));
		main.add(new HTML("<b1>We are committed to providing you with the highest level of online support and services. " +
				"We encourage you to share your valuable opinions and experiences with us, and will look forward to your feedback.</b1>"));
		FlexTable layout = new FlexTable();
			layout.setHTML(0, 0, "<l1>First Name:</l1>");
			layout.setHTML(0, 1, "<b1>fistNameFromDatabase</b1>");
			layout.setHTML(1, 0, "<l1>Email:</l1>");
			layout.setHTML(1, 1, "<b1>emailFromDatabase</b1>");
			layout.setHTML(2, 0, "<l1>Feedback Type:</l1>");
			ListBox feedbackLB = new ListBox();
			feedbackLB.addItem("Select One");
			feedbackLB.addItem("Criticism");
			feedbackLB.addItem("Compliment");
			feedbackLB.addItem("Suggestion");
			feedbackLB.addItem("Mistake");
			feedbackLB.addItem("Comment");
			feedbackLB.addItem("Comment");
			feedbackLB.addItem("Other");
			layout.setWidget(2, 1, feedbackLB);
			layout.setHTML(3, 0, "<l1>Your Feedback</l1>");
		TextArea feedbackText =  new TextArea();
		feedbackText.setWidth("400px");
		feedbackText.setHeight("300px");
		main.add(layout);
		main.add(feedbackText);
		Button submitFeedback = new Button();
		submitFeedback.setText("Submit Feedback");
		main.add(submitFeedback);
		submitFeedbackPanel.add(main);
	}
	private void setContactUs(){
		contactUsPanel.add(new HTML("<h1>Contact Us:<br></h1>" +
				"<b1>Australia 0011.800.424.29.473<br>" +
				"Europe 0011.800.424.29.473<br>" +
				"Canada +1.866.642.6045<br>" +
				"Mexico +1.866.642.6045<br>" +
				"U.S. 866.642.6045<br>" +
				"Normal hours 8AM-5PM PST/PDT Mon-Fri<br>" +
				"Severity one incidents are 24/7</b1>"));
	}
}
