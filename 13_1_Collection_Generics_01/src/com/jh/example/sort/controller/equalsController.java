package com.jh.example.sort.controller;

import java.util.ArrayList;

import com.jh.example.sort.model.vo.Information;

public class equalsController {
    
    
    public boolean eqsort(Information im1, Information im2) {
	boolean key = true;
	if(im1 == im2) {
	    key = true;
	}
	if(im2 == null) {
	    key = false;
	}
	
	if(im1.getClass() != im2.getClass()) {
	    key = false;
	}
	if(im1.getAddress() == null) {
	    if(im2.getAddress() != null) {
		key = false;
	    }
	}else if(!im1.getAddress().equals(im2.getAddress())) {
	    key = false;
	}
	return key;
    }
    public ArrayList<Information> createList(ArrayList<Information> list){
	ArrayList<Information> result = list;
	
	return result;
    }
   
}
