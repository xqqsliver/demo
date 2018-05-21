package com.example.demo.model;

public class SingleModel {
	private static SingleModel s = null;

	public static SingleModel getSingleInstance() {
		if (s == null) {
			synchronized (SingleModel.class) {
				if (s == null) {
					s = new SingleModel();
				}
			}
		}
		return s;

	}

}
