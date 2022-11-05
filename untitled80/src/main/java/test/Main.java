package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Four four=new Four();
        Two two = new Two();
        Eight eight = new Eight();
        Scanner scanner = new Scanner(System.in);
        int num=scanner.nextInt();
        int turn=scanner.nextInt();
        if(turn==2){
            System.out.println(two.conversion(num));
        } else if (turn == 4) {
            System.out.println(four.conversion(num));
        } else if (turn == 8) {
            System.out.println(eight.conversion(num));
        }
    }

    public abstract static class Abs {
        public abstract String conversion(int num);
    }

    public static class Eight extends Abs {
        @Override
        public String conversion(int num) {
            String a = "";//用字符串拼接
            while(num!=0) {//利用十进制转二进制除2法
                a=num%8+a;
                num=num/8;
            }
            return a;
        }
    }

    public static class Four extends Abs {
        @Override
        public String conversion(int num) {
            String a = "";
            while(num!=0) {
                a=num%4+a;
                num=num/4;
            }
            return a;
        }
    }

    public static class Two extends Abs {
        @Override
        public String conversion(int num) {
            String a = "";//用字符串拼接
            while(num!=0) {//利用十进制转二进制除2法
                a=num%2+a;
                num=num/2;
            }
    return a;


        }
        }
}
