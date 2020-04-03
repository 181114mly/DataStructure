package ExerciseJava;

import java.util.LinkedList;
import java.util.Queue;

// 判断一棵树是不是完全二叉树
public class CompleteTree {
    static class Node{
        public char val;
        public Node left;
        public Node right;
        public Node(char val) {
            this.val = val;
        }
    }
    public boolean isCompleteTree(Node root) {
    if(root==null){
        return true;
    }
    //设计标志位进行阶段转化
     boolean isSecondStage=false;
    //对二叉树进行层序遍历
    Queue<Node> queue=new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
        Node cur=queue.poll();
        //第一阶段，任何一个节点，一定有两个子树
        if(!isSecondStage){
            //左子树不为空，右子树不为空，将左右子树入队
            if(root.left!=null&&root.right!=null){
                queue.offer(root.left);
                queue.offer(root.right);
            }
            //左子树不为空，右子树为空，进入第二阶段
            else if(root.left!=null&&root.right==null){
                queue.offer(root.left);
                isSecondStage=true;
            }
            //左子树为空，右子树不为空，不是完全二叉树
            else if(root.left==null&&root.right!=null){
                return false;
            }
            //左子树为空，右子树为空，进入第二阶段
            else if(root.left==null&&root.right==null){
                isSecondStage=true;
            }
        }
        //第二阶段，任何一个节点一定没有子树
        else{
            //找到一个反例，就不是完全二叉树
            if(root.left!=null||root.right!=null){
                return false;
            }
        }
    }
    return true;
    }
}
