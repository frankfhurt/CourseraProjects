package br.com.principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadCreator {

	public static void main(String[] args) {
		
		// new ThreadCreator().threadStart();
		// new ThreadCreator().threadExecutor();
		new ThreadCreator().sharedArrayTest();
	}

	public void threadStart(){
		System.out.println("Criando Threads");
		
		Thread thread1 = new Thread(new PrintTask("task1"), "Thread1");
		Thread thread2 = new Thread(new PrintTask("task2"), "Thread2");
		Thread thread3 = new Thread(new PrintTask("task3"), "Thread3");
		
		System.out.println("Threads criadas!\nStartando threads");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("Threads iniciadas, main finalizado\n");
	}
	
	public void threadExecutor(){
		
		PrintTask task1 = new PrintTask("task1");
		PrintTask task2 = new PrintTask("task2");
		PrintTask task3 = new PrintTask("task3");
		
		System.out.println("Iniciando Executor");
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.execute(task1);
		executor.execute(task2);
		executor.execute(task3);
		
		executor.shutdown();
		
		System.out.println("Taks started, main ends.\n\n");
	}
	
	public void sharedArrayTest(){
		SimpleArray sharedSimpleArray = new SimpleArray(6);
		
		ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
		ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(writer1);
		executor.execute(writer2);
		
		executor.shutdown();
		
		try {
			boolean tasksEnded = executor.awaitTermination(500, TimeUnit.MILLISECONDS);
			if (tasksEnded) {
				System.out.println(sharedSimpleArray);
			} else {
				System.out.println("Timeout enquanto esperava a thread terminar.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
