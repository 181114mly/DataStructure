package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr){
        mergeSortHelper(arr,0,arr.length);
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {
        if(right-left<=1){
            return;
        }
        int mid=(left+right)/2;
        mergeSortHelper(arr,left,mid);
        mergeSortHelper(arr,mid,right);
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr,int low,int mid,int high) {
        //创建一个数组
        int[] extra=new int[high-low];
        int cur1=low;
        int cur2=mid;
        int index=0;
        while(cur1<mid&&cur2<high){
            if(arr[cur1]<=arr[cur2]){
                extra[index]=arr[cur1];
                cur1++;
                index++;
            }
            else{
                extra[index]=arr[cur2];
                cur2++;
                index++;
            }
        }
        while(cur1<mid){
            extra[index]=arr[cur1];
            cur1++;
            index++;
        }
        while(cur2<high){
            extra[index]=arr[cur2];
            cur2++;
            index++;
        }
        for(int i=0;i<high-low;i++){
            arr[low+i]=extra[i];
        }
    }

    public static void main(String[] args) {
        int[] array={9,3,6,8,1,5,4};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
