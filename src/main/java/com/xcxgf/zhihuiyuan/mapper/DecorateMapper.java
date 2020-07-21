package com.xcxgf.zhihuiyuan.mapper;

import com.xcxgf.zhihuiyuan.POJO.Decorate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DecorateMapper {
    /**
     * 后台查分页询装修申请信息
     * @param status
     * @param start
     * @param pageSize
     * @return
     */
    @Select("select * from decorate where status=#{status} limit #{start},#{pageSize}")
    public List<Decorate> getDecoraterList(Boolean status,int start,int pageSize);

    /**
     * 后台根据审核状态统计装修申请条数
     * @param status
     * @return
     */
    @Select("select count(*) from decorate where status=#{status}")
    public int getCountByStatus(Boolean status);


    /**
     * 企业申请进行装修
     * @param decorate
     * @return
     */
    @Insert("insert into decorate(companyName,address,telPhone,stype,remark,status,createTime) " +
            "values(#{companyName},#{address},#{telPhone},#{stype},#{remark},#{status},#{createTime})")
    public int applyDecorate(Decorate decorate);

    /**
     * 前端个人查询本公司的装修申请信息
     * @param start
     * @return
     */
    @Select("select * from decorate where companyName=#{companyName} order by createTime limit #{start},#{pageSize}")
    public List<Decorate> getSurrenderListByCname(String companyName,int start,int pageSize);

    /**
     * 个人装修申请信息的总条数
     * @param companyName
     * @return
     */
    @Select("select count(*) from decorate where companyName=#{companyName}")
    public int getCountByCname(String companyName);

    /**
     * 设置是否通过
     * @param audit
     * @param id
     * @return
     */
    @Update("update decorate set audit=#{audit},status=true where id=#{id}")
    public int istopass(Boolean audit,int id);

}
