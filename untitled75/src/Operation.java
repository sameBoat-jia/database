import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Operation {
    public void getStudent(int Sno)
    {
//        JdbcMysql jdbcMysql=new JdbcMysql();
        ArrayList<Student>students=new ArrayList<>();
        try {
            Connection connection=JdbcMysql.getConnec();
            String sql="select *from student where Sno="+Sno;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Student student=new Student()   ;
                student.setSbirth(resultSet.getString("Sbirth"));
                student.setSclass(resultSet.getString("Sclass"));
                student.setSmail(resultSet.getString("Smail"));
                student.setSname(resultSet.getString("Sname"));
                student.setSphone(resultSet.getString("Sphone"));
                student.setSno(resultSet.getInt("Sno"));
                student.setSsex(resultSet.getString("Ssex"));
                students.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (Student student :
                students) {
            System.out.println(student);
        }
    }
    public void insertStudent(Student student) throws Exception {
        Connection connection=JdbcMysql.getConnec();
        String sql="";

    }
}
