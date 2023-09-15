import java.util.Hashtable;
import java.util.Map;

public class HashTableEg2 {
    public static void main(String args[])
    {
        Hashtable<Integer, String> hash = new Hashtable<Integer, String>();

        hash.put(4, "Java");
        hash.put(1, "Python");
        hash.put(3, "Cpp");
        hash.put(2, "C");

        for(Map.Entry m:hash.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
        }

        System.out.println("\nAfter Remove");

        hash.remove(2, "C");

        for(Map.Entry m:hash.entrySet())
        {
            System.out.println(m.getKey()+" "+m.getValue());
        }

    }
}
