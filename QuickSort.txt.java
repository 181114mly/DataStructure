package Sort;


import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array){
        quickSortHelper(array, 0, array.length - 1);
    }
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            // 区间中有0个或者1个元素,不需要排序
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int beg = left;
        int end = right;
        // 取最右侧元素为基准值
        int base = array[right];
        while (beg < end) {
            // 从左往右找到比基准值大的元素
            while (beg < end && array[beg] <= base) {
                beg++;
            }
            // 从右往左找比基准值小的元素
            while (beg < end && array[end] >= base) {
                end--;
            }
            // 交换 beg 和 end 的值
            swap(array, beg, end);
    }
        swap(array, beg, right);
        return beg;
}
    private static void swap(int[] array, int beg, int end) {
        int temp=array[beg];
        array[beg]=array[end];
        array[end]=temp;
    }

    public static void main(String[] args) {
        int[] array={9,3,6,8,1,5,4};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    }
