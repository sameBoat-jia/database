package com.itheima.controller;


import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//定义controller
//使用@Controller定义bean
@Controller
public class UserController {

   @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name ,int age)
   {
       System.out.println("=========================");
       System.out.println("普通参数传递 age==>" +
               age);
       System.out.println("普通参数传递 name==>" +
               name);
       return "{'module':'common param'}";
   }
   //集合参数：json格式
   @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes)
   {
       System.out.println("list common(json)参数传递 list==>" +
               likes);
       return "{'modul':'list common for json param'}";
   }
   //POJO参数：json格式
    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User user)
    {
        System.out.println("pojo(json)参数传递 user==>" +
                user);
        return "aaaaaaaaaaaaaaaaaaaa";
    }
}
