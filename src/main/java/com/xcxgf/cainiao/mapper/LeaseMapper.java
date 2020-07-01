package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 对数据库中leaseinfo表（租赁信息管理表）的增删改查操作
 * @author zyz
 */
public interface LeaseMapper {
    /**
     * 查询满足条件的可用记录
     *
     * @param search 查询条件
     * @param limit  需要返回的记录的起始位置和返回的
     * @return Lease类型的集合，满足查询条件的可用记录
     */
    @Select("select * " +
            "from leaseContractInfo " +
            "${search} " +
            "ORDER BY endRentTime,insertTime desc,buildingName+0,roomNumber " +
            "${limit}")
    public List<LeaseContract> getSearchList(String search, String limit);


    @Select("select count(*) from sousoucontractinfo where companyName like CONCAT('%',#{name},'%') and isDelete=#{isDelete}")
    public int getContractCount(String name,Boolean isDelete);

    @Select("select * from sousoucontractinfo where companyName like CONCAT('%',#{name},'%') and isDelete=#{isDelete} order by htEndTime limit #{startPage},#{pageSize}")
    public List<LeaseContract> getContractList(int startPage, int pageSize, String name,Boolean isDelete);


    /**
     * 查询满足查询条件的可用记录的记录条数
     *
     * @param search 查询条件
     * @return int类型，满足查询条件的可用记录的条数
     */
    @Select("SELECT count(*) " +
            "FROM leaseContractInfo " +
            "${search}")
    public int getSearchCount(String search);

    /**
     * 删除合同记录
     *
     * @param leaseContract 需要被删除的记录对象
     * @return int类型，删除操作影响的记录条数，0为删除失败，否则删除成功
     */
    @Update("update leaseContractInfo set isDelete=true,refund=#{refund}" +
            "WHERE id=#{id}")
    public int deleteLeaseInfo(LeaseContract leaseContract);

    /**
     * 更新记录（更新房间的业主为空闲）
     *
     * @param leaseContract 需要更新的记录对象
     * @return int类型，更新操作影响的记录条数，为0时更新失败，否则更新成功
     */
    @Update("UPDATE roominfo SET owner='空闲' " +
            "WHERE roomNumber=#{roomNumber} " +
            "and buildingName=#{buildingName}")
    public int deleteRoomInfoOwner(LeaseContract leaseContract);

    /**
     * 插入合同记录
     *
     * @param leaseContract 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */

    @Insert("INSERT INTO leaseContractInfo(owner,roomNumber,buildingName,depositOnContracts,rentPeriod,startRentTime,endRentTime,firstYear_unitPrice,firstYear_managePrice,firstYear_energyPrice,secondYear_unitPrice,secondYear_managePrice,secondYear_energyPrice,firstYear_rentCost,secondYear_rentCost,totalRentCost,insertTime,noPayPeriod,lastPayTime) " +
            "VALUES(#{owner},#{roomNumber},#{buildingName},#{depositOnContracts},#{rentPeriod},#{startRentTime},#{endRentTime},#{firstYear_unitPrice},#{firstYear_managePrice},#{firstYear_energyPrice},#{secondYear_unitPrice},#{secondYear_managePrice},#{secondYear_energyPrice},#{firstYear_rentCost},#{secondYear_rentCost},#{totalRentCost},#{insertTime},#{rentPeriod},#{insertTime})")
    public int insertLeaseContractInfo(LeaseContract leaseContract);

    /**
     * 更新记录（根据租赁合同信息更新房间的业主）
     *
     * @param leaseContract 需要更新的记录对象
     * @return int类型，更新操作影响的记录条数，为0时更新失败，否则更新成功
     */
    @Update("UPDATE roominfo SET owner=#{owner} " +
            "WHERE roomNumber=#{roomNumber} " +
            "and buildingName=#{buildingName}")
    public int updateRoomInfoOwner(LeaseContract leaseContract);


    /**
     * 查询是否业主仍有合同未结束（执行插入记录操作时）
     *
     * @param leaseContract 需要查询是否存在的记录对象
     * @return int类型，满足查询条件的记录条数，为0时不存在重复记录，否则存在重复记录
     */
    @Select("select count(*) " +
            "from leaseContractInfo " +
            "where owner=#{owner}")
    public int insertSearchSame(LeaseContract leaseContract);

