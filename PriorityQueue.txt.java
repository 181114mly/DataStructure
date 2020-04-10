package Heap;
//以大堆为例
public class PriorityQueue {
    //向上调整
    public static void shiftUp(int[] arr,int index){
        int child=index;
        int parent=(index-1)/2;
        while(child>0){
            if(arr[parent]<arr[child]){
                int temp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=temp;
            }
            else{
               break;
            }
            child=parent;
            parent=(child-1)/2;
        }
    }
//入队列
    private int[] arr=new int[10];
    private int size=0;
    public  void offer(int x){
       arr[size]=x;
       size++;
       shiftUp(arr,size-1);
    }
    //出队列
    public int poll(){
      int oldValue=arr[0];
      arr[0]=arr[size-1];
      size--;
        shiftDown(arr,size,0);
      return oldValue;
    }
    //向下调整
    public static void shiftDown(int[] arr,int size,int index){
        int parent=index;
        int child=2*parent+1;
        while(child<size){
            if(child+1<size&&arr[child+1]>arr[child]){
                child=child+1;
            }
            if(arr[child]>arr[parent]){
                int temp=arr[child];
                arr[child]=arr[parent];
                arr[parent]=temp;
            }
            else{
                break;
            }
             parent=child;
             child=parent*2+1;
        }
    }
    //取队首元素
    public int peek(){
        return arr[0];
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
      PriorityQueue queue =new PriorityQueue();
      queue.offer(2);
      queue.offer(8);
      queue.offer(3);
      queue.offer(6);
      queue.offer(9);
      queue.offer(7);
      queue.offer(5);
      
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur+" ");
        }
    }
}
