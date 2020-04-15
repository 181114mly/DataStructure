package Sort;

import java.util.Arrays;
//堆排序
public class HeapSort {
    public static void heapSort(int[] array){
        //建造一个堆
        buildHeap(array);
        //把堆顶元素 和 堆的最后一个元素 进行交换
        //循环此时时length-1,当堆中有一个元素的时候，是有序的
        for(int i=0;i<array.length-1;i++){
            //此时堆中元素个数为length-i
            //堆中最后一个元素的下标为length-i-1
            swap(array,0,array.length-i-1);
            //交换完成之后，堆中元素个数又减少一，堆中元素个数为array.length-i-1;
            shiftDown(array,array.length-i-1,0);
        }
    }

    private static void buildHeap(int[] array) {
        for(int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while(child<size){
            while(child+1<size&&array[child+1]>array[child]){
                child=child+1;
            }
            if(array[parent]<array[child]){
                swap(array,parent,child);
            }else{
                break;
            }
            parent=child;
            child=2*parent+1;
        }
    }

    public static void main(String[] args) {
        int[] array={9,5,2,7,4,1,6,3,8};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
