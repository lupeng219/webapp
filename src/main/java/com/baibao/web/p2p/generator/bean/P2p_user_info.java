package com.baibao.web.p2p.generator.bean;

import java.util.Date;

/**
 * 用户详细信息
 * 
 * @author Denny
 * @date 2016年6月21日
 */
public class P2p_user_info implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
    private String puiCustno;      		 //用户编号
    private String puiPlatGrade;   		 //用户信用等级
    private String puiPlatScore;   		 //用户积分
    private Date puiMobilebindtime;		 //手机绑定时间
    private Date puiEmailbindtime; 		 //邮箱绑定时间
    private String puiPlataccountiscert; //是否认证 0 认证 1 未认证
    private Date puiRegistrationTime;    //用户注册时间
    private String puiRealName;			 //用户真实姓名
    private String puiCertType;          //证件类型
    private String puiCertNo;            //证件证号
    private String puiAge;				 //用户年龄
    private String puiSex;				 //用户性别
    private String puiBirthday;			 //用户生日
    private String puiEducation;		 //用户教育信息
    private String puiCollege;			 //用户毕业学校
    private String puiMateria;			 //婚姻状况
    private String puiAddress;			 //居住地址
    private String puiNativePlace;		 //用户籍贯
    private String puiWorkCity;			 //工作城市
    private String puiWorkProvinces;     //工作省份
    private String puiWorkAddress;		 //工作地址
    private String puiCompanyType;		 //公司类型
    private String puiCompanyIndustry;   //公司行业
    private String puiCompanySize;		 //公司规模
    private String puiWorkAge;			 //工作年龄
    private String puiWorkPhone;		 //公司电话
    private String puiWorkPosition;      //工作职位
    private String puiMonthSalary;		 //月收入
    private String puiChildren;			 //是否有子女
    private String puiHouse;			 //是否有房子
    private String puiCars;				 //是否有车
    private String puiCarsLoan;			 //是否有车贷
    private String puiHouseLoan;		 //是否有房贷
    private String puiRelativeName;		 //直系亲属名称
    private String puiRelativeRelation;  //直系亲属关系
    private String puiRelativePhone;	 //直系亲属电话
    private String puiContactName;		 //其他联系人名称
    private String puiContactRelation;	 //其他联系人关系
    private String puiContactPhone;		 //其他联系人电话
    private String puiRecommendedCustNo; //推荐人手机号	
    private String puiUserType; //用户类型\n0普通1员工2销售3渠道
    
    
    public String getPuiCustno() {
        return puiCustno;
    }

    public void setPuiCustno(String puiCustno) {
        this.puiCustno = puiCustno == null ? null : puiCustno.trim();
    }

    public String getPuiPlatGrade() {
        return puiPlatGrade;
    }

    public void setPuiPlatGrade(String puiPlatGrade) {
        this.puiPlatGrade = puiPlatGrade == null ? null : puiPlatGrade.trim();
    }

    public String getPuiPlatScore() {
        return puiPlatScore;
    }

    public void setPuiPlatScore(String puiPlatScore) {
        this.puiPlatScore = puiPlatScore == null ? null : puiPlatScore.trim();
    }

    public Date getPuiMobilebindtime() {
        return puiMobilebindtime;
    }

    public void setPuiMobilebindtime(Date puiMobilebindtime) {
        this.puiMobilebindtime = puiMobilebindtime;
    }

    public Date getPuiEmailbindtime() {
        return puiEmailbindtime;
    }

    public void setPuiEmailbindtime(Date puiEmailbindtime) {
        this.puiEmailbindtime = puiEmailbindtime;
    }

    public String getPuiPlataccountiscert() {
        return puiPlataccountiscert;
    }

    public void setPuiPlataccountiscert(String puiPlataccountiscert) {
        this.puiPlataccountiscert = puiPlataccountiscert == null ? null : puiPlataccountiscert.trim();
    }

    public Date getPuiRegistrationTime() {
        return puiRegistrationTime;
    }

    public void setPuiRegistrationTime(Date puiRegistrationTime) {
        this.puiRegistrationTime = puiRegistrationTime;
    }

    public String getPuiRealName() {
        return puiRealName;
    }

    public void setPuiRealName(String puiRealName) {
        this.puiRealName = puiRealName == null ? null : puiRealName.trim();
    }

    public String getPuiCertType() {
        return puiCertType;
    }

    public void setPuiCertType(String puiCertType) {
        this.puiCertType = puiCertType == null ? null : puiCertType.trim();
    }

    public String getPuiCertNo() {
        return puiCertNo;
    }

    public void setPuiCertNo(String puiCertNo) {
        this.puiCertNo = puiCertNo == null ? null : puiCertNo.trim();
    }

    public String getPuiAge() {
        return puiAge;
    }

    public void setPuiAge(String puiAge) {
        this.puiAge = puiAge == null ? null : puiAge.trim();
    }

    public String getPuiSex() {
        return puiSex;
    }

    public void setPuiSex(String puiSex) {
        this.puiSex = puiSex == null ? null : puiSex.trim();
    }

    public String getPuiBirthday() {
        return puiBirthday;
    }

    public void setPuiBirthday(String puiBirthday) {
        this.puiBirthday = puiBirthday == null ? null : puiBirthday.trim();
    }

    public String getPuiEducation() {
        return puiEducation;
    }

    public void setPuiEducation(String puiEducation) {
        this.puiEducation = puiEducation == null ? null : puiEducation.trim();
    }

    public String getPuiCollege() {
        return puiCollege;
    }

    public void setPuiCollege(String puiCollege) {
        this.puiCollege = puiCollege == null ? null : puiCollege.trim();
    }

    public String getPuiMateria() {
        return puiMateria;
    }

    public void setPuiMateria(String puiMateria) {
        this.puiMateria = puiMateria == null ? null : puiMateria.trim();
    }

    public String getPuiAddress() {
        return puiAddress;
    }

    public void setPuiAddress(String puiAddress) {
        this.puiAddress = puiAddress == null ? null : puiAddress.trim();
    }

    public String getPuiNativePlace() {
        return puiNativePlace;
    }

    public void setPuiNativePlace(String puiNativePlace) {
        this.puiNativePlace = puiNativePlace == null ? null : puiNativePlace.trim();
    }

    public String getPuiWorkCity() {
        return puiWorkCity;
    }

    public void setPuiWorkCity(String puiWorkCity) {
        this.puiWorkCity = puiWorkCity == null ? null : puiWorkCity.trim();
    }

    public String getPuiWorkProvinces() {
        return puiWorkProvinces;
    }

    public void setPuiWorkProvinces(String puiWorkProvinces) {
        this.puiWorkProvinces = puiWorkProvinces == null ? null : puiWorkProvinces.trim();
    }

    public String getPuiWorkAddress() {
        return puiWorkAddress;
    }

    public void setPuiWorkAddress(String puiWorkAddress) {
        this.puiWorkAddress = puiWorkAddress == null ? null : puiWorkAddress.trim();
    }

    public String getPuiCompanyType() {
        return puiCompanyType;
    }

    public void setPuiCompanyType(String puiCompanyType) {
        this.puiCompanyType = puiCompanyType == null ? null : puiCompanyType.trim();
    }

    public String getPuiCompanyIndustry() {
        return puiCompanyIndustry;
    }

    public void setPuiCompanyIndustry(String puiCompanyIndustry) {
        this.puiCompanyIndustry = puiCompanyIndustry == null ? null : puiCompanyIndustry.trim();
    }

    public String getPuiCompanySize() {
        return puiCompanySize;
    }

    public void setPuiCompanySize(String puiCompanySize) {
        this.puiCompanySize = puiCompanySize == null ? null : puiCompanySize.trim();
    }

    public String getPuiWorkAge() {
        return puiWorkAge;
    }

    public void setPuiWorkAge(String puiWorkAge) {
        this.puiWorkAge = puiWorkAge == null ? null : puiWorkAge.trim();
    }

    public String getPuiWorkPhone() {
        return puiWorkPhone;
    }

    public void setPuiWorkPhone(String puiWorkPhone) {
        this.puiWorkPhone = puiWorkPhone == null ? null : puiWorkPhone.trim();
    }

    public String getPuiWorkPosition() {
        return puiWorkPosition;
    }

    public void setPuiWorkPosition(String puiWorkPosition) {
        this.puiWorkPosition = puiWorkPosition == null ? null : puiWorkPosition.trim();
    }

    public String getPuiMonthSalary() {
        return puiMonthSalary;
    }

    public void setPuiMonthSalary(String puiMonthSalary) {
        this.puiMonthSalary = puiMonthSalary == null ? null : puiMonthSalary.trim();
    }

    public String getPuiChildren() {
        return puiChildren;
    }

    public void setPuiChildren(String puiChildren) {
        this.puiChildren = puiChildren == null ? null : puiChildren.trim();
    }

    public String getPuiHouse() {
        return puiHouse;
    }

    public void setPuiHouse(String puiHouse) {
        this.puiHouse = puiHouse == null ? null : puiHouse.trim();
    }

    public String getPuiCars() {
        return puiCars;
    }

    public void setPuiCars(String puiCars) {
        this.puiCars = puiCars == null ? null : puiCars.trim();
    }

    public String getPuiCarsLoan() {
        return puiCarsLoan;
    }

    public void setPuiCarsLoan(String puiCarsLoan) {
        this.puiCarsLoan = puiCarsLoan == null ? null : puiCarsLoan.trim();
    }

    public String getPuiHouseLoan() {
        return puiHouseLoan;
    }

    public void setPuiHouseLoan(String puiHouseLoan) {
        this.puiHouseLoan = puiHouseLoan == null ? null : puiHouseLoan.trim();
    }

    public String getPuiRelativeName() {
        return puiRelativeName;
    }

    public void setPuiRelativeName(String puiRelativeName) {
        this.puiRelativeName = puiRelativeName == null ? null : puiRelativeName.trim();
    }

    public String getPuiRelativeRelation() {
        return puiRelativeRelation;
    }

    public void setPuiRelativeRelation(String puiRelativeRelation) {
        this.puiRelativeRelation = puiRelativeRelation == null ? null : puiRelativeRelation.trim();
    }

    public String getPuiRelativePhone() {
        return puiRelativePhone;
    }

    public void setPuiRelativePhone(String puiRelativePhone) {
        this.puiRelativePhone = puiRelativePhone == null ? null : puiRelativePhone.trim();
    }

    public String getPuiContactName() {
        return puiContactName;
    }

    public void setPuiContactName(String puiContactName) {
        this.puiContactName = puiContactName == null ? null : puiContactName.trim();
    }

    public String getPuiContactRelation() {
        return puiContactRelation;
    }

    public void setPuiContactRelation(String puiContactRelation) {
        this.puiContactRelation = puiContactRelation == null ? null : puiContactRelation.trim();
    }

    public String getPuiContactPhone() {
        return puiContactPhone;
    }

    public void setPuiContactPhone(String puiContactPhone) {
        this.puiContactPhone = puiContactPhone == null ? null : puiContactPhone.trim();
    }

	public String getPuiRecommendedCustNo() {
		return puiRecommendedCustNo;
	}

	public void setPuiRecommendedCustNo(String puiRecommendedCustNo) {
		this.puiRecommendedCustNo = puiRecommendedCustNo;
	}
    
}