package com.cjean.daliytest.设计模式.创建者模式.原型模式;
import com.cjean.daliytest.设计模式.创建者模式.原型模式.Mark;

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


	// 在 引用代码执行clone方法是 会执行 下面的函数方法   深克隆就能够克隆出不受原型 并且也不会影响改变原型的原因就是 因为
	// 在下面这个克隆函数中  进行新对象的创建 从而导致  原型对象以及引用对象不是一个了
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
        System.out.println("原User2："+user);
        System.out.println("克隆的User2："+userClone);
        //修改引用类型的mark属性
        user.mark.setMath(60);
        System.out.println("修改后的原user："+user);
        System.out.println("修改后的克隆user："+userClone);
        

        user.setAge(2222);
        System.out.println("修改后的原user："+user);
        System.out.println("修改后的克隆user："+userClone);
        

        user.mark.setMath(160);
        System.out.println("修改后的原user："+user);
        System.out.println("修改后的克隆user："+userClone);
    }
}