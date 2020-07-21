package com.xcxgf.zhihuiyuan.controller;

import com.xcxgf.zhihuiyuan.POJO.SouContract;
import com.xcxgf.zhihuiyuan.services.SouContractServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("SouContract")
public class SouContractController {
    @Autowired
    SouContractServices souContractServices;

    @RequestMapping(method = RequestMethod.GET,value = "/getContractCount")
    public int getContractCount(HttpServletRequest request){
        return souContractServices.getContractCount(request);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getContractList")
    public List<SouContract> getContractList(HttpServletRequest request){
        return souContractServices.getContractList(request);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insertContract")
    public int insertContract(@RequestBody SouContract souContract){
        return souContractServices.insertContract(souContract);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insertXuYueContract")
    public int insertXuYueContract(@RequestBody SouContract souContract){
        return souContractServices.insertXuYueContract(souContract);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateAdvantage")
    public int updateAdvantage(@RequestBody SouContract souContract){
        return souContractServices.updateAdvantage(souContract);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/getContractBySno")
    public List<SouContract> getContractBySno(@RequestBody String sno){
        return souContractServices.getContractBySno(sno);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/deleteContract")
    public int deleteContract(@RequestBody SouContract souContract){
        return souContractServices.deleteContract(souContract);
    }
}
