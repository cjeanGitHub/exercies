package com.cjean.daliytest.ÈÝÆ÷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyIterator<E> {
	private void mai() {
		

		Map<String, String> map = new HashMap<String, String>();
        map.put("A", "¸ßä¿");
        map.put("B", "¸ßÐ¡Æß");
        Set<String> ss = map.keySet();
        for (Iterator<String> iterator = ss.iterator(); iterator.hasNext();) {
        	String key = iterator.next();
        	System.out.println(key + "--" + map.get(key));
        }
	}
}
