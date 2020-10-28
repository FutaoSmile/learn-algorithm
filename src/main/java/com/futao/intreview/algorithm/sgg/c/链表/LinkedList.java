package com.futao.intreview.algorithm.sgg.c.链表;

/**
 * @author futao
 * @date 2020/10/15
 */
public interface LinkedList<E> {
    /**
     * 添加元素到队列头
     *
     * @param e 要添加的元素
     */
    void addFirst(E e);

    /**
     * 添加元素到队尾
     *
     * @param e 要添加的元素
     */
    void addLast(E e);

    /**
     * 删除元素
     *
     * @param e 要删除的元素
     */
    boolean delete(E e);

    /**
     * 打印
     */
    void print();

    /**
     * 判断链表是否为空
     *
     * @return 链表是否为空
     */
    boolean isEmpty();
}
