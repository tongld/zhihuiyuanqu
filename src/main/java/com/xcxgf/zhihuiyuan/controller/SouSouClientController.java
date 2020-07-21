package com.xcxgf.zhihuiyuan.controller;

import com.xcxgf.zhihuiyuan.POJO.SouSouClient;
import com.xcxgf.zhihuiyuan.services.SouSouClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author gdd
 */
@RestController
@RequestMapping("SouSouClient")
public class SouSouClientController {
    @Autowired
    SouSouClientService souSouClientService;


    @RequestMapping(method = RequestMethod.GET,value = "/getClientList")
    public List<SouSouClient> getClientList(HttpServletRequest request){
        return souSouClientService.getClientList(request);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getClientCount")
    public int getClientCount(HttpServletRequest request){
        return souSouClientService.getClientCount(request);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateClient")
    public int updateClient(@RequestBody  SouSouClient souSouClient){
        return souSouClientService.updateClient(souSouClient);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insertClient")
    public int insertClient(@RequestBody SouSouClient souSouClient){
        return souSouClientService.insertClient(souSouClient);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/deleteClient")
    public int deleteClient(@RequestBody String companyName){
        return souSouClientService.deleteClient(companyName);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getAllClient")
    public List<SouSouClient> getAllClient(@RequestBody String name){
        return souSouClientService.getAllClient(name);
    }



}
