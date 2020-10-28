package com.futao.intreview.algorithm.sgg.a.稀疏数组;

import java.util.Arrays;

/**
 * 稀疏数组，减少需要存储的数据量
 *
 * @author futao
 * @date 2020/10/14
 */
public class A {

    private static final int ROWS = 11;

    public static void main(String[] args) {
        // 白色棋子(2,3)    1
        // 黑色棋子(3,4)    2

        int[][] checkerboard = new int[A.ROWS][A.ROWS];
        checkerboard[1][2] = 1;
        checkerboard[2][3] = 2;

        for (int[] x : checkerboard) {
            for (int item : x) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        int[][] ints = new A().normalArrayToSparseArray(checkerboard);
        System.out.println(Arrays.deepToString(ints));

//        // 使用稀疏数组保存
//        int[][] spArr = new int[3][3];
//
//        // 第一行保存 原始数组的 行数，列数，元素个数
//        spArr[0][0] = A.ROWS;
//        spArr[0][1] = A.ROWS;
//        spArr[0][2] = 2;
//
//        // 第二行保存 第一个元素的行、列、值
//        spArr[1][0] = 1;
//        spArr[1][1] = 2;
//        spArr[1][2] = 1;
//
//        // 第三行保存 第二个元素的行、列、值
//        spArr[2][0] = 2;
//        spArr[2][1] = 3;
//        spArr[2][2] = 2;
//
//        for (int[] rows : spArr) {
//            for (int item : rows) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
//        }
        int[][] ints1 = new A().sparseArrayToNormalArray(ints);
        for (int[] ints2 : ints1) {
            for (int i : ints2) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    /**
     * 稀疏数组恢复成原始二维数组
     *
     * @param sparseArray 稀疏数组
     * @return 还原之后的原始二维数组
     */
    public int[][] sparseArrayToNormalArray(int[][] sparseArray) {
        // 行数
        int rowLen = sparseArray[0][0];
        // 列数
        int colLen = sparseArray[0][1];
        // 原始二维数组
        int[][] normalArray = new int[rowLen][colLen];

        for (int i = 1; i < sparseArray.length; i++) {
            int[] curRow = sparseArray[i];
            // 赋值给原始数组
            normalArray[curRow[0]][curRow[1]] = curRow[2];
        }
        return normalArray;
    }

    /**
     * 普通二维数组压缩为稀疏数组
     *
     * @param normalArray 原始二维数组
     * @return 压缩之后的稀疏数组
     */
    public int[][] normalArrayToSparseArray(int[][] normalArray) {
        // 行数
        int rowLen = normalArray.length;
        // 列数
        int colLen = normalArray[0].length;

        int sum = 0;

        for (int[] rowItems : normalArray) {
            for (int colItem : rowItems) {
                if (colItem != 0) {
                    ++sum;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];

        sparseArray[0][0] = rowLen;
        sparseArray[0][1] = colLen;
        sparseArray[0][2] = sum;

        int curRowIndex = 1;

        for (int i = 0; i < normalArray.length; i++) {
            int[] rwoItem = normalArray[i];
            for (int j = 0; j < rwoItem.length; j++) {
                int item = rwoItem[j];
                if (item != 0) {
                    sparseArray[curRowIndex][0] = i;
                    sparseArray[curRowIndex][1] = j;
                    sparseArray[curRowIndex][2] = item;
                    ++curRowIndex;
                }
            }
        }
        return sparseArray;
    }
}
