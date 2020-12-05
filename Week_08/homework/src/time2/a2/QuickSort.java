package time2.a2;

public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        int pivot = devide(arr, left, right);
        if (left < pivot - 1) {
            quickSort(arr, left, pivot - 1);
        }
        if (pivot < right) {
            quickSort(arr, pivot, right);
        }
    }

    private static int devide(int[] arr, int left, int right) {
        int middle = arr[(left + right) / 2];
        while (left < right) {
            while (arr[left] < middle) {
                left ++;
            }
            while (arr[right] > middle) {
                right --;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left ++;
                right --;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 8, 14, 6, 7, 10};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // arrSort(new int[0]);
    }
}
