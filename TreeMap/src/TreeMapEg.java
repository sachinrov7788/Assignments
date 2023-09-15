import java.util.*;

class TreeMapEg
{
    public static void main(String[] args)
    {
        TreeMap<Integer,String> map = new TreeMap<>();

        map.put(100, "Raj");
        map.put(103, "vijay");
        map.put(101, "Rajesh");
        map.put(102, "Ram");

        for(Map.Entry m:map.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
        }

    }
}