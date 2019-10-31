package com.cjean.daliytest.设计模式.结构型模式.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {
	public static Map<String, ConcreteFlyWeight> map = new HashMap<String, ConcreteFlyWeight>();
	
	public static ConcreteFlyWeight getKey(String name) {
		if(null != map.get(name)) {
			return map.get(name);
		}else {
			ConcreteFlyWeight concreteFlyWeight = new ConcreteFlyWeight(name);
			map.put(name, concreteFlyWeight);
			return map.get(name);
		}
	}
}
