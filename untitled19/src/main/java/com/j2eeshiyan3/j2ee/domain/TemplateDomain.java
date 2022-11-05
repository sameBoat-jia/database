package com.j2eeshiyan3.j2ee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "samlpe")
public class TemplateDomain {
    @Id
    @Column(name = "sample_time")
    private String time;

    @Column(name = "sample_data")
    private String template;

    public TemplateDomain() {
    }

    public TemplateDomain(String time, String template) {
        this.time = time;
        this.template = template;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
