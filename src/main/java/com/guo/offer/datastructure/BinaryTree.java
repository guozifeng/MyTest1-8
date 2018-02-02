package com.guo.offer.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTree tree = new BinaryTree();
        int[] datas = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Node> nodelist = new LinkedList<>();
        tree.creatBinaryTree(datas, nodelist);
        Node root = nodelist.get(0);
        System.out.println("�ݹ����������");
        tree.preOrderTraversal(root);
        System.out.println();
        System.out.println("�ǵݹ����������");
        tree.preOrderTraversalbyLoop(root);
        System.out.println();
        System.out.println("�ݹ����������");
        tree.inOrderTraversal(root);
        System.out.println();
        System.out.println("�ǵݹ����������");
        tree.inOrderTraversalbyLoop(root);
        System.out.println();
        System.out.println("�ݹ���������");
        tree.postOrderTraversal(root);
        System.out.println();
        System.out.println("�ǵݹ���������");
        tree.postOrderTraversalbyLoop(root);
        System.out.println();
        System.out.println("������ȱ�����");
        tree.bfs(root);
        System.out.println();
        System.out.println("������ȱ�����");
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        tree.dfs(root, rst, list);
        System.out.println(rst);
    }

    /**
     * 
     * @param datas ʵ�ֶ��������ڵ�ֵ������
     * @param nodelist ������list
     */
    private void creatBinaryTree(int[] datas, List<Node> nodelist) {
        // ��������node�ڵ�
        for (int nodeindex = 0; nodeindex < datas.length; nodeindex++) {
            Node node = new Node(datas[nodeindex]);
            nodelist.add(node);
        }
        // �����и��ڵ��趨�ӽڵ�
        for (int index = 0; index < nodelist.size() / 2 - 1; index++) {
            // ���Ϊn�Ľڵ��������ӽڵ���Ϊ2*n ���ӽڵ���Ϊ2*n+1 ������Ϊlist��0��ʼ��ţ����Ի�Ҫ+1
            // ���︸�ڵ���1��2,3��,2��4,5��,3��6,7��,4��8,9�� �������һ�����ڵ��п���û�����ӽڵ� ��Ҫ��������
            nodelist.get(index).setLeft(nodelist.get(index * 2 + 1));
            nodelist.get(index).setRight(nodelist.get(index * 2 + 2));
        }
        // �����������һ�����ڵ� ��Ϊ���п���û�����ӽڵ�
        int index = nodelist.size() / 2 - 1;
        nodelist.get(index).setLeft(nodelist.get(index * 2 + 1)); // ���������ӽڵ�
        if (nodelist.size() % 2 == 1) { // ������������ڵ㣬���һ�����ڵ�������ӽڵ�
            nodelist.get(index).setRight(nodelist.get(index * 2 + 2));
        }
    }

    /**
     * ������ǰ�ڵ��ֵ
     * 
     * @param nodelist
     * @param node
     */
    public void checkCurrentNode(Node node) {
        System.out.print(node.getVar() + " ");
    }

    /**
     * �������������
     * 
     * @param root ���������ڵ�
     */
    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        checkCurrentNode(node);
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    /**
     * �������������
     * 
     * @param root ���ڵ�
     */
    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft());
        checkCurrentNode(node);
        inOrderTraversal(node.getRight());
    }

    /**
     * �������������
     * 
     * @param root ���ڵ�
     */
    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        checkCurrentNode(node);
    }

    /**
     * �ǵݹ�ǰ�����
     * 
     * @param node
     */
    public void preOrderTraversalbyLoop(Node node) {
        Stack<Node> stack = new Stack();
        Node p = node;
        while (p != null || !stack.isEmpty()) {
            // System.out.println("11111111 = "+p);
            while (p != null) { // ��p��Ϊ��ʱ���Ͷ�ȡp��ֵ�������ϸ���pΪ�����ӽڵ㣬�����϶�ȡ���ӽڵ�
                // System.out.println("checkCurrentNode = "+p);
                checkCurrentNode(p);
                stack.push(p); // ��p��ջ
                p = p.getLeft();
                // System.out.println("getLeft = "+p);
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.getRight();
            }
        }
    }

    /**
     * �ǵݹ��������
     * 
     * @param node
     */
    public void inOrderTraversalbyLoop(Node node) {
        Stack<Node> stack = new Stack();
        Node p = node;
        while (p != null || !stack.isEmpty()) {
            // System.out.println("11111111 = "+p);
            while (p != null) {
                // System.out.println("22222 = "+p);
                stack.push(p);
                p = p.getLeft();
                // System.out.println("3333 = "+p);
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                // System.out.println("44444 = "+p);
                checkCurrentNode(p);
                p = p.getRight();
                // System.out.println("555555 = "+p);
            }
        }
    }

    /**
     * �ǵݹ�������
     * 
     * @param node
     */
    public void postOrderTraversalbyLoop(Node node) {
        Stack<Node> stack = new Stack<>();
        Node p = node, prev = node;

        while (p != null || !stack.isEmpty()) {
            // System.out.println(" node = "+p);

            while (p != null) {
                System.out.println(" p = " + p);
                stack.push(p);
                p = p.getLeft();
            }
            
            // ����һ��˼·��1�������ӽڵ㶼Ϊ�ա�2����ǰ�ڵ���ҽڵ���ϴεĴ�ӡ�ڵ���ȡ� �����������ӡ���ݡ�
            if (!stack.isEmpty()) {
                Node temp = stack.peek().getRight();
                System.out.println((temp == prev) + " temp = " + temp + " prev = " + prev);
                if (temp == null || temp == prev) {
                    p = stack.pop();
                    // System.out.println(" 222222222222 = "+p);
                    checkCurrentNode(p);
                    prev = p;
                    p = null;
                } else {
                    p = temp;
                }
            }
        }
    }

    /**
     * ������ȱ��������ϵ��±�����������
     * 
     * @param root
     */
    public void bfs(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(root); // ���Ƚ����ڵ�������
        // ����������ֵʱ��ÿ��ȡ�����׵�node��ӡ����ӡ֮���ж�node�Ƿ����ӽڵ㣬���У����ӽڵ�������
        while (queue.size() > 0) {
            Node node = queue.peek();
            queue.poll(); // ȡ������Ԫ�ز���ӡ
            System.out.print(node.var + " ");
            if (node.left != null) { // ��������ӽڵ㣬����������
                queue.offer(node.left);
            }
            if (node.right != null) { // ��������ӽڵ㣬����������
                queue.offer(node.right);
            }
        }
    }

    /**
     * ������ȱ���
     * 
     * @param node
     * @param rst
     * @param list
     */
    public void dfs(Node node, List<List<Integer>> rst, List<Integer> list) {
        System.out.println("node  =  " + node);
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.var);
            /* ���ｫlist����rst��ʱ������ֱ�ӽ�list���룬����ͨ���½�һ��list��ʵ�֣�
             * ��Ϊ���ֱ����list�Ļ�������remove��ʱ��Ҳ�Ὣ�����һ����Ľڵ�ɾ��*/
            rst.add(new ArrayList<>(list));
            // System.out.println(rst+"---------2------"+list);
            list.remove(list.size() - 1);
            // System.out.println("---------3------"+list);
        }
        list.add(node.var);
        // System.out.println("--------1-------"+list);
        dfs(node.left, rst, list);
        System.out.println("--------4-------" + list);
        dfs(node.right, rst, list);
        // System.out.println("***************"+list);
        list.remove(list.size() - 1);
        // System.out.println("++++++++++++++++"+list);
    }

    /**
     * �ڵ��� var �ڵ�ֵ left �ڵ����ӽڵ� right ���ӽڵ�
     */
    class Node {

        @Override
        public String toString() {
            return "Node [var=" + var + ", left=" + left + ", right=" + right + "]";
        }

        int var;
        Node left;
        Node right;

        public Node(int var) {
            this.var = var;
            this.left = null;
            this.right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getVar() {
            return var;
        }

        public void setVar(int var) {
            this.var = var;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

    }

}