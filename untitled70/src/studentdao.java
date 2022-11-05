import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class studentdao {
//获取登录用户
	public static List<User> getuser() {
		
		List<User> list  = new ArrayList<User>();
	//1、获得数据库连接
	//2、编写sql
	//3、执行sql
	//4、获得结果
	//5、根据结果解析
		try {
			Connection connection=JdbcMysql.getconnection();
			String sql=" SELECT * FROM user";
			//执行sql对象
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);//执行查询操作 result接收查询结果
			while(result.next()){//判断里面存在值
				User user=new User();
				user.setUserName(result.getString("user_name"));
				user.setUserPasswd(result.getString("user_passwd"));
				user.setPower(result.getString("user_identity"));
				list.add(user);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	//查询单个学生
	public static void getstudent(int id) {
		
		List<student> list  = new ArrayList<student>();

		
	//1、获得数据库连接
	//2、编写sql
	//3、执行sql
	//4、获得结果
	//5、根据结果解析 
		try {
			Connection connection=JdbcMysql.getconnection();
			
			String sql =" SELECT * FROM student WHERE student_id="+id;
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);//执行查询操作 result接收查询结果
				while(result.next()) {
					student s = new student();
					s.setStudent_id(result.getInt("student_id"));
					s.setStudent_name(result.getString("student_name"));
					s.setSex(result.getString("sex"));
					s.setAge(result.getInt("age"));
					s.setMajor(result.getString("major"));
					list.add(s);
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 for (student student : list) {
			System.out.println(student);
			
		}
		
	}
	
	
//查询所有的学生信息

		
		public static void getstudentAll() {
			
			List<student> list  = new ArrayList<student>();
		//1、获得数据库连接
		//2、编写sql
		//3、执行sql
		//4、获得结果
		//5、根据结果解析
			try {
				Connection connection=JdbcMysql.getconnection();
				String sql=" SELECT * FROM student";
				//执行sql对象
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);//执行查询操作 result接收查询结果
				while(result.next()){//判断里面存在值
					student s=new student();
					s.setStudent_id(result.getInt("student_id"));
					s.setStudent_name(result.getString("student_name"));
					s.setSex(result.getString("sex"));
					s.setAge(result.getInt("age"));
					s.setMajor(result.getString("major"));
					list.add(s);
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (student student : list) {
				System.out.println(student);
			}
			
		}
	
//查询课程信息
		
public  void getcourseAll() {
			
			List<course> list  = new ArrayList<course>();
		//1、获得数据库连接
		//2、编写sql
		//3、执行sql
		//4、获得结果
		//5、根据结果解析
			try {
				Connection connection=JdbcMysql.getconnection();
				String sql=" SELECT * FROM course";
				//执行sql对象
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);//执行查询操作 result接收查询结果
				while(result.next()){//判断里面存在值
					course c=new course();
					c.setCourse_id(result.getInt("course_id"));
					c.setCourse_name(result.getString("course_name"));
					c.setCourse_time(result.getDouble("course_time"));
					c.setCourse_grade(result.getDouble("course_grade"));
					c.setTeacher_id(result.getInt("teacher_id"));
					list.add(c);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (course course : list) {
				System.out.println(course);
			}
			
		}
// 增加学生
public void insertstudent (student s) {
	try {
		Connection connection = JdbcMysql.getconnection();
		// ? 占位符 在后面给他赋值
		String sql="INSERT INTO student VALUES(?,?,?,?,?)";
		java.sql.PreparedStatement ps= connection.prepareStatement(sql);
		ps.setInt(1, s.getStudent_id());
		ps.setString(2, s.getStudent_name());
		ps.setString(3, s.getSex());
		ps.setInt(4, s.getAge());
		ps.setString(5, s.getMajor());
		//执行sql
		ps.executeUpdate();// 增加 修改 删除
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//删除学生
public void deletestudent(int i) {
	
	try {
		Connection connection=JdbcMysql.getconnection();
		String sql="DELETE FROM student WHERE student_id=?";
		java.sql.PreparedStatement ps= connection.prepareStatement(sql);
		ps.setInt(1, i);
		ps.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
}


//修改学生成绩
public void updateGrade(int score, int student_id,int course_id) {
	try {
		Connection connection = JdbcMysql.getconnection();
		String sql = "UPDATE score SET grade=? WHERE student_id=? AND course_id=?";
		 PreparedStatement ps = connection.prepareStatement(sql);
		 ps.setInt(1, score);
		 ps.setInt(2, student_id);
		 ps.setInt(3, course_id);
		 ps.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
	}
}

//增加课程信息
public void insertcourse(course c) {
	try {
		Connection connection = JdbcMysql.getconnection();
		String sql = "INSERT INTO course VALUES(?,?,?,?,?)";
		PreparedStatement ps  = connection.prepareStatement(sql);
		ps.setInt(1,c.getCourse_id() );
		ps.setString(2, c.getCourse_name());
		ps.setDouble(3, c.getCourse_time());
		ps.setDouble(4, c.getCourse_grade());
		ps.setInt(5, c.getTeacher_id());
		ps.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
	}
}
//删除课程信息
public void deletecourse(int id) {
	try {
		Connection connection = JdbcMysql.getconnection();
		String sql = "DELETE FROM course WHERE course_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
//修改课程的老师
public void updateCourse(int teacher_id,int course_id) {
	try {
		Connection connection = JdbcMysql.getconnection();
		String sql = "UPDATE course SET teacher_id=? WHERE course_id=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, teacher_id);
		ps.setInt(2, course_id);
		ps.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
	}
}

}
