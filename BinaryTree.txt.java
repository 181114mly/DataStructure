package ExerciseJava;

public class BinaryTree {
   static class Node{
       public char val;
       public  Node left;
       public Node right;

       public Node(char val) {
           this.val = val;
       }
   }
    public static Node buildtree(){
      Node A=new Node('A');
      Node B=new Node('B');
      Node C=new Node('C');
      Node D=new Node('D');
      Node E=new Node('E');
      Node F=new Node('F');
      Node G=new Node('G');
      Node H=new Node('H');
      A.left=B;
      A.right=C;
      B.left=D;
      B.right=E;
      E.left=G;
      G.right=H;
      C.right=F;
      return A;
    }
    //前序遍历，递归
   public static void preOrder(Node root){
       if(root==null){
           return;
       }
       System.out.print(root.val+" ");
       preOrder(root.left);
       preOrder(root.right);
   }
   //中序遍历，递归
   public static void inOrder(Node root){
       if(root==null){
           return;
       }
       inOrder(root.left);
       System.out.print(root.val+" ");
       inOrder(root.right);
   }
   //后续遍历，递归
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static void main(String[] args) {
        Node node=buildtree();

        System.out.print("前序遍历：");
        preOrder(node);
        System.out.println();

        System.out.print("中序遍历：");
        inOrder(node);
        System.out.println();

        System.out.print("后序遍历：");
        postOrder(node);
        System.out.println();

    }
}
