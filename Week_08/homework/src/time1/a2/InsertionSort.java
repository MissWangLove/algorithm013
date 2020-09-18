package time1.a2;

public class InsertionSort {

    /**
     * 插入排序
     * 假设前面有序，从未排序里面拿元素插入到前面已排序的里面
     */

    /**
     * 插入排序的时间复杂度是 O(n ^ 2)
     * 看起来代码比选择排序简单，但是我觉得思路都一样，想的时候比选择排序难点
     */
    public static void arrSort(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return ;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
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
