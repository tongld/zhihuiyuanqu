package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Certification;
import com.xcxgf.cainiao.mapper.CertificatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CertificatService {
    @Autowired
    CertificatMapper certificatMapper;

    /**
     * 图片上传，保存相对路径到数据库
     * @param file 图片文件
     * @param companyName 公司名
     * @param proposer 申请人
     * @param telPhone 联系电话
     * @return
     * @throws IOException
     */
    public String pushAduit(MultipartFile file,String companyName,String proposer,String telPhone) throws IOException {
        Certification certification=new Certification();
        certification.setCompanyName(companyName);
        certification.setProposer(proposer);
        certification.setTelPhone(telPhone);
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm");
        String filedatename=sdf.format(date);
        String fileName=file.getOriginalFilename();
        String fileNameLast=fileName.substring(fileName.lastIndexOf("."));
        System.out.println(fileNameLast);
        if(!(fileNameLast.equals(".jpg")||fileNameLast.equals(".jpeg")||fileNameLast.equals(".png"))){
            return "文件格式错误";
        }
        String path="/usr/src/java/file/zhihuiyuanqu/upload/"+filedatename+"/"+fileName;
        String path1 ="zhihuiyuanqu/upload/"+filedatename+"/"+fileName;
//        System.out.println(path);
//        System.out.println(path1);
        File file1=new File(path);
        if(!file1.getParentFile().exists()){
            file1.mkdirs();
        }
        file.transferTo(file1);
        certification.setImgPath(path1);
        certification.setApplyTime(filedatename);
        certificatMapper.toCertificat(certification);
        return path1;
    }

    /**
     * 获取待审核或已审核的申请信息(未测试)
     * @param status 待审核的信息类型
     * @return
     */
    public List<Certification> getCertificatByStatus(Boolean status,int startPage,int pageSize){
        int start=(startPage-1)*pageSize;
        List<Certification> certifications =certificatMapper.getCertificatByStatus(status,start,pageSize);
        return certifications;
    }
    /**
     * 根据当前的id获取详细信息(未测试)
     * @param id
     * @return
     */
    public Certification getDetail(int id){
        Certification certification=certificatMapper.getDetail(id);
        return certification;
    }

    /**
     * 获取全部的企业认证信息(未测试)
     * @return
     */
    public List<Certification> getAllCertificat(){
        List<Certification> certification=certificatMapper.getAllCertificat();
        return  certification;
    }

    /**
     * 审核是否通过(未测试)
     * @param approval
     * @param id
     * @return
     */
    public int toApprove(Boolean approval,int id){
        int i=certificatMapper.toApprove(approval,id);
        return i;
    }


    public int toRefused(String remark,int id){

        int i=certificatMapper.toRefused(remark,id);

        return i;
    }
}
