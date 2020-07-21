package com.xcxgf.zhihuiyuan.mapper;


import com.xcxgf.zhihuiyuan.POJO.PaymentInfo;
import com.xcxgf.zhihuiyuan.POJO.SystemInfo;
import org.apache.ibatis.annotations.*;


import java.text.MessageFormat;
import java.util.List;
import java.util.Map;


/**
 * @author 田易
 */
@SuppressWarnings("ALL")
public interface PaymentMapper {

    /**
     * 查询房间
     * @param roomNumber
     * @param limit
     * @return
     */
    @Select("select  * from paymentinfo where roomNumber LIKE CONCAT('%',#{roomNumber},'%') and id ${limit}")
    public List<PaymentInfo> getSearchRoomNumberList(String roomNumber,String limit);

    /**
     * 查询企业
     * @param owner
     * @param limit
     * @return
     */
    @Select("select  * from paymentinfo where owner LIKE CONCAT('%',#{owner},'%') and id ${limit};")
    public List<PaymentInfo> getSearchBuildingNameList(String owner,String limit);

    /**
     * 查询paymentinfo表中是否有数据
     * @return
     */
    @Select("select  count(id) from paymentinfo where id ")
    public int tableIsNull();

    /**
     * 查询本期的数据
     * @param limit  需要返回的记录的起始位置和终止位置
     * @return 类型的集合，满足条件的可用记录
     */
    @Select("select  * from paymentinfo where id ${limit}")
    public List<PaymentInfo> getPaymentList(String limit);

    /**
     * 分页条数
     * @return
     */
    @Select("select  count(*) from paymentinfo")
    public int getCount();

    /**
     * 指定搜索房号的分页条数
     * @param roomNumber
     * @return
     */
    @Select("select  count(*) from paymentinfo where roomNumber = #{roomNumber}")
    public int getSearchRoomCount(String roomNumber);

    /**
     * 指定搜索企业的分页条数
     * @param owner
     * @return
     */
    @Select("select  count(*) from paymentinfo where owner = #{owner}")
    public int getSearchOwnerCount(String owner);

    /**
     * 添加paymentinfo表数据
     * @param paymentInfo paymentInfo对象
     * @return
     */
    @Insert("insert into paymentinfo( waterNumber, electricityNumber,owner,buildingName,roomNumber,startTime,endTime,waterCost,electricityCost," +
            "waterNumberPrevious,waterDifference,electricityNumberPrevious,electricityDifference,total) " +
            "values(#{waterNumber}, #{electricityNumber}, #{owner},#{buildingName},#{roomNumber},#{startTime},#{endTime},#{waterCost},#{electricityCost}," +
            "#{waterNumberPrevious},#{waterDifference},#{electricityNumberPrevious},#{electricityDifference},#{total})")
    public int insertPaymentInfo(PaymentInfo paymentInfo);


    /**
     * 批量添加paymentInfo表数据
     * @param paymentInfo paymentInfo对象
     * @return
     */
    @InsertProvider(type = Provider.class, method = "batchInsert")
    Integer batInfoAdd(List<PaymentInfo> paymentInfo);

