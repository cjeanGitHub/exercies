package com.cjean.daliytest.Ïß³Ì;

public class TestThread {
	
	

	public static void main(String[] args) {
		Race race = new Race();
		new Thread(race,"rabbit").start();
		new Thread(race,"totouce").start();
	}

}
class Race implements Runnable{
	private String winner;

	public void run() {
		for(int step=1;step<101;step++) {
			if(null!=winner) {
				System.out.println(winner);
				break;
			}else {
				System.out.println(Thread.currentThread().getName()+"-->"+step);
			}
			boolean resultFlage = getWinner(step);
		}
	}
	
	public boolean getWinner(int step) {
		if(100 == step) {
			winner = Thread.currentThread().getName()+"-resultFlage-winner-->"+step;
			return true;
		}else {
			return false;
		}
	}
	
}

