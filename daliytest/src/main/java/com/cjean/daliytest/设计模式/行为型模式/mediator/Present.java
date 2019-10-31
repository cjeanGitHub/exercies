package com.cjean.daliytest.设计模式.行为型模式.mediator;

import java.util.HashMap;
import java.util.Map;

public class Present implements Mediator {
	
	private Map<String,Department> departmentMap = new HashMap<>();

	@Override
	public void command(String dname) {
		departmentMap.get(dname).selfWork();
	}

	@Override
	public void register(String dname, Department department) {
		departmentMap.put(dname, department);
	}

}
