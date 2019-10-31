package com.cjean.daliytest.jvm;

public class TestJvm {
	 /**
	   * @param args
	   */
	  public static void main(String[] args) {
	    System. out .println( " 内存信息 :" + toMemoryInfo());

	    System. out .println( " ========================:" );
	    String s = null;
	    for(int i=0;i<500000000;i++) {
	    	s = "发顺gdgwetet丰"+i;
	    }
	    System. out .println( " ========================:" );
	    System. out .println( " 内存信息 :" + toMemoryInfo());
	    System.gc();
	    System. out .println( " ========================:" );
	    System.out .println( " 内存信息 :" + toMemoryInfo());
	    
	  }
	  
	  /**
	   * 获取当前 jvm 的内存信息
	   *
	   * @return
	   */
	  public static String toMemoryInfo() {
	  
	    Runtime currRuntime = Runtime.getRuntime ();
	    
	    System.out .println( " maxMemory :" + (currRuntime.maxMemory()/1024/ 1024));
	    System.out .println( " freeMemory :" + (currRuntime.freeMemory()/1024/ 1024));
	    System.out .println( "  totalMemory:" + (currRuntime.totalMemory()/1024/ 1024));
	    System.out .println( "availableProcessors  :" + (currRuntime.availableProcessors()));
	    int nFreeMemory = ( int ) (currRuntime.freeMemory() / 1024 / 1024);
	    int nTotalMemory = ( int ) (currRuntime.totalMemory() / 1024 / 1024);
	    return nFreeMemory + "M/" + nTotalMemory +"M(free/total)" ;
	  }

}
