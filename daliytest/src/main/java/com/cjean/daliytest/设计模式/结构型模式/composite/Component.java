package com.cjean.daliytest.���ģʽ.�ṹ��ģʽ.composite;

/**
 * ���󹹽�
 * @author Cjean
 *
 */
public interface Component {
	void operation();
}

/**
 *  Ҷ�ӹ���
 * @author Cjean
 *
 */
interface Leaf extends Component{
	void operation();
}
/**
 * ��������
 * @author Cjean
 *
 */
interface Composite extends Component{
	void add(Component c);
	void remove(int index);
	Component getComponent(int index);
	void operation();
}