package com.jh.example.map.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.jh.example.map.model.vo.Snack;
import com.jh.example.map.model.vo.compare.SnackComperator;

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
	
	// map TreeMap() 정렬
	System.out.println("====== Treey Map() =====");
	Map m2 = new TreeMap();
	m2.putAll(m);
	System.out.println("m2.putAll(m) : " + m2);
	
	// 정렬 클래스 생성후 적용 한다.
	Map m3 = new TreeMap(new SnackComperator()); 	// 가격순으로 오름차순
	m3.putAll(m2);
	System.out.println("m3.putAll(m2)" + m3);
	// size() map 저장된 entry 수 반환
	System.out.printf("m3의 개수 m3.size(%d)\n",m3.size());
	
	// remove(Object key) : 해당 key 의 entry 삭제
	System.out.println(m3.remove("양파링"));		// key 값만 삭제 가 된다.
	// remove(Object key, Object value)
	System.out.println(m3.remove("오잉", new Snack("약간 매운맛",1300)));
	System.out.println(m3);
	
	// clear() : 모든 entry 삭제
	// isEmpty() : map 이 비어있으면 true 반환
	m3.clear();
	System.out.println("m3.clear() : " + m3 );
	System.out.printf("m3.isEmpty(%B)\n",m3.isEmpty());
    }
    public void doProperties() {
	// 키와 값을 String 타입으로 제한한 Map 컬렉션
	// 주로 Properties 는 프로퍼티 (*.properties)파일을 읽어 들일 때 주로 사용
	// - 옵션정보, 데이터베이스 연결 정보, 국제화(다국어) 정보를 기록하여 텍스트 파일로 활용
	// - 애플리케이션에서 주로 변경이 잦은 문자열을 저장하여 관리하기 때문에 유지보수를 편리하게 만들어준다.
	// - 키와 값이 '='기호로 연결되어 있는 텍스트 파일로 ISO 8859-1 문자셋으로 저장되고, 한글은 유니코드로 변환되어 저장
	Properties prop = new Properties();
	// prop.put(1,10);  	       	pur() 메소드는 HashTable 상속 받아서 사용 한것
	prop.setProperty("채소","오이");
	prop.setProperty("과일","사과");
	prop.setProperty("간식","젤리");
	prop.setProperty("채소","피망"); // map 과 같이 키가 값을 경우 value 값을 덮어 버린다.
	System.out.println("prop : "+ prop);
	// getProperty(key, defaultValue) : key 를 통해 value 반환
	System.out.printf("prop.getProperty('채소') : %s\n",prop.getProperty("채소"));
						// getProerty(String key) : key 를 통해 value 반환
	System.out.printf("prop.getProperty('견과') : %s\n",prop.getProperty("견과"));
						// key 가 존재 하지 않을 경우 value 값으로 null 을 호출한다.
	System.out.printf("prop.getProperty('채소'.'양파') : %s\n",prop.getProperty("채소","양파"));
						// key 가 있을때 value 변경되지 않고 값을 출력한다.
	System.out.printf("prop.getProperty('견과','땅콩') : %s\n", prop.getProperty("견과","땅콩"));
						// getProperty key 가 없을 경우 value 가 있을 경우 value 값을 출력한다.
	// 구버전	Iterator 메서드랑 같다.
	Enumeration e = prop.propertyNames();
	while(e.hasMoreElements()) {
	    String key = (String)e.nextElement();		// = next() 메서드랑 같다.
	    System.out.printf("키 : %s / 값 :  %s \n", key,prop.getProperty(key));
	}
    }						
    public void fileSave() {
	try(FileOutputStream fos = new FileOutputStream("test.properties")){
	    Properties prop = new Properties();
	    prop.setProperty("title", "Properties Practice");
	    prop.setProperty("width", "1920");
	    prop.setProperty("height", "1080");
	    prop.setProperty("language","Korea");
	    			// 어디에 보낼지 / 주석으로 표신한다.
	    prop.store(fos, "Properties Test File");
	    // out 에 prop 저장 , comments 는 주석으로 저장
	}catch(FileNotFoundException e) {
	    e.printStackTrace();
	}catch(IOException e) {
	    e.printStackTrace();
	}
    }
    public void fileOpen() {
	try(FileInputStream fis = new FileInputStream("test.properties")){
	    Properties prop = new Properties();
	    // 변수명 .load(InputStream inStream)
	    // InputStream 에 있는 파일을 읽어서 저장한다.
	    prop.load(fis);
	    System.out.println(prop);
	}catch(FileNotFoundException e) {
	    e.printStackTrace();
	}catch(IOException e) {
	    e.printStackTrace();
	}
    }
}