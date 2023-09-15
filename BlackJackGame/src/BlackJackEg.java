import java.util.*;
interface card {
    int ranGen();
    void choose();
    void playhit();
    void dealerhit();
    void stay();
    void playert();
    void comp();
    void Score();
}
public class BlackJackEg implements card {
    static int player=0;
    static int dealer=0;
    static boolean curr=true;
    static String str;
    static boolean stayval=true;
    static int target;
    static HashMap<Integer, Integer>map=new HashMap<>(){{
        put(2,4);
        put(3,4);
        put(4,4);
        put(5,4);
        put(6,4);
        put(7,4);
        put(8,4);
        put(9,4);
        put(10,4);
        put(11,4);

    }};
    public static void main(String[] args) {
        card c=new BlackJackEg();
        System.out.println("\nWelcome to BlackJack Program");
        int i1=c.ranGen();
        int i2=c.ranGen();
        System.out.println("You get a "+i1+" and a "+i2);
        player+=i1+i2;
        dealer+=c.ranGen();
        Scanner s=new Scanner(System.in);
        System.out.println("The dealer has a "+dealer+" showing, and a hidden card.\nHis total is hidden, too.");
        System.out.println("Set the Target Value:");
        target=s.nextInt();
        c.choose();

    }

    /*ranGen method generates random value ranges from 2 to 11 and
    generated value can't be used more than 4 times if it's used. Then
    it will generate another random value from  given range.*/
    public int ranGen()
    {
        int val=(int)Math.floor((Math.random()*(11-2+1)+2));
        if(map.get(val)>0)
        { map.put(val,map.get(val)-1);
            return val;
        }
        else
        {
            while(map.get(val)==0)
            {val=(int)Math.floor((Math.random()*(11-2+1)+2));
            }
            map.put(val,map.get(val)-1);
        }
        return val;
    }

    /*choose method will get input as a string from user if it is player.
    if it is dealer it will generate random choice either "hit" or "stay"
    and then call it's respective functions */
    public void choose()
    {
        if(curr){
            Scanner s=new Scanner(System.in);
            System.out.println("\nWould you like to \"hit\" or \"stay\"?");
            str=s.nextLine();
        }
        else{
            if((int)Math.floor((Math.random()*(5-2+1)+2))>2)
                str="hit";
            else
                str="stay";
        }
        if(str.equals("hit"))
        {   if(curr)
            playhit();
        else
            dealerhit();
        }
        if(str.equals("stay"))
        {  if(stayval&&curr)
        {curr=false;
            stayval=false;
            stay();
        }
        else if(curr)
        {curr=false;
            comp();
            choose();
        }
        else
        {   System.out.println("\nDealer stays.");
            curr=true;
            comp();
            choose();
        }
        }
    }

    /*it generate random value and add it to player's total.
    check for ending condition then again call choose method*/
    public void playhit()
    {  int val=ranGen();
        System.out.println("\nYou drew a "+val+".");
        player+=val;
        playert();
        comp();
        choose();
    }

    /*it generate random value and add it to dealer's total.
    check for ending condition then again call choose method*/
    public void dealerhit()
    {  int val=ranGen();
        System.out.println("\nHe drews a "+val+".");
        dealer+=val;
        dealert();
        comp();
        choose();
    }

    /*it generate random value and add it to dealer's total
    then check for ending condition and call choose method */
    public void stay()
    { int val=ranGen();
        System.out.println("\nOkay dealer's turn. ");
        System.out.println("His hidden card was a "+val+".");
        dealer+=val;
        dealert();
        stayval=false;
        comp();
        choose();
    }

    //display's player total.
    public void playert()
    { System.out.println("Your total is "+player+".");
    }

    //display's dealer's total.
    public void dealert()
    { System.out.println("His total was "+dealer+".");
    }

    /*it checks for the ending condition that is whether
     player total or dealer total exceeded the limit*/
    public void comp()
    {
        if(player>target)
        {Score();
            System.out.println("\nDEALER WIN!");
            System.exit(0);
        }
        else if(dealer>target)
        {Score();
            System.out.println("\nYOU WIN!");
            System.exit(0);
        }
    }

    //displays the total of player and dealer.
    public void Score()
    {
        System.out.println("\nYour total is:"+player+".");
        System.out.println("Dealer total is:"+dealer+".");
    }

}