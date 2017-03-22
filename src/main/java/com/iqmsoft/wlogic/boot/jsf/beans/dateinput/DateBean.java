package com.iqmsoft.wlogic.boot.jsf.beans.dateinput;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("dateBean")
@Scope("view")
public class DateBean {
    private Date startDate;
    private Date endDate;
    private Date standardDate;

    public void register() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (!startDate.before(endDate)) {
            endDate = null;
            FacesMessage errorMessage = new FacesMessage("End date must be greater than start date");
            errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, errorMessage);
        }
    }

    public String getSampleDay(){
        if(standardDate != null){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            return String.format("You choose '%s'.",formatter.format(standardDate));
        }
        return "No date selected was selected.";
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStandardDate() {
        return standardDate;
    }

    public void setStandardDate(Date standardDate) {
        this.standardDate = standardDate;
    }
}
