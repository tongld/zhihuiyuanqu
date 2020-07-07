package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Repairs;
import com.xcxgf.cainiao.mapper.RepairsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RepairsService {
    @Autowired
    RepairsMapper repairsMapper;

    public int addRepairs(Repairs repairs){

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm");
        repairs.setCreateTime(sdf.format(new Date()));
        return repairsMapper.addRepair(repairs);
    }
}
