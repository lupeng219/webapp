package com.baibao.web.p2p.generator.bean;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户表-PO
 * crdloo501
 * @author Denny
 * @date 2016年6月21日
 */
public class P2p_user implements UserDetails, java.io.Serializable {

    private static final long serialVersionUID = -4255419244607029768L;

    private String puCustNo;                    // 用户编号
    private String puMobile;                    // 用户手机号
    private String puPassword;                  // 用户密码
    private String puMail;                      // 用户邮箱
    private String puHeadUrl;                   // 用户上传头像地址
    private Date puLastlogintime;               // 最后登录时间

    private Integer puEnabled;                  // 默认注册成功后可用 true成功 false失败
    private Integer puAccountNonExpired;        // 用户是否过期 true未过期 false 已过期
    private Integer puAccountNonLocked;         // 用户是否锁定 true 未锁定 false 已锁定
    private Integer puCredentialsNonExpired;    // 用户证书是否有效 true 有效 false 无效
    private String puInviteCode;                // 用户邀请码

    // 临时字段
    private String pca_accountNo;               // 支付账号
    private Date pui_registration_time;         // 注册时间

    public Date getPui_registration_time()
    {
        return pui_registration_time;
    }

    public void setPui_registration_time(Date pui_registration_time)
    {
        this.pui_registration_time = pui_registration_time;
    }

    public String getPuInviteCode()
    {
        return puInviteCode;
    }

    public void setPuInviteCode(String puInviteCode)
    {
        this.puInviteCode = puInviteCode;
    }

    public String getPca_accountNo()
    {
        return pca_accountNo;
    }

    public void setPca_accountNo(String pca_accountNo)
    {
        this.pca_accountNo = pca_accountNo;
    }

    private Collection<GrantedAuthority> authorities;// 用户证书是否有效

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return authorities;
    }

    @Override
    public String getPassword()
    {
        return puPassword;
    }

    @Override
    public String getUsername()
    {
        return puMobile;
    }

    public String getPuPassword()
    {
        return puPassword;
    }

    public void setPuPassword(String puPassword)
    {
        this.puPassword = puPassword;
    }

    public String getPuMobile()
    {
        return puMobile;
    }

    public void setPuMobile(String puMobile)
    {
        this.puMobile = puMobile;
    }

    public String getPuMail()
    {
        return puMail;
    }

    public void setPuMail(String puMail)
    {
        this.puMail = puMail;
    }

    public String getPuHeadUrl()
    {
        return puHeadUrl;
    }

    public void setPuHeadUrl(String puHeadUrl)
    {
        this.puHeadUrl = puHeadUrl;
    }

    public String getPuCustNo()
    {
        return puCustNo;
    }

    public void setPuCustNo(String puCustNo)
    {
        this.puCustNo = puCustNo;
    }

    public Date getPuLastlogintime()
    {
        return puLastlogintime;
    }

    public void setPuLastlogintime(Date puLastlogintime)
    {
        this.puLastlogintime = puLastlogintime;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities)
    {
        this.authorities = authorities;
    }

    public Integer getPuEnabled()
    {
        return puEnabled;
    }

    public void setPuEnabled(Integer puEnabled)
    {
        this.puEnabled = puEnabled;
    }

    public Integer getPuAccountNonExpired()
    {
        return puAccountNonExpired;
    }

    public void setPuAccountNonExpired(Integer puAccountNonExpired)
    {
        this.puAccountNonExpired = puAccountNonExpired;
    }

    public Integer getPuAccountNonLocked()
    {
        return puAccountNonLocked;
    }

    public void setPuAccountNonLocked(Integer puAccountNonLocked)
    {
        this.puAccountNonLocked = puAccountNonLocked;
    }

    public Integer getPuCredentialsNonExpired()
    {
        return puCredentialsNonExpired;
    }

    public void setPuCredentialsNonExpired(Integer puCredentialsNonExpired)
    {
        this.puCredentialsNonExpired = puCredentialsNonExpired;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        if (this.puAccountNonExpired == 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        if (this.puAccountNonLocked == 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        if (this.puCredentialsNonExpired == 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEnabled()
    {
        if (this.puEnabled == 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object anObject)
    {
        if (this == anObject)
        {
            return true;
        }
        if (anObject instanceof P2p_user)
        {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return this.puCustNo.hashCode() + 29 * 100;
    }
}
