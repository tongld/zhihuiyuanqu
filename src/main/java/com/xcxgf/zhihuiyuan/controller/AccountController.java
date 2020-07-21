package com.xcxgf.zhihuiyuan.controller;

import com.xcxgf.zhihuiyuan.POJO.*;
import com.xcxgf.zhihuiyuan.services.AccountService;
import com.xcxgf.zhihuiyuan.services.GetFormatDate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("Account")
public class AccountController {
    @Autowired
    AccountService accountService;

    /**
     * 合同信息查询
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value="/getOwnerList")
    public List<Enterprise> getOwnerList(HttpServletRequest request){
        return accountService.getOwnerList(request);
    }

    /**
     * 获取合同总信息
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping(method = RequestMethod.GET,value="/getAccountList")
    public List<Account> getAccountList(HttpServletRequest request) throws ParseException
    {return accountService.getAccountList(request);}

    @RequestMapping(method = RequestMethod.GET,value="/getAccountList0")
    public List<Account> getAccountList0() {return accountService.getAccountList0();}

    /**
     * 获取合同总条数
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getAccountCount")
    public int getAccountCount(){return accountService.getAccountCount();}

    /**
     * 获取过期合同总条数
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getDeleteCount")
    public int getDeleteCount(){return accountService.getDeleteCount();}

    /**
     * 合同更新
     * @param account
     * @return
     * @throws ParseException
     */
    @RequestMapping(method = RequestMethod.POST,value="/updateAccount")
    public int updateAccount(@RequestBody Account account) throws ParseException
    { return accountService.updateAccount(account);}

    /**
     * 新增合同信息
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping(method = RequestMethod.POST,value="/insertAccount")
    public int insertAccount(HttpServletRequest request) throws ParseException {
        int Status=1;
        Account account=new Account();
        Room room=new Room();
        Renewal renewal=new Renewal();
        GetFormatDate getFormatDate=new GetFormatDate();
        try {
            InputStream is = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String line = null;
            StringBuffer content = new StringBuffer();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
            String reqStr = content.toString().trim();
            //json解析处理

            JSONObject jsonObject = new JSONObject(reqStr);
            JSONArray jsonArray = jsonObject.getJSONArray("selectdatas");
            account.setOwner(jsonObject.getString("companyName"));
            renewal.setOwner(jsonObject.getString("companyName"));

            account.setBuildingName(jsonObject.getString("buildingName"));

            account.setStartRentTime(jsonObject.getString("startDate"));
            renewal.setContinueStartTime(jsonObject.getString("startDate"));

            account.setRentPeriod(jsonObject.getInt("leasePeriod"));
            renewal.setContinuePeriod(jsonObject.getInt("leasePeriod"));

            account.setTotalCost((float) jsonObject.getDouble("remark"));
            renewal.setTotalCost((float) jsonObject.getDouble("remark"));


            account.setInsertTime(jsonObject.getString("insertTime"));
            renewal.setInsertTime(jsonObject.getString("insertTime"));


            room.setOwner(jsonObject.getString("companyName"));
            room.setBuildingName(jsonObject.getString("buildingName"));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String  roomNumber = jsonObject1.getString("roomNumber");
                String contractId=getFormatDate.getNowDate()+roomNumber;
                account.setContractId(contractId);
                renewal.setContractId(contractId);

                account.setRoomNumber(roomNumber);
                room.setRoomNumber(roomNumber);
                int t= accountService.updateRoom(room);
                int a=accountService.insertAccount(account);
                int c=accountService.insertRenewals(renewal);

                if(a!=1||t!=1||c!=1){
                    Status=0;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status;
    }

    /**
     * 合同删除
     * @param account
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value="/deleteAccount")
    public int deleteAccount(@RequestBody Account account){
        return accountService.deleteAccount(account);}

    /**
     * 上传（暂时不用）
     * @param excelDataList
     * @return
     * @throws ParseException
     */
    @RequestMapping(method = RequestMethod.POST,value="/uploadAccount")
    public int uploadAccount(@RequestBody List<ExcelData> excelDataList) throws ParseException {

        return accountService.uploadAccount(excelDataList);
    }


    /**
     * 获取全部符合搜索条件的合同
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value="/getNameList")
    public List<Account> getAccountNameList(HttpServletRequest request){
        return accountService.getAccountNameList(request);
    }

    /**
     * 获取全部符合搜索条件的合同的总条数
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value="/getNameCount")
    public int getAccountNameCount(HttpServletRequest request){
        return accountService.getAccountNameCount(request);
    }

    /**
     * 获取寝室楼栋
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getBuildingList")
    public List<Building> getBuildingList(){
        return accountService.getBuildingList();
    }

    /**
     * 获取房间
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getRoomList")
    public List<Room> getRoomList(HttpServletRequest request){
        return accountService.getRoomList(request);
    }

    /**
     * 获取选择的楼栋的空闲房间的数量
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getRoomListCount")
    public int getRoomListCount(HttpServletRequest request){

        return accountService.getRoomListCount(request);
    }

    /**
     * 获取该合同中的具体租赁房间条数
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getRoomListCount2")
    public int getRoomListCount2(HttpServletRequest request){
        return accountService.getRoomListCount2(request);
    }

    /**
     * 获取该合同中的具体租赁房间
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getRoomList2")
    public List<Room> getRoomList2(HttpServletRequest request){
        return accountService.getRoomList2(request);
    }

    /**
     * 获取公司名
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getCompanyName")
    public int getCompanyName(HttpServletRequest request){
        return accountService.getCompanyName(request);
    }

    /**
     * 获取房间类型
     * @param account
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getRoomType")
    public String getRoomType(@RequestBody Account account){
        return accountService.getRoomType(account);
    }

    /**
     * 根据公司名查询全部符合条件的公司名称
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/getAllCompany")
    public List<Enterprise> getAllCompany(HttpServletRequest request){
        return accountService.getAllCompany(request);
    }
}
