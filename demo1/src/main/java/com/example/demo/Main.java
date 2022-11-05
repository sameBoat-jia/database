package com.example.demo;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Main
{
    public static void main(String[] args) {
        Faker faker;
        faker = new Faker(Locale.CHINA);
        for (int i = 0; i < 100; i++) {
            String name=faker.name().fullName();
            System.out.println(name);
        }
    }
}