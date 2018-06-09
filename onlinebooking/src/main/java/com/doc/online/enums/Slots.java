package com.doc.online.enums;

public enum Slots {
	MORNING(1), EVENING(2);

	private int slot;

	private Slots(int slot) {
		this.slot = slot;
	}

	public int value() {
		return slot;
	}

}
