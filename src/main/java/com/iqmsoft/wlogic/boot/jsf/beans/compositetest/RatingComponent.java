package com.iqmsoft.wlogic.boot.jsf.beans.compositetest;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;

@FacesComponent("ratingComponent")
public class RatingComponent extends UINamingContainer {

	public Object[] getItems() {
		Object totalStars = getAttributes().get("totalStars");
		int size = Integer.valueOf(String.valueOf(totalStars));
		return new Object[size];
	}

}
