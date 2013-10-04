package com.huko.testing;

public class NanoTimeTest {

	public static void main(String[] args) {
	    
		long startTime = System.nanoTime();
		for(int i = 0; i <= 9000000; i++) {
			long a = System.nanoTime();
		}
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime)/1000000);
	}

}
