import java.util.Scanner;

public class JavaPractice1 {
    private String gradeString;
    private String[] gradeStringList;
    private int gradeCount = 0;
    private double gradeSum = 0;
    private double gradeMin = 100;
    private double gradeMax = 0;
    private double gradeAve = 0;

    private int[] level = new int[6];
    private double[] score;
    private int[] grade;

    public JavaPractice1() {
        Scanner reader = new Scanner(System.in);
        System.out.println("输入成绩");
        gradeString = reader.nextLine();
        gradeStringList = gradeString.split(" ");
        gradeCount = gradeStringList.length;
        grade = new int[gradeCount];
        score = new double[gradeCount];
        for (int i = 0; i < 6; i++) {
            level[i] = 0;
        }
    }

    public boolean formatGrade() {
        if (gradeCount == 0) {
            return false;
        }
        double tempScore;
        for (int i = 0; i < gradeCount; i++) {
            tempScore = Double.parseDouble(gradeStringList[i]);
            score[i] = tempScore;
            grade[i] = (int) tempScore / 10;
            gradeSum += tempScore;
            if (tempScore > 100.0 || tempScore < 0.0) {
                System.out.println("输入错误");
            }
            if (gradeMin > tempScore)
                gradeMin = tempScore;
            if (gradeMax < tempScore)
                gradeMax = tempScore;
            switch (grade[i]) {
                case 10:
                    ++level[0];
                    break;
                case 9:
                    ++level[1];
                    break;
                case 8:
                    ++level[2];
                    break;
                case 7:
                    ++level[3];
                    break;
                case 6:
                    ++level[4];
                    break;
                default:
                    ++level[5];
                    break;
            }
        }
        gradeAve = gradeSum / score.length;
        return true;
    }

    public void showGrade() {
        System.out.println("平均分：" + gradeAve +
                "最高分:" + gradeMax +
                "最低分:" + gradeMin);
        System.out.printf("A+等级（100）的人数为%d,百分比为%.1f%%\n", level[0], (double) level[0] / score.length * 100);
        System.out.printf("A等级（100~90）的人数为%d,百分比为%.1f%%\n", level[1], (double) level[1] / score.length * 100);
        System.out.printf("B等级（89~80）的人数为%d,百分比为%.1f%%\n", level[2], (double) level[2] / score.length * 100);
        System.out.printf("C等级（79~70）的人数为%d,百分比为%.1f%%\n", level[3], (double) level[3] / score.length * 100);
        System.out.printf("D等级（69~60）的人数为%d,百分比为%.1f%%\n", level[4], (double) level[4] / score.length * 100);
        System.out.printf("E等级（59~0）的人数为%d,百分比为%.1f%%\n", level[5], (double) level[5] / score.length * 100);
    }

    public static void main(String[] args) {
        try {
            JavaPractice1 grade = new JavaPractice1();
            grade.formatGrade();
            grade.showGrade();
        } catch (Exception e) {
            System.out.println("错误信息：" + e.getMessage());
        }
    }
}


