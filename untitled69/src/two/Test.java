package two;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        double Rational.setNumerator()=scanner.nextDouble();
//        Rational.setNumerator(scanner.nextInt());
//        Rational.setDenominator(scanner.nextInt());
        Rational rational=new Rational();
        rational.setDenominator(scanner.nextInt());
        rational.setNumerator(scanner.nextInt());

    }
}
