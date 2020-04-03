package ExerciseJava;

import java.util.LinkedList;
import java.util.Queue;
//层序遍历
public class LevelOrder {
    static class Node{
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
        }
    }
    public void levelOrderTraversal(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
          Node cur=queue.poll( );
          //打印元素
            System.out.print(cur.val+" ");
          if(root.left!=null){
              queue.offer(root.left);
          }
          if(root.right!=null){
              queue.offer(root.right);
          }
        }
    }
}
