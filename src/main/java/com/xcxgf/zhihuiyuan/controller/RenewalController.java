package com.xcxgf.zhihuiyuan.controller;


import com.xcxgf.zhihuiyuan.POJO.Renewal;
import com.xcxgf.zhihuiyuan.POJO.Room;

import com.xcxgf.zhihuiyuan.services.RenewalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("Renewal")
public class RenewalController {
    @Autowired
    RenewalService renewalService;


    @RequestMapping(method= RequestMethod.GET,value = "/getRenewalList")
    public List<Renewal> getRenewalList(HttpServletRequest request){return renewalService.getRenewalList(request);}

    @RequestMapping(method =RequestMethod.GET,value = "/getCount")
    public int getCount(HttpServletRequest request){return  renewalService.getCount(request);}

    @RequestMapping(method =RequestMethod.POST,value = "/insertRenewals")
    public int insertRenewals(@RequestBody Renewal renewal) throws ParseException {
        //System.out.printf(renewal.getLeasePeriod());
        return renewalService.insertRenewals(renewal);
    }

    @RequestMapping(method =RequestMethod.POST,value = "/insertRenewals2")
    public int insertRenewals2(@RequestBody Renewal renewal) {
        //System.out.printf(renewal.getLeasePeriod());
        return renewalService.insertRenewals2(renewal);
    }
    @RequestMapping(method =RequestMethod.POST,value = "/updateRoom")
    public int updateRoom(@RequestBody  Room room){
        return renewalService.updateRoom(room);
    }


}

