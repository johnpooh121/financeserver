package com.example.financeserver.data.repository;

import com.example.financeserver.data.entity.AdjSpanEntity;
import com.example.financeserver.data.entity.RawSpanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface AdjSpanRepository extends JpaRepository<AdjSpanEntity,Long> {
    List<AdjSpanEntity> findAdjSpanEntitiesBy일자BetweenAnd종목코드(Date startdate, Date enddate,String code);
}
