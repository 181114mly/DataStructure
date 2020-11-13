//判断一个树是不是平衡二叉树
package Nowcoder;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class BalancedTree {
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        int left=maxHeight(root.left);
        int right=maxHeight(root.right);
        if(left-right>1||left-right<-1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    private int maxHeight(TreeNode node) {
        if(node==null){
            return 0;
        }
        if(node.left==null&&node.right==null){
            return 1;
        }
        int height1=maxHeight(node.left);
        int height2=maxHeight(node.right);
        //加一加的是根节点的高度
        int max=Math.max(height1,height2)+1;
        return max;
    }
}
