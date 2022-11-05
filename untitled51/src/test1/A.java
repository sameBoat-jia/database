package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> score = new ArrayList<Double>();
        String inputString = scanner.nextLine();
        String stringArray[] = inputString.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            score.add(Double.parseDouble(stringArray[i]));
        }
        System.out.println("最高分是：" + max(score) +
                "平均分是：" + average(score) +
                "最低分是：" + min(score));
        level(score);
    }

    public static double average(ArrayList<Double> score) {
        double sum = 0;
        for (Double dou :
                score) {
            sum += dou;
        }
        return sum / score.size();
    }

    public static double max(ArrayList<Double> score) {
        Collections.sort(score);
        return score.get(score.size() - 1);
    }

    public static double min(ArrayList<Double> score) {
        Collections.sort(score);
        return score.get(0);
    }

    public static void level(ArrayList<Double> score) {
        int[] num = new int[60];
        for (int i = 0; i < score.size(); i++) {
            if (score.get(i) == 100) {
                num[0]++;
            } else if (score.get(i) >= 90) {
                ++num[1];

            } else if (score.get(i) >= 80) {
                ++num[2];

            } else if (score.get(i) >= 70) {
                ++num[3];

            } else if (score.get(i) >= 60) {
                ++num[4];

            } else if (score.get(i) < 60) {
                ++num[5];
            }
        }System.out.println("不及格的有：" + num[5] + "占总人数的：" + (double) num[5] / score.size());
        System.out.println("60分以上的有：" + num[4] + "占总人数的：" + (double) num[4] / score.size());
        System.out.println("70分以上的有：" + num[3] + "占总人数的：" + (double) num[3] / score.size());
        System.out.println("80分以上的有：" + num[2] + "占总人数的：" + (double) num[2] / score.size());
        System.out.println("90分以上的有：" + num[1] + "占总人数的：" + (double) num[1] / score.size());
        System.out.println("100分的有：" + num[0] + "占总人数的：" + (double) num[0] / score.size());


    }
}