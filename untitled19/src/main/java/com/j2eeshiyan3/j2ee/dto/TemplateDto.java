package com.j2eeshiyan3.j2ee.dto;

public class TemplateDto {
    private String time;
    private String template;

    public TemplateDto() {
    }

    public TemplateDto(String time, String template) {
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
