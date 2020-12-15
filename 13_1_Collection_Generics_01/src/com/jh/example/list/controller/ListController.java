package com.jh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jh.example.list.model.vo.Student;

public class ListController {
    /* 장점
     * 1. 순서 유지
     * 	2. 중복 가능
     */
    public void List() {
	List exList = new ArrayList();	// 다형성
	// 인터페이스	/ 인터페이스를 구현한 클래스
	// 선언시 자동으로 10크기로 생성 된다.  초과시 자동으로 증가 / 고정도 가능하다.
	
	// 그 객체만 들어 갈수 있게 해주는 <> 제네릭 
	List<Student> list = new ArrayList<Student>(3);
	// Studnet 객체만 지정하게 후 크기 3으로 생성
	
	// add(E e) : 리스트 끝에 데이터 e 추가  / 지정수 초과시 넘 자동으로 인덱스도 증가 된다.
	list.add(new Student("테스트", 0));
	list.add(new Student("도담아", 60));
	
	System.out.println("list : " + list);
	
	list.add(new Student("남나눔",90));
	list.add(new Student("하현효",86));
	// 장점 1. 저장 크기에 제약이 없다.
	
	list.add(new Student("문미미",60));
	System.out.println("list : " + list);
	System.out.println("현재 list에 담긴 element 개수 : " + list.size());
	// size()  리스트에 있는 element 의 개수 반환
	
	// add(int index, E e) : index 지정한 위치에 e 추가
	list.add(0, new Student("류리라",100));
	System.out.println("add(int index,E e) : "+ list );
	
	list.add(3, new Student("강건강", 40));
	System.out.println("add(int index,E e) : " + list);
	
	// remove(Objeect o) : 해당 o 객체 삭제
	list.remove(new Student("테스트", 0));
	System.out.println(list.remove(new Student("테스트", 0 )));
	System.out.println("remove(Object o)   : " + list);
	// new Student 가 주소값을 가져와서 비교하기 때문에 

	// remove (int index) : 해당 index번째 인덱스에 있는 객체 삭제
	list.remove(1);
	System.out.println("remove(Index i)    : " + list);
// =======================================================
	// 정렬 방법 1. Collections 이용
	
	// 배열을 유용하게 사용하기 위한 클래스 : Array
	// 컬렉션을 유용하게 사용하기 위한 클래스 : Collections
	// 객체는 정렬기준이 정해진것이 없다.
	// list 에 Student 객체가 들어가 있다.
	// 정렬의 기준이 현재 없다.
	Collections.sort(list);
	System.out.println("Collections.sort(Object o) : " + list);
	// Student cannot be cast to java.lang.Comparable
	// java.lang.Error: Unresolved compilation problem
	
	/*
	   Object o = > 인터페이스 구현하여 정의 해준다.
	   Collections.sort((java.util.List<T>) (list);
	 -> T 객체에 Comparable 을 상속받아  compareTo 메소드 재정의를 통해 정렬 구현 (한 개의 정렬)
		Collections.sort(List<T> list, Comparator<T> c)  지정한 Comparator클래스에 의한 정렬 (여러 개의 정렬)
	 	Comparable, Comparator 인터페이스를 구현해서 이 객체 안에서는 이 필드를 가지고 정렬 기준을 세워줘야 한다.
	 */
	
	
	
    }
}
