package com.example.financeserver.data.repository;

import com.example.financeserver.data.entity.DailyEntity;
import com.example.financeserver.data.entity.RawSpanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.financeserver.data.entity.DateCodePK;


import java.sql.Date;
import java.util.List;

public interface DailyRepository extends JpaRepository<DailyEntity,DateCodePK> {
    List<DailyEntity> findDailyEntitiesBy일자(Date date);
}
