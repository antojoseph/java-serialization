package com.example.serialization;

public class Car {
	

	public String make;
	public String model;
	public int year;
	
	public Car(String make, String model, int year) {
		this.make = make;
		this.model=model;
		this.year = year;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	public void setModel(String model) {
		this.model=model;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public int getYear() {
		return year;
	}

}
