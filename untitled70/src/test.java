import java.util.List;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Login();//调用login方法
}
	
	//创建login方法
	public static void Login() {
		int count = 0 ;
		studentdao sd = new studentdao();
		List<User> list = sd.getuser();
		System.out.println("欢迎来到学生管理系统");
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的用户名");
		String Username = sc.nextLine();
		System.out.println("请出入你的密码");
		String userPasswd = sc.nextLine();
	
		for (User user : list) {
			if(Username.equals(user.getUserName())) {
				
			 if( userPasswd.equals(user.getUserPasswd()) ) {
					System.out.println("恭喜你登陆成功");
					if(user.getPower().equals("学生")) {
						while(true) {						
						System.out.println("请选择你的操作");
						System.out.println("1、查询所有学生信息");
						System.out.println("2、 根据id查找学生信息");
						System.out.println("3、 退出");
                        int a = sc.nextInt();
                        sc.nextLine();
                        if (a == 1) {
                        	sd.getstudentAll();
                        }
                        else if (a == 3) {
                        	break;
                        }
                        else if (a ==2) {
                        	System.out.println("请输入你要查询的学生id");
                        	int n = sc.nextInt();
                        	sc.nextLine();
                        	sd.getstudent(n);
                        	System.out.println("查询成功");
                        }
						}
					}
					else if(user.getPower().equals("老师")) {
						
				while(true) {
						System.out.println("请选择你的操作");
						System.out.println("1、查询学生信息");
						System.out.println("2、根据学生id查询学生信息");
						System.out.println("3、查询课程信息");
						System.out.println("4、 退出");
						int a = sc.nextInt();
                        sc.nextLine();
						if( a == 1) {
							sd.getstudentAll();
						}
						else if (a == 3) {
							sd.getcourseAll();
						}
						else if (a == 4) {
							break;
						}
						else if (a == 2) {
							System.out.println("请输入你要查询的学生id");
                        	int n = sc.nextInt();
                        	sc.nextLine();
                        	sd.getstudent(n);
                        	System.out.println("查询成功");
						}
				}
					}
					else if(user.getPower().equals("管理员")) {
						while(true) {
						System.out.println("请选择你的操作");
						System.out.println("1、查询学生信息");
						System.out.println("2、根据id查找学生信息");
						System.out.println("3、增加学生信息");
						System.out.println("4、删除学生信息");
						System.out.println("5、修改学生成绩");
						System.out.println("6、查询课程信息");
						System.out.println("7、增加课程信息");
						System.out.println("8、删除课程信息");
						System.out.println("9、修改课程信息");
						System.out.println("10、 退出");
						 int a = sc.nextInt();
	                     sc.nextLine();
	                     if(a == 1) {
	                    	 sd.getstudentAll();
	                     }
	                     else if (a == 3) {
	                    	 student s = new student();
	                    	 System.out.println("请输入学生id");
	                    	 int id = sc.nextInt();
	                    	 sc.nextLine();
	                    	 System.out.println("请输入学生姓名");
	                    	 String name = sc.nextLine();
	                    	 System.out.println("请输入学生性别");
	                    	 String sex = sc.nextLine();
	                    	 System.out.println("请输入学生年龄");
	                    	 int age = sc.nextInt();
	                    	 sc.nextLine();
	                    	 System.out.println("请输入学生专业");
	                    	 String major = sc.nextLine();
	                    	 s.setStudent_id(id);
	                    	 s.setStudent_name(name);
	                    	 s.setSex(sex);
	                    	 s.setAge(age);
	                    	 s.setMajor(major);
	                    	 sd.insertstudent(s);
	                    	 System.out.println("添加成功");
	                    	 
	                     }
	                     else if (a == 4) {
	                    	 System.out.println("请输入删除学生的id");
	                    	 int id = sc.nextInt();
	                    	 sc.nextLine();
	                    	 sd.deletestudent(id);
	                    	 System.out.println("删除成功");
	                     }
	                     else if (a == 5){
	                    	 System.out.println("请输入你要修改的学成id");
	                    	 int student_id = sc.nextInt();
	                    	 sc.nextLine();
	                    	 System.out.println("请输入你要修改的课程id");
	                    	 int course_id = sc.nextInt();
	                    	 sc.nextLine();
	                    	 System.out.println("请输入你要把成绩修改为多少");
	                    	 int score = sc.nextInt();
	                    	 sd.updateGrade(score, student_id, course_id);
	                    	 System.out.println("修改成功");
	                     }
	                     else if (a == 6) {
	                    	 sd.getcourseAll();
	                     }
	                     else if (a == 7) {
	                    	 course c  = new course();
	                    	 System.out.println("请输入你要增加的课程的id");
	                    	 int course_id = sc.nextInt();
	                    	 sc.nextLine();
	                    	 System.out.println("请输入你要增加的课程的名称");
	                    	 String course_name = sc.nextLine();
	                    	 System.out.println("请输入你要增加课程的课时");
	                    	 double time = sc.nextDouble();
	                    	 System.out.println("请输入你要增加课程的学分");
	                    	 double grade = sc.nextDouble();
	                    	 System.out.println("请输入你要增加的课程的老师id");
	                    	 int teacher_id = sc.nextInt();
	                    	 sc.nextLine();
	                    	 c.setTeacher_id(course_id);
	                    	 c.setCourse_name(course_name);
	                    	 c.setCourse_time(time);
	                    	 c.setCourse_grade(grade);
	                    	 c.setTeacher_id(teacher_id);
	                    	 sd.insertcourse(c);
	                    	 System.out.println("增加成功");
	                     }
	                     else if (a == 8) {
	                    	 System.out.println("请输入你要删除的课程id");
	                    	 int id  = sc.nextInt();
	                    	 sc.nextLine();
	                    	 sd.deletecourse(id);
	                    	 System.out.println("删除成功");
	                     }
	                     else if (a == 9) {
	                    	 System.out.println("请输入你要更改的课程的id");
	                    	 int coures_id = sc.nextInt();
	                    	 sc.nextLine();
	                    	 System.out.println("请输入你要把改 课程改为id为多少的老师");
	                    	 int teacher_id =sc.nextInt();
	                    	 sc.nextLine();
	                    	 sd.updateCourse(teacher_id, coures_id);
	                    	 System.out.println("修改成功");
	                     }
	                     else if (a == 10) {
	                    	 break;
	                     }
	                     else if (a == 2) {
	                    	 System.out.println("请输入你要查询的学生id");
	                        	int n = sc.nextInt();
	                        	sc.nextLine();
	                        	sd.getstudent(n);
	                        	System.out.println("查询成功");
	                     }
	                     
						} 
				}
					
					break;
				}
			 else {
				 System.out.println("密码错误");
				 break;
			 }
			 
			}
			count++;
			if(count == list.size()) {
				System.out.println("改用户名不存在");
			}
		}
		
		}
	}
	}
