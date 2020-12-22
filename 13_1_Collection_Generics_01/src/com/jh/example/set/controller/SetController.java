 package com.jh.example.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import com.jh.example.set.model.vo.Dog;
import com.jh.example.set.model.vo.DogComparator;

public class SetController {
    public void doSet() {
	/*
	 * 기본적으로 실행 한 메소드
	 * 가장 많이 사용 하는 객체
	 * set 에는 index 가 없어 중복 저장이 안되고 순서가 유지가 안된다.
	 * null 도 중복을 허용하지 않기 때문에 1개의 null 만 저장
	 * 구현 클래스로 HashSet,LinkedSet,TreeSet 이 있음
	 */
	Set set = new HashSet();	// 다형성
	set.add(new Dog("멍멍",2.2));
	set.add(new Dog("왈왈",2));
	set.add(new Dog("몽이",5.0));
	System.out.println("set 3개 추가 	    : " + set);
	// 순서 유지 하지 않는다 -> 만약 순서대로 나온 경우 우연일 뿐
	
	set.add(new Dog("멍멍",2.2));
	System.out.println("set.add(new 중복추가) : " + set);
	// 결과 값 : set.add(new 중복추가) : [멍멍(2.2kg), 몽이(5.0kg), 멍멍(2.2kg), 왈왈(2.0kg)]
	// new 연산자로 새로운 객체 만들었기 때문에 구분 불가 => 호출한 객체에 hashCode() , equals() 오버라이딩
	// 오버라이딩 후 결과
	// [멍멍(2.2kg), 왈왈(2.0kg), 몽이(5.0kg)]
	
	// set은 동일 객체 뿐 아닐나 동등 객체까지 중복 저장하지 않는다.
	//		동일 객체 : 객체의 주소 값이 같은 경우
	//		Member m1 = new Member("1");
	//		Member m2 = m1;
	//		동등 객체 : 같은 값을 가지고 있는 경우
	//			==> 실체 담긴 값이 같은 것 까지 중복으로 본다.
	//		Member m1 = new Member("1");
	//		Member m2 = new Member("1");
	
	set.add("dddd");	// 동등 객체 이기 때문에 하나만 등록이 된다.
	set.add("dddd");
	System.out.println("set 동등객체 dddd 확인 : " + set);
	//	[멍멍(2.2kg), 몽이(5.0kg), 멍멍(2.2kg), 왈왈(2.0kg), dddd]
	
//	set.add(new String("예시1"));
//	System.out.println(set.add(new String("예시1")));
//	set.add(new String("예시1"));
	
	System.out.println("테스트 : " + set);
// ===========================================================
	// LinkedHashSet : 순서 유지 해주는 set
	// 중복은 안되고 순서 정렬만 해주는 것이 LinkeHashSet
	// 클래스 가서 딱히 해줘야 할 작업이 없다.
	Set set2 = new LinkedHashSet();
	set2.add(new Dog("초코",2.1));
	set2.add(new Dog("콩이",8.3));
	set2.add(new Dog("두부",5.0));
	System.out.println("======= LinkedHasSet =======");
	System.out.println(set2);
	set2.add(new Dog("초코",2.1));
	System.out.println(set2);
	System.out.println("==============================");
	
	// 1가지 기준점으로 정렬 Dog 클래스의 compareTo 주석 참고
	// treeSet 은 Comparable 이 되어야 작동이 가능함 Exception 처리 안하고 동작시 에러가 발생한다.
	Set set3 = new TreeSet();
	set3.add(new Dog("초코",2.1));
	set3.add(new Dog("콩이",8.3));
	set3.add(new Dog("두부",5.0));
	set3.add(new Dog("초코",2.1));
	set3.add(new Dog("로이",6.1));
	set3.add(new Dog("공주",5.2));
	set3.add(new Dog("왕자",9.5));
	set3.add(new Dog("조이",12.5));
	
	System.out.println("정렬1 이름순 정렬 : " + set3);
	
	// 2가지 기준점으로 정렬 하는 방법
	// 2가지 이상일 경우 Comparator 클래스 인터페이스 생성으로 만든다.
	Set set4 = new TreeSet(new DogComparator());
	set4.add(new Dog("초코",6.1));
	set4.add(new Dog("콩이",8.3));
	set4.add(new Dog("두부",5.0));
	set4.add(new Dog("초코",2.1));
	set4.add(new Dog("로이",6.1));
	set4.add(new Dog("공주",5.2));
	set4.add(new Dog("왕자",9.5));
	set4.add(new Dog("조이",12.5));
	System.out.println("정렬2 몸무게오름차순 , 같다면 이름오름 차순 : "+ set4);
	
// ============================================================
	// set 에 있는 객체를 하나씩 출력 하는 방법
	// 1. Set 를 List 화 시키기 (참고할 다른 클래스 없음)
	List<Dog> list = new ArrayList<Dog>();
	list.addAll(set4);
	System.out.println("===== set 객체 하나씩 출력 =====\n방법 1. List 변환\nlist.get(2) 결과 : " + list.get(2));
	
	// 2. Iterator / Enumeration / ListIterator 사용
	// Itorator 메소드 List 와 Set 계열에서만 사용 가능단방향 이다. 앞으로 돌아 올수 없다.
	Iterator<Dog> it = set4.iterator();
	// it.hasNext(); 다음 객체가 있는지 확인 반환형은 booelan 그렇기 때문에 while 안에 넣어서 사용
	System.out.println("===== Iterator 하나씩 출력  =====");
	while(it.hasNext()) { //다음 객체가 존재 하는가?	
	    // 즉 진행했다가 다시 돌아 올 수가 없다.
	    // API 의 hasToken 에서도 사용 했었음
	    // 이렇게 해서 하나하나 접근 		it.next() 반환형은 Object 이다.
	    System.out.println(it.next()); // 객체 반환
	}
	while(it.hasNext()) {//다음 객체가 있는가 ?
		System.out.println("re : " + it.next());	// 결과 출력이 나오지 않음
		// 끝에 도달 할 경우 다시 만들어도 작동 안함 다시 만들어야 사용 가능
	}
//===================================================================================================
	// ListIterator : 단방향인 Iterator , List 에서만 사용
	// ListIterator는 양방향이어서 앞으로 돌아올 수 있음. set에서 사용 불가능.
	System.out.println("===== 양방향 =====");
	ListIterator<Dog> lit = list.listIterator();
	System.out.println("===== Has Next =====");
	while(lit.hasNext()) {
	    System.out.println(lit.next());
	}
	System.out.println("===== Has Previous =====");
	while(lit.hasPrevious()) {
	    System.out.println(lit.previous());
	}
	System.out.println("=========== Previous ================");
	while(lit.hasPrevious()) {// 내 앞에 값이 존재 하니 ?
		// 앞/뒤 진행 한뒤 반대로 진행 해야 정상적으로 출력을 할 수 있다.
		System.out.println(lit.previous());
	}
	System.out.println("===========  Has Next ==========");
	while(lit.hasNext()) {
		System.out.println(lit.next());
	}
    }
}

