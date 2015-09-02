package br.com.principal;

public class ArrayWriter implements Runnable {

	private final SimpleArray sharedSimpleArray;
	private final int startValue;

	public ArrayWriter(int value, SimpleArray array) {
		sharedSimpleArray = array;
		startValue = value;
		System.out.println("malhacaoooooooooo!!!!!!");
	}

	@Override
	public void run() {
		for (int i = startValue; i < startValue + 3; i++) {
			sharedSimpleArray.add(i);
		}
	}
}
