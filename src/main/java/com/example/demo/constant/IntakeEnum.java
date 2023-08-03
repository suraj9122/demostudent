package com.example.demo.constant;

public enum IntakeEnum {
	JAN("JAN");

	String value;

	IntakeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
