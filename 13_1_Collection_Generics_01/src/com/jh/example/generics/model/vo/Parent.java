package com.jh.example.generics.model.vo;

public class Parent<S,D> {
    private S s;
    private D d;

    public Parent() {
    }

    public Parent(S s, D d) {
	this.s = s;
	this.d = d;
    }
    public S getS() {
	return s;
    }
    public void setS(S s) {
	this.s = s;
    }
    public D getD() {
	return d;
    }
    public void setD(D d) {
	this.d = d;
    }
    @Override
	public String toString() {
		return "Parent [s=" + s + ", d=" + d + "]";
	}	
}
