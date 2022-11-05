package com.example.j2ee2.mapper;

import com.example.j2ee2.bean.TempNow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TempNowMapper extends JpaRepository<TempNow,Integer> {
    @Query(value = "select * from temp_now order by time desc limit 12",nativeQuery = true)
    List<TempNow>getNew();
}
