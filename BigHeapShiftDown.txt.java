package Heap;

import java.util.Arrays;
//大堆向下调整,从后往前遍历数组
public class BigHeapShiftDown {
    public static void shiftDown(int[] arr,int size,int index){
        int parent=index;
        int child=2*parent+1;
        while(child<size){
            if(child+1<size && arr[child+1]>arr[child]){
                child=child+1;
            }
            if(arr[parent]<arr[child]){
                int temp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=temp;
            }
            else{
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }
    public static void buildHeap(int[] arr,int size){
        for(int i=(size-1-1)/2;i>=0;i--){
            shiftDown(arr,size,i);
        }
    }

    public static void main(String[] args) {
        int[] arr={9, 5, 2, 7, 3, 6, 8,1};
        buildHeap(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
