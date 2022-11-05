package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class Num4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> integers = new ArrayList<>();
        String inputString=sc.nextLine();
        String stringArray[]=inputString.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            integers.add(new Integer(Integer.parseInt(stringArray[i])));
        }
        int m=sc.nextInt();
        for (int i=0;;i++) {
            if(n!=0) {
                if (i+1 == m) {
                    m = integers.get(i);
                    integers.set(i,0);
                    System.out.println(i+1);
                    if(i==integers.size())
                    n--;
                }
            }
        }
//        integers.remove(0);
//        for (Integer integer :
//                integers) {
//            System.out.println(integer);
//        }
    }
}
/*
1
6
2 5 3 7 5 4
3
 */