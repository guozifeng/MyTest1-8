package com.guo.interview.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.guo.interview.questions.RBTreeNode.Color;

public class RedBlackTree {
    // �����������������
    // ��������update/delete���������½��仯
    // ����update/delete������clear���List
    protected List<Integer> midOrderVisitList = new ArrayList<Integer>();

    // �����������е�ͷָ��
    // �������Ӳ��������ĸ����
    // delete������rotate�����У��漰�����
    // fakeRoot�Ĵ��ھ���Ϊ�˷������������Ĳ���
    protected RBTreeNode fakeRoot;

    public RedBlackTree(RBTreeNode root) {
        this();
        fakeRoot.setLeftChild(root);
        root.setParent(fakeRoot);
        root.setColor(Color.BLACK);
    }

    public RedBlackTree() {
        fakeRoot = new RBTreeNode(-1);
    }

    public boolean isEmpty() {
        return fakeRoot.getLeftChild().isNull();
    }

    public void invalidateVisitList() {
        midOrderVisitList.clear();
    }

    public RBTreeNode getRoot() {
        return fakeRoot.getLeftChild();
    }

    public boolean isRed(RBTreeNode node) {
        return node.getColor() == Color.RED;
    }

    /**
     * �ݹ��ѯĳ�������Ƿ�������
     * 
     * @param node ָ��������
     * @param data Ҫ���ҵ�����
     * @return �����㡣����ƥ��������򷵻ض�Ӧ��㡣����ƥ�䣬�򷵻�Ҷ�ӽ�㡣
     */
    protected RBTreeNode recursiveSearch(RBTreeNode node, int data) {
        // ����Ϊ�գ��ս�㣩�����Ҳ���ƥ��Ľ��
        // ��ʱparent�����������
        // 1��Ҷ��� 2������������ 3������������
        // ����parent��Ϊ�˷�����в����������Ϊ����һ�����Ҫ��search
        if (node.isNull())
            return node.getParent();
        int _data = node.getData();
        if (_data == data)
            return node;
        // ���������������ݹ����
        if (data < _data)
            return recursiveSearch(node.getLeftChild(), data);
        return recursiveSearch(node.getRightChild(), data);
    }

    /**
     * �ǵݹ��ѯĳ���������Ƿ�������
     * 
     * @param node ָ��������
     * @param data Ҫ���ҵ�����
     * @return �����㡣����ƥ��������򷵻ض�Ӧ��㡣����ƥ�䣬�򷵻�Ҷ�ӽ�㡣
     */
    protected RBTreeNode normalSearch(RBTreeNode node, int data) {
        RBTreeNode parent = RBTreeNode.NULL_NODE;
        while (!node.isNull()) {
            int _data = node.getData();
            if (_data == data)
                return node;
            parent = node;
            if (data < _data)
                node = node.getLeftChild();
            else
                node = node.getRightChild();
        }
        return parent;
    }

    // �����ṩ�Ĳ�ѯ�ӿ�
    // �����ʵ�ֿ�ʹ�õݹ��ѯ��Ҳ�ɲ�ʹ�õݹ��ѯ
    public RBTreeNode search(int data) {
        if (!isEmpty())
            // return recursiveSearch(getRoot(), data);
            return normalSearch(getRoot(), data);
        return RBTreeNode.NULL_NODE;
    }

    protected void midOrderVisit(RBTreeNode tree, List<Integer> dataList) {
        if (tree.isNull())
            return;
        midOrderVisit(tree.getLeftChild(), dataList);
        dataList.add(tree.getData());
        midOrderVisit(tree.getRightChild(), dataList);
    }

    public List<Integer> midOrderVisit() {
        // ���򻺴��б��������ݣ��������ٴα�����ֱ�ӷ��ظ��б�
        if (midOrderVisitList.size() == 0)
            midOrderVisit(fakeRoot.getLeftChild(), midOrderVisitList);
        return midOrderVisitList;
    }

    public boolean insert(int data) {
        RBTreeNode resultTree = search(data);

        // ����
        if (resultTree.isNull()) {
            RBTreeNode root = new RBTreeNode(data);
            fakeRoot.setLeftChild(root);
            root.setParent(fakeRoot);
            // ������и����Ϊ��
            root.setColor(Color.BLACK);
            return true;
        }

        // ԭ�����Ѿ��и���������ز���
        int _data = resultTree.getData();
        if (data == _data)
            return false;

        // �ǿ���
        RBTreeNode newTree = new RBTreeNode(data);
        if (data < _data)
            resultTree.setLeftChild(newTree);
        else
            resultTree.setRightChild(newTree);
        newTree.setParent(resultTree);

        // ���������ʹ֮ƽ��
        insertRebalance(newTree);

        // ���ṹ�仯�����򻺴����
        midOrderVisitList.clear();
        return true;
    }

