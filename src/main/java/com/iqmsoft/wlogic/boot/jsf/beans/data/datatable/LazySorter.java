package com.iqmsoft.wlogic.boot.jsf.beans.data.datatable;

import java.util.Comparator;
import org.primefaces.model.SortOrder;

public class LazySorter implements Comparator<Scooter> {

    private String sortField;

    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int compare(Scooter car1, Scooter car2) {
        try {
            Object value1 = Scooter.class.getField(this.sortField).get(car1);
            Object value2 = Scooter.class.getField(this.sortField).get(car2);

            int value = ((Comparable)value1).compareTo(value2);

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
