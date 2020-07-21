package com.xcxgf.zhihuiyuan.services;

import com.xcxgf.zhihuiyuan.POJO.Repairs;
import com.xcxgf.zhihuiyuan.common.enums.BaseServiceException;
import com.xcxgf.zhihuiyuan.common.enums.ServiceErrCode;
import com.xcxgf.zhihuiyuan.mapper.RepairsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RepairsService {
    @Autowired
    RepairsMapper repairsMapper;

    /**
     * 新增维修信息
     * @param repairs
     * @return
     */
    public int addRepairs(Repairs repairs){

        if (repairs.getCompanyName().equals("")){
            throw new BaseServiceException("参数不能为空！", ServiceErrCode.NOTFOUND_RESULT_ERR);
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm");
        repairs.setCreateTime(sdf.format(new Date()));
        return repairsMapper.addRepair(repairs);
    }

    /**
     * 分页查询当前状态下的维修信息
     * @param status
     * @param startPage
     * @param pageSize
     * @return
     */
    public List<Repairs> getRepairData(int status,int startPage,int pageSize){
        int start=(startPage-1)*pageSize;
        return repairsMapper.getRepairData(status,start,pageSize);
    }

    /**
     * 统计当前状态下的维修信息条数
     * @param status
     * @return
     */
    public int getRepairCount(int status){
        if (status!=1&&status!=2&&status!=3){
            throw new BaseServiceException("参数数值错误",ServiceErrCode.REQ_PARAM_ERR);
        }
        return repairsMapper.getRepairCount(status);
    }

    /**
     * 更新维修的状态
     * @param status
     * @param id
     * @return
     */
    public int updateRepairsStatus(int status,int id){
        if (status!=1&&status!=2&&status!=3){
            throw new BaseServiceException("参数数值错误",ServiceErrCode.REQ_PARAM_ERR);
        }
        return repairsMapper.updateRepairsStatus(status,id);
    }

    /**
     * 更新维修人
     * @param repairman
     * @param id
     * @return
     */
    public int updateRepairman(String repairman,int id){

        if(repairsMapper.updateRepairsStatus(2,id)==1){
            return repairsMapper.updateRepairman(repairman,id);
        }

        return -1;
    }

    /**
     * 分页，根据公司名，信息状态获取数据
     * @param companyName
     * @param status
     * @param startPage
     * @param pageSize
     * @return
     */
    public List<Repairs> getOwnRepairs(String companyName,int status,int startPage,int pageSize){
        int start=(startPage-1)*pageSize;
        return repairsMapper.getOwnRepairs(companyName,status,start,pageSize);
    }

    /**
     * 按公司名和信息状态统计数据
     * @param companyName
     * @param status
     * @return
     */
    public int getOwnCount(String companyName,int status){

        return repairsMapper.getOwnCount(companyName,status);
    }
}
