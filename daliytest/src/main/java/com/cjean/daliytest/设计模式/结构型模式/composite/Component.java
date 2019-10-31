package com.cjean.daliytest.设计模式.结构型模式.composite;

/**
 * 抽象构建
 * @author Cjean
 *
 */
public interface Component {
	void operation();
}

/**
 *  叶子构建
 * @author Cjean
 *
 */
interface Leaf extends Component{
	void operation();
}
/**
 * 容器构建
 * @author Cjean
 *
 */
interface Composite extends Component{
	void add(Component c);
	void remove(int index);
	Component getComponent(int index);
	void operation();
}