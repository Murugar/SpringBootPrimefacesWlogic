package com.iqmsoft.wlogic.boot.jsf.beans.numberinput;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fahrenheitBean")
@Scope("view")
public class FahrenheitBean {
    private Integer f = 32;

    public Integer getF() {
        return f;
    }

    public void setF(Integer f) {
        this.f = Math.max(f,-460);
    }

    public int getC() {
        return (int) ((f -32) * (5.0/9.0));
    }
}
