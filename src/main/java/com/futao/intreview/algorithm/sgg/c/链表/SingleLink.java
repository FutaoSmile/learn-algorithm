package com.futao.intreview.algorithm.sgg.c.链表;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 单向链表
 *
 * @author futao
 * @date 2020/10/15
 */
public class SingleLink<E> implements LinkedList<E> {

    /**
     * 节点
     */
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class Node {

        /**
         * 当前节点存储的元素
         */
        private E e;

        /**
         * 指向下一个节点
         */
        private Node next;
    }


    /**
     * 头节点
     */
    private Node headNode = null;

    /**
     * 添加元素到队列头
     *
     * @param e 要添加的元素
     */
    public void addFirst(E e) {
        // 要添加的节点,要添加的节点的next为当前的headNode
        // 头节点指向当前添加的节点
        headNode = new Node(e, headNode);
    }

    /**
     * 添加元素到队尾
     *
     * @param e 要添加的元素
     */
    public void addLast(E e) {
        // 要添加的节点
        Node curNode = new Node(e, null);

        if (headNode == null) {
            addFirst(e);
            return;
        }
        Node _curNode = this.headNode;
        while (_curNode.getNext() != null) {
            _curNode = _curNode.getNext();
        }
        _curNode.setNext(curNode);
    }

    /**
     * 删除元素
     *
     * @param e 要删除的元素
     */
    public boolean delete(E e) {
        if (headNode == null) {
            return false;
        }
        if (headNode.getE() == e) {
            headNode = null;
            return true;
        }
//        Node _curNode = this.headNode;
//
//        while (true) {
//            if (_curNode.getNext() != null)
//        }

        return false;
    }

    /**
     * 打印
     */
    public void print() {
        System.out.print("【");
        Node curNode = headNode;
        while (curNode != null) {
            System.out.println("\t" + curNode.getE());
            curNode = curNode.next;
        }
        System.out.println("】");
    }

    /**
     * 判断链表是否为空
     *
     * @return 链表是否为空
     */
    public boolean isEmpty() {
        return false;
    }
}
