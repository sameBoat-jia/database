import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int a = Integer.parseInt(str.charAt(0) + "");
        int b = Integer.parseInt(str.charAt(2) + "");
        int c = Integer.parseInt(str.charAt(4) + "");
        int d = Integer.parseInt(str.charAt(6) + "");
        FractionalNumber fractionalNumber = new FractionalNumber(a, b);
        switch (str.charAt(3))
        {
            case '+':
                System.out.println(fractionalNumber.add(c,d).toString());
                break;
            case '-':
                System.out.println(fractionalNumber.sub(c,d).toString());
                break;
            case '*':
                System.out.println(fractionalNumber.mul(c,d).toString());
                break;
            case '/':
                System.out.println(fractionalNumber.div(c,d).toString());
                break;
        }
    }
}
