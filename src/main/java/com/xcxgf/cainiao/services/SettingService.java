package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Setting;
import com.xcxgf.cainiao.mapper.SettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统设置，后端与数据库的逻辑处理层
 */
@Service
public class SettingService {
    @Autowired
    private SettingMapper sm;

    /**
     * 获取所有可用数据
     * @return Setting类型，所有可用数据
     */
    public List<Setting> getSettingList(){
        return sm.getSettingList();
    }

    /**
     * 更新记录
     * @param setting 需要被更新的记录对象
     * @return Setting类型的集合，所有在更新之后获取的可用数据
     */
    public List<Setting> updateSettingList(Setting setting){
        sm.updateSettingList(setting);
        return sm.getSettingList();
    }
}
