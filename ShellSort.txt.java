package Sort;

import java.util.Arrays;

//希尔排序
public class ShellSort {
    public static void shellSort(int[] array){
        int gap=array.length/2;
        while(gap>1) {
            insertSortGap(array,gap);
            gap/=2;
        }
        insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for(int bound=gap;bound<array.length;bound++){
            int v=array[bound];
            int cur=bound-gap;
            for(;cur>=0;cur-=gap){
                if(array[cur]>v){
                    array[cur+gap]=array[cur];
                }
                else{
                    break;
                }
            }
            array[cur+gap]=v;
        }
    }

    public static void main(String[] args) {
        int[] array={9,5,2,7,4,1,6,3,8};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
