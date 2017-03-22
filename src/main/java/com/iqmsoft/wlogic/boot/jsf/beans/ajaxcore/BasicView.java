package com.iqmsoft.wlogic.boot.jsf.beans.ajaxcore;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("basicView")
@Scope("view")
public class BasicView {
    private String text;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
