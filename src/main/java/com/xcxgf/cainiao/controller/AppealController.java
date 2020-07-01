package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Appeal;
import com.xcxgf.cainiao.POJO.ReturnData;
import com.xcxgf.cainiao.services.AppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("Appeal")
public class AppealController {
    @Autowired
    AppealService appealService;
    /**
     *查询表格数据
     * @param request request中包含3个参数，dataStart（返回数据的起始位置），dataEnd（返回数据的终止位置）
     * @return
     */
    @GetMapping("/getAppealInfo")
    public ReturnData getAppealInfo(HttpServletRequest request) {
        // 从request中获取各参数
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        // 拼接查询字符串，limit字符串
        String limit = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;

        return appealService.getAppealInfo(limit);
    }

    /**
     * 删除
     * @param appeal
     * @return
     */
    @PostMapping("/delete")
    public int delete(@RequestBody Appeal appeal){
        return appealService.delete(appeal);
    }

    /**
     * 确定操作
     * @param appeal
     * @return
     */
    @PostMapping("/determine")
    public int determine(@RequestBody Appeal appeal){
        return appealService.determine(appeal);
    }

    /**
     * 添加
     * @param appeal
     * @return
     */
    @PostMapping("/add")
    public int add(@RequestBody Appeal appeal){
        return appealService.add(appeal);
    }
}
