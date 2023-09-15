import java.util.*;

public class HashTableEg1
{
    public static void main(String[] args)
    {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();

        hashTable.put(1,1);
        hashTable.put(2,2);
        hashTable.put(3,2);
        //hashtable doesn't allow the null value as a key and value
        //hashTable.put(null,3);

        System.out.println(hashTable);

        //method to remove the element from the hashTable
        hashTable.remove(1);

        //After removing
        System.out.println(hashTable);

        //method to find the size of an hashTable
        System.out.println(" Size of the hashTable :" +hashTable.size());


        //method to check in hashTable - no keys to values
        System.out.println("Check empty or not " + hashTable.isEmpty());

        //check the specified value present in the hashtable or not
        System.out.println("Check whether value is present or not "+hashTable.contains(1));

        //check the specified key present in the hashtable or not
        System.out.println("Check whether key is present or not " +hashTable.containsKey(5));

        //check the specified value present in the hastable more than one times or not with different keys
        System.out.println("Check the specified value present in the hastable more than one times or not with different keys : "+hashTable.containsValue(2));

        //Return the value to which the specified key is mapped
        System.out.println("The value to which the specified key is mapped : " +hashTable.get(2));

        //Returns the value to which the specified key is mapped, or defaultValue
        System.out.println("Returns the value to which the specified key is mapped, or defaultValue : "+hashTable.getOrDefault(5,100));

        //Returns the hash code value for this Map
        System.out.println("Returns the hash code value for this Map : "+ hashTable.hashCode());

        //Check whether hashtable is empty or not
        System.out.println("Check whether hashtable is empty or not : " + hashTable.isEmpty());

        //Create a key set
        Set key = hashTable.keySet();
        System.out.println("Key Set: " + key);

        //Create enumeration for keys
        Enumeration en = hashTable.keys();
        System.out.println("Keys are " );
        while(en.hasMoreElements())
        {
            System.out.println(en.nextElement());
        }

        //Create an another hashtable to merge it as one
        Hashtable<Integer, Integer> hashTable2 = new Hashtable<>();
        hashTable2.put(10,9);
        hashTable2.put(9,9);
        hashTable2.put(8,8);
        hashTable2.put(7,5);

        //Display
        System.out.println("HashTable2 Values are :  "+ hashTable2);

        //Add all the value from hashtable1 to hashtable2
        hashTable2.putAll(hashTable);
        System.out.println("After putting all the values in the hashtable2 using putAll() method : " + hashTable2);

        //toString method is used to represent hashtable as string
        System.out.println("Return hashtable as a string : "+ hashTable2.toString());

        //Equals method is used to check the equality between two hashtable object
        System.out.println("Two hashTables are equal or not "+ hashTable.equals(hashTable2));

        // Iterate the hashTable values using the collection iterator class
        Iterator<Integer> i = hashTable2.values().iterator();
        System.out.println("Iterate the Hashtable through the hashtable values using collection iterator : ");
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

        //replace method
        hashTable2.replace(10,3);
        System.out.println("After replacing the value in the hashtable : " + hashTable2);

    }
}