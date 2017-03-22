package com.iqmsoft.wlogic.boot.jsf.beans.basics;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.iqmsoft.wlogic.boot.jsf.jsf.FacesViewScope;

import java.util.Date;

@Component("basicsBean")
@Scope("view")
public class BasicsBean {

    private Integer selectedNumber;
    private Date selectedDate;

    public Integer getSelectedNumber() {
        return selectedNumber;
    }

    public void setSelectedNumber(Integer selectedNumber) {
        this.selectedNumber = selectedNumber;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }
}
