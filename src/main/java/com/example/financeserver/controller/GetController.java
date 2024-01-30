package com.example.financeserver.controller;

import com.example.financeserver.data.dao.RecordDAO;
import com.example.financeserver.data.entity.AdjSpanEntity;
import com.example.financeserver.data.entity.BasicEntity;
import com.example.financeserver.data.entity.DailyEntity;
import com.example.financeserver.data.entity.RawSpanEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/data/kor")
public class GetController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetController.class);
    private final RecordDAO recordDAO;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    public GetController(RecordDAO recordDAO) {
        this.recordDAO = recordDAO;
    }

    public String ToRecord(Object[] l) {
        String[] ret = new String[l.length];
        for (int i = 0; i < l.length; i++) {
            ret[i] = "\"" + (l[i] != null ? l[i].toString() : "") + "\"" + (i + 1 == l.length ? "\n" : ",");
        }
        return String.join("", ret);
    }

    @GetMapping("/daily/{date}")
    public ResponseEntity<String> getDailyData(@PathVariable String date) throws ParseException {
        System.out.println(date);
        LOGGER.info(date);
        Date d = new Date(formatter.parse(date).getTime());
        List<DailyEntity> list = recordDAO.getDailyData(d);
        String headrow = "종목코드,종목명,시장구분,소속부,종가,대비,등락률,시가,고가,저가,거래량,거래대금,시가총액,상장주식수\n";
        StringBuilder sb = new StringBuilder();
        sb.append(headrow);
        for (DailyEntity e : list) {
            sb.append(ToRecord(e.tolist()));
        }
        String ret = sb.toString();
//        return ResponseEntity.status(HttpStatus.OK).body(ret);
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "text/csv; charset=EUC-KR");
        header.add("Content-Disposition","atachment;filename=\""+"user.csv"+"\"");
        return ResponseEntity.status(HttpStatus.CREATED).
                headers(header).body(ret);
    }

    @GetMapping("/basic/{date}")
    public ResponseEntity<String> getBasicData(@PathVariable String date) throws ParseException {
        System.out.println(date);
        LOGGER.info(date);
        Date d = new Date(formatter.parse(date).getTime());
        List<BasicEntity> list = recordDAO.getBasicData(d);
        String headrow = "표준코드,단축코드,한글 종목명,한글 종목약명,영문 종목명,상장일,시장구분,증권구분,소속부,주식종류,액면가,상장주식수\n";
        StringBuilder sb = new StringBuilder();
        sb.append(headrow);
        for (BasicEntity e : list) {
            sb.append(ToRecord(e.tolist()));
        }
        String ret = sb.toString();
//        return ResponseEntity.status(HttpStatus.OK).body(ret);
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "text/csv; charset=EUC-KR");
        header.add("Content-Disposition","atachment;filename=\""+"user.csv"+"\"");
        return ResponseEntity.status(HttpStatus.CREATED).
                headers(header).body(ret);
    }

    @GetMapping("/span/raw/")
    public ResponseEntity<String> getRawSpanData(@RequestParam String start,@RequestParam String end,@RequestParam String target) throws ParseException {
        LOGGER.info(start,end,target);
        Date s = new Date(formatter.parse(start).getTime());
        Date e = new Date(formatter.parse(end).getTime());
        List<RawSpanEntity> list = recordDAO.getRawSpanData(s,e,target);
        String headrow = "일자,종가,대비,등락률,시가,고가,저가,거래량,거래대금,시가총액,상장주식수\n";
        StringBuilder sb = new StringBuilder();
        sb.append(headrow);
        for (RawSpanEntity ent : list) {
            sb.append(ToRecord(ent.tolist()));
        }
        String ret = sb.toString();
//        return ResponseEntity.status(HttpStatus.OK).body(ret);
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "text/csv; charset=EUC-KR");
        header.add("Content-Disposition","atachment;filename=\""+"user.csv"+"\"");
        return ResponseEntity.status(HttpStatus.CREATED).
                headers(header).body(ret);
    }

    @GetMapping("/span/adj/")
    public ResponseEntity<String> getAdjSpanData(@RequestParam String start,@RequestParam String end,@RequestParam String target) throws ParseException {
        LOGGER.info(start,end,target);
        Date s = new Date(formatter.parse(start).getTime());
        Date e = new Date(formatter.parse(end).getTime());
        List<AdjSpanEntity> list = recordDAO.getAdjSpanData(s,e,target);
        String headrow = "일자,종가,대비,등락률,시가,고가,저가,거래량,거래대금,시가총액,상장주식수\n";
        StringBuilder sb = new StringBuilder();
        sb.append(headrow);
        for (AdjSpanEntity ent : list) {
            sb.append(ToRecord(ent.tolist()));
        }
        String ret = sb.toString();
//        return ResponseEntity.status(HttpStatus.OK).body(ret);
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "text/csv; charset=EUC-KR");
        header.add("Content-Disposition","atachment;filename=\""+"user.csv"+"\"");
        return ResponseEntity.status(HttpStatus.CREATED).
                headers(header).body(ret);
    }

}
