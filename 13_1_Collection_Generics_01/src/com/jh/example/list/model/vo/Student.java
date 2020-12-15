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

    @Override
    public int hashCode() {
	// hashCode 란  각 객체의 주소값을 기반으로 생성된 정수값 
	final int prime = 31;
	// 컴퓨터 계산 할 때 적당한 숫자는 31이기 때문에 이 소수를 가지고 계산을 한다. 또한 짝수를 곱했을 때 오버플로우 되면 정보 손실일 발생
	// 할수 있기 때문이다. 이진수에서 2를 곱하면 비트가 왼쪽으로 한 비트식 이동하기 때문이다. 홀수 중 31의 장점은 31 * i 
	// (i < 5) - i 와 같기 때문에 곱셈 대신 비트 이동 및 뺄셈으로 처리하여 성능면에서 좀 더 이득이 있기 때문이다.
	int result = 1;
	return result;
    }
    
    @Override
    public int compareTo(Object o) {
	
	
        return 0;
    }
}