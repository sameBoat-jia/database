package test1;

import java.util.ArrayList;

public class Tools {
    public double getAverage(ArrayList<Grade>grades)
    {
        double sum=0;
        for (Grade grade :
                grades) {
            sum += grade.getGrade();
        }
        return sum/grades.size();
    }
    public double getMax(ArrayList<Grade>grades)
    {
            double max=grades.get(0).getGrade();
        for (Grade grade :
                grades) {
            if (max<grade.getGrade())
            {
                max=grade.getGrade();
            }
        }
        return max;
    }
    public double getMin(ArrayList<Grade>grades)
    {
        double min=grades.get(0).getGrade();
        for (Grade grade :
                grades) {
            if(min>grade.getGrade())
            {
                min=grade.getGrade();
            }
        }
        return min;
    }
    public ArrayList<Grade>getSpecificaList(ArrayList<Grade>grades,int level)
    {
        ArrayList<Grade>list =new ArrayList<>();
        double low=0;
        double height=60;
        if (level < 6) {
            for (Grade grade :
                    grades) {
                if (grade.getGrade()>=0&&grade.getGrade()<60)
                {
                    list.add(grade);
                }
            }
        }
        else {
            low=level*10;
            height=low+10;
            for (Grade grade :
                    grades) {
                if (grade.getGrade()>=low&&grade.getGrade()<=height)
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
                "~" +height+
                "的人数：" +list.size()+
                "百分比："+list.size()/grades.size());
        return list;
    }
    public void getAllList(ArrayList<Grade>grades)
    {
        for (int i = 5; i < 10; i++) {
            getSpecificaList(grades,i);
        }
    }
}
