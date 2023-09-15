public class ConstructorEg {
    float l,b;
    ConstructorEg()
    {
        System.out.println("Constructor is Created");
    }
    ConstructorEg(float a,float b)
    {
        this.l=a;
        this.b=b;
    }
    ConstructorEg(ConstructorEg obj)
    {
        this.l=obj.l;
        this.b=obj.b;
    }
    void display()
    {
        System.out.println("Area is:"+this.l*this.b);
    }

}