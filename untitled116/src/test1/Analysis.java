package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class Analysis {
    public static void main(String[] args) {
        Tools tools = new Tools();

        System.out.println("请输入您想要输入的学生的成绩");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Grade> grades = new ArrayList<>();
        String inputString= scanner.nextLine();
        String stringArray[]=inputString.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            grades.add(new Grade(Double.parseDouble(stringArray[i])));
        }
        System.out.println("平均分" +
                tools.getAverage(grades));
        System.out.println("最高分是：" +tools.getMax(grades)+
                "最低分是："+tools.getMin(grades));
        tools.getAllList(grades);
    }
}
