import java.util.*;

class Tree{
    int data;
    Tree left;
    Tree right;
    Tree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BinarytreeEg{
    public static void main(String args[])
    {
        ArrayList<Integer>arr=new ArrayList<>();
        Tree t1=new Tree(10);
        BinarytreeEg t=new BinarytreeEg();
        Tree root=t1;
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag)
        {
            System.out.println("\n1.Insert node");
            System.out.println("2.Preorder traversal");
            System.out.println("3.Inorder traversal");
            System.out.println("4.Postorder traversal");
            System.out.println("5.Level order traversal");
            System.out.println("6.Search");
            System.out.println("7.Exit");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter key value : ");
                    int key=sc.nextInt();
                    t.addnode(root,key);
                    break;
                case 2:
                    arr=t.preorderTrav(root,new ArrayList<Integer>());
                    System.out.print("preorder: ");
                    t.print(arr);
                    break;
                case 3:
                    arr=t.inorderTrav(root,new ArrayList<Integer>());
                    System.out.print("Inorder: ");
                    t.print(arr);
                    break;
                case 4:
                    arr=t.postorderTrav(root,new ArrayList<Integer>());
                    System.out.print("postorder: ");
                    t.print(arr);
                    break;
                case 5:
                    arr=t.bfs(root,new ArrayList<>());
                    System.out.print("BFS: ");
                    t.print(arr);
                    break;
                case 6:
                    System.out.println("Enter a value to be searched : ");
                    int val=sc.nextInt();
                    t.search(root,val);
                    break;
                case 7:
                    flag=false;

            }
        }
    }
    void search(Tree root,int val)
    {
        Tree ans=binarySearch(root,val);
        if(ans!=null)
            System.out.println("Element is found");
        else
            System.out.println("Not found");

    }
    int addnode(Tree root,int val)
    {
        if(root==null)
            return 0;
        if(val>root.data)
        {
            if(addnode(root.right,val)==0)
            root.right=new Tree(val);
        }
        else
        {
            if(addnode(root.left,val)==0)
                root.left=new Tree(val);
        }
        return 1;

    }
    ArrayList<Integer> preorderTrav(Tree root,ArrayList<Integer> arr)
    {
        if(root==null)
            return arr;
        arr.add(root.data);
        preorderTrav(root.left,arr);
        preorderTrav(root.right,arr);
        return arr;
    }
    ArrayList<Integer> inorderTrav(Tree root,ArrayList<Integer> arr)
    {
        if(root==null)
            return arr;
        inorderTrav(root.left,arr);
        arr.add(root.data);
        inorderTrav(root.right,arr);
        return arr;
    }
    ArrayList<Integer> postorderTrav(Tree root,ArrayList<Integer> arr)
    {
        if(root==null)
            return arr;
        postorderTrav(root.left,arr);
        postorderTrav(root.right,arr);
        arr.add(root.data);
        return arr;
    }
    static Tree binarySearch(Tree root,int target)
    {
        if(root==null||root.data==target)
            return root;
        if(root.data<target)
            return binarySearch(root.right,target);
        else
            return binarySearch(root.left,target);
    }
    ArrayList<Integer> bfs(Tree root,ArrayList<Integer> arr)
    {
        Queue<Tree>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Tree temp=q.poll();
            arr.add(temp.data);
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        return arr;
    }
    void print(ArrayList<Integer>arr)
    {
        for(int i=0;i<arr.size();i++)
        System.out.print(arr.get(i)+" ");
        System.out.println();
    }
}