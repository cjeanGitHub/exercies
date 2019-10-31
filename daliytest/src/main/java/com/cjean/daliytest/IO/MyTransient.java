package com.cjean.daliytest.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Rectangle implements Serializable {

	/**
	 * �Ƚ�����Java�еĶ������л� ������transient֮ǰ���б�Ҫ�ȸ����Java�����л��ĺ��壻
	 * 
	 * Java�ж�������л�ָ���ǽ�����ת�������ֽ����е���ʽ����ʾ����Щ�ֽ����а����˶�������ݺ���Ϣ��
	 * һ�����л���Ķ�����Ա�д�����ݿ���ļ��У�Ҳ���������紫�䣬
	 * һ�㵱����ʹ�û���cache���ڴ�ռ䲻���п��ܻ᱾�ش洢��Ӳ�̣���Զ�̵���rpc�����紫�䣩��ʱ��
	 * ������Ҫ�����ǵ�ʵ����ʵ��Serializable�ӿڣ�Ŀ�ľ���Ϊ����������л���
	 * 
	 * ��Ȼ�����л��������Ŀ����Ϊ�˷����л����ָ���ԭ�ȵ�Java����Ҫ��Ȼ���л�������أ��������л�����ֽ����ж��ǿ��Իָ���Java����ģ�
	 * ������̾��Ƿ����л���
	 * 
	 * ����transient�ؼ���
	 * Java��transient�ؼ��ֵ����ã��򵥵�˵��������ĳЩ�����εĳ�Ա���Ա����������л�����һ������ܺ���⣬���ǲ������л���
	 * ��ôʲô����£�һ�������ĳЩ�ֶβ���Ҫ�����л��أ������������������Կ���ʹ�ùؼ���transient���Σ�
	 * 
	 * 1�����е��ֶ�ֵ���Ը��������ֶ��Ƶ���������һ�������������������ԣ����ȡ���ȡ������ʾ�����ѣ�һ�㲻��������ƣ�����ô�����л���ʱ��
	 * ���������Ծ�û��Ҫ�����л��ˣ�
	 * 
	 * 2��������������ҵ������ɣ���Щ�ֶβ��뱻���л���
	 * 
	 * PS���ǵ�֮ǰ��HashMapԴ���ʱ�򣬷����и��ֶ�����transient���εģ��Ҿ��û����е���ģ�ȷʵû��Ҫ�����modCount�ֶν������л���
	 * ��Ϊû�����壬modCount��Ҫ�����ж�HashMap�Ƿ��޸ģ���put��remove������ʱ��modCount�������������������ֱ�����һ��ʼ����Ϊ�κ�ֵ��
	 * 0��ȻҲ�ǿ��ԣ�new�����������л����������߿�¡clone������ʱ����Ϊ0�ģ���û��Ҫ�־û���ֵ��
	 */
	private static final long serialVersionUID = 1710022455003682613L;
	private Integer width;
	private Integer height;
	private transient Integer area;

	public Rectangle(Integer width, Integer height) {
		this.width = width;
		this.height = height;
		this.area = width * height;
	}

	public void setArea() {
		this.area = this.width * this.height;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(40);
		sb.append("width : ");
		sb.append(this.width);
		sb.append("\nheight : ");
		sb.append(this.height);
		sb.append("\narea : ");
		sb.append(this.area);
		return sb.toString();
	}
}

public class MyTransient {
	public static void main(String args[]) throws Exception {
		Rectangle rectangle = new Rectangle(3, 4);
		System.out.println("1.ԭʼ����\n" + rectangle);
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("rectangle"));
		// ����д�����
		o.writeObject(rectangle);
		o.close();

		// ������ȡ����
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("rectangle"));
		Rectangle rectangle1 = (Rectangle) in.readObject();
		System.out.println("2.�����л���Ķ���\n" + rectangle1);
		rectangle1.setArea();
		System.out.println("3.�ָ���ԭʼ����\n" + rectangle1);
		in.close();
	}
}
