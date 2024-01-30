package com.example.financeserver.data.dao.impl;

import com.example.financeserver.data.dao.RecordDAO;
import com.example.financeserver.data.entity.AdjSpanEntity;
import com.example.financeserver.data.entity.BasicEntity;
import com.example.financeserver.data.entity.DailyEntity;
import com.example.financeserver.data.entity.RawSpanEntity;
import com.example.financeserver.data.repository.AdjSpanRepository;
import com.example.financeserver.data.repository.DailyRepository;
import com.example.financeserver.data.repository.BasicRepository;
import com.example.financeserver.data.repository.RawSpanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.Date;
import java.util.List;

@Component
public class RecordDAOImpl implements RecordDAO{
    private final DailyRepository dailyRepository;

    private final BasicRepository basicRepository;

    private final RawSpanRepository rawSpanRepository;
    private final AdjSpanRepository adjSpanRepository;

    @Autowired
    public RecordDAOImpl(DailyRepository dailyRepository, BasicRepository basicRepository, RawSpanRepository rawSpanRepository, AdjSpanRepository adjSpanRepository){
        this.dailyRepository=dailyRepository;
        this.basicRepository = basicRepository;
        this.rawSpanRepository = rawSpanRepository;
        this.adjSpanRepository = adjSpanRepository;
    }
    @Override
    public List<DailyEntity> getDailyData(Date date) {
        return dailyRepository.findDailyEntitiesBy일자(date);
    }

    @Override
    public List<BasicEntity> getBasicData(Date date) {
        return basicRepository.findBasicEntitiesBy일자(date);
    }

    @Override
    public List<RawSpanEntity> getRawSpanData(Date s, Date e, String target) {
        return rawSpanRepository.findRawSpanEntitiesBy일자BetweenAnd종목코드(s,e,target);
    }

    @Override
    public List<AdjSpanEntity> getAdjSpanData(Date s, Date e, String target) {
        return adjSpanRepository.findAdjSpanEntitiesBy일자BetweenAnd종목코드(s,e,target);
    }


}
