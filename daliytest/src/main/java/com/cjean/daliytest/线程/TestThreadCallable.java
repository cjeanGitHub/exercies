package com.cjean.daliytest.Ïß³Ì;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadCallable {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Race race = new Race();
		ExecutorService serv = Executors.newFixedThreadPool(2);
		Future<String> rs1 = (Future<String>) serv.submit(race,"rabbit");
		Future<String> rs2 = (Future<String>) serv.submit(race,"totuoce");

		System.out.println("rs1==="+rs1);
		System.out.println("rs2==="+rs2);
		try {
			String s1 = (String)rs1.get();
			String s2 = (String)rs2.get();
			System.out.println("s1==="+s1);
			System.out.println("s2==="+s2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		serv.shutdown();
		
	}

}
class RaceCallable implements Callable<String>{
	private String winner;
	public boolean getWinner(int step) {
		if(100 == step) {
			winner = Thread.currentThread().getName()+"-resultFlage-winner-->"+step;
			return true;
		}else {
			return false;
		}
	}

	public String call() throws Exception {
		for(int step=1;step<101;step++) {
			if(null!=winner) {
				System.out.println(winner);
				break;
			}else {
				System.out.println(Thread.currentThread().getName()+"-->"+step);
			}
			boolean resultFlage = getWinner(step);
		}
		return winner;
	}
	
}