    private void insertRebalance(RBTreeNode node) {
        RBTreeNode parent = node.getParent();
        while (parent != fakeRoot && parent.getColor() == Color.RED) {
            RBTreeNode grandpa = parent.getParent();
            RBTreeNode uncle;
            // ��������游��������
            if (parent == grandpa.getLeftChild()) {
                uncle = grandpa.getRightChild();
                // case1��������Ϊ��
                if (isRed(uncle)) {
                    uncle.setColor(Color.BLACK);
                    parent.setColor(Color.BLACK);
                    grandpa.setColor(Color.RED);
                    node = grandpa;
                }
                // case2��������Ϊ�ڣ��ҵ�ǰ������丸�����Һ���
                else if (node == parent.getRightChild()) {
                    node = parent;
                    node.leftRotate();
                }
                // case 3��������Ϊ�ڣ��ҵ�ǰ������丸��������
                else if (node == parent.getLeftChild()) {
                    parent.setColor(Color.BLACK);
                    grandpa.setColor(Color.RED);
                    node = grandpa;
                    node.rightRotate();
                }
            }
            // ��������游�����Һ���
            else {
                uncle = grandpa.getLeftChild();
                // case1��������Ϊ��
                if (isRed(uncle)) {
                    uncle.setColor(Color.BLACK);
                    parent.setColor(Color.BLACK);
                    grandpa.setColor(Color.RED);
                    node = grandpa;
                }
                // case2��������Ϊ�ڣ��ҵ�ǰ������丸��������
                else if (node == parent.getLeftChild()) {
                    node = parent;
                    node.rightRotate();
                }
                // case 3��������Ϊ�ڣ��ҵ�ǰ������丸�����Һ���
                else if (node == parent.getRightChild()) {
                    parent.setColor(Color.BLACK);
                    grandpa.setColor(Color.RED);
                    node = grandpa;
                    node.leftRotate();
                }
            }
            parent = node.getParent();
        }
        getRoot().setColor(Color.BLACK);
    }

    /**
     * �����ɾ�����
     * 
     * @param data Ҫɾ��������
     * @return true����ɾ���ɹ���false����ɾ��ʧ��
     */
    public boolean delete(int data) {
        // ����
        if (isEmpty())
            return false;

        RBTreeNode target = search(data);
        // ���в����ڸ����ݣ��޷�ɾ��
        int targetData = target.getData();
        if (targetData != data)
            return false;

        final RBTreeNode parent = target.getParent();
        final RBTreeNode left = target.getLeftChild();
        final RBTreeNode right = target.getRightChild();
        // �������������ɾ�������Ǹ����
        RBTreeNode replacement;
        Color originalColor = target.getColor();

        // �������գ��������������1�������������� 2��������������
        if (right.isNull()) {
            if (target == parent.getLeftChild())
                parent.setLeftChild(left);
            else
                parent.setRightChild(left);
            left.setParent(parent);
            replacement = left;
        }
        // ��������
        else if (left.isNull()) {
            if (target == parent.getLeftChild())
                parent.setLeftChild(right);
            else
                parent.setRightChild(right);
            right.setParent(parent);
            replacement = right;
        }
        // �����������ǿ�
        else {
            // �ҵ���ɾ���������������ҷ�֧��ͷ��Ҷ���
            // ��֮�滻��ɾ���Ľ���λ��
            RBTreeNode temp = target.getLeftChild();
            while (!temp.getRightChild().isNull())
                temp = temp.getRightChild();

            target.setData(temp.getData());

            RBTreeNode tempLeftChild = temp.getLeftChild();
            RBTreeNode tempParent = temp.getParent();
            // temp�ĸ�����Ե���target���
            // ˵��ѭ����û��ִ�У���target����������û���ҷ�֧
            if (tempParent == target)
                tempParent.setLeftChild(tempLeftChild);
            else
                tempParent.setRightChild(tempLeftChild);
            tempLeftChild.setParent(tempParent);

            // ��������һ��trick������temp��target��data
            // ���ղ���ɾ��target������ɾ��temp���
            // �����油tempλ�õģ�����tempLeftChild
            replacement = tempLeftChild;
            // ��Ϊɾ������temp������originColorҪ�޸ĳ�temp����ɫ
            originalColor = temp.getColor();
        }
        // ���ṹ�仯�����򻺴����
        midOrderVisitList.clear();
        // ��ɾ���Ľ��Ϊ�ڲſ�������������ƽ��
        if (originalColor == Color.BLACK)
            deleteRebalance(replacement);
        return true;
    }

    public RBTreeNode getBrother(RBTreeNode node) {
        RBTreeNode parent = node.getParent();
        if (node == parent.getLeftChild())
            return parent.getRightChild();
        return parent.getLeftChild();
    }

