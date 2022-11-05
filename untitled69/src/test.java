import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        String str = sc.next();//读取输入的算式


        int a = Integer.parseInt(str.charAt(0)+"");//获得两个分数的分子分母，考虑到项目的复杂性，
        int b = Integer.parseInt(str.charAt(2)+"");//输入的算式各项只能是正的，并且分子分母只能一位
        int c = Integer.parseInt(str.charAt(4)+"");
        int d = Integer.parseInt(str.charAt(6)+"");

        FractionalNumber f1 = new FractionalNumber(a, b);

        switch(str.charAt(3)) {
            case '+': System.out.println(f1.add(c, d).toString());
                break;
            case '-':System.out.println(f1.sub(c, d).toString());
                break;
            case '*':System.out.println(f1.mul(c, d).toString());
                break;
            case '/':System.out.println(f1.div(c, d).toString());
                break;
        }
    }

}

