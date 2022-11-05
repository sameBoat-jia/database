package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Operation {
    public void getStudent(int Sno){
        ArrayList<Student>students=new ArrayList<>();
        try {
            Connection connection=JdbcMysql.getConnection();
            String sql="SELECT *from student where Sno="+Sno;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next())
            {
                Student student=new Student();
                student.setSbirth(resultSet.getString("Sbirth"));
                student.setSclass(resultSet.getString("Sclass"));
                student.setSmail(resultSet.getString("Smail"));
                student.setSname(resultSet.getString("Sname"));
                student.setSno(resultSet.getInt("Sno"));
                student.setSphone(resultSet.getString("Sphone"));
                student.setSsex(resultSet.getString("Ssex"));
                students.add(student);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        for (Student student :
                students) {
            System.out.println(student);
        }
    }
    public void insertStudent(Student student)
    {
        try {
                Connection connection=JdbcMysql.getConnection();
                String sql="insert into Student value(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getSname());
            preparedStatement.setString(2,student.getSname());
            preparedStatement.setString(3,student.getSbirth());
            preparedStatement.setString(4, student.getSclass());
            preparedStatement.setString(5, student.getSphone());
            preparedStatement.setInt(6, student.getSno());
            preparedStatement.setString(7, student.getSmail());
            preparedStatement.executeUpdate();
        }catch (Exception e)
        {

        }
    }
}
