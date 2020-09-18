package time1.a2;

public class QuickSort {
    /**
     * 快速排序
     *
     * 分，找标杆，左右两侧
     */

    /**
     * 这个是在原数组上进行操作，使用最后一个元素作为标杆，然后划分两界，递归就可以得到最后排序后的数组
     */
    public static void arrSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = getPivot(arr, begin, end);
        arrSort(arr, begin, pivot - 1);
        arrSort(arr, pivot + 1, end);
    }

    private static int getPivot(int[] arr, int begin, int end) {
        int count = begin;
        int pivot = end;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                count ++;
            }
        }
        int temp = arr[count];
        arr[count] = arr[pivot];
        arr[pivot] = temp;
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 8, 14, 6, 7, 10};
        arrSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // arrSort(new int[0]);
    }
}
