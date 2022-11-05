package one;

import java.util.ArrayList;
import java.util.Scanner;
import one.Grade;

public class Test {
    public static void main(String[] args) {
        System.out.println("输入一组学生成绩：");
        Operation operation = new Operation();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Grade>grades = new ArrayList<>();
        String inputString=scanner.nextLine();
        String stringArry[]=inputString.split(" ");
        for (int i = 0; i < stringArry.length; i++) {
            grades.add(new Grade(Double.parseDouble(stringArry[i])));
        }
        System.out.println("平均分：" + operation.getAverage(grades));
        System.out.println("最高分：" + operation.getMax(grades) + "最低分：" + Operation.getMin(grades));
        operation.getAll(grades);
    }
}
