public class course {
 private int course_id;
 private String course_name;
 private double course_time;
 private double course_grade;
 private int teacher_id;
public int getCourse_id() {
	return course_id;
}
public void setCourse_id(int course_id) {
	this.course_id = course_id;
}
public String getCourse_name() {
	return course_name;
}
public void setCourse_name(String course_name) {
	this.course_name = course_name;
}
public double getCourse_time() {
	return course_time;
}
public void setCourse_time(double course_time) {
	this.course_time = course_time;
}
public double getCourse_grade() {
	return course_grade;
}
public void setCourse_grade(double course_grade) {
	this.course_grade = course_grade;
}
public int getTeacher_id() {
	return teacher_id;
}
public void setTeacher_id(int teacher_id) {
	this.teacher_id = teacher_id;
}
@Override
public String toString() {
	return "course [course_id=" + course_id + ", course_name=" + course_name + ", course_time=" + course_time
			+ ", course_grade=" + course_grade + ", teacher_id=" + teacher_id + "]";
}
}
