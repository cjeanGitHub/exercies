package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.composite.killvirus;

public class Client {
	public static void main(String[] args) {
		KillVirusComponent k2,k3,k4,k5,k6;
		Folder f1 = new Folder("�����ļ���");
		k2 = new TextKillVirus("���±�.txt");
		k3 = new ImagKillVirus("˽����Ƭ.png");
		
		k2.killVirus();
		System.out.println("**************");
		
		f1.add(k2);
		f1.add(k3);
		f1.killVirus();
		System.out.println("**************");
		Folder f2 = new Folder("�����ļ���");
		k4 = new ImagKillVirus("˽�ܼ���Ƭ.png");
		k5 = new VideoKillVirus("������.avi");
		f2.add(k4);
		f2.add(k5);
		f2.killVirus();
		System.out.println("**************");
		f1.add(f2);
		f1.killVirus();
		
		
	}
}
