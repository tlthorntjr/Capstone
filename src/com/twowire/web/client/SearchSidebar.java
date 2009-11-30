package com.twowire.web.client;
import com.twowire.web.client.AdvancedSearchSidebar;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SearchSidebar{
	private VerticalPanel searchPanel = new VerticalPanel();

	public SearchSidebar(){
		setSearchBox();
	}
	private void setSearchBox(){
		TextBox searchBox = new TextBox();
		searchBox.setText("Search Keywords");
		Button searchButton = new Button();
		searchButton.setText("Search");
		HorizontalPanel searchBoxPanel = new HorizontalPanel();
		searchBoxPanel.add(searchBox);
		searchBoxPanel.add(searchButton);
		DisclosurePanel advancedSearch = new DisclosurePanel("Advanced Search");
		advancedSearch.setContent(advancedSearch());
		searchPanel.add(searchBoxPanel);
		searchPanel.add(advancedSearch);
	}
	public VerticalPanel getSearchPanel(){
		return searchPanel;
	}
	
 	public VerticalPanel advancedSearch(){
		AdvancedSearchSidebar advSearch = new AdvancedSearchSidebar();
		VerticalPanel advancedSearchPanel = new VerticalPanel();
		advancedSearchPanel.add(advSearch.getAdvancedPanel());
		return advancedSearchPanel;
		
	}
}
