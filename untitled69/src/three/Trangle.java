package three;

import java.util.Scanner;

public class Trangle extends Picture {
    public double a;
    public double p;
    //public double a;
    public double b;
    public double c;

    public Trangle(double a, double b, double c) {
        this.a = a;
//        this.p = p;
        this.b = b;
        this.c = c;
        p = (a + b + c) / 2;
    }

    @Override
    public void setArea() {
//        Scanner scanner = new Scanner(System.in);
//        a=scanner.nextDouble();b=scanner.nextDouble();c=scanner.nextDouble();
//        double p=(a+b+c)/2;
        if (a + b > c && a + c > b && b + c > a)
            this.area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        else System.out.println("this is not a triangle");

    }

    @Override
    public void setCircumference() {
        this.circumference = a + b + c;
    }
}
