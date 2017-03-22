package com.iqmsoft.wlogic.boot.jsf.beans.panel;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.iqmsoft.wlogic.boot.jsf.beans.data.datatable.Scooter;

@Component ("tabbedView")
@Scope ("view")
public class TabbedView {
	private List<Scooter> scooters;

	private TabView tabView;

	@PostConstruct
	public void init() {
		scooters = new ArrayList<Scooter>();
		scooters.add(new Scooter("Y25YIH5", "Scooty1", 2014, "Black", 10000, true));
		scooters.add(new Scooter("JHF261G", "Scooty2", 2013, "Blue", 50000, true));
		scooters.add(new Scooter("HSFY23H", "Scooty3", 2012, "Black", 35000, false));
		scooters.add(new Scooter("GMDK353", "Scooty4", 2014, "White", 40000, true));
		scooters.add(new Scooter("345GKM5", "Scooty5", 2011, "Gray", 48000, false));
		scooters.add(new Scooter("645ZM5", "Scooty6", 2011, "Gold", 60000, false));
	}

	public List<Scooter> getScooters() {
		return scooters;
	}

	public void onTabChange(TabChangeEvent event) {
		System.out.println("Tab Changed..");
		FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onTabClose(TabCloseEvent event) {
		System.out.println("Tab Changed..");
		FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void buttonAction() {
		 System.out.println("ajax button action called...");
		 FacesMessage message = new FacesMessage("Success", "AJAX Button Pressed");
         FacesContext.getCurrentInstance().addMessage(null, message);
		
	}

	public TabView getTabView() {
		return tabView;
	}

	public void setTabView(TabView tabView) {
		this.tabView = tabView;
	}
}
