public class FractionalNumber {
    private int numerator;//分子
    private int denominator;//分母

    public FractionalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
  /*  private int maxCom(int a,int b)
    {
        //求最大公约数
        if (a<b)
        {
            int c=a;
            a=b;
            b=c;
        }
        int r=0;
        try {
            r=a%b;
        }catch (Exception e)
        {
            System.out.println("出错了");
        }//分母为0异常处理
        while (r!=0)
        {
            a=b;
            b=r;
            r=a%b;
        }
        return b;
   }
   */
  public FractionalNumber add(int numerator,int denominator)
    {
        int d=denominator;
        denominator=this.denominator*denominator;
        numerator=this.numerator*d+numerator*this.denominator;
        return new FractionalNumber(numerator,denominator);
    }
    public FractionalNumber sub(int numerator,int denominator)
    {
        int d=denominator;
        denominator =this.denominator*denominator;
        numerator=this.numerator*d-numerator*this.denominator;
        return new FractionalNumber(numerator,denominator);
    }
    public FractionalNumber mul(int numerator, int denominator) {// 乘

        denominator = this.denominator * denominator;
        numerator = this.numerator * numerator;

        return new FractionalNumber(numerator, denominator);
    }
    public FractionalNumber div(int numerator, int denominator) {// 除
        int d = denominator;
        denominator = this.denominator * numerator;
        numerator = this.numerator * d;
        return new FractionalNumber(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator+"/"+denominator;
    }
}
