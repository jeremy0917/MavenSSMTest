package com.yjy.maventest.designmodel;

import org.junit.Test;

import com.yjy.maventest.designmodel.工厂模式.Animal;
import com.yjy.maventest.designmodel.工厂模式.AnimalFactory;
import com.yjy.maventest.designmodel.抽象工厂模式.AbstractFactory;
import com.yjy.maventest.designmodel.抽象工厂模式.Animal2;
import com.yjy.maventest.designmodel.抽象工厂模式.Color;
import com.yjy.maventest.designmodel.抽象工厂模式.FactoryProducter;
import com.yjy.maventest.designmodel.观察者模式.CountDownTimer;
import com.yjy.maventest.designmodel.观察者模式.NagaTimer;
import com.yjy.maventest.designmodel.观察者模式.TimeSubject;

public class TestDesignModel {
	@Test
	public void test1() {
		//测试工厂模式
		AnimalFactory af = new AnimalFactory();
		
		Animal a1 = af.getAnimal("DOG");
		Animal a2 = af.getAnimal("CAT");
		Animal a3 = af.getAnimal("DUCK");
		a1.sleep();
		a2.sleep();
		a3.sleep();
	}
	
	@Test
	public void test2(){
		//测试抽象工厂
		
		AbstractFactory animalFactory = FactoryProducter.getFactory("ANIMAL2");
		Animal2 dog = animalFactory.getAnimal2("DOG");
		Animal2 cat = animalFactory.getAnimal2("CAT");
		Animal2 duck = animalFactory.getAnimal2("DUCK");
		dog.sleep();
		cat.sleep();
		duck.sleep();
		
		AbstractFactory colorFactory = FactoryProducter.getFactory("COLOR");
		Color red = colorFactory.getColor("RED");
		Color bule = colorFactory.getColor("BLUE");
		Color white = colorFactory.getColor("WHITE");
		red.fill();
		bule.fill();
		white.fill();
	}
	
	@Test
	public void test3(){
		NagaTimer subject = new NagaTimer();
		
		long countdown = System.currentTimeMillis();
		CountDownTimer observer = new CountDownTimer("A", countdown);
		
		subject.registerObserver(observer);
		subject.notifyObservers();
		
	}
}
