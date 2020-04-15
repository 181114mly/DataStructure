package Sort;
import java.util.Arrays;
//插入排序
public class InsertSort {
    public static void insertSort(int[] array){
        for(int bound=1;bound<array.length;bound++){
            int v=array[bound];
            int cur=bound-1;
            for(;cur>=0;cur--){
                //这个条件如果写成 >= , 插入排序就不是稳定排序了
                if(array[cur]>v){
                    array[cur+1]=array[cur];
                }
                else{
                    break;
                }
            }
            array[cur+1]=v;
        }
    }

    public static void main(String[] args) {
        int[] array={9,5,2,7,4,1,6,3,8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
