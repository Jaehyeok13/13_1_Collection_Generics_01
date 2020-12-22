package com.jh.example.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.jh.example.map.model.vo.Snack;

public class MapController {
    public void doMap() {
	Map m = new HashMap();
	// put(K key, V value) : 키와 값 추가
	m.put("새우깡", new Snack("짠맛",1500));
	m.put("포테이토칩", new Snack("고소한 맛",1000));
	m.put("양파링",new Snack("양파맛",1300));
	m.put("오잉",new Snack("약간 매운맛",1300));
	// String 형태라서 자동 hashcode 와 equals 오버 라이딩 되서 중복 안됨
	System.out.println("===== 과자 입력 결과 =====\n" + m);
	// key = value 형식으로 저장이 된다.
	m.put("새우깡", new Snack("신맛",1500));
	// 키 중복 저장 불가(set 방식), 값은 중복 저장 가능(list방식)
	// 키 가 일치할 경우 키에 해당하는 값을 덮어 씌운다.
	System.out.println("===== 키일치 값 변경 =====\n" + m);
	// 구현 클래스 HashMap, HashTable, LinkedHashMap, Properties, TreeMap
	// contains 메소드 활용
	// containsKey(Object key) : key 가 있으면 true 반환
	// containsValue(Object key) : vlaue(값) 가 있으면 true 반환
	boolean key = m.containsKey("새우깡");
	System.out.println("containsKey(새우깡) : " + key);
	boolean value = m.containsValue(new Snack("양파맛",1300));
	System.out.println("containsValue(양파맛) : " + value); // 결과 false 객체가 구분이 못하기 때문
	// equals(), hashCode 오버라이딩 후 정상 true 확인
	
	// get(Object key ) : 키의 값 반환 값은 바로 검색이 가능하지 않기 때문이다.
	System.out.println("===== 키로값 확인 =====\nm.get(새우깡) : " + m.get("새우깡"));
	System.out.println(m.get("홈런볼")); // 없을시 null 반환
// =====================================================
	// map 엘리먼트 접근하기
	// 1. values() : 모든 value 를 Collection 에 담아 반환
	//		키 값을 제외 하고 출력한다.
	System.out.println("===== 키값 제외 =====\n"+m.values());
	// 2. keySet() : 모든 키를 Set 에 담아서 반환
	//		반환값이 set 이여서 Set 만들어야 한다.
	Set set1 = m.keySet();
	Iterator li = set1.iterator();
	System.out.println("===== keySet() =====");
	while(li.hasNext()) {
	    Object o = li.next();	//Object(부모) 키값 전달
	    System.out.printf("키 : %s, 값 : %s\n",o,m.get(o)); // 키 값을 가지고 온후 키값에 있는 값 추출
	}
	// 향상된 for
	System.out.println("===== 향상된 for =====");
	for(Object o : m.keySet()) {
	    System.out.printf("키 : %s, 값 : %s\n",o,m.get(o)); // 키 값을 가지고 온후 키값에 있는 값 추출
	}
	System.out.println("===== keySet() =====");
	// 3. entrySet() : 모든 entry객체(키 + 값의 쌍) 를 set 에 담아 반환
	Set set2 = m.entrySet();	// 담아 놓고 사용 해야 한다.
	Iterator li2 = set2.iterator();
	System.out.println("===== entrySet() =====");
	while(li2.hasNext()) {
	    Map.Entry me = (Map.Entry)li2.next();
	    System.out.printf("키값 : %s, 값 : %s\n",me.getKey(),me.getValue());
	}
	System.out.println("===== 향상된 for =====");
	for(Object o : set2) {
	    Map.Entry me = (Map.Entry)o;
	    System.out.printf("키값 : %s, 값 : %s\n",me.getKey(),me.getValue());
	}
	System.out.println("===== entrySet() =====");
    }
}
