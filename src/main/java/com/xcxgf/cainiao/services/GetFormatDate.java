package com.xcxgf.cainiao.services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetFormatDate {
    public String getNowDate(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String ndate= dateFormat.format(date).toString();
        return ndate;
    }
}
