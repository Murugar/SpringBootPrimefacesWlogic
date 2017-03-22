package com.iqmsoft.wlogic.boot.jsf.beans.data.datatable;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component("dtLazyView")
@Scope("view")
public class LazyView {
    private LazyDataModel<Scooter> lazyModel;

    private Scooter selectedCar;

    @Autowired
    private ScooterService service;

    @PostConstruct
    public void init() {
        lazyModel = new LazyScootDataModel(service.createCars(200));
    }

    public LazyDataModel<Scooter> getLazyModel() {
        return lazyModel;
    }

    public Scooter getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Scooter selectedCar) {
        this.selectedCar = selectedCar;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Scooter Selected", ((Scooter) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void editRow(Scooter carToBeEdited){
        carToBeEdited.setBrand("Edited");
    }
}
