package com.example.demo.model;

public class FactoryModel extends AbstractPizzaFactoryModel {
	public static void main(String args[]) {
		FactoryModel s = new FactoryModel();
		s.orderPizza("1");
	}

	@Override
	Pizza createPizza(String type) {
		System.out.print("FactoryModel");
		Pizza s = null;
		if (type == "1") {
			s = new PizzaImpl();
		}
		if (type == "2") {
			s = new PizzaImpl2();
		}
		return s;
	}

}
