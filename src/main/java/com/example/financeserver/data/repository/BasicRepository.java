package com.example.financeserver.data.repository;

import com.example.financeserver.data.entity.BasicEntity;
import com.example.financeserver.data.entity.DailyEntity;
import com.example.financeserver.data.entity.DateCodePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface BasicRepository extends JpaRepository<BasicEntity, DateCodePK> {
    List<BasicEntity> findBasicEntitiesBy일자(Date date);
}
