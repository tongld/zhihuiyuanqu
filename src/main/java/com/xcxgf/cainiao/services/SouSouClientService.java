package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.SouSouClient;
import com.xcxgf.cainiao.mapper.SouSouClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SouSouClientService {
    @Autowired
    SouSouClientMapper souSouClientMapper;

    /**
     * 获取嗖嗖鸟意向客户信息
     * @return
     */
    public List<SouSouClient> getClientList(HttpServletRequest request){
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
        int startPage=(Integer.parseInt(request.getParameter("startPage"))-1)*pageSize;
        String name=request.getParameter("name");
        return souSouClientMapper.getClientList(startPage,pageSize,name);
    }

    /**
     * 获取嗖嗖鸟客户信息总条数
     * @return
     */
    public int getClientCount(HttpServletRequest request){
        String name=request.getParameter("name");
        return souSouClientMapper.getClientCount(name);
    }

    /**
     * 更新客户信息
     * @param souSouClient
     * @return
     */
    public int updateClient(SouSouClient souSouClient){
        return souSouClientMapper.updateClient(souSouClient);
    }

    /**
     * 新增意向客户
     * @param souSouClient
     * @return
     */
    public int insertClient(SouSouClient souSouClient){
        String companyName=souSouClient.getCompanyName();
        if(souSouClientMapper.selectClientByName(companyName)>0){
            return -1;
        }
        return souSouClientMapper.insertClient(souSouClient);
    }

    /**
     * 删除意向客户
     * @param companyName
     * @return
     */
    public int deleteClient(String companyName){
        return souSouClientMapper.deleteClient(companyName);
    }

    public List<SouSouClient> getAllClient(String name){
        return souSouClientMapper.getAllClient(name);
    }
}
