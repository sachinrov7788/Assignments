import java.util.*;
class GraphEg{
    static Scanner sc=new Scanner(System.in);
    static HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();

    public void reset() {
    }

    public void DFS(int input) {
    }

    public void edge(int i, int i1) {
    }

    public void add(int n) {
    }

    static class node{
        int data;
        ArrayList<Integer>list;
        node(int data)
        {
            this.data=data;
            this.list=new ArrayList<>();
        }
    }

    public static void main(String args[])
    {
        link();
        System.out.print("Enter the source node for traversal:");
        bfs(sc.nextInt());
    }
    static void link()
    {
        System.out.println("Enter node element:");
        node root=new node(sc.nextInt());
        System.out.print("1.Enter Vertices or 2.End:");
        while(sc.nextInt()==1)
        {
            root.list.add(sc.nextInt());
            System.out.print("1.Enter Vertices or 2.End:");
        }
        map.put(root.data,root.list);
        Integer[] Arr = null;
        Arr = root.list.toArray(new Integer[root.list.size()]);
        System.out.println(root.data+"->"+Arrays.toString(Arr));
        System.out.print("1.Create new node or 2.End:");
        if(sc.nextInt()==1)
            link();
    }
    static void bfs(int val)
    {
        HashMap<Integer,Integer>map1=new HashMap<>();
        Queue<Integer>q=new LinkedList<>();
        q.add(val);
        while(!q.isEmpty())
        {
            Integer cur=q.poll();
            if(!map1.containsKey(cur))
            {
                map1.put(cur,1);
                System.out.print("->"+cur+" ");
                if(map.containsKey(cur))
                    q.addAll(map.get(cur));
            }
        }

    }

}