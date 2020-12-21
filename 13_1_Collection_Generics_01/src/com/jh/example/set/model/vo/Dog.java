package com.jh.example.set.model.vo;

public class Dog {
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
	return getWeight();
    }
    @Override
    public String toString() {
        return name + "(" + weight + "kg)";
    }
}
