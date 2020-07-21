package com.xcxgf.zhihuiyuan.services;

import com.xcxgf.zhihuiyuan.POJO.Appeal;
import com.xcxgf.zhihuiyuan.POJO.ReturnData;
import com.xcxgf.zhihuiyuan.mapper.AppealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AppealService {
    @Autowired
    AppealMapper appealMapper;
    /**
     * 得到paymentInfo表数据
     * @param limit
     * @return
     */
    public ReturnData getAppealInfo(String limit){
        ReturnData dataReturn = new ReturnData();
        try {
            dataReturn.setDataCount(appealMapper.getCount());
            dataReturn.setAppeals(appealMapper.getAppealList(limit));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataReturn;
    }

    /**
     * 删除
     * @param appeal
     * @return
     */
    public int delete(Appeal appeal){
        return appealMapper.delete(appeal);
    }

    /**
     * 确定操作
     * @param appeal
     * @return
     */
    public int determine(Appeal appeal){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        appeal.setSolveTime(df.format(new Date()));
        return appealMapper.determine(appeal);
    }

    /**
     * 添加
     * @param appeal
     * @return
     */
    public int add(Appeal appeal){
        int flag=0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String report = appeal.getReportTime();
        try {
            appeal.setReportTime(df.format(df.parse(report)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(appealMapper.appealIsNull() >= 1){
            flag=appealMapper.add(appeal);
        }else {
            flag=appealMapper.addFirst(appeal);
        }
        return flag;
    }


}
