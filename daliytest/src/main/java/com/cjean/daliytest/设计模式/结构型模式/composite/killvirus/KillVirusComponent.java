package com.cjean.daliytest.设计模式.结构型模式.composite.killvirus;

import java.util.ArrayList;
import java.util.List;
/**
 * 抽象构件：提供实现类的功能
 * @author Cjean
 *
 */
public interface KillVirusComponent {
	void killVirus();
}
/**
 * 抽象叶子：只有实现类的功能
 * @author Cjean
 *
 */
class TextKillVirus implements KillVirusComponent {
	private String name;

	public TextKillVirus(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("---文本文件："+name+"，进行病毒查杀！！");
	}
	
}
/**
 * 抽象叶子：只有实现类的功能
 * @author Cjean
 *
 */
class VideoKillVirus implements KillVirusComponent {
	private String name;

	public VideoKillVirus(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("---视频文件："+name+"，进行病毒查杀！！");
	}
	
}
/**
 * 抽象叶子：只有实现类的功能
 * @author Cjean
 *
 */
class ImagKillVirus implements KillVirusComponent {
	private String name;

	public ImagKillVirus(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("---图片文件："+name+"，进行病毒查杀！！");
	}
	
}
/**
 * 抽象容器   
 * 		包括实现类的，并有自己的方法
 * @author Cjean
 *
 */
class Folder implements KillVirusComponent {
	
	private String name;
	private List<KillVirusComponent> list = new ArrayList<>();
	
	public Folder(String name) {
		super();
		this.name = name;
	}
	
	void add(KillVirusComponent k) {
		list.add(k);
	}
	
	void remove(KillVirusComponent k) {
		list.remove(k);
	}
	
	@Override
	public void killVirus() {
		System.out.println("文件夹："+name+",病毒查杀中！！");
		for (KillVirusComponent killVirusComponent : list) {
			killVirusComponent.killVirus();
		}
	}
	
}

