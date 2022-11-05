package com.example.demo;


/*
    pojo plain old java objects
    Bean特征，1public型class
    2所有属性都是私有的
    3必须有缺省构造函数
    4每个成员属性都配getter和setter方法
*/
public class Book {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Book() {
    }
}
