package ExerciseJava;
import java.util.Stack;

class TreeNode {
    public char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
public class BinaryTreeLoop {
    public static TreeNode build(){
       TreeNode A=new TreeNode('A');
       TreeNode B=new TreeNode('B');
       TreeNode C=new TreeNode('C');
       TreeNode D=new TreeNode('D');
       TreeNode E=new TreeNode('E');
       TreeNode F=new TreeNode('F');
       TreeNode G=new TreeNode('G');
       TreeNode H=new TreeNode('H');
        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        E.left=G;
        G.right=H;
        C.right=F;
        return A;
    }
    //前序遍历，非递归
    public static void preOrderByLoop(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            System.out.print(cur.val+" ");
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
    }
    //中序遍历，非递归
    public static void inOrderByLoop(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(true){
           while(cur!=null){
               stack.push(cur);
               cur=cur.left;
           }
           if(stack.isEmpty()){
               break;
           }
           TreeNode top=stack.pop();
           System.out.print(top.val+" ");

           cur=top.right;
        }
    }
    //后序遍历，非递归访问
    public static void postOrderByLoop(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode prev=null;
        while(true){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            TreeNode top=stack.peek();
            if(top.right==null||prev==top.right){
                System.out.print(top.val+" ");
                stack.pop();
                prev=top;
            }
            else{
             cur=top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root=build();
        System.out.println("前序遍历2：");
        preOrderByLoop(root);
        System.out.println();
        System.out.println("中序遍历：");
        inOrderByLoop(root);
        System.out.println();
        System.out.println("后序遍历：");
        postOrderByLoop(root);
        System.out.println();

    }
}
