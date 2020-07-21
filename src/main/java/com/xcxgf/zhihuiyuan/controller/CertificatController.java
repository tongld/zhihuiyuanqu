package com.xcxgf.zhihuiyuan.controller;

import com.xcxgf.zhihuiyuan.POJO.Certification;
import com.xcxgf.zhihuiyuan.services.CertificatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
public class CertificatController {
    @Autowired
    CertificatService certificatService;

    /**
     * 企业认证数据提交
     * @param file 图片文件
     * @param companyName 公司名
     * @param proposer 申请人
     * @param telPhone 电话
     * @return
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.POST,value="/pushAduit")
    public String pushAduit(@RequestParam("file") MultipartFile file,@RequestParam String companyName,@RequestParam String proposer,@RequestParam("telPhone") String telPhone) throws IOException {


        String MSG=certificatService.pushAduit(file,companyName,proposer,telPhone);

        return MSG;

    }

    /**
     * 企业上传的图片展示
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET,value="**/upload/**")
    public static void getPhoto(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String path="/usr/src/java/file"+request.getRequestURI();
            File file = new File(path);
            FileInputStream fis;
            fis = new FileInputStream(file);

            response.setContentType("image/png");
            OutputStream out = response.getOutputStream();
            int len = 0;
            byte[] byt = new byte[1024];
            while ((len = fis.read(byt)) != -1) {
                out.write(byt, 0, len);
            }
            out.flush();
            out.close();
            fis.close();
    }

    /**
     * 获取待审核或已审核的申请信息
     * @param status
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getCertificatByStatus")
    public List<Certification> getCertificatByStatus(@RequestParam Boolean status,@RequestParam int startPage,@RequestParam int pageSize){
        
        List<Certification> certifications=certificatService.getCertificatByStatus(status,startPage,pageSize);
        return certifications;
    }

    /**
     * 获取详细信息(未测试)
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getStatusDetail")
    public Certification getDetail(@RequestParam int id){
        Certification certification=certificatService.getDetail(id);
        return certification;
    }

    /**
     * 获取企业认证全部信息(未测试)
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getAllCertificat")
    public List<Certification> getAllCertificat(){
        List<Certification> certification=certificatService.getAllCertificat();
        return certification;
    }

    /**
     * 审核是否通过(未测试)
     * @param approval
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/toApprove")
    public int toApprove(@RequestParam Boolean approval,@RequestParam int id){
        int i=certificatService.toApprove(approval,id);
        return i;
    }

    /**
     * 更新该企业认证不通过
     * @param remark
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/refused")
    public int toRefused(@RequestParam String remark,@RequestParam int id){

        int i=certificatService.toRefused(remark,id);
        return i;
    }

    /**
     * 查询当前状态下的企业认证信息总条数
     * @param status
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/getCertificatCount")
    public int getCertificatCount(@RequestParam Boolean status){
        return certificatService.getCertificatCount(status);
    }

}
