package com.example.j2ee2.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class TempNow {
    @Id
    private Integer id;
    private Double temperature;
    private Timestamp time;
}
