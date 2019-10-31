package com.cjean.daliytest.ÈÝÆ÷;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyTreeMap<K, V> {
	
	public static void main(String[] args) {
		Map tMap = new TreeMap(); 

		tMap.put(4, "4");
		tMap.put(1, "111");
		tMap.put(5, "5");
		tMap.put(3, "3");
		tMap.put(2, "2");
		
		System.out.println(tMap.toString());
		
		Map<Emp, String> tMap2 = new TreeMap(); 


		tMap2.put(new Emp(13,"qq",555), "--1");
		tMap2.put(new Emp(2,"s",55235), "--2");
		tMap2.put(new Emp(63,"ww",215), "--3");
		tMap2.put(new Emp(35,"e",523), "--4");
		tMap2.put(new Emp(23,"r",523), "--5");
		tMap2.put(new Emp(34,"a",532155), "--6");
		tMap2.put(new Emp(1,"s",55235), "--7");
		
		System.out.println(tMap2.toString());
		
		
//		Map<Emp2, String> tMap3 = new TreeMap(); 
//
//
//		tMap3.put(new Emp2(13,"qq",555), "--1");
//		tMap3.put(new Emp2(2,"s",55235), "--2");
//		tMap3.put(new Emp2(63,"ww",215), "--3");
//		tMap3.put(new Emp2(35,"e",523), "--4");
//		tMap3.put(new Emp2(23,"r",523), "--5");
//		tMap3.put(new Emp2(34,"a",532155), "--6");
//		tMap3.put(new Emp2(1,"s",55235), "--7");
//		
//		System.out.println(tMap3.toString());
		
		
	}
	
	static class Emp implements Comparable<Emp>{
		private int id;
		
		private String name;

		private int solar;
		
		public Emp(int id, String name, int solar) {
			super();
			this.id = id;
			this.name = name;
			this.solar = solar;
		}

		@Override
		public String toString() {
			return "Emp [id=" + id + ", name=" + name + ", solar=" + solar + "]";
		}

		public int compareTo(Emp o) {
			if(this.solar>o.solar) {
				return 1;
			}else if(this.solar<o.solar){
				return -1;
			}else {
				if(this.id>o.id) {
					return 1;
				}else if(this.id<o.id){
					return -1;
				}else {
					return 0;
				}
			}
		}
	}
	
	static class Emp2 {
		private int id;
		
		private String name;

		private int solar;
		
		public Emp2(int id, String name, int solar) {
			super();
			this.id = id;
			this.name = name;
			this.solar = solar;
		}

		@Override
		public String toString() {
			return "Emp [id=" + id + ", name=" + name + ", solar=" + solar + "]";
		}

	}

}
