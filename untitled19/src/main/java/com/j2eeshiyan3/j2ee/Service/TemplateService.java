package com.j2eeshiyan3.j2ee.Service;

import com.j2eeshiyan3.j2ee.dao.TemplateDao;
import com.j2eeshiyan3.j2ee.domain.TemplateDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {
    @Autowired
    TemplateDao templateDao;

    public List<TemplateDomain> get10Minutes() {
        List<TemplateDomain> List = templateDao.getTemplate10MinutesList();
        return List;
    }

    public List<TemplateDomain> getEveryMinute() {
        List<TemplateDomain> List = templateDao.getTemplateEveryMinuteList();
        return List;
    }

    public List<TemplateDomain> getEveryHour() {
        List<TemplateDomain> List = templateDao.getTemplateEveryHourList();
        return List;
    }
    public TemplateDomain getNow() {
        TemplateDomain templateDomain = templateDao.getNow();
        return templateDomain;
    }
}
