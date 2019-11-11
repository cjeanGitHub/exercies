/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BinarySeachTree
 * Author:   14172
 * Date:     2019/11/9 19:36
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.daliytest.容器;

/**
 * @author 14172
 * @create 2019/11/9
 * @since 1.0.0
 */
public class BinarySeachTree {
    public int data;
    public BinarySeachTree left;
    public BinarySeachTree right;

    public BinarySeachTree (int data){//初始化
        this.data = data;
        this.left = null;
        this.right = null;
    }
    //插入 子节点
    public void insertNode(BinarySeachTree root,int data){
        if (root.data > data){//插入的数字 小于 父节点  放在父节点的左侧
            if(null == root.left){
                root.left = new BinarySeachTree(data);
            }else {
                insertNode(root.left,data);
            }
        }else {//插入的数字 小于 父节点  放在父节点的右侧
            if(null == root.right){
                root.right = new BinarySeachTree(data);
            }else {
                insertNode(root.right,data);
            }
        }
    }

    //先序便利
    public void getFirstSort(BinarySeachTree root){
        if (null != root){
            System.out.print(root.data+",");
            getFirstSort(root.left);
            getFirstSort(root.right);
        }
    }
    //z中序便利 二叉树
    public void getMidSort(BinarySeachTree root){
        if(null != root){
            getMidSort(root.left);
            System.out.print(root.data+",");
            getMidSort(root.right);
        }
    }
    //后序便利
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
        System.out.println("==先序便利==");
        binarySeachTree.getFirstSort(binarySeachTree);
        System.out.println("==中序便利 ==");
        binarySeachTree.getMidSort(binarySeachTree);
        System.out.println("==后序便利==");
        binarySeachTree.getLastSort(binarySeachTree);

    }
}
