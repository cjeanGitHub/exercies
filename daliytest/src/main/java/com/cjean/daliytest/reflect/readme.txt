����˽�����Եķ��ʣ���https://blog.csdn.net/codefunjava/article/details/39718843��
	˽������.setAccessible(true);//���ɽ���˽�����Եķ���
		�磺
		
			private String field1="˽������";
			public String field2="��������";
		
			field1 = e.getClass().getDeclaredField("field1");
			field2 = e.getClass().getDeclaredField("field2");
			field1.setAccessible(true);
			System.out.println("field1: "+field1.get(e));
			field1.set(e,"��������һ��field1ֵ");
