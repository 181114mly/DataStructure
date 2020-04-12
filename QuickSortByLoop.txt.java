package Sort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSortByLoop {
    public static void quickSoreByLoop(int[] array){
        //Integer 代表数组下标
        Stack<Integer> stack=new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left=stack.pop();
            int right=stack.pop();
            if(left>=right){
                continue;
            }
            int index=partition(array,left,right);
            stack.push(right);
            stack.push(index+1);

            stack.push(index-1);
            stack.push(0);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int beg=left;
        int end=right;
        int base=array[right];
        while(beg<end){
             while(beg<end&&array[beg]<=base){
                 beg++;
             }
             while(beg<end&&array[end]>=base){
                 end--;
             }
             swap(array,beg,end);
        }
        //结束while循环的原因beg和end重合。
        swap(array,beg,right);
        return beg;
    }
    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={8,3,7,2,9,6,1,4};
        quickSoreByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
}
