package com.iqmsoft.wlogic.boot.jsf.beans.ajaxcore;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("counterView")
@Scope("view")
public class CounterView {
    private int number;

    public int getNumber() {
        return number;
    }

    public void increment() {
        number++;
    }
}
