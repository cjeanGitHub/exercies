package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.װ����ģʽ;

/**
 * װ���� ģʽ   �Ĳ���
 * 
 * 1.�������
 * 2.�������
 * 3.����װ��
 * 4.����װ��
 * 
 * @author Cjean
 *
 */
public class װ����ģʽDemo {
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		System.err.println(coffee.info()+"=="+coffee.cost());
		Drink milk = new Milk(coffee);
		System.err.println(milk.info()+"=="+milk.cost());
		Drink suger = new Suger(coffee);
		System.err.println(suger.info()+"=="+suger.cost());
	}
}
//�������
interface Drink{
	double cost();
	String info();
}
//�������
class Coffee implements Drink{
	private String name = "ԭζ����";
	public double cost() {
		return 10;
	}
	public String info() {
		return name;
	}
}

//����װ��
abstract class Decoder implements Drink{
	private Drink drink;
	public Decoder(Drink drink) {
		super();
		this.drink = drink;
	}

	public double cost() {
		return drink.cost();
	}

	public String info() {
		return drink.info();
	}
}

//����װ��
class Milk extends Decoder{

	public Milk(Drink drink) {
		super(drink);
	}
	
	public double cost() {
		return super.cost()*4;
	}

	public String info() {
		return super.info()+"����ţ��";
	}
}
class Suger extends Decoder{

	public Suger(Drink drink) {
		super(drink);
	}
	
	public double cost() {
		return super.cost()*2;
	}

	public String info() {
		return super.info()+"��������";
	}
}