    public void deleteRebalance(RBTreeNode node) {
        while (node != getRoot() && node.getColor() == Color.BLACK) {
            RBTreeNode parent = node.getParent();
            RBTreeNode brother, brotherLeftChild, brotherRightChild;

            // ����
            if (node == parent.getLeftChild()) {
                brother = parent.getRightChild();
                brotherLeftChild = brother.getLeftChild();
                brotherRightChild = brother.getRightChild();
                // case 1�����ֵܽڵ�Ϊ��
                // ��ת�ֵܽ���븸������ɫ
                // �Ը����Ϊ��������
                // �����ֵܽ��Ϊԭ�����������������Һ���
                // ��Ϊ����µ��Һ�����ԭ�ֵܽ��ĺ���
                // ��ԭ�ֵܽ��Ϊ�죬�亢�ӱ�Ϊ��
                // ���case 1���ջ�ת����case 2/3/4�е�ĳһ��
                if (isRed(brother)) {
                    brother.setColor(Color.BLACK);
                    parent.setColor(Color.RED);
                    parent.leftRotate();
                    brother = parent.getRightChild();
                }
                // case 2�����ֵ�Ϊ�ڣ����ֵܵ���������Ϊ��
                // �ֵܱ�죬���޸��������һ���������
                // ֻ��case 2�ᵼ���޸�������
                // ���ƺ�����β�ȷ����������case 1/2/3/4��Ҳ�����޸����
                // �޸���ɵ���������֣�
                // 1�����ƺ�Ľ��Ϊ�죬��ʱ����ѭ��������node�ú�
                // 2�����ƺ󵽴����㣬ͬ������ѭ��������node�ú�
                else if (!isRed(brotherLeftChild) && !isRed(brotherRightChild)) {
                    brother.setColor(Color.RED);
                    node = parent;
                }
                // case 3�����ֵ�Ϊ�ڣ����ֵܵ�����Ϊ��, �Һ���Ϊ��
                // �����ֵܺ������ӵ���ɫ
                // �����ֵ�Ϊ�������
                // �����ֵܽ��Ϊԭ�����������������Һ���
                // �����󣬱�ɵ�4�����
                else if (!isRed(brotherRightChild)) {
                    brother.setColor(Color.RED);
                    brotherLeftChild.setColor(Color.BLACK);
                    brother.rightRotate();
                    brother = parent.getRightChild();
                }
                // case 4�����ֵ�Ϊ�ڣ����ֵܵ��Һ���Ϊ�죨���Ӻ��ڣ�
                // �ֵܽ�����ɫ�ĳɸ������ɫ
                // ��󸸽�����ֵܵ��Һ��Ӷ�Ϳ�ɺ�
                // �Ը����Ϊ������������ʱ�޸����
                else if (isRed(brotherRightChild)) {
                    brother.setColor(parent.getColor());
                    parent.setColor(Color.BLACK);
                    brotherRightChild.setColor(Color.BLACK);
                    parent.leftRotate();
                    node = getRoot();// �޸���ɣ�����ѭ��
                }
            }
            // �Һ���
            else {
                brother = parent.getLeftChild();
                brotherLeftChild = brother.getLeftChild();
                brotherRightChild = brother.getRightChild();
                // case 1�����ֵܽڵ�Ϊ��
                if (isRed(brother)) {
                    brother.setColor(Color.BLACK);
                    parent.setColor(Color.RED);
                    parent.rightRotate();
                    brother = parent.getLeftChild();
                }
                // case 2�����ֵ�Ϊ�ڣ����ֵܵ���������Ϊ��
                else if (!isRed(brotherLeftChild) && !isRed(brotherRightChild)) {
                    brother.setColor(Color.RED);
                    node = parent;
                }
                // case 3�����ֵ�Ϊ�ڣ����ֵܵ��Һ���Ϊ��, ����Ϊ��
                else if (!isRed(brotherLeftChild)) {
                    brother.setColor(Color.RED);
                    brotherRightChild.setColor(Color.RED);
                    brother.rightRotate();
                    brother = parent.getLeftChild();
                }
                // case 4�����ֵ�Ϊ�ڣ����ֵܵ�����Ϊ�죨�Һ��Ӻ��ڣ�
                else if (isRed(brotherLeftChild)) {
                    brother.setColor(parent.getColor());
                    parent.setColor(Color.BLACK);
                    brotherLeftChild.setColor(Color.BLACK);
                    parent.rightRotate();
                    node = getRoot();// �޸���ɣ�����ѭ��
                }
            }
        }
        node.setColor(Color.BLACK);
    }

    /**
     * ���Ĳ������
     */
    public void layerVisit() {
        if (isEmpty())
            return;
        Queue<RBTreeNode> queue = new LinkedList<RBTreeNode>();
        queue.offer(getRoot());
        while (!queue.isEmpty()) {
            RBTreeNode node = queue.poll();

            if (node.isNull()) {
                System.out.println("null");
                continue;
            }
            System.out.println(node);

            RBTreeNode left = node.getLeftChild();
            RBTreeNode right = node.getRightChild();
            queue.offer(left);
            queue.offer(right);
        }
    }
}
