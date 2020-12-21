package com.jh.example.sort.run;

import java.util.ArrayList;
import java.util.List;

import com.jh.example.sort.controller.equalsController;
import com.jh.example.sort.model.vo.Information;

public class Run {

    public static void main(String[] args) {
	
	equalsController ec = new equalsController();
	Information im1 = new Information("홍길동",25,"서울 특별시");
	System.out.println("im1 : "  +im1);
	Information im2 = new Information("후후",25,"서울 특별시");
	System.out.println("im2 : " + im2);
	System.out.println("im1 = im2 ? : " + im1.equals(im2));
	System.out.println(ec.eqsort(im1,im2));
	
	ArrayList<Information> list = new ArrayList<Information>(2);
	list.add(im1);
	list.add(im2);
	ec.createList(list);
	// 정렬 하겠다.
	for(Information i : list) {
	    System.out.println(i);
	}
    }

}
