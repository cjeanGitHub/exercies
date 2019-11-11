/**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: BinarySeachTree
 * Author:   14172
 * Date:     2019/11/9 19:36
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.cjean.daliytest.����;

/**
 * @author 14172
 * @create 2019/11/9
 * @since 1.0.0
 */
public class BinarySeachTree {
    public int data;
    public BinarySeachTree left;
    public BinarySeachTree right;

    public BinarySeachTree (int data){//��ʼ��
        this.data = data;
        this.left = null;
        this.right = null;
    }
    //���� �ӽڵ�
    public void insertNode(BinarySeachTree root,int data){
        if (root.data > data){//��������� С�� ���ڵ�  ���ڸ��ڵ�����
            if(null == root.left){
                root.left = new BinarySeachTree(data);
            }else {
                insertNode(root.left,data);
            }
        }else {//��������� С�� ���ڵ�  ���ڸ��ڵ���Ҳ�
            if(null == root.right){
                root.right = new BinarySeachTree(data);
            }else {
                insertNode(root.right,data);
            }
        }
    }

    //�������
    public void getFirstSort(BinarySeachTree root){
        if (null != root){
            System.out.print(root.data+",");
            getFirstSort(root.left);
            getFirstSort(root.right);
        }
    }
    //z������� ������
    public void getMidSort(BinarySeachTree root){
        if(null != root){
            getMidSort(root.left);
            System.out.print(root.data+",");
            getMidSort(root.right);
        }
    }
    //�������
    public void getLastSort(BinarySeachTree root){
        if (null != root){
            getLastSort(root.left);
            getLastSort(root.right);
            System.out.print(root.data+",");
        }
    }
    public static void main(String[] args) {

        int[] data = {3,2,6,7,4,1,12};
        BinarySeachTree binarySeachTree = new BinarySeachTree(data[0]);
        for (int i=1;i<data.length;i++){
            binarySeachTree.insertNode(binarySeachTree,data[i]);
        }
        System.out.println("==�������==");
        binarySeachTree.getFirstSort(binarySeachTree);
        System.out.println("==������� ==");
        binarySeachTree.getMidSort(binarySeachTree);
        System.out.println("==�������==");
        binarySeachTree.getLastSort(binarySeachTree);

    }
}
