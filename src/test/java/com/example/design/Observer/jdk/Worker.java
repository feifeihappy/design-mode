package com.example.design.Observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class Worker implements Observer, DisplayWork {
 
	private String name;
	private String des;
	
	public Worker(String name, String des) {
		super();
		this.name = name;
		this.des = des;
	}
 
 
	@Override
	public void display() {
		System.out.println("我在" + des + "了！");
	}
 
 
	public String getName() {
		return name;
	}
 
 
	public void setName(String name) {
		this.name = name;
	}
 
 
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("老板来了，" + name + "好好干活啦！");
		this.display();
	}
}