package Sort;

import java.util.Arrays;
//选择排序
public class SelectSort {
    public static void selectSort(int[] array){
     for(int i=0;i<array.length;i++){
         for(int j=i+1;j<array.length;j++){
             if(array[j]<array[i]){
                 int temp=array[j];
                 array[j]=array[i];
                 array[i]=temp;
             }
         }
     }
    }

    public static void main(String[] args) {
        int[] array={9,5,2,7,4,1,6,3,8};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
