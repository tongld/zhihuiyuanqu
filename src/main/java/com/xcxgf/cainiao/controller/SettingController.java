package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Setting;
import com.xcxgf.cainiao.services.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * 系统设置管理，前端后台交互层
 */
@RestController
@RequestMapping("setting")
public class SettingController {
    @Autowired
    private SettingService ss;

    /**
     * 获取所有系统设置的数据
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getSettingList")
    public List<Setting> getSettingList(){
        return ss.getSettingList();
    }

    /**
     * 更新系统设置的数据
     * @param setting 需要被更新的数据
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updateSettingList")
    public List<Setting> updateSettingList(@RequestBody Setting setting){
        ss.updateSettingList(setting);
        return ss.getSettingList();
    }
}
