package com.cjean.daliytest.���ģʽ.��Ϊ��ģʽ.mediator;

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