    /**
     * mysql批量语句拼接类
     */
    class Provider {
        public String batchInsert(Map map) {
            List<PaymentInfo> paymentInfos = (List<PaymentInfo>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("insert into paymentinfo(waterNumber, electricityNumber,owner,buildingName,roomNumber,startTime," +
                    "endTime,waterCost,electricityCost,waterNumberPrevious,waterDifference,electricityNumberPrevious,electricityDifference,total) values");

            MessageFormat mf = new MessageFormat(
                    "(#'{'list[{0}].waterNumber},#'{'list[{0}].electricityNumber},#'{'list[{0}].owner},#'{'list[{0}].buildingName}," +
                            "#'{'list[{0}].roomNumber},#'{'list[{0}].startTime},#'{'list[{0}].endTime},#'{'list[{0}].waterCost},#'{'list[{0}].electricityCost}," +
                            "#'{'list[{0}].waterNumberPrevious},#'{'list[{0}].waterDifference},#'{'list[{0}].electricityNumberPrevious}," +
                            "#'{'list[{0}].electricityDifference},#'{'list[{0}].total})"
            );
            for (int i = 0; i < paymentInfos.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                if (i < paymentInfos.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
    }

    /**
     * 查询系统设置中是否有数据
     * @return
     */
    @Select("select  count(id) from systeminfo where id ")
    public int systemInfoIsNull();


    /**
     * 新增系统后台设置单价
     * @param systemInfo systemInfo对象
     * @return
     */
    @Insert("insert into systeminfo(id ,waterUnitPrice,electricityUnitPrice,leaseUnitPrice,energySharingPrice) values(1,#{waterUnitPrice},#{electricityUnitPrice},#{leaseUnitPrice},#{energySharingPrice})")
    public int insertSystemInfo(SystemInfo systemInfo);


    /**
     * 查询后台设置数据
     * @return
     */
    @Select("select * from systeminfo")
    public List<SystemInfo> getSystemInfoList();


    /**
     * 更新后台设置数据
     * @param systemInfo systemInfo对象
     * @return
     */
    @Update("update systeminfo set waterUnitPrice = #{waterUnitPrice},electricityUnitPrice = #{electricityUnitPrice},leaseUnitPrice=#{leaseUnitPrice},energySharingPrice=#{energySharingPrice} where id = 1")
    public int updateSystemInfo(SystemInfo systemInfo);


    /**
     * 查询所有年份
     * @return
     */
    @Select("SELECT DISTINCT YEAR(startTime) FROM paymentinfo WHERE startTime order by YEAR(startTime) asc")
    public List<Long> getYearsList();


    /**
     * 查询年份水费数据
     * @return
     */
    @Select("select SUM(waterCost) from paymentinfo WHERE startTime GROUP BY YEAR(startTime) order by YEAR(startTime) asc")
    public List<Float> getYearsWaterCostList();


    /**
     * 查询年份电费数据
     *  @return
     */
    @Select("select  SUM(electricityCost) from paymentinfo WHERE startTime GROUP BY YEAR(startTime) order by YEAR(startTime) asc")
    public List<Float> getYearsElectricityCostList();


    /**
     * 查询本年月份
     * @param time
     * @return
     */
    @Select("SELECT DISTINCT MONTH(startTime) FROM paymentinfo WHERE startTime LIKE CONCAT(#{startTime},'%') order by MONTH(startTime) asc")
    public List<Long> getMonthList(@Param("startTime")String time);

    /**
     * 查询本年月份水费数据
     * @param time
     * @return
     */
    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
    @Select("select  SUM(waterCost) from paymentinfo WHERE startTime LIKE CONCAT(#{startTime},'%') GROUP BY MONTH(startTime) order by MONTH(startTime) asc")
    public List<Float> getMonthWaterCostList(@Param("startTime")String time);



    /**
     * 查询本年月份电费数据
     * @param time
     * @return
     */
    @Select("select SUM(electricityCost) from paymentinfo WHERE startTime LIKE CONCAT(#{startTime},'%') GROUP BY MONTH(startTime) order by MONTH(startTime) asc")
    public List<Float> getMonthElectricityCostList(@Param("startTime")String time);



    /**
     * 查询本年季度
     * @param time
     * @return
     */
    @Select("SELECT DISTINCT QUARTER(startTime) FROM paymentinfo WHERE startTime LIKE CONCAT(#{startTime},'%') order by QUARTER(startTime) asc")
    public List<Long> getQuarterList(@Param("startTime")String time);


    /**
     * 查询本年季度水费数据
     * @param time
     * @return
     */
    @Select("select SUM(waterCost) from paymentinfo where YEAR(startTime) LIKE CONCAT(#{startTime},'%') GROUP BY QUARTER(startTime) order by QUARTER(startTime) asc")
    public List<Float> getQuarterWaterCostList(@Param("startTime")String time);


    /**
     * 查询本年季度电费数据
     * @param time
     * @return
     */
    @Select("select SUM(electricityCost) from paymentinfo where YEAR(startTime) LIKE CONCAT(#{startTime},'%') GROUP BY QUARTER(startTime) order by QUARTER(startTime) asc")
    public List<Float> getQuarterElectricityCostList(@Param("startTime")String time);



    /**
     * 更新paymentInfo类
     * @param paymentInfo paymentInfo对象
     * @return
     */
    @Update("UPDATE paymentinfo SET " +
            "waterNumber = #{waterNumber}, electricityNumber = #{electricityNumber},owner = #{owner},buildingName = #{buildingName},roomNumber = #{roomNumber}," +
            "startTime = #{startTime},endTime = #{endTime},waterCost = #{waterCost},electricityCost = #{electricityCost}," +
            "waterNumberPrevious = #{waterNumberPrevious},waterDifference = #{waterDifference}," +
            "electricityNumberPrevious = #{electricityNumberPrevious},electricityDifference = #{electricityDifference},total = #{total}" +
            "WHERE id = #{id}")
    public int updataPaymentInfo(PaymentInfo paymentInfo);



    /**
     * 查id
     * @param paymentInfo paymentInfo对象
     * @return
     */
    @Select("select id from paymentinfo WHERE buildingName = #{buildingName} and roomNumber = #{roomNumber}" )
    public int selectPaymentInfoId(PaymentInfo paymentInfo);


    /**
     * 得到水电表数据
     * @param id
     * @return
     */
    @Select("select waterNumber,electricityNumber from paymentinfo WHERE id = #{id}" )
    public PaymentInfo selectPaymentInfo(@Param("id") int id);


    /**
     * 插入查询是否有重复
     * @param paymentInfo paymentInfo对象
     * @return
     */
    @Select("select 1 from paymentinfo WHERE buildingName = #{buildingName} and roomNumber = #{roomNumber} limit 1")
    public String repeatData(PaymentInfo paymentInfo);

    /**
     * 查询所有楼栋
     * @return
     */
    @Select("select DISTINCT buildingName from roominfo")
    public List<String> getBuildingList();


    /**
     * 查询所属楼栋的未使用的房号
     * @param buildingName
     * @return
     */
    @Select("select DISTINCT roomNumber from roominfo where buildingName = #{buildingName} and owner != '空闲'")
    public List<Long> getBuildingRoomList(@Param("buildingName")String buildingName);


    /**
     * 查询水电表已存在的房号
     * @param buildingName
     * @param startTime
     * @return
     */
    @Select("select roomNumber from paymentinfo where buildingName = #{buildingName} and startTime = MONTH(#{startTime})")
    public List<Long> getPaymentinfoRoomList(@Param("buildingName")String buildingName,@Param("startTime")String startTime);


    /**
     * 查询企业
     * @param buildingName
     * @param roomNumber
     * @return
     */
    @Select("select owner from roominfo where buildingName = #{buildingName} and roomNumber= #{roomNumber}")
    public String getEnterpriseNumber(@Param("buildingName")String buildingName,@Param("roomNumber")String roomNumber);


}
