package sort;

import java.util.Arrays;

/**
 * @author xql
 * @create 2022-02-25 14:27
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] a = {8, 6, 4, 2, 7, 5, 3, 1, 9};
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bubble_v2(a);
    }


    /**
     * 冒泡排序最终算法
     * bbb
     * @param a
     */
    public static void bubble_v2(int[] a){

        int times = a.length - 1;//每轮需要比较的次数

        while (true) {
            int coordinate = 0;
            for (int i = 0; i < times; i++) {
                System.out.println("比较次数" + i);
                if (a[i] > a[i + 1]){
                    convert(a, i, i + 1);
                    coordinate = i;//记录最后一次交换的i的下标
                }
            }
            times = coordinate;
            if ( 0 == coordinate){
                break;
            }
            System.out.println("第轮冒泡" + Arrays.toString(a));
        }
    }

    public static void bubble(int[] a) {

        for (int j = 0; j < a.length - 1; j++) {

            boolean swapped = false;

            for (int i = 0; i < a.length - 1 - j; i++) {
                System.out.println("比较次数" + i);
                if (a[i] > a[i + 1]){
                    convert(a, i, i + 1);

                    swapped = true;

                    //convert(a, a[i], a[j]);
                    //不要错把数组的值当成数组下标传递过去
                }
            }
            if (swapped == false){
                break;
            }


            System.out.println("第" + j + "轮冒泡" + Arrays.toString(a));
        }


    }

    public static void convert(int[] a, int i, int j){

        int t = a[i];
        a[i] = a[j];
        a[j] = t;

    }
}
