package com.xcxgf.cainiao.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class funhelper {
    public String addMounth(String date,int num) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date dt=sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH,num);
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);
        //System.out.println(reStr);
        return reStr;
    }
}
