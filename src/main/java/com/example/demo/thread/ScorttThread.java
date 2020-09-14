package com.example.demo.thread;
/**
 * @author 定义一个线程
 * @author scortt
 *
 */
public class ScorttThread implements Runnable{
	private int a;
	private String b;
	private String c;
	
	public ScorttThread(int a,String b,String c) {
		this.a=a;
		this.b=b;
		this.c=c;
	} 
	
	public void run() {
		System.out.println(a+b+c);
		for (int i = 0; i < 1000; i++) {
			System.out.println("线程"+a+"已经处理数据"+i);
		}
	}

}
