package com.yjy.maventest.designmodel.抽象工厂模式;

public class ColorFactory extends AbstractFactory{

	@Override
	public Color getColor(String color) {
		if (color == null || "".equals(color)) {
			return null;
		}
		
		if ("RED".equals(color)) {
			return new Red();
		} else if ("BLUE".equals(color)) {
			return new Blue();
		} else if ("WHITE".equals(color)) {
			return new White();
		}
		return null;
	}

	@Override
	public Animal2 getAnimal2(String animal) {
		return null;
	}
	
}
