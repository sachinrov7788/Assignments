interface Printable
{
    void print();
}

interface Showable extends Printable
{
    void show();
}

class InterFaceToInterFace implements Showable
{
    public void print()
    {
        System.out.println("Hello");
    }
    public void show()
    {
        System.out.println("Welcome");
    }

    public static void main(String args[])
    {
        InterFaceToInterFace obj = new InterFaceToInterFace();
        obj.print();
        obj.show();
    }
}