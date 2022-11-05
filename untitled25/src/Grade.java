import java.util.Scanner;

public class Grade {
    private String gradeString;
    private String[] gradeStringList;
    private int gradeCount=0;
    private double gradeSum=0;
    private double gradeMin=100;
    private double gradeMax=0;
    private double gradeAve=0;
    private int[] level=new int[6];
    private  double[] score;
    private int []grade;

    public Grade(){
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入考试成绩");
        //将读取到的成绩给gradeString
        gradeString=reader.nextLine();
        //split方法“ ”按空格分开
        gradeStringList=gradeString.split(" ");
        gradeCount=gradeStringList.length;
        grade=new int [gradeCount];
        score=new double[gradeCount];
        for (int i = 0; i < 6; i++) {
            level[i]=0;
        }
    }
    public boolean formatGrade(){
        if(gradeCount==0){
            return false;
        }double temScore;
        for (int i = 0; i < gradeCount; i++) {
            temScore=Double.parseDouble(gradeStringList[i]);
        }
    }
}
