package com.example.demo.model;

public class FactoryModel2 extends AbstractPizzaFactoryModel {
	public static void main(String args[]) {
		FactoryModel2 s = new FactoryModel2();
		s.orderPizza("1");
	}

	@Override
	Pizza createPizza(String type) {
		System.out.print("FactoryModel2");
		Pizza z = null;
		if (type == "1") {
			z = new PizzaImpl3();
		}
		if (type == "2") {
			z = new PizzaImpl4();
		}
		return z;
	}

}
