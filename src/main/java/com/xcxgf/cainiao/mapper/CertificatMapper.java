package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Certification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CertificatMapper {
    /**
     * 查询 全部审核信息
     * @return
     */
    @Select("select * from certification")
    public List<Certification> getAllCertificat();

    /**
     * 根据id获取企业认证详细信息
     * @param id
     * @return
     */
    @Select("select * from certification where id=#{id}")
    public Certification getDetail(int id);

    /**
     * 根据企业认证的状态获取信息
     * @param status
     * @return
     */
    @Select("select *from certification where status=#{status}")
    public List<Certification> getCertificatByStatus(Boolean status);

    /**
     * 新增企业认证申请
     * @param certification
     * @return
     */
    @Insert("insert into certification(companyName,proposer,telPhone,imgPath,applyTime) " +
            "values(#{companyName},#{proposer},#{telPhone},#{imgPath},#{applyTime})")
    public int toCertificat(Certification certification);

    /**
     * 审核当前的企业认证是否通过
     * @param approval
     * @param id
     * @return
     */
    @Update("update certification set approval=#{approval},status=true where id=#{id}")
    public int toApprove(Boolean approval,int id);


    @Update("update certification set approval=false,remark=#{remark},status=true where id=#{id}")
    public int toRefused(String remark,int id);

}
