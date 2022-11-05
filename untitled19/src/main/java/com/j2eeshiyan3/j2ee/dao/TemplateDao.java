package com.j2eeshiyan3.j2ee.dao;

import com.j2eeshiyan3.j2ee.domain.Minute;
import com.j2eeshiyan3.j2ee.domain.TemplateDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TemplateDao extends JpaRepository<TemplateDomain,Integer> {
    @Query(value = "select sample_time,sample_data from sample where date_sub(now(),interval 1 minute) < sample_time", nativeQuery = true)
    List<TemplateDomain> getTemplateEveryMinuteList();
    @Query(value = "select sample_time,sample_data from sample where date_sub(now(),interval 10 minute) < sample_time", nativeQuery = true)
    List<TemplateDomain> getTemplate10MinutesList();
    @Query(value = "select sample_time,sample_data from sample where date_sub(now(),interval 1 hour) < sample_time", nativeQuery = true)
    List<TemplateDomain> getTemplateEveryHourList();
    @Query(value = "select sample_time,sample_data from sample where date_sub(now(),interval 5 second ) < sample_time LIMIT 1 ", nativeQuery = true)
    TemplateDomain getNow();
}
