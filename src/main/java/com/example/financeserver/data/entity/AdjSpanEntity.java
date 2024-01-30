package com.example.financeserver.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "adj_span")
@IdClass(DateCodePK.class)
public class AdjSpanEntity {
    @Id
    private Date 일자;
    @Id
    @Column(columnDefinition = "CHAR(6)")
    private String 종목코드;

    private Integer 종가;
    private Integer 대비;
    private float 등락률;
    private Integer 시가;
    private Integer 고가;
    private Integer 저가;
    private Long 거래량;
    private Long 거래대금;
    private Long 시가총액;
    private Long 상장주식수;

    public Object[] tolist(){
        return new Object[]{일자,종가,대비,등락률,시가,고가,저가,거래량,거래대금,시가총액,상장주식수}; //종목코드 뺌
    }
}
