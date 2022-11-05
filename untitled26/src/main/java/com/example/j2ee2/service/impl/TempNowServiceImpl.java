package com.example.j2ee2.service.impl;

import com.example.j2ee2.bean.TempNow;
import com.example.j2ee2.mapper.TempNowMapper;
import com.example.j2ee2.service.TempNowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TempNowServiceImpl implements TempNowService {

    @Autowired
    TempNowMapper tempNowMapper;

    public TempNow add(double temperature) {
        TempNow tempNow = new TempNow();
        tempNow.setId(0);
        tempNow.setTemperature(temperature);
        tempNow.setTime(new Timestamp(System.currentTimeMillis()));
        return tempNowMapper.save(tempNow);
    }

    public List getNow() {
        List<TempNow> tempNows = tempNowMapper.getNew();
        List temps = new ArrayList();
        for (int i = 0; i < tempNows.size(); i++) {
            temps.add(tempNows.get(i).getTemperature());
        }
        Collections.reverse(temps);
        return temps;
    }

    public List getAll() {
        List<TempNow> tempAll = tempNowMapper.findAll();
        List temps = new ArrayList();
        for (int i = 0; i < tempAll.size(); i++) {
            temps.add(tempAll.get(i).getTemperature());
        }
        //Collections.reverse(temps);
        return temps;
    }

    public List getAverage() {
        List<TempNow> tempAll = tempNowMapper.findAll();
        List temps = new ArrayList();
        int count = 0;
        double sum = 0;
        for (int i = 0; i < tempAll.size(); i++) {
            if (count < 12) {
                sum += tempAll.get(i).getTemperature();
                count++;
            } else if (count == 12) {
                double average=new BigDecimal(sum/12).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue() ;
                temps.add(average);
                sum = 0;
                count = 0;
            }
        }
        return temps;
    }
}
