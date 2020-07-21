package com.xcxgf.zhihuiyuan.services;

import com.xcxgf.zhihuiyuan.POJO.Building;
import com.xcxgf.zhihuiyuan.POJO.DataReturn;
import com.xcxgf.zhihuiyuan.POJO.Room;
import com.xcxgf.zhihuiyuan.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 办公室管理，后端与数据库的逻辑处理层
 * @author zyz
 */
@Service
public class RoomService {
    @Autowired
    private RoomMapper rm;

    /**
     * 查询满足指定查询条件的记录
     * @param search 查询内容
     * @param start 记录返回起始位置
     * @param count 记录返回条数
     * @param dataType 记录类型，主要区分房间类型
     * @return
     */
    public DataReturn getSearchList(String search, String start, String count, String dataType) {
        // 拼接查询字符串，limit字符串
        String searchStr = "".equals(search) ? "" : "and (buildingName = '" + search + "' or owner = '" + search + "')";
        String limitStr = "0".equals(start) && "0".equals(count) ? "" : "limit " + start + "," + count;

        DataReturn dataReturn = new DataReturn();
        dataReturn.setRoomList(rm.getSearchList(searchStr, limitStr, dataType));
        dataReturn.setDataCount(rm.getSearchCount(searchStr, dataType));
        return dataReturn;
    }

    /**
     * 删除记录
     *
     * @param room 需要被删除的记录对象
     * @return int类型，0为删除失败，1为删除成功
     */
    public int deleteRoomList(Room room) {
        int reqCode = 0;
        if (rm.deleteRoomInfo(room) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 插入记录
     *
     * @param room 需要被插入的记录对象
     * @return int类型，0为插入失败，1为插入成功
     */
    public int insertRoomList(Room room) {
        int reqCode = 0;
        if (rm.insertSearchSame(room) != 0) {
            reqCode = -1;
        } else if (rm.insertRoomInfo(room) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 更新记录
     *
     * @param room 需要被更新的记录对象
     * @return int类型，0为更新失败，-1为已存在重复数据，1为更新成功
     */
    public int updateRoomList(Room room) {
        int reqCode = 0;
        if (room.getTempRoomNumber().equals(room.getRoomNumber())){
            if (rm.updateSearchSame(room) != 1) {
                reqCode = -1;
            }else if (rm.updateRoomInfo(room) > 0) {
                reqCode = 1;
            }
        }else{
            if (rm.updateSearchSame(room) != 0) {
                reqCode = -1;
            }else if (rm.updateRoomInfo(room) > 0) {
                reqCode = 1;
            }
        }


        return reqCode;
    }

    /**
     * 批量插入记录
     *
     * @param roomList 需要被插入的记录对象集合
     * @return int类型，插入操作的状态，-1为表内无数据，-2为全部重复，0为插入失败，否则返回成功条数
     */
    public int uploadRoomList(List<Room> roomList) {
        int reqCode = 0;
        int sameCount = 0;
        String dataType = null;
        // 先判空
        if (roomList.size() != 0) {
            // 判断是否有该楼栋，再判断是否重复，最后执行插入记录操作
            for (Room room : roomList) {
                // 存在该楼栋
                dataType = rm.getBuildingType(room);
                if (rm.insertSearchBuildingName(room, dataType) != 0) {
                    if (rm.insertSearchSame(room) != 0) {
                        sameCount += 1;
                    } else if (rm.insertRoomInfo(room) > 0) {
                        reqCode += 1;
                    }
                }
            }
            // 当重复条数和数据条数一致时
            if (sameCount == roomList.size()) {
                reqCode = -2;
            }
        } else {
            reqCode = -1;
        }
        return reqCode;
    }

    /**
     * 获取所有楼栋信息
     * @param dataType 楼栋类型
     * @return
     */
    public List<Building> getBuildingList(String dataType) {
        return rm.getBuildingList(dataType);
    }
}
