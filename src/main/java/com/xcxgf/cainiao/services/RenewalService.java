package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Renewal;
import com.xcxgf.cainiao.POJO.Room;
import com.xcxgf.cainiao.mapper.AccountMapper;
import com.xcxgf.cainiao.mapper.RenewalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Service
public class RenewalService {
    @Autowired
    RenewalMapper renewalMapper;

    @Autowired
    AccountMapper accountMapper;
    public List<Renewal> getRenewalList(HttpServletRequest request){
        String contractId=request.getParameter("nid");
        return renewalMapper.getRenewalList(contractId);}


    public int getCount(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("nid"));

        return renewalMapper.getCount(id);
    }

    public int insertRenewals(Renewal renewal) throws ParseException {

        funhelper funh=new funhelper();
        int addNum=renewal.getContinuePeriod();
        String contractId=renewal.getContractId();
        String endRentTime=funh.addMounth(renewal.getContinueStartTime(),
                renewal.getContinuePeriod());
        renewal.setContinueEndTime(endRentTime);
        float totalCost=renewal.getTotalCost();
        accountMapper.updateleasePeriod(addNum,totalCost,endRentTime,contractId);
        return renewalMapper.insertRenewals(renewal);
    }

    public int insertRenewals2(Renewal renewal) {

        String owner=renewal.getOwner();
        String contractId=renewal.getContractId();
        accountMapper.updateOwner(owner,contractId);

        return renewalMapper.insertRenewals(renewal);
    }


    public int updateRoom(Room room){
        return renewalMapper.updateRoom(room);
    }
}
