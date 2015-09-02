package br.com.principal;

import java.util.Random;

public class PrintTask implements Runnable {

	private final int sleepTime;
	private final String taskName;
	private final static Random generator = new Random();

	public PrintTask(String taskName) {
		super();
		this.sleepTime = generator.nextInt(5000);
		this.taskName = taskName;
	}

	@Override
	public void run() {
		try {
			System.out.println(taskName + " vai dormir por " + sleepTime + " millisegundos");
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			System.out.println("A thread " + taskName + " foi terminada prematuramente.");
		}
		
		System.out.println(taskName + " terminou de dormir.");
	}

}
