package com.xcxgf.zhihuiyuan.mapper;

import com.xcxgf.zhihuiyuan.POJO.Building;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 对数据库中buildinginfo表（楼栋管理表）的增删改查操作
 * @author zyz
 */
public interface BuildingMapper {

    /**
     * 查询满足条件的可用记录
     *
     * @param search 查询条件
     * @param limit  需要返回的记录的起始位置和终止位置
     * @return Building类型的集合，满足条件的可用记录
     */
    @Select("select * " +
            "from buildinginfo " +
            "${search} " +
            "ORDER BY buildingName+0,insertTime desc " +
            "${limit}")
    public List<Building> getSearchList(String search, String limit);

    /**
     * 查询满足条件的可用记录的条数
     *
     * @param search 查询条件
     * @return int类型，满足条件的记录条数
     */
    @Select("SELECT count(*) " +
            "FROM buildinginfo " +
            "${search}")
    public int getSearchCount(String search);

    /**
     * 更新记录
     *
     * @param building 需要更新的记录对象
     * @return int类型，更新操作影响的记录条数，为0时更新失败，否则更新成功
     */
    @Update("UPDATE buildinginfo " +
            "SET buildingType=#{buildingType}, " +
            "updateTime=#{updateTime}" +
            "WHERE buildingName=#{buildingName}")
    public int updateBuildingInfo(Building building);

    /**
     * 删除记录
     *
     * @param building 需要删除的记录对象
     * @return int类型，删除操作影响的记录条数，为0时删除失败，否则删除成功
     */
    @Delete("DELETE FROM buildinginfo WHERE buildingName =#{buildingName}")
    public int deleteBuildingInfo(Building building);

    /**
     * 插入新记录
     *
     * @param building 需要插入的记录对象
     * @return int类型，插入记录影响的记录条数，为0时插入失败，否则插入成功
     */
    @Insert("INSERT INTO buildinginfo(buildingName,buildingType,insertTime) " +
            "VALUES(#{buildingName}, #{buildingType}, #{insertTime})")
    public int insertBuildingInfo(Building building);

    /**
     * 查询是否存在重复记录（执行插入记录操作时）
     *
     * @param building 需要查询是否存在的记录对象
     * @return int类型，满足查询条件的记录条数，为0时不存在重复记录，否则存在重复记录
     */
    @Select("select count(*) " +
            "from buildinginfo " +
            "where buildingName = #{buildingName}")
    public int insertSearchSame(Building building);

    /**
     * 查询是否存在重复记录（执行更新记录操作时）
     *
     * @param building 需要查询是否存在的记录对象
     * @return int类型，满足查询条件的记录条数，为0时不存在重复记录，否则存在重复记录
     */
    @Select("SELECT COUNT(*) " +
            "FROM (SELECT * FROM buildinginfo WHERE buildingName NOT in (select buildingName from buildinginfo where buildingName=#{buildingName} )) AS temp" +
            " WHERE buildingName = #{buildingName}")
    public int updateSearchSame(Building building);

}