package com.example.demo.component;

public class ComponentC {
public ComponentC() {
	// TODO Auto-generated constructor stub
}
	private ComponentB com;

	public ComponentC(ComponentB com) {
		this.com = com;
	}

	public ComponentB getCom() {
		return com;
	}

	public void setCom(ComponentB com) {
		this.com = com;
	}

}
