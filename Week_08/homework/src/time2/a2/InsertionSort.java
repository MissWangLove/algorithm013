package time2.a2;

public class InsertionSort {

    /**
     * 插入排序
     * 假设前面有序，从未排序里面拿元素插入到前面已排序的里面
     */

    public static void arrSort(int[] arr) {

    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 8, 14, 6, 7, 10};
        arrSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // arrSort(new int[0]);
    }
}
