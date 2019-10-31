反射私有属性的访问：（https://blog.csdn.net/codefunjava/article/details/39718843）
	私有属性.setAccessible(true);//即可进行私有属性的访问
		如：
		
			private String field1="私有属性";
			public String field2="公有属性";
		
			field1 = e.getClass().getDeclaredField("field1");
			field2 = e.getClass().getDeclaredField("field2");
			field1.setAccessible(true);
			System.out.println("field1: "+field1.get(e));
			field1.set(e,"重新设置一个field1值");
