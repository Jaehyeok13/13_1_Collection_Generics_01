package com.jh.example.generics.model.vo;

public class Child<S, D, N> extends Parent<S, D>{
    private N n;
    public Child() {}
    public Child(S s, D d, N n) {
	super(s,d);
	this.n = n;
    }
    public N getN() {
	return n;
    }
    public void setN(N n) {
	this.n = n;
    }
    @Override
    public String toString() {
	return "Child [n=" + n + ", toString()=" + super.toString() + "]";
    }
}
