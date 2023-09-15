
class A
{
    interface Message
    {
        void msg();
    }
}

class ClassToInterface implements A.Message
{
    public void msg()
    {
        System.out.println("Hello interface");
    }

    public static void main(String args[])
    {
        A.Message message=new ClassToInterface();
        message.msg();
    }
}