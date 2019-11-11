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

import java.util.HashMap;

/**
 * @author 14172
 * @create 2019/11/9
 * @since 1.0.0
 */
public class RedBlackBinarySeachTree {

    public Node nodeTemp;

    class Node{
        public int data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data){
            this.data = data;
        }
    }
    public RedBlackBinarySeachTree(){

    }

    public Node leftRoat(Node node){
        if (null != node.right){
            nodeTemp = node.right;
            node.right = nodeTemp.left;
            nodeTemp.left = node;
            nodeTemp.parent = null;
            node = nodeTemp;
        }
        return node;
    }
    public static void main(String[] args) {

        System.out.println(Integer.highestOneBit((9 - 1) << 1));
        new HashMap<>();
    }
}
