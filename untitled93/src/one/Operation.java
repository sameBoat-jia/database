package one;

import java.util.ArrayList;

public class Operation implements StuInterface{
    @Override
    public double getAverage(ArrayList<Grade> grades) {
        double sum=0;
        for (Grade grade :
                grades) {
            sum+=grade.grade;
        }
        return sum/grades.size();
    }


    public static double getMax(ArrayList<Grade> grades) {
        double max=grades.get(0).grade;
        for (Grade grade :
                grades) {
            if (max < grade.grade) {
                max=grade.grade;
            }
            }
        return max;
    }

    public static double getMin(ArrayList<Grade> grades) {
        double min=grades.get(0).grade;
        for (Grade grad :
                grades) {
            if (min>grad.grade)
            {
                min=grad.grade;
            }
        }
        return min;
    }

    @Override
    public ArrayList<Grade> getList(ArrayList<Grade> grades, int level) {
        ArrayList<Grade> list = new ArrayList<>();
        double low=0,heigh=60;
        if(level<6)
        {
            for (Grade grade :
                    grades) {
             if(grade.grade>=0&&grade.grade<=60)
             {
                 list.add(grade);
             }
            }
        }
        else {
            low=level*10;
            heigh=low+10;
            for (Grade grade :
                    grades) {
                if (grade.grade>=low&&grade.grade<=heigh)
                {
                    list.add(grade);
                }
            }
        }
        if (level<6)
        {
            System.out.println("不及格学生");
        }
        System.out.println("分数档为" +low+
                "~" +heigh+
                "的人数为" +list.size()+
                "百分比" +
                list.size()/((double)grades.size()));
    return list;
    }

    @Override
    public void getAll(ArrayList<Grade> grades) {
        for (int i = 5; i < 10; i++) {
            getList(grades,i);
        }
    }
}
