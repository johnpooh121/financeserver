package com.example.financeserver.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(DateCodePK.class)
@Table(name = "basic")
public class BasicEntity {
    @Id
    private Date 일자;
    @Id
    @Column(name = "단축코드",columnDefinition = "CHAR(6)")
    private String 종목코드;

    @Column(columnDefinition = "char(200)")
    private String 표준코드;

    @Column(name="한글 종목명",columnDefinition = "char(200)")
    private String 한글_종목명;

    @Column(name="한글 종목약명",columnDefinition = "char(200)")
    private String 한글_종목약명;

    @Column(name="영문 종목명",columnDefinition = "char(200)")
    private String 영문_종목명;

    private Date 상장일;

    @Column(columnDefinition = "char(200)")
    private String 시장구분;
    @Column(columnDefinition = "char(200)")
    private String 증권구분;
    @Column(columnDefinition = "char(200)")
    private String 소속부;
    @Column(columnDefinition = "char(200)")
    private String 주식종류;
    @Column(columnDefinition = "char(200)")
    private String 액면가;
    @Column(columnDefinition = "char(200)")
    private Long 상장주식수;

    public Object[] tolist() {
        return new Object[]{표준코드,종목코드,한글_종목명,한글_종목약명,영문_종목명,상장일,시장구분,증권구분,소속부,주식종류,액면가,상장주식수}; //일자 뺌
    }
}
