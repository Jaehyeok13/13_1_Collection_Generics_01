package com.jh.example.set.model.vo;

import java.util.Comparator;

public class DogComparator implements Comparator{
    public int compare(Object o1, Object o2) {
	// 몸무게로 오름차순 후 만약 몸무게가 같은 이름순으로 정렬을 한다.
	double  stand = ((Dog)o1).getWeight();
	double compar = ((Dog)o2).getWeight();
	if(stand > compar) {
	    return 1;
	}else if(stand == compar) {
	    // 몸무게가 같으니 이름으로 비교를 한다.
	    String standName = ((Dog)o1).getName();
	    String comparName = ((Dog)o2).getName();
	    return standName.compareTo(comparName);
	}
	return -1;
    }
}
