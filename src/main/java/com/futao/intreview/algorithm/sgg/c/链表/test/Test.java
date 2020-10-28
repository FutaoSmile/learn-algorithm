package com.futao.intreview.algorithm.sgg.c.链表.test;

import com.futao.intreview.algorithm.sgg.c.链表.SingleLink;
import lombok.*;

/**
 * @author futao
 * @date 2020/10/15
 */
public class Test {

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Hero {
        private int no;
        private String name;
        private String nickName;
    }

    public static void main(String[] args) {
        SingleLink<Hero> heroSingleLink = new SingleLink<Hero>();
        heroSingleLink.print();

        heroSingleLink.addFirst(new Hero(2, "老二", "ER"));
        heroSingleLink.addFirst(new Hero(1, "老大", "DA"));
        heroSingleLink.print();

        heroSingleLink.addLast(new Hero(3, "老三", "SAN"));

        heroSingleLink.print();
    }
}
