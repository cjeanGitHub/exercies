package com.cjean.daliytest.���ģʽ.������ģʽ.����ģʽ.abstractfactory;

public interface Tyre {
	void message();
}
class RichTyre implements Tyre{

	@Override
	public void message() {
		System.out.println("RichTyre-��ĥ����");
	}
}
class LowTyre implements Tyre{

	@Override
	public void message() {
		System.out.println("LowTyre->ĥ���");
	}
}