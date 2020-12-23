package com.jh.example.map.model.vo.compare;

import java.util.Comparator;

public class SnackComperator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
	String stand = (String)o1;
	String object = (String)o2;
	return -stand.compareTo(object);
    }
}
