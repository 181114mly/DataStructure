package SearchTree;

public class BinarySearchTree {
    static class Node{
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }
    public static Node root=null;
    //查找
    public static Node find(int key){
        Node cur=root;
        while(cur!=null){
            if(key<cur.key){
                cur=cur.left;
            }
            else if(key>cur.key){
                cur=cur.right;
            }
            else{
                return cur;
            }
        }
        return null;
    }
    //插入
    private boolean insert(int key){
        if(root==null){
            root=new Node(key);
            return true;
        }
        Node cur=root;
        //parent是cur的父节点，和链表类似，插入需要记录前一个节点的位置
        Node parent=null;
        while(cur!=null){
            if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }
            else if(key>cur.key){
                parent=cur;
                cur=cur.right;
            }
            else{
         //发现相同的key，插入失败
                return false;
            }
        }
        //while循环结束后，cur为null，找到该插入元素的父节点
        //用待插入的值和父节点的值进行比较，才能判断插入到父节点的左子树还是右子树
        if(key<parent.key){
            parent.left=new Node (key);
        }else{
            parent.right=new Node(key);
        }
        return true;
    }
    //删除
    private boolean delete(int key){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }
            else if(key>cur.key){
                parent=cur;
                cur=cur.right;
            }
            else{
                removeNode(parent,cur);
                return true;
            }
        }
        return false;
    }
    private void removeNode(Node parent, Node cur){
        //1、要删除节点的左子树为空
        if(cur.left==null){
            if(cur==root){
                cur=cur.right;
            }
            else if(parent.left==cur){
                parent.left=cur.right;
            }
            else if(parent.right==cur){
                parent.right=cur.right;
            }
        }
        //2、要删除节点的右子树为空
        else if(cur.right==null){
            if(cur==root){
                cur=cur.left;
            }
            else if(parent.left==cur){
                parent.left=cur.left;
            }
            else if(parent.right==cur){
                parent.right=cur.left;
            }
        }
        //3、要删除节点的左右子树都不为空
        else{
            //(1)先找到替罪羊节点
            Node goatParent=null;
            Node scapegoat=cur.right;
            while(scapegoat.left!=null){
                goatParent=scapegoat;
                scapegoat=scapegoat.left;
            }
            //(2)把替罪羊节点的值赋给待删除节点.
            cur=scapegoat;
            //(3)删除替罪羊节点
            if(goatParent.left==scapegoat){
                goatParent.left=scapegoat.right;
            }
            else if(goatParent.right==scapegoat){
                goatParent.right=scapegoat.right;
            }

        }
    }
    private static void preOrder(Node root){
        if(root==null){
            return;
        }
      System.out.print(root.key+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.key+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();
        tree.insert(1);
        tree.insert(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(8);
        tree.insert(6);
        tree.insert(7);


        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();

        System.out.println("查找元素：");
        Node cur1=find(6);
        System.out.println(cur1.key);

        System.out.println("插入元素：");
        System.out.println(tree.insert(8));
        System.out.println(tree.insert(0));

        System.out.print("删除元素：");
        System.out.println(tree.delete(3));
        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();
    }

}
