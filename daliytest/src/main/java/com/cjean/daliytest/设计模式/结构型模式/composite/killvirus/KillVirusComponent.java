package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.composite.killvirus;

import java.util.ArrayList;
import java.util.List;
/**
 * ���󹹼����ṩʵ����Ĺ���
 * @author Cjean
 *
 */
public interface KillVirusComponent {
	void killVirus();
}
/**
 * ����Ҷ�ӣ�ֻ��ʵ����Ĺ���
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
		System.out.println("---�ı��ļ���"+name+"�����в�����ɱ����");
	}
	
}
/**
 * ����Ҷ�ӣ�ֻ��ʵ����Ĺ���
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
		System.out.println("---��Ƶ�ļ���"+name+"�����в�����ɱ����");
	}
	
}
/**
 * ����Ҷ�ӣ�ֻ��ʵ����Ĺ���
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
		System.out.println("---ͼƬ�ļ���"+name+"�����в�����ɱ����");
	}
	
}
/**
 * ��������   
 * 		����ʵ����ģ������Լ��ķ���
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
		System.out.println("�ļ��У�"+name+",������ɱ�У���");
		for (KillVirusComponent killVirusComponent : list) {
			killVirusComponent.killVirus();
		}
	}
	
}