    /**
     * 查询所有有空闲房间的楼栋
     *
     * @return
     */
    @Select("SELECT * " +
            "FROM buildinginfo " +
            "where buildingName IN (SELECT buildingName FROM roominfo where owner = '空闲' and buildingName in (SELECT buildingName from buildinginfo WHERE buildingType != '宿舍'))")
    public List<Building> getBuildingList();

    /**
     * 查找所有办公房间租赁状态为空闲的记录
     *
     * @return Room类型的集合，所有房间租赁状态为空闲的记录
     */
    @Select("select * " +
            "from roominfo " +
            "where owner = '空闲' " +
            "and buildingName in (select buildingName from buildinginfo where buildingType!='宿舍') " +
            "ORDER BY buildingName+0,roomNumber")
    public List<Room> getEmptyRoomList();

    /**
     * 查询管理单价
     *
     * @return Setting类型的集合，所有可用的记录
     */
    @Select("select leaseUnitPrice " +
            "from systeminfo")
    public String getSettingList();

    /**
     * 查询能耗公摊单价
     *
     * @return Setting类型的集合，所有可用的记录
     */
    @Select("select energySharingPrice " +
            "from systeminfo")
    public String getEnergyPrice();

    /**
     * 查询所有在合同当中的楼栋信息
     *
     * @return
     */
    @Select("select * from buildinginfo where buildingName in (select buildingName from leaseContractInfo)")
    public List<Building> getPayBuildingList();

    /**
     * 查询所有合同信息，作为房间级联
     *
     * @return
     */
    @Select("select * " +
            "from roominfo " +
            "where (buildingName,roomNumber) in (select buildingName,roomNumber from leaseContractInfo where noPayPeriod>0);")
    public List<Room> getPayRoomList();

    /**
     * 插入缴费记录数据
     *
     * @param leaseCost
     * @return
     */
    @Insert("insert into leaseCostInfo(buildingName,roomNumber,owner,unitPrice,period,rentCost,propertyFee,energySharing,totalCost,insertTime,startPayTime,endPayTime,firstYear_rentCost,secondYear_rentCost) " +
            "values(#{buildingName},#{roomNumber},#{owner},#{unitPrice},#{period},#{rentCost},#{propertyFee},#{energySharing},#{totalCost},#{insertTime},#{startPayTime},#{endPayTime},#{firstYear_rentCost},#{secondYear_rentCost})")

    public int insertLeaseCostInfo(LeaseCost leaseCost);

    /**
     * 查询是否已有以往的缴费记录存在
     *
     * @param leaseCost
     * @return
     */
    @Select("select count(*) " +
            "from leaseCostInfo " +
            "where buildingName=#{buildingName} " +
            "and roomNumber=#{roomNumber}")
    public int searchLeaseCostSame(LeaseCost leaseCost);

    /**
     * 更新合同的首租租金总计
     *
     * @param leaseCost
     * @return
     */
    @Update("update leaseContractInfo " +
            "set firstRent=#{totalCost}," +
            "updateTime=#{insertTime} " +
            "WHERE roomNumber=#{roomNumber} " +
            "and buildingName=#{buildingName}")
    public int updateRentPriceFirst(LeaseCost leaseCost);

    /**
     * 更新合同中的【未缴费租期】
     *
     * @param leaseCost
     * @return
     */
    @Update("update leaseContractInfo " +
            "set noPayPeriod=noPayPeriod-#{period}," +
            "updateTime=#{insertTime} " +
            "where buildingName=#{buildingName} " +
            "and roomNumber=#{roomNumber}")
    public int updateNoPayPeriod(LeaseCost leaseCost);

    /**
     * 更新合同中的【上一次缴费终止租期】
     *
     * @param leaseCost
     * @return
     */
    @Update("update leaseContractInfo " +
            "set lastPayTime=#{endPayTime}," +
            "updateTime=#{insertTime} " +
            "where buildingName=#{buildingName} " +
            "and roomNumber=#{roomNumber}")
    public int updateLastPayTime(LeaseCost leaseCost);

    /**
     * 查询是否缴费租期是正确，小于等于未缴费租期
     *
     * @param leaseCost
     * @return
     */
    @Select("select count(*) " +
            "from leaseContractInfo " +
            "where buildingName=#{buildingName} " +
            "and roomNumber=#{roomNumber} " +
            "and noPayPeriod>=#{period}")
    public int searchTimeRight(LeaseCost leaseCost);

