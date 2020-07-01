package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.POJO.Enterprise;
import com.xcxgf.cainiao.mapper.EnterpriseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 园区企业管理，后端与数据库的逻辑处理层
 * @author zyz
 */
@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseMapper em;

    /**
     * 查询指定条件的记录数据
     *
     * @param search 查询条件的内容
     * @param start  记录起始位置
     * @param count  查询返回的记录数量
     * @return
     */
    public DataReturn getSearchList(String search, String start, String count) {
        // 拼接查询字符串，limit字符串
        String searchStr = "".equals(search) ? "" : "where (enterpriseName like '%" + search + "%' or enterprisePerson like '%" + search + "%' or state = '"+search+"')";
        String limitStr = "0".equals(start) && "0".equals(count) ? "" : "limit " + start + "," + count;

        DataReturn dataReturn = new DataReturn();
        dataReturn.setEnterpriseList(em.getSearchList(searchStr, limitStr));
        dataReturn.setDataCount(em.getSearchCount(searchStr));
        return dataReturn;
    }


    /**
     * 删除记录
     *
     * @param enterprise 需要被删除的记录对象
     * @return int类型，0为删除失败，1为删除成功
     */
    public int deleteEnterpriseList(Enterprise enterprise) {
        int reqCode = 0;
        if (em.deleteEnterpriseInfo(enterprise) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 更新记录
     *
     * @param enterprise 需要被更新的记录对象
     * @return int类型，0为更新失败，1为更新成功，-1为存在重复数据
     */
    public int updateEnterpriseList(Enterprise enterprise) {
        int reqCode = 0;
        if (em.updateSearchSame(enterprise) != 0) {
            reqCode = -1;
        } else if (em.updateEnterpriseInfo(enterprise) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 插入记录
     *
     * @param enterprise 需要插入的记录对象
     * @return int类型，0为更新失败，1为更新成功，-1为存在重复数据
     */
    public int insertEnterpriseList(Enterprise enterprise) {
        int reqCode = 0;
        if (em.insertSearchSame(enterprise) != 0) {
            reqCode = -1;
        } else if (em.insertEnterpriseInfo(enterprise) > 0) {
            reqCode = 1;
        }
        return reqCode;

    }

    /**
     * 批量插入记录
     *
     * @param enterpriseList 需要被插入的记录对象集合
     * @return int类型，插入操作的状态，-1为表内无数据，-2为全部重复，0为插入失败，否则返回成功条数
     */
    public int uploadEnterpriseList(List<Enterprise> enterpriseList) {
        int reqCode = 0;
        int sameCount = 0;
        // 先判空
        if (enterpriseList.size() != 0) {
            // 判断是否重复，再执行插入记录操作
            for (Enterprise enterprise : enterpriseList) {
                if (em.insertSearchSame(enterprise) != 0) {
                    sameCount += 1;
                } else if (em.insertEnterpriseInfo(enterprise) > 0) {
                    reqCode += 1;
                }
            }
            if (sameCount == enterpriseList.size()) {
                reqCode = -2;
            }
        } else {
            reqCode = -1;
        }
        return reqCode;
    }
}
