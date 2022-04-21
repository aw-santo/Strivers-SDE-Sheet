public class RedBlackTree
{
    
    public RedBlackTree()
    {
        super();
        root = null;
    }

    public Node root;
    
    class Node
    {
        int data;
        Node right;
        Node left;
        char colour;
        Node parent;
 
        Node(int data)
        {
            super();
            this.data = data;
            this.left = this.right = this.parent = null;
            this.colour = 'R';
        }
    }

    Node rotateLeft(Node node)
    {
        Node x = node.right;
        Node y = x.left;
        x.left = node;
        node.right = y;
        node.parent = x;
        if(y!=null)
            y.parent = node;
        return(x);
    }

    Node rotateRight(Node node)
    {
        Node x = node.left;
        Node y = x.right;
        x.right = node;
        node.left = y;
        node.parent = x;
        if(y!=null)
            y.parent = node;
        return(x);
    }
 

    boolean ll = false;
    boolean rr = false;
    boolean lr = false;
    boolean rl = false;

    Node insertHelp(Node root, int data)
    {
        boolean f=false;

        if(root==null)
            return(new Node(data));
        else if(data<root.data)
        {
            root.left = insertHelp(root.left, data);
            root.left.parent = root;
            if(root!=this.root)
            {
                if(root.colour=='R' && root.left.colour=='R')
                    f = true;
            }
        }
        else
        {
            root.right = insertHelp(root.right,data);
            root.right.parent = root;
            if(root!=this.root)
            {
                if(root.colour=='R' && root.right.colour=='R')
                    f = true;
            }
        }

        if(this.ll)
        {
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
            this.ll = false;
        }
        else if(this.rr)
        {
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            this.rr  = false;
        }
        else if(this.rl)
        {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
 
            this.rl = false;
        }
        else if(this.lr)
        {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            this.lr = false;
        }
        if(f)
        {
            if(root.parent.right == root)
            {
                if(root.parent.left==null || root.parent.left.colour=='B')
                {
                    if(root.left!=null && root.left.colour=='R')
                        this.rl = true;
                    else if(root.right!=null && root.right.colour=='R')
                        this.ll = true;
                }
                else
                {
                    root.parent.left.colour = 'B';
                    root.colour = 'B';
                    if(root.parent!=this.root)
                        root.parent.colour = 'R';
                }
            }
            else  
            {
                if(root.parent.right==null || root.parent.right.colour=='B')
                {
                    if(root.left!=null && root.left.colour=='R')
                        this.rr = true;
                    else if(root.right!=null && root.right.colour=='R')
                        this.lr = true;
                }
                else
                {
                    root.parent.right.colour = 'B';
                    root.colour = 'B';
                    if(root.parent!=this.root)
                        root.parent.colour = 'R';
                }
            }
            f = false;
        }
        return(root); 
    }
 
    
    public void insert(int data)
    {
        if(this.root==null)
        {
            this.root = new Node(data);
            this.root.colour = 'B';
        }
        else
            this.root = insertHelp(this.root,data);
    }
    
    void inorderTraversalHelper(Node node)
    {
        if(node!=null)
        {
            inorderTraversalHelper(node.left);
            System.out.printf("%d ", node.data);
            inorderTraversalHelper(node.right);
        }
    }
    
    public void inorderTraversal()
    {
        inorderTraversalHelper(this.root);
    }
    
    
    public static void main(String[] args)
    {
        
        RedBlackTree rbt = new RedBlackTree();
        int[] arr = {10, 44, 6, 1, 553, 7, 81, 2, 99};
        for(int i=0;i<arr.length;i++)
        {
            rbt.insert(arr[i]);
        }
        
        System.out.println("\n***************************************************************************");
        System.out.println("\nInorder traversal after inserting {10, 44, 6, 1, 553, 7, 81, 2, 99} --- these elements...\n");
        rbt.inorderTraversal();
        System.out.println("\n\n***************************************************************************");
    }
}