    /**
     * 级联删除某合同的所有缴费记录
     *
     * @param leaseContract
     * @return
     */
    @Delete("delete " +
            "from leaseCostInfo " +
            "where buildingName=#{buildingName} " +
            "and roomNumber=#{roomNumber}")
    public int deleteAllPay(LeaseContract leaseContract);

    /**
     * 合同变更时，查询企业是否登记
     *
     * @param leaseContract
     * @return
     */
    @Select("select count(*) " +
            "from enterpriseinfo " +
            "where enterpriseName=#{owner}")
    public int searchEnterpriseRight(LeaseContract leaseContract);

    /**
     * 合同变更时，更新合同的所属人，以及修改时间
     *
     * @param leaseContract
     * @return
     */
    @Update("update leaseContractInfo " +
            "set owner=#{owner},updateTime=#{updateTime} " +
            "where buildingName=#{buildingName} " +
            "and roomNumber=#{roomNumber}")
    public int updateContractOwner(LeaseContract leaseContract);

    /**
     * 合同变更时，更新所有该合同名下的缴费记录，将变更业主为null的记录都更新该字段
     *
     * @param leaseContract
     * @return
     */
    @Update("update leaseCostInfo " +
            "set isChangeOwner=#{owner},updateTime=#{updateTime} " +
            "where buildingName=#{buildingName} " +
            "and roomNumber=#{roomNumber} " +
            "and isChangeOwner is null")
    public int updateLeaseCostInfo(LeaseContract leaseContract);

    /**
     * 查询某合同的所有缴费记录
     *
     * @param leaseContract
     * @return
     */
    @Select("select * " +
            "from leaseCostInfo " +
            "where buildingName=#{buildingName} " +
            "and roomNumber=#{roomNumber} and owner=#{owner}")
    public List<LeaseCost> getLeaseCostList(LeaseContract leaseContract);

    /**
     * 删除最后一条租赁合同记录时，修改企业的登记状态为【已注册】
     * @param leaseContract
     * @return
     */
    @Update("update enterpriseinfo " +
            "set state='已注册' " +
            "where enterpriseName=#{owner}")
    public int updateEnterpriseStateWhenDelete(LeaseContract leaseContract);

    /**
     * 新增第一条租赁合同记录时，修改企业的登记状态为【已入驻】
     * @param leaseContract
     * @return
     */
    @Update("update enterpriseinfo " +
            "set state='已入驻' " +
            "where enterpriseName=#{owner}")
    public int updateEnterpriseStateWhenInsert(LeaseContract leaseContract);

    /**
     * 查询是否该企业是未入驻状态
     * @param leaseContract
     * @return
     */
    @Select("select count(*) " +
            "from enterpriseinfo " +
            "where enterpriseName=#{owner} " +
            "and state!='已入驻'")
    public int isInsertFirstSearch(LeaseContract leaseContract);

    /**
     * 获取租金单价
     * @param leaseCost
     * @return
     */
    @Select("select unitPrice " +
            "from leaseContractInfo " +
            "where buildingName=#{buildingName} " +
            "and roomNumber=#{roomNumber}")
    public String getPayUnitPrice(LeaseCost leaseCost);

    /**
     * 合同变更时，原合同所属人已无合同时，修改登记状态
     * @param leaseContract
     * @return
     */
    @Update("update enterpriseinfo " +
            "set state = '已注册' " +
            "where enterpriseName = (select owner from leaseContractInfo where buildingName=#{buildingName} and roomNumber=#{roomNumber})")
    public int updateOldState(LeaseContract leaseContract);

    /**
     * 合同退租时，查询是否有未缴清费用
     * @param leaseContract
     * @return
     */
    @Select("select noPayPeriod " +
            "from leaseContractInfo " +
            "where buildingName=#{buildingName} " +
            "and roomNumber=#{roomNumber} and isDelete=false")
    public int hasLeaseCost(LeaseContract leaseContract);

    /**
     * 合同变更时，查询所属原企业是否已无合同
     * @param leaseContract
     * @return
     */
    @Select("select count(*) " +
            "from leaseContractInfo " +
            "where owner = (select owner from leaseContractInfo where buildingName=#{buildingName} and roomNumber=#{roomNumber})")
    public int hasLeaseContract(LeaseContract leaseContract);

    /**
     * 合同详情里，查找合同联系人的信息
     * @param leaseContract
     * @return
     */
    @Select("select * from enterpriseinfo where enterpriseName=#{owner}")
    public Enterprise getOwnerInfo(LeaseContract leaseContract);




}
