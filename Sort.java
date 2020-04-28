package Sort;

import java.util.Arrays;

public class Sort {
    private static void insertSort(int[] array){
       for(int bound=1;bound<array.length;bound++){
           int temp=array[bound];
           int cur=bound-1;
           for(;cur>=0;cur--){
               if(array[cur]>temp){
                   array[cur+1]=array[cur];
               }
               else{
                   break;
               }
           }
           array[cur+1]=temp;
       }
    }
    private static void shellSort(int[] array){
        int gap=array.length/2;
        while(gap>1){
            shellSortHelper(array,gap);
            gap/=2;
        }
        shellSortHelper(array,1);
    }
    private static void shellSortHelper(int[] array,int gap){
        for(int bound=gap;bound<array.length;bound++){
            int temp=array[bound];
            int cur=bound-gap;
            for(;cur>=0;cur-=gap){
                if(array[cur]>temp){
                    array[cur+gap]=array[cur];
                }
                else{
                   break;
                }
            }
            array[cur+gap]=temp;
        }
    }

    private static void bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                //如果这里写成>=就无法保证稳定性
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }else{
                    continue;
                }
            }
        }
    }

    private static void quickSort(int[] array,int beg,int end){
        if(beg>=end){
            return;
        }
        int index=partition(array,beg,end);
        quickSort(array,beg,index-1);
        quickSort(array,index+1,end);
    }

    private static int partition(int[] array,int beg,int end){
        int left=beg;
        int right=end;
        int temp=array[end];
        while(left<right){
            while(left<right&&array[left]<=temp){
                left++;
            }
            while(left<right&&array[right]>=temp){
                right--;
            }
           swap(array,left,right);
        }
        swap(array,left,end);
        return left;
    }

    private static void swap(int[] array,int i, int j) {
        int m=array[i];
        array[i]=array[j];
        array[j]=m;
    }

    private static void selectSort(int[] array){
        for(int bound=0;bound<array.length;bound++){
            for(int cur=bound+1;cur<array.length;cur++){
                if(array[cur]<array[bound]){
                    int temp=array[bound];
                    array[bound]=array[cur];
                    array[cur]=temp;
                }
            }
        }
    }

    private static void heapSort(int[] array){
        createHeap(array);
        for(int i=0;i<array.length;i++){
            swap(array,0,array.length-i-1);
            shiftDown(array,array.length-i-1,0);
        }
    }

    private static void createHeap(int[] array) {
        for(int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
    }
    private static void shiftDown(int[] array,int size,int index){
        //建大堆
       int parent=index;
       int child=2*parent+1;
       while(child<size){
           if (child + 1 < size && array[child+1]>array[child]) {
               child=child+1;
           }
           if(array[parent]<array[child]){
               swap(array,child,parent);
           }
           else{
               break;
           }
           parent=child;
           child=2*parent+1;
       }
    }
     private static void mergeSort(int[] array){
        mergeSortHelper(array,0,array.length);
     }
    //[left,mid)
    //[mid,right)
     private static void mergeSortHelper(int[] array,int left,int right){
        //不能写成if(left>=right){return;}
        if(right-left<=1){
            return;
        }
        int mid=(left+right)/2;
        mergeSortHelper(array,left,mid);
        mergeSortHelper(array,mid,right);
        merge(array,left,mid,right);
     }
     private static void merge(int[] array,int low,int mid,int high){
        int[] extra=new int[high-low];
        int cur1=low;
        int cur2=mid;
        int index=0;
        while(cur1<mid&&cur2<high){
            //写成<不能保证稳定性
            if(array[cur1]<=array[cur2]){
                extra[index]=array[cur1];
                cur1++;
                index++;
            }
            else{
                extra[index]=array[cur2];
                cur2++;
                index++;
            }
        }
        while(cur1<mid){
            extra[index]=array[cur1];
            cur1++;
            index++;
        }
        while(cur2<high){
            extra[index]=array[cur2];
            cur2++;
            index++;
        }
        for(int i=0;i<high-low;i++){
            array[low+i]=extra[i];
        }
     }
    public static void main(String[] args) {
        int[] arr={8,5,9,2,7,6,1,4,3};
        //insertSort(arr);
        //shellSort(arr);
        //quickSort(arr,0,arr.length-1);
        //bubbleSort(arr);
       // selectSort(arr);
        //heapSort(arr);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
