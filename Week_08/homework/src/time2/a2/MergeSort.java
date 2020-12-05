package time2.a2;

public class MergeSort {

    public static void  mergeSort(int[] arr) {
        devide(arr, 0, arr.length - 1);
    }

    private static void devide(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            devide(arr, low, middle);
            devide(arr, middle + 1, high);
            meger(arr, low, middle, high);
        }
    }

    private static void meger(int[] arr, int low, int middle, int high) {
        int[] helper = new int[arr.length];
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }
        int left = low;
        int right = middle + 1;
        int i = low;
        while (left <= middle && right <= high) {
            if (helper[left] <= helper[right]) {
                arr[i ++] = helper[left ++];
            } else {
                arr[i ++] = helper[right ++];
            }
        }
        // 右边的数组大于左边的情况
        if (left < middle) {
            for (int j = 0; j <= middle - left; j ++) {
                arr[i + j] = helper[left + j];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 8, 14, 6, 7, 10};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // arrSort(new int[0]);
    }
}
