package com.cjean.daliytest.设计模式.结构型模式.装饰器模式;

/**
 * 装饰器 模式   四部分
 * 
 * 1.抽象组件
 * 2.具体组件
 * 3.抽象装饰
 * 4.具体装饰
 * 
 * @author Cjean
 *
 */
public class 装饰器模式Demo {
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		System.err.println(coffee.info()+"=="+coffee.cost());
		Drink milk = new Milk(coffee);
		System.err.println(milk.info()+"=="+milk.cost());
		Drink suger = new Suger(coffee);
		System.err.println(suger.info()+"=="+suger.cost());
	}
}
//抽象组件
interface Drink{
	double cost();
	String info();
}
//具体组件
class Coffee implements Drink{
	private String name = "原味咖啡";
	public double cost() {
		return 10;
	}
	public String info() {
		return name;
	}
}

//抽象装饰
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

//具体装饰
class Milk extends Decoder{

	public Milk(Drink drink) {
		super(drink);
	}
	
	public double cost() {
		return super.cost()*4;
	}

	public String info() {
		return super.info()+"加了牛奶";
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
		return super.info()+"加了蔗糖";
	}
}

