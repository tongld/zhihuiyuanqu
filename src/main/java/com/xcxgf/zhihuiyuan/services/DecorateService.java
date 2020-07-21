package com.xcxgf.zhihuiyuan.services;

import com.xcxgf.zhihuiyuan.POJO.Decorate;
import com.xcxgf.zhihuiyuan.common.enums.BaseServiceException;
import com.xcxgf.zhihuiyuan.common.enums.ServiceErrCode;
import com.xcxgf.zhihuiyuan.mapper.DecorateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DecorateService {
    @Autowired
    DecorateMapper decorateMapper;

    /**
     * 计算数据库查询的起始位置，根据审核状态分页获取信息
     * @param status
     * @param startPage
     * @param pageSize
     * @return
     */
    public List<Decorate> getDecoraterList(Boolean status,int startPage, int pageSize){
        if(status==null||startPage<=0||pageSize<=0){
            throw new BaseServiceException("参数数值错误", ServiceErrCode.REQ_PARAM_ERR);
        }
        int start=(startPage-1)*pageSize;
        return decorateMapper.getDecoraterList(status,start,pageSize);
    }

    /**
     * 根据状态统计信息总条数
     * @param status
     * @return
     */
    public int getCountByStatus(Boolean status){
        if(status==null){
            throw new BaseServiceException("参数数值错误", ServiceErrCode.REQ_PARAM_ERR);
        }
        return decorateMapper.getCountByStatus(status);
    }

    /**
     * 新增装修申请信息
     * @param decorate
     * @return
     */
    public int applyDecorate(Decorate decorate){

        int iserror=0;
        funhelper fhelp=new funhelper();
        decorate.setCreateTime(fhelp.getDateFormat());

        if(decorate.getCompanyName().equals("")){
            throw new BaseServiceException("参数数值错误",ServiceErrCode.REQ_PARAM_ERR);
        }
        try{
             iserror=decorateMapper.applyDecorate(decorate);
        }
        catch (Exception e){
            if(iserror!=1){
                throw new BaseServiceException(e.getMessage(),ServiceErrCode.REQ_PARAM_ERR);
            }
        }

        return iserror;
    }

    /**
     * 个人查询本公司的装修申请信息
     * @param companyName
     * @param startPage
     * @param pageSize
     * @return
     */
    public List<Decorate> getSurrenderListByCname(String companyName,int startPage,int pageSize){

        if(startPage<=0||pageSize<=0||companyName.equals("")){
            throw new BaseServiceException("参数数值错误", ServiceErrCode.REQ_PARAM_ERR);
        }
        int start=(startPage-1)*pageSize;
        return decorateMapper.getSurrenderListByCname(companyName,start,pageSize);
    }

    /**
     * 统根据审核状态角色计当前公司的申请信息条数
     * @param companyName
     * @return
     */
    public int getCountByCname(String companyName){
        if(companyName.equals("")){
            throw new BaseServiceException("参数数值错误", ServiceErrCode.REQ_PARAM_ERR);
        }
        return decorateMapper.getCountByCname(companyName);
    }

    /**
     * 是否通过装修申请
     * @param audit
     * @param id
     * @return
     */
    public int istopass(Boolean audit,int id){
        return decorateMapper.istopass(audit,id);
    }

}
