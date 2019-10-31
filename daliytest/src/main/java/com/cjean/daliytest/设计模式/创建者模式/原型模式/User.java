package com.cjean.daliytest.���ģʽ.������ģʽ.ԭ��ģʽ;

import java.io.Serializable;

class Mark implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int chinese;
    private int math;
    public Mark(int chinese, int math) {
        this.chinese = chinese;
        this.math = math;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public void setMath(int math) {
        this.math = math;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "chinese=" + chinese +
                ", math=" + math +
                '}';
    }
}
public class User implements Cloneable{
    private String name;
    private int age;
    private Mark mark;

    public int sex;



    public User(String name, int age, Mark mark, int sex) {
		super();
		this.name = name;
		this.age = age;
		this.mark = mark;
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", mark=" + mark + ", sex=" + sex + "]";
	}


	@Override
    protected Object clone() throws CloneNotSupportedException {
    	Object clone = super.clone();
        return clone;
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
        User user = new User("user",22,mark,1);
        
        User userClone = (User) user.clone();
        System.out.println("ԭuser��"+user);
        System.out.println("��¡��user��"+userClone);
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