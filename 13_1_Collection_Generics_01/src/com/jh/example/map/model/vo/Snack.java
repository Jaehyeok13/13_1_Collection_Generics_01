package com.jh.example.map.model.vo;

public class Snack {
    private String flavor;
    private int price;
    
    public Snack() {}
    public Snack(String flavor, int price) {
	this.flavor = flavor;
	this.price = price;
    }
    
    public void setFlavor(String flavor) {
	this.flavor = flavor;
    }
    public String getFlavor() {
	return flavor;
    }
    public void setPrice(int price) {
	this.price = price;
    }
    public int getPrice() {
	return price;
    }
    @Override
    public String toString() {
        return flavor + "[" + price + "원]";
    }
    
    public boolean equals(Object o) {
	if(this == o) {
	    return true;
	}
	if(o == null) {
	    return false;
	}
	if(getClass() != o.getClass()) {
	    return false;
	}
	Snack other = (Snack)o;
	if(flavor == null) {
	    if(other.flavor != null) {
		return false;
	    }
	}else if(!flavor.equals(other.flavor)) {
	    return false;
	}
	if(price != other.price) {
	    return false;
	}
	return true;
    }
    public int hashCode(){
	int prime = 31;
	int result = 1;
	prime = prime * result + ((flavor == null) ? 0 : flavor.hashCode() );
	prime = prime * result + price;
	return prime;
    }
}
