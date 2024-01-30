package com.example.financeserver.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(DateCodePK.class)
@Table(name = "daily")
public class DailyEntity {
    @Id
    private Date 일자;
    @Id
    @Column(columnDefinition = "CHAR(6)")
    private String 종목코드;
    @Column(columnDefinition = "CHAR(200)")
    private String 종목명;
    @Column(columnDefinition = "CHAR(200)")
    private String 시장구분;
    @Column(columnDefinition = "CHAR(200)")
    private String 소속부;
    private Integer 종가;
    private Integer 대비;
    private Float 등락률;
    private Integer 시가;
    private Integer 고가;
    private Integer 저가;
    private Long 거래량;
    private Long 거래대금;
    private Long 시가총액;
    private Long 상장주식수;

    public Object[] tolist() {
        return new Object[]{종목코드, 종목명, 시장구분, 소속부, 종가, 대비, 등락률, 시가, 고가, 저가, 거래량, 거래대금, 시가총액, 상장주식수}; //일자 뺌
    }
}
