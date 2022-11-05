package databast;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Service implements dao{
    Get_set get_set=new Get_set();

    @Override
    public void addStudent() throws ClassNotFoundException, SQLException {
       try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入学生的id:");
            int id = scanner.nextInt();
            System.out.println("请输入学生的姓名：");
            String name = scanner.next();
            //values(id,name)
           //"values(\""+id+"\",\""+name+"\")"
            String sql ="INSERT INTO aaa values('"+id+"','"+name+"')";
//           String sql = "INSERT INTO aaa values(" + id + ",'" + name + "')";

           Connection connection = JdbcMysql.getConnec();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
        }catch (Exception e)
       {
           throw new RuntimeException(e);
       }
    }

    @Override
    public void delStudent() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除学生的id");
        int delId=scanner.nextInt();
        try {
            Connection connection=JdbcMysql.getConnec();
            Statement statement=connection.createStatement();
            String sql="delete from aaa where id="+delId;
            statement.executeUpdate(sql);
            System.out.println("已删除");
            connection.close();
        }catch (Exception e)
        {
        }
    }

    @Override
    public void showAll() throws ClassNotFoundException, SQLException {

            try {
                Connection connection=JdbcMysql.getConnec();
                Statement statement=connection.createStatement();
                String sql="select *from aaa";
                //query查询
                ResultSet resultSet=statement.executeQuery(sql);
                while (resultSet.next()){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name");
                    System.out.println("id:" +id);
                    System.out.println("名字:" +
                            name);
                    System.out.println("==============");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }


    @Override
    public void quary() throws ClassNotFoundException, SQLException {
        try {Connection connection=JdbcMysql.getConnec();
            Statement statement =connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入学生的id");
            int stuId=scanner.nextInt();
                        String sql="select *from aaa where id="+stuId;

            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID:" + id);
                System.out.println("名字：" + name);
            }
        }catch (Exception e)
        {

        }
    }

    @Override
    public void modify() throws ClassNotFoundException, SQLException {
        try {
            Connection connection=JdbcMysql.getConnec();
            Statement statement=connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要修改的学生的id");
            int id1=scanner.nextInt();
            System.out.println("请输入修改后的学生的id");
            int id2=scanner.nextInt();
            System.out.println("请输入修改后学生的姓名");
            String name2=scanner.next();
            //update aaa set id='"+id2+"',name='"+name2+"' where id='"+id1+"'
            String sql="update aaa set id='"+id2+"',name='"+name2+"' where id='"+id1+"'";
            statement.executeUpdate(sql);
            System.out.println("修改成功");
            connection.close();
        }catch (Exception e)
        {

        }
    }
}
