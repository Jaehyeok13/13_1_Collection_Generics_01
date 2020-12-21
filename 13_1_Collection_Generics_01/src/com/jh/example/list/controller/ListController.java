package com.jh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jh.example.list.model.compare.StudentComparator;
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
	System.out.println(exList.size());
	// 그 객체만 들어 갈수 있게 해주는 <> 제네릭 
	// 특정 타입만 다루지 않고, 여러 종류의 타입으로 변신할 수있도록 클래스나 메소드를 일반화시키는 기법
	// -<E>,<K>,<V>등등 : 타입 매게 변수(요소타입을 일반화한 타입)
	// 예) 제네릭 백터 : Vector<E>
	// E에 특정 타입으로 구체화,
	// 정수만 다루는 백터 Vector<Integer>
	// 문자열만 다루는 벡터 Vector<String>
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
	 list.remove(new Student("테스트",0)); // -> 이렇게 선언시 삭제 안될 수 있다. 
	// new Studnet() 새로운 객체 선언으로 인하여 서로 같은 객체인지 자바는 인지 할 수 없기 때문이다.
	// equals() 메서드를 오버라이드 하여 재정의로 같은 객체 인지 시켜줘야 한다.
	System.out.println("remove(Object o)   : " + list);
	// new Student 가 주소값을 가져와서 비교하기 때문에 

	// remove (int index) : 해당 index번째 인덱스에 있는 객체 삭제
	list.remove(1);
	System.out.println("remove(Index i)    : " + list);
// =======================================================
	// 정렬 방법 1. Collections 이용 , 2. List 안의 sort 메서드 이용
	// compareTo() 메서드를 활용 하기 때문에 해당 interface 메소드를 가지고 잇는 interface class 인
	// Comparable 을 implements한 object만 sort의 사용이 가능하다
	
	// 배열을 유용하게 사용하기 위한 클래스 : Array
	// 컬렉션을 유용하게 사용하기 위한 클래스 : Collections
	// 객체는 정렬기준이 정해진것이 없다.
	Collections.sort(list);
	System.out.println("===== 정렬 =====\nCollections.sort(Object o)이름             : " + list);
	// Student cannot be cast to java.lang.Comparable
	// java.lang.Error: Unresolved compilation problem
	/*
	 정렬의 기준이 현재 없다.-> Comparable, Comparator interface 구현하여 정렬 기준을 만들어 준다.
	 interface 메소드는 implements하는 클레스에서 반드시 구현해야 하기 때문에 Comparable<T>를 implements하는 
	 모든 클레스들은 해당 메소드를 구현해야한다.
	   Object o.
	   Collections.sort((java.util.List<T>) (list);
	 -> T 객체에 Comparable 을 상속받아  compareTo 메소드 재정의를 통해 정렬 구현 (한 개의 정렬)
		Collections.sort(List<T> list, Comparator<T> c)  지정한 Comparator클래스에 의한 정렬 (여러 개의 정렬)
	 	Comparable, Comparator 인터페이스를 구현해서 이 객체 안에서는 이 필드를 가지고 정렬 기준을 세워줘야 한다.
	 
	 list 에 Student 객체가 들어가 있다.
	 java.lang : import 없이 사용 할 수 있는 패키지 
	 기본적으로 사용 할 정렬 기준 : Comparable
	 추가적으로 사용 할 정렬 기준 : Comparator
	*/

	// 정렬 방법2. List 안에 있는 sort() 이용
	// 
	list.sort(null);
	System.out.println("List.sort(null)이름                        : " + list);
	list.sort(Comparator.reverseOrder());
	System.out.println("list.sort(Comparator.reverseOrder()이름내림 : " + list);
	// 한번 comparable 메서드 정의 했기 때문에 다른 기준으로 정렬 하기 위해서 compartor 매개 변수 전달로 인터페이스 생성
	list.sort(new StudentComparator()); // model class type의 데이터 비교를 위한 Comparator 전달
	System.out.println("list.sort(new StudentComparator())점수     : " + list + "\n===== 수정 =====");

	// Type safety: The expression of type Comparator needs unchecked conversion to conform to Comparator<? super Student>
	/*
	 ArrayList 일 경우  Comparable을 implements한 오브젝트라면 null값을 입력해 오름차순으로 정렬할 수 있다.
	반대로 내림차순은 Comparator.reverseOrder() 메소드를 통해 리턴받은 comparator를 통해 가능하다.
	sort 메서드 사용 하기 위한 2가지 방법
	1.sort 메소드의 메게변수로 model class type에 적용 가능한 Comparator를 전달한다.
	2.model class에 Comparable을 implements한 뒤 compareTo 메소드를 override한다.
	 */
// ===========================================
	// 수정 
	// set(int indext, E e) : index번째 인덱스에 있는 요소를 E 요소로 수정
	list.set(2, new Student("도대담",31));	
	System.out.println("list.set(int index, E e) : " + list);
	// get(int index) : index번째 인덱스에 있는 요소를 가지고 온다.
	
	// 제네릭을 사용 하므로 다운 캐스팅을 하지 않아도 된다.
//	 Student s = (Student)list.get(2);
	Student s = list.get(2);
//	 Object o = list.get(2);
	 System.out.println("list.get(2)              : [" + s +"]");
	 // subList(int index1, int index2) : index1 번째 부터 index2 까지의 인덱스의 리스트 반환
	 List<Student> copyList = new ArrayList<Student>(list.subList(2, 5));
	 System.out.println("list.subList(fromIndex, toIndex) : " + copyList);
        // contains(Object o) : o 가 리스트에 존재한다면 true 반환
        // indexOf(Object o) : o 가 리스트에 위치하는 인덱스 번호 반환
	
	 // index 값으로 위치 찾기
	 if(list.contains(new Student("남나눔",90))) {
	     int index = list.indexOf(new Student("남나눔",90));
	     Student ss = list.get(index);
	     System.out.println("===== 인덱스 위치 찾기 =====\n인덱스 번호 : " + index +" 값 :  "+ ss);
	 }
	 // clear() : 저장된 모든 객체 삭제
	 // isEmpy() : 리스트가 비어있는지 확인
	 list.clear();
	 System.out.println("list.clear : " + list);
	 System.out.println("list.isEmpty : " + list.isEmpty());
	 
    }
}
