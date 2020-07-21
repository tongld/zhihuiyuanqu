package com.xcxgf.zhihuiyuan.mapper;

import com.xcxgf.zhihuiyuan.POJO.Appeal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AppealMapper {
    /**
     * 分页条数
     * @return
     */
    @Select("select  count(*) from appeal")
    public int getCount();

    /**
     * 查询数据
     * @param limit  需要返回的记录的起始位置和终止位置
     * @return 类型的集合，满足条件的可用记录
     */
    @Select("select  * from appeal where id ${limit}")
    public List<Appeal> getAppealList(String limit);

    /**
     * 删除
     * @param appeal
     * @return
     */
    @Delete("delete from appeal where id = #{id}")
    public int delete(Appeal appeal);

    /**
     * 确定操作
     * @param appeal
     * @return
     */
    @Update("UPDATE appeal SET state = 1 , solveTime = #{solveTime} where id = #{id}")
    public int determine(Appeal appeal);

    /**
     * 第一次添加
     * @param appeal
     * @return
     */
    @Insert("insert into appeal(id ,problem,content,owner,state,reportTime,contacts,telephone) values(1,#{problem},#{content},#{owner},#{state},#{reportTime},#{contacts},#{telephone})")
    public int addFirst(Appeal appeal);

    /**
     * 添加
     * @param appeal
     * @return
     */
    @Insert("insert into appeal(problem,content,owner,state,reportTime,contacts,telephone) values(#{problem},#{content},#{owner},#{state},#{reportTime},#{contacts},#{telephone})")
    public int add(Appeal appeal);

    /**
     * 查询是否有数据
     * @return
     */
    @Select("select count(id) from appeal where id ")
    public int appealIsNull();
}
