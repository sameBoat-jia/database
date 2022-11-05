package com.example.demo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MyController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(User user )
    {
        System.out.println("username    "+user);
//        System.out.println(avatar.getName());
        return "received";
    }

    static class User{
        private String username;
        private String password;

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", id=" + id +
                    ", sex='" + sex + '\'' +
                    ", fav=" + fav +
                    ", birthday=" + birthday +
                    '}';
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public void setBirthday(LocalDate birthday) {
            this.birthday = birthday;
        }

        private int id;
private String sex;
private List<String> fav  ;

        public List<String> getFav() {
            return fav;
        }

        public void setFav(List<String> fav) {
            this.fav = fav;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate birthday;

        public LocalDate getLocalDate() {
            return birthday;
        }

        public void setLocalDate(LocalDate localDate) {
            this.birthday = localDate;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
