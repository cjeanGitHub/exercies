package com.cjean.daliytest.Ïß³Ì;

import java.util.concurrent.*;

public class TestThreadCallable {

	private static volatile boolean stopFlage = false;

	public void setStopFlage(boolean stopFlageArg){
		stopFlage=stopFlageArg;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		RaceCallable raceCallable = new RaceCallable();
		ExecutorService serv = Executors.newFixedThreadPool(2);

		Future<String> rs1 = (Future<String>) serv.submit(raceCallable);
		Future<String> rs2 = (Future<String>) serv.submit(raceCallable);

		try {
			String s1 = (String)rs1.get();
			String s2 = (String)rs2.get();
			System.out.println("s1==="+s1);
			System.out.println("s2==="+s2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		if (stopFlage){
			serv.shutdownNow();
		}
	}

}
class RaceCallable implements Callable<String>{
	private String winner;

	public boolean getWinner(int step) {
		if(100 == step) {
			winner = Thread.currentThread().getName()+" is winner ,step :"+step;
			return true;
		}else {
			return false;
		}
	}

	public String call() throws Exception {
		for(int step=1;step<101;step++) {
			if(null!=winner) {
				TestThreadCallable t = new TestThreadCallable();
				t.setStopFlage(true);
				System.out.println(winner);
				break;
			}else {
				System.out.println(Thread.currentThread().getName()+" is running , step:"+step);
			}
			boolean resultFlage = getWinner(step);
			if(resultFlage){
				return winner;
			}
		}
		return winner;
	}
	
}

