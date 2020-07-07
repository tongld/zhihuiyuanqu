package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Repairs;
import com.xcxgf.cainiao.common.enums.BaseServiceException;
import com.xcxgf.cainiao.common.enums.ServiceErrCode;
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
        if (repairs==null){
            throw new BaseServiceException("参数不能为空！", ServiceErrCode.NOTFOUND_RESULT_ERR);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm");
        repairs.setCreateTime(sdf.format(new Date()));
        return repairsMapper.addRepair(repairs);
    }
}
