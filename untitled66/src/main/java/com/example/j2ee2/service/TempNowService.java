package com.example.j2ee2.service;

import com.example.j2ee2.bean.TempNow;

import java.util.List;

public interface TempNowService {

    TempNow add(double temperature);

    List getNow();

    List getAll();

    List getAverage();
}
