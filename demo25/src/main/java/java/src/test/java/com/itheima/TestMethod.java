package java.src.test.java.com.itheima;

import java.util.Arrays;
import java.util.Comparator;

public class TestMethod {

    public static void main(String[] args) {
        Student stu = new Student("小明");
        stu.study("Java");
    }

    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        // 隐式参数
        public void study(Student this, String subject) {
            System.out.println(this.name + ": 在学习 " + subject);
        }
    }

}
