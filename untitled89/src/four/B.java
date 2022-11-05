package four;

public class B {
    public int f(int a,int b)
    {
        if(a<b)
        {
            int temp=a;
            a=b;
            b=temp;
        }
        while (b>0)
        {
            int temp=a%b;
            a=b;
            b=temp;
        }

        return a;
    }
}
