package com.jh.example.sort.model.vo;

public class Information {
    private String name;
    private int age;
    private String address;
    
    public Information() {}
    
    public Information(String name, int age, String address) {
	this.name = name;
	this.age = age;
	this.address = address;
    }
    public void setName(String name) {
	this.name = name;
    }
    public String getName() {
	return name;
    }
    public void setAge(int age) {
	this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setAddress(String address) {
	this.address = address;
    }
    public String getAddress() {
        return address;
    }
    @Override
    public String toString() {
        return "이름 : "  + name + " 나이 : " + age + " 주소 : " + address;
    }
    // 개발자의 의도에 따라 name 만 같으면 두 객체를 같게 볼 수도 있고 name,age 두개 또는 3개가 다 같아야
    // 같은것으로 봐야 할지 모르기 때문이다.
    // 따라서 equals() 메서드를 오버라이드(재정의) 해서 두 객체의 내용이 같은지를 정의한다.
    @Override
    public boolean equals(Object obj) {
	// 객체 비교
	if(this == obj) { // 내 자신과 매개 변수로 들어온 obj 가 같다면(메모리 주소가) 당연히 같다
	    return true;
	}
	if(obj == null) { // 매개 변수로 들어온 obj 가 null 이면 당연히 같지 않다.
	    return false;
	}
	// getClass() 전체 선언된 클래스를 말한다. 간단한 정보 
	if(getClass() != obj.getClass()) {
	    // 내 클래스 정보와 obj의 클래스 정보가 같지 않다면
	    // 우리는 당연히 동일 하지 않다.
	    return false;
	}
	// 필드에서 동일 한지 안한지 비교를 한다. 
	// 개발자가 생성한 클래스
	Information other = (Information) obj;
	//				다형성 형변환
	// String 같은 경우 
	// 생성한 클래스의 비교할 변수 확인
	if(name == null) { // 내안에 있는 name 값이 없을 때(null) 인경우
	    if(other.name != null) {
		// 나는 null 인데 매개변수 name 이 null 이 아닐때 , 서로 다르다.
		return false;
	    }
	}else if(!name.equals(other.name)) {
	    // 생성자 name 이 있는데 other의 name 이 같지 않으면 서로 다르다
	    return false;
	}
	// 숫자인 경우 값만 같지지만 비교한다. / 같지 않으면 다르다.
	if(age != other.age) {
	    return false;
	}
	if(address == null) {
	    if(other.address != null) {
		return false;
	    }
	}else if(!address.equals(other.address)){
	    return false;
	}
	return true;
    }
    // eclipse(IDE) 에서 equals() 메서드를 generate 시켜주는 기능을 가지고 있는데 자연스럽게 hashCode() 도 함께
    // generate 시켜준다. 즉,equals()와 hashCode() 를 같이 재정의하게 한다.
    // hashCode 도 함께 정의하는 이유는 hash를 사용 하는 Collection(HashSet,HashMap,..)
    // 사용시 같다고 생각하지 않기 때문에 문제가 발생 할 수 있다.
    // 그렇기 때문에 equals로 같은 객체라면 반드시 hashCode 도 같은 값이여야만 한다.
    //하지만 반대로 hashCode가 같은 값이더라도 equals로 같은 객체가 아닐 수 있다는 것을 유의해야 한다.
    // 그렇기 때문에 hashCode 도 같은 파라미터를 이용 해야 한다.
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + age;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	
	return result;
    }
}
