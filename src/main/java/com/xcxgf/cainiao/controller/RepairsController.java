package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Repairs;
import com.xcxgf.cainiao.services.RepairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RepairsController {
    @Autowired
    RepairsService repairsService;

    @RequestMapping(method = RequestMethod.POST,value = "addRepairs")
    public int addRepairs(@RequestBody Repairs repairs){
        return repairsService.addRepairs(repairs);
    }


}
