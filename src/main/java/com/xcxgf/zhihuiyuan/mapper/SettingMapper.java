package com.xcxgf.zhihuiyuan.mapper;

import com.xcxgf.zhihuiyuan.POJO.Setting;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SettingMapper {
    /**
     * 查找所有可用记录
     *
     * @return Setting类型的集合，所有可用的记录
     */
    @Select("select * from settingInfo where state != -1")
    public List<Setting> getSettingList();

    /**
     * 更新记录
     *
     * @param setting 需要被更新的记录对象
     */
    @Update("update settingInfo set manageExpense=#{manageExpense} where id=#{id}")
    public void updateSettingList(Setting setting);
}
