public class ChainConstructor
{

    ChainConstructor()
    {
        this("Javatpoint");
        System.out.println("Default constructor called.");
    }

    ChainConstructor(String str)
    {
        System.out.println("Parameterized constructor called");
    }
    public static void main(String args[])
    {
        ChainConstructor cc = new ChainConstructor();
    }

}