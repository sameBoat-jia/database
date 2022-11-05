package com.j2eeshiyan3.j2ee.controller;

import com.alibaba.fastjson.JSON;
import com.j2eeshiyan3.j2ee.Service.TemplateService;
import com.j2eeshiyan3.j2ee.domain.TemplateDomain;
import com.j2eeshiyan3.j2ee.dto.TemplateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class TemplateController {
    @Autowired
    private TemplateService templateService;

    @GetMapping("/histogramMesg")
    public String getMin() throws ParseException {
        List<TemplateDomain> templateList = templateService.getEveryHour();
        List<TemplateDomain> temp = new ArrayList<>();
        List<Double> histo = new ArrayList<>();
        double sum = 0;
        double count = 0;
        double avg = 0;
        for (int i = 0; i < templateList.size(); ) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = null;
            Date d2 = null;
            d1 = format.parse(templateList.get(i).getTime());
            for (int j = i; j < templateList.size(); j++) {
                d2 = format.parse(templateList.get(j).getTime());
                long diff = d2.getTime() - d1.getTime();
                double template=Double.parseDouble(templateList.get(j).getTemplate());
                long diffMinutes = diff / (60 * 1000) % 60;
                if (diffMinutes <= 10) {
                    sum+=template;
                    count++;
                } else {
                    avg=sum/count;
                    histo.add(avg);
                    i=j;
                    break;
                }
            }
        }

//        List<TemplateDto> dtos = new ArrayList<>();
//        for (TemplateDomain template : templateList) {
//            TemplateDto dto = new TemplateDto();
//            dto.setTime(template.getTime());
//            dto.setTemplate(template.getTemplate());
//            dtos.add(dto);
//        }
        return JSON.toJSONString(histo);
    }

    @GetMapping("/linechartMesg")
    public String getHour() {
        List<TemplateDomain> templateList = templateService.getEveryHour();
        List<TemplateDto> dtos = new ArrayList<>();
        for (TemplateDomain template : templateList) {
            TemplateDto dto = new TemplateDto();
            dto.setTime(template.getTime());
            dto.setTemplate(template.getTemplate());
            dtos.add(dto);
        }
        return JSON.toJSONString(dtos);
    }

    @GetMapping("/now")
    public String getNow() {
//        System.out.println("进来了");
        TemplateDomain template = templateService.getNow();
        TemplateDto dto = new TemplateDto();
        dto.setTime(template.getTime());
        dto.setTemplate(template.getTemplate());
        return JSON.toJSONString(dto);
    }
}
