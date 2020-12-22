package com.jh.example.set.model.vo;

public class Dog implements Comparable{
    private String name;
    private double weight;
    public Dog() {}
    public Dog(String name, double weight) {
	this.name = name;
	this.weight = weight;
    }
    public void setName(String name) {
	this.name = name;
    }
    public String getName() {
	return name;
    }
    public void setWeight(double weight) {
	this.weight = weight;
    }
    public double getWeight() {
	return weight;
    }
    @Override
    public String toString() {
        return name + "(" + weight + "kg)";
    }
    @Override
    public boolean equals(Object o){
	if(this == o) {
	    return true;
	}
	if(o == null) {
	    return false;
	}
	if(getClass() != o.getClass()) {
	    return false;
	}
	Dog other = (Dog)o;
	if(name == null) {
	    if(other.name != null) {
		return false;
	    }
	}else if(!name.equals(other.name)) {
	    return false;
	}
	if(weight != other.weight) {
	    return false;
	}
	return true;
    }
    public int hashCode() {
	int prime = 31;
	int result = 1;
	prime = prime * result + ((name == null) ? 0 : name.hashCode());
	prime = prime * result + (int)weight;
	return prime;
    }
    @Override
    public int compareTo(Object o) {
	// 정렬 기준을 만들어 준다
	String other = ((Dog)o).getName();
	return name.compareTo(other);
    }
}
