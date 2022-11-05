package one;

public class Test {
    public static void main(String[] args) {
        Big big = new Big();
        Small small = new Small();
        int a = big.f(4, 8);
        int b = small.f(4, 8);
        System.out.println("最大公约数是：" + a +
                "最小公倍数是：" +
                b);
    }

    public static class Big {
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

    public static class Small extends Big {
        public int f(int a,int b)
        {
            int m=super.f(a,b);
            int c=a*b/m;
            return c;
        }
    }
}
