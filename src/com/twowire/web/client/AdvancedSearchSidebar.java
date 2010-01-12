package com.twowire.web.client;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AdvancedSearchSidebar {

	
	private VerticalPanel advancedPanel = new VerticalPanel();
	
	public AdvancedSearchSidebar(){
		//setSearchBox();
    	setSearchType();
		setSearchExamples();
		setLastModified();
		setProduct();
		setWithinCategory();
	}
	public VerticalPanel getAdvancedPanel(){
		return advancedPanel;
	}
	private void setSearchBox(){
		TextBox searchBox = new TextBox();
		Button searchButton = new Button();
		HorizontalPanel searchBoxPanel = new HorizontalPanel();
		searchBoxPanel.add(searchBox);
		searchBoxPanel.add(searchButton);
		advancedPanel.add(searchBoxPanel);
	}

	private void setSearchType(){
		VerticalPanel searchType = new VerticalPanel();
		HTML searchTypeHeader = new HTML();
		searchTypeHeader.setText("Search Type:");
		searchType.add(searchTypeHeader);
		searchType.add(new RadioButton("searchType", "find all words"));
		searchType.add(new RadioButton("searchType", "find any words"));
		searchType.add(new RadioButton("searchType", "find exact phrase"));
		HorizontalPanel idSearchRadio = new HorizontalPanel();
		RadioButton byID = new RadioButton("searchType", "by ID: 5489 - ");
		TextBox idNo = new TextBox();
		idNo.setWidth("60");
		idSearchRadio.add(byID);
		idSearchRadio.add(idNo);
		idSearchRadio.setSpacing(4);
		searchType.add(idSearchRadio);
		
		advancedPanel.add(searchType);
		
	}
	private void setSearchExamples(){
		VerticalPanel searchExamples = new VerticalPanel();
		HTML searchExamplesHeader = new HTML();
		searchExamplesHeader.setText("Search Examples");
		searchExamples.add(searchExamplesHeader);
		HTML searchExamplesList = new HTML("<dl>"+
				"<li>opti* will search optimology"+
				"<li>Double quotes mark" +
				"<li>+inclue or -exclude words with +/-</dl>");
		searchExamples.add(searchExamplesList);
		advancedPanel.add(searchExamples);
		
	}
	private void setLastModified(){
		VerticalPanel lastModified = new VerticalPanel();
		HTML lastModifiedHeader = new HTML("Last Modifed Since:");
		ListBox lastModifiedLb = new ListBox();
		lastModifiedLb.addItem("Anytime");
		lastModifiedLb.addItem("1 Day(s)");
		lastModifiedLb.addItem("1 Week(s)");
		lastModifiedLb.addItem("1 Month(s)");
		lastModifiedLb.addItem("6 Month(s)");
		lastModifiedLb.addItem("1 Year(s)");
		lastModified.add(lastModifiedHeader);
		lastModified.add(lastModifiedLb);
		advancedPanel.add(lastModified);
	}
	private void setProduct(){
		VerticalPanel productPanel = new VerticalPanel();
		HTML productHeader = new HTML();
		ListBox productLb = new ListBox();
		productLb.addItem("All");
		productHeader.setText("Product:");
		productPanel.add(productHeader);
		productPanel.add(productLb);
		advancedPanel.add(productPanel);
	}
	private void setWithinCategory(){
		VerticalPanel withinCategoryPanel = new VerticalPanel();
		HTML withinCateogryHeader = new HTML();
		ListBox withinCategoryLb = new ListBox();
		withinCategoryLb.addItem("All Categories");
		withinCategoryLb.addItem("CMS Logging Database");
		withinCategoryLb.addItem("Linux/Unix System Administration");
		withinCategoryLb.addItem("CMS Accessories");
		withinCategoryLb.addItem("Security Bulletins");
		withinCateogryHeader.setText("Within Category:");
		withinCategoryPanel.add(withinCateogryHeader);
		withinCategoryPanel.add(withinCategoryLb);
		advancedPanel.add(withinCategoryPanel);
	}

}
