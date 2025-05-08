package com.example.design.Observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class BossSubject extends Observable {
	
	public void registerObserver(Observer observer) {
		addObserver(observer);
	}
 
 
 
 
	public void removeObserver(Observer observer) {
		removeObserver(observer);
		System.out.println("成功告诉观察者我不需要被通知了");
	}
 
 
	public void setChanged() {
		super.setChanged();
	}
	
	public void notifyAllObserver() {
		System.out.println("开始通知");
		notifyObservers();
		System.out.println("所有的都已通知！");
	}
 
 
}