package com.example.financeserver.data.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;


public class DateCodePK implements Serializable {
    private Date 일자;
    private String 종목코드;
}
