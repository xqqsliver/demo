package com.example.demo.model;

public abstract class AbstractPizzaFactoryModel {
	public void orderPizza(String type) {
		Pizza pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

	}

	abstract Pizza createPizza(String type);

}
