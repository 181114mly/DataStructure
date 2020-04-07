package BinaryTree;

public class OtherBinaryTree {
    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x)
        {
            val = x;
        }
    }
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
    //求结点个数
    public static int count(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+count(root.left)+count(root.right);
    }
    //求叶子节点个数
    public static int leaveCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leaveCount(root.left) + leaveCount(root.right);
    }

    // 求二叉树第 k 层节点的个数
    public static int kLevelSize (TreeNode root, int k){
        if (k < 1 || root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.left, k - 1) + kLevelSize(root.right, k - 1);
    }
    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    public static TreeNode find(TreeNode root, char val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        TreeNode result=find(root.left,val);
        if(result!=null){
            return result;
        }
        return find(root.right,val);
    }

    public static void main(String[] args) {
        TreeNode node=build();
        int sum=count(node);
        System.out.println("二叉树节点个数为："+sum);

        int sum1=leaveCount(node);
        System.out.println("二叉树中叶子节点个数为："+sum1);

        int sum2=kLevelSize(node,4);
        System.out.println("求二叉树第 k 层节点的个数"+sum2);

    }
}
