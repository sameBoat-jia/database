package com.itheima.springbootinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

    @Value("${address[0]}")
    private String address1;

    @Autowired
    private Environment environment;

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(name);
        System.out.println(age);
        System.out.println(address1);
        System.out.println("=====================");
        System.out.println(environment.getProperty("person.name"));
        System.out.println(environment.getProperty("address[0]"));
        System.out.println("---------------------------");
        System.out.println(person);
        String[] address = person.getAddress();
        for (String s :
                address) {
            System.out.println(s);
        }
        return "hello spring bbbbb";
    }
}
