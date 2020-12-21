package com.jh.example.list.model.vo;

public class Student implements Comparable{
    private String name;
    private int score;
    
    public Student() { }
    
    public Student(String name, int score) {
	this.name = name;
	this.score = score;
    }
    
    public void setName(String name) {
	this.name = name;
    }
    
    public String getName() {
	return name;
    }
    public void setScore(int score) {
	this.score = score;
    }
    public int getScore() {
	return score;
    }
    
    @Override
    public String toString() {
	return "name : " + name + " score : " + score +" ";
    }
    
    public boolean equals(Object obj) {
	// 객체로 3가지
	// 1. 기본 적인 매개변수 객체가 같은지
	if(this == obj) {
	    return true;
	}
	// 2. 매개변수 받아온 객체 값 존재 확인
	if(obj == null) {
	    return false;
	}
	// 3. 현재 클래스와 매개변수 받은 클래스 확인
	if(getClass() != obj.getClass()) {
	    return false;
	}
	
	Student other = (Student)obj;
	// 매칭으로 같은지 구분할 파라매터 값
	if(name == null) {
	    if(other.name != null) {
		return false;
	    }
	}else if(!name.equals(other.name)) {
	    return false;
	}
	// 매개변수 타입이 String 아닐 경우 
	if(score != other.score) {
	    return false;
	}
	return true;
    }
    
    // hasCode() = 두 객체가 같은 객체인지 확인 하는 메소드 정의된 것을 다시 오버라이딩 해준다. (재정의)
    @Override
    public int hashCode() {
	// hashCode 란  각 객체의 주소값을 기반으로 생성된 정수값 
	final int prime = 31;
	// 컴퓨터 계산 할 때 적당한 숫자는 31이기 때문에 이 소수를 가지고 계산을 한다. 또한 짝수를 곱했을 때 오버플로우 되면 정보 손실일 발생
	// 할수 있기 때문이다. 이진수에서 2를 곱하면 비트가 왼쪽으로 한 비트식 이동하기 때문이다. 홀수 중 31의 장점은 31 * i 
	// (i < 5) - i 와 같기 때문에 곱셈 대신 비트 이동 및 뺄셈으로 처리하여 성능면에서 좀 더 이득이 있기 때문이다.			
	// 따라서 equals()와 hashCode()가 모두 true이면서로 같은 key로 
	int result = 1; 
	result = prime * result + ((name == null) ? 0 : name.hashCode()); 
	result = prime * result + score;
	return result;
    }

    // 인터페이스 재 정의 해준다. 정렬할 기준점을 설정한다.
    @Override
    public int compareTo(Object o) {
			// 비교대상 (나(this) : 비교 주체)
	// 기본적인 하나로 하기 때문에 이 메서드만 사용한다.
	// 기준 : 이름으로 오름 차순 하겠다.
	String other = ((Student)o).getName();
	// 기준이 String 형이기 때문에 String 변수 선언
	
	// 오름차순으로 정렬 / 내림차순 기호 -(마이너스)
	int result = name.compareTo(other);
	// String 클래스에 있는 compareTo 메서드 비교
	
	return result;
	// 3가지 규칙
	// 기준이 되는 데이터가 비교하는 데이터보다 큰 경우 양수 1
	// 							작은 경우 음수 -1
	//							같은 경우 0
    }
}
