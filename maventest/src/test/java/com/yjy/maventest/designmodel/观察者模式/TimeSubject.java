package com.yjy.maventest.designmodel.观察者模式;

//被观察者,也就是主题
public interface TimeSubject {
	
	//提供增加观察者方法
	public void registerObserver(TimerObserver o);  
	
	//提供删除观察者方法
	public void removeObserver(TimerObserver o);  
	
	//提供通知观察者方法
	public void notifyObservers(); 
}


