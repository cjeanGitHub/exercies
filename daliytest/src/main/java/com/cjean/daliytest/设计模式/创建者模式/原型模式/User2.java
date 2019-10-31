package com.cjean.daliytest.���ģʽ.������ģʽ.ԭ��ģʽ;
import com.cjean.daliytest.���ģʽ.������ģʽ.ԭ��ģʽ.Mark;

public class User2 implements Cloneable{
    private String name;
    private int age;
    private Mark mark;
    public int sex;



    public User2(String name, int age, Mark mark, int sex) {
		super();
		this.name = name;
		this.age = age;
		this.mark = mark;
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "User2 [name=" + name + ", age=" + age + ", mark=" + mark + ", sex=" + sex + "]";
	}


	// �� ���ô���ִ��clone������ ��ִ�� ����ĺ�������   ���¡���ܹ���¡������ԭ�� ����Ҳ����Ӱ��ı�ԭ�͵�ԭ����� ��Ϊ
	// �����������¡������  �����¶���Ĵ��� �Ӷ�����  ԭ�Ͷ����Լ����ö�����һ����
	@Override
    protected Object clone() throws CloneNotSupportedException {
		Mark mark2 = new Mark(20,30);
		User2 user = (User2) super.clone();
		user.setMark(mark2);
        return user;
    }
    
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}
	

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
        Mark mark = new Mark(100,99);
        User2 user = new User2("User2",22,mark,1);
        User2 userClone = (User2) user.clone();
        System.out.println("ԭUser2��"+user);
        System.out.println("��¡��User2��"+userClone);
        //�޸��������͵�mark����
        user.mark.setMath(60);
        System.out.println("�޸ĺ��ԭuser��"+user);
        System.out.println("�޸ĺ�Ŀ�¡user��"+userClone);
        

        user.setAge(2222);
        System.out.println("�޸ĺ��ԭuser��"+user);
        System.out.println("�޸ĺ�Ŀ�¡user��"+userClone);
        

        user.mark.setMath(160);
        System.out.println("�޸ĺ��ԭuser��"+user);
        System.out.println("�޸ĺ�Ŀ�¡user��"+userClone);
    }
}