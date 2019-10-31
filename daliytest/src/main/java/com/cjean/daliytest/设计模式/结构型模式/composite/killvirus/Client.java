package com.cjean.daliytest.设计模式.结构型模式.composite.killvirus;

public class Client {
	public static void main(String[] args) {
		KillVirusComponent k2,k3,k4,k5,k6;
		Folder f1 = new Folder("个人文件夹");
		k2 = new TextKillVirus("记事本.txt");
		k3 = new ImagKillVirus("私人照片.png");
		
		k2.killVirus();
		System.out.println("**************");
		
		f1.add(k2);
		f1.add(k3);
		f1.killVirus();
		System.out.println("**************");
		Folder f2 = new Folder("二级文件夹");
		k4 = new ImagKillVirus("私密级照片.png");
		k5 = new VideoKillVirus("呼呼呼.avi");
		f2.add(k4);
		f2.add(k5);
		f2.killVirus();
		System.out.println("**************");
		f1.add(f2);
		f1.killVirus();
		
		
	}
}
