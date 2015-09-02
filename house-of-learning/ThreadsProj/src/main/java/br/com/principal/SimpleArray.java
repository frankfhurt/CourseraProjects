package br.com.principal;

import java.util.Arrays;
import java.util.Random;

public class SimpleArray {

	private final int[] array;
	private int writeIndex = 0;
	private final static Random generator = new Random();

	public SimpleArray(int size) {
		array = new int[size];
	}

	public synchronized void add(int value) {
		int position = writeIndex;
		int dormir = generator.nextInt(100);

		try {
			System.out.println("A thread vai dormir por " + dormir + "millis");
			Thread.sleep(dormir);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		array[position] = value;

		System.out.println(Thread.currentThread().getName() + " escreveu " + value + " no elemento " + position);

		++writeIndex;
		System.out.println("Proximo indice para escrever: " + writeIndex);
	}

	@Override
	public String toString() {
		return "\nConteudo do SimpleArray:\n" + Arrays.toString(array);
	}

}
