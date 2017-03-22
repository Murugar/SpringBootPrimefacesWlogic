package com.iqmsoft.wlogic.boot.jsf.beans.data.datatable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyScootDataModel extends LazyDataModel<Scooter> {

    private List<Scooter> datasource;

    public LazyScootDataModel(List<Scooter> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Scooter getRowData(String rowKey) {
        for(Scooter scooter : datasource) {
            if(scooter.getId().equals(rowKey))
                return scooter;
        }

        return null;
    }

    @Override
    public Object getRowKey(Scooter car) {
        return car.getId();
    }

    @Override
    public List<Scooter> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<Scooter> data = new ArrayList<Scooter>();

        //filter
        for(Scooter car : datasource) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(car.getClass().getField(filterProperty).get(car));

                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                        }
                        else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }

            if(match) {
                data.add(car);
            }
        }

        //sort
        if(sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}