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
    @Override
    public boolean equals(Object obj) {
	
	return super.equals(obj);
    }
    
}
