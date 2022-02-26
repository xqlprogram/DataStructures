package search;

/**
 * @author xql
 * @create 2022-02-24 12:44
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {1, 2, 4, 7, 8, 10, 11, 14, 15, 18, 22, 26};

        int target = 10;
        int idx = BinarySearch(array, target);

        System.out.println("数值为：" + idx + "[" + target + "]");

    }

    public static int BinarySearch(int[] a, int t){

        int l = 0, r = a.length - 1, m;

        while (l <= r){

            m = (l + r)/2;

            if (a[m] == t) {
                return m;
            } else if (a[m] > t) {
                r = m - 1;
            }else {
                l = m + 1;
            }
        }

        return -1;
    }
}
