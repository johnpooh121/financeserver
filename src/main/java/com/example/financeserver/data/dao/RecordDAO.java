package com.example.financeserver.data.dao;

import com.example.financeserver.data.entity.AdjSpanEntity;
import com.example.financeserver.data.entity.BasicEntity;
import com.example.financeserver.data.entity.DailyEntity;
import com.example.financeserver.data.entity.RawSpanEntity;


import java.sql.Date;
import java.util.List;

public interface RecordDAO {
    List<DailyEntity> getDailyData(Date date);
    List<BasicEntity> getBasicData(Date date);
    List<RawSpanEntity> getRawSpanData(Date s,Date e,String Target);
    List<AdjSpanEntity> getAdjSpanData(Date s, Date e, String Target);
}
