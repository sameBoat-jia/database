import java.util.ArrayList;
import java.util.Scanner;

public class Analysis {
    public static void main(String[] args) {
        System.out.println("请输入学生成绩");
        Scanner sc = new Scanner(System.in);
        ArrayList<grade> grades = new ArrayList<>();

    }

}
class grade{
    public double grade;
    public grade(){

    }

    public grade(double grade) {
        this.grade = grade;
    }
}
class Tools{
    public static double getAverage(ArrayList<grade>grades){
        double sum=0.0;
        //for(元素类型 每次循环的元素名称 : 循环对象)
        for (grade grade :
                grades) {
            sum+=grade.grade;
        }
        return sum/grades.size();
    }
    public static double getMax(ArrayList<grade>grades) {
        if (grades.size() == 0) {
            return 0;
        }
        double max = grades.get(0).grade;
        for (grade grade :
                grades) {
            if (max < grade.grade) {
                max = grade.grade;
            }
        }
        return max;
    }
}