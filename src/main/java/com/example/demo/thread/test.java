package com.example.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class test {
	public static void main(String[] args) {
	    Executor executor = new ThreadPoolExecutor(8,12,5,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(8),new ThreadPoolExecutor.CallerRunsPolicy());
	    for (int i = 0; i < 8; i++) {
	    	executor.execute(new ScorttThread(i, "123", "213"));
		}
	}
}
