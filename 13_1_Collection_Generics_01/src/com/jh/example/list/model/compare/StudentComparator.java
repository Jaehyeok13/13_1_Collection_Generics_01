package com.jh.example.list.model.compare;

import java.util.Comparator;

import com.jh.example.list.model.vo.Student;

public class StudentComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
	// 객체 밖에서 만들지기 때문에 매개변수 2개를 가져온다
	// 점수 내림차순
	// 오름차순일때
	//	비교주체가 비교 대상보다 크면 양수
	//					작으면 음수
	//					같으면 0
	// 다형성 다운 캐스팅으로 직접 import 해줘야 한다.
	int standard = ((Student)o1).getScore();	//비교 주체
	int object = ((Student)o2).getScore();	// 비교 대상
	if(standard > object) {
	    return -1;
	}else if(standard == object) {
	    return 0;
	}else {
	    return 1;
	}
    }
}
