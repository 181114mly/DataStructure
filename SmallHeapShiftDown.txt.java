package Heap;

import java.util.Arrays;
//小堆向下调整，从后向前遍历数组
public class SmallHeapShiftDown {
    public static void shiftDown(int[] arr,int size,int index){
        int parent=index;
        int child=2*index+1;
        while(child<size){
            //找出左右子树中的较小值
            if(child+1<size&&arr[child]>arr[child+1]) {
               child=child+1;
             }
            //用较小值和parent位置的元素进行比较
            //如果parent位置的元素大，就交换parent位置和child位置的元素。
            if(arr[parent]>arr[child]){
                int temp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=temp;
            }
            //
            else{
                break;
            }
            //更新parent和child
            parent=child;
            child=parent*2+1;
        }
    }
    public static void createHeap(int[] arr,int size){
        for(int i=(size-1-1)/2;i>=0;i--){
            shiftDown(arr,size,i);
        }
    }

    public static void main(String[] args) {
        int[] arr={9, 5, 2, 7, 3, 6, 8,1};
        createHeap(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
