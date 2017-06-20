package com.baibao.web.p2p.comm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.baibao.web.p2p.generator.bean.P2p_user;

/**
 * Spring Security提供了一个线程安全的对象：SecurityContextHolder，
 * 通过这个对象，我们可以访问当前的登录用户
 * @author Administrator
 */
public class SecurityUserHolder
{	
	private static Logger logger = LoggerFactory.getLogger(SecurityUserHolder.class); 
	
	/**
	 * 获取当前用户
	 * @return
	 */
	public static P2p_user getCurrentUser()
	{
		Authentication au =
			SecurityContextHolder
				.getContext().getAuthentication();

		if (au == null ||
			!(au.getPrincipal() instanceof P2p_user))
			return null;

		P2p_user user = (P2p_user) au.getPrincipal();
		return user;
	}
	
	/**
	 * 获得当前用户昵称
	 * @return
	 */
	/*public static String getNickname() {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if(au == null){
			return null;
		}else{
			if( au.getPrincipal() instanceof P2p_user )
			{
				P2p_user user = (P2p_user) au.getPrincipal();
				if(user !=null){
					return user.getPuNickname();
				}else{
					return null;
				}
			}
			return null;
		}
		
	}*/
	
	/**
	 * 获得当前用户的客户号
	 * @return
	 */
	public static String getCustNo()
	{
		P2p_user user = getCurrentUser();
		
		if (user == null)
			return null;
		
		return user.getPuCustNo();
	}
	
	
	/**
	 * 获得当前用户的客户号
	 * @return
	 */
	public static String getRemoteAddress()
	{
		try
		{
			Authentication au =
				SecurityContextHolder
					.getContext().getAuthentication();
			if (au == null)
				return null;

			WebAuthenticationDetails auth =
				(WebAuthenticationDetails) au.getDetails();
			return auth.getRemoteAddress();
		} catch(Exception e)
		{
			logger.error("getRemoteAddress", e);
			return null;
		}
	}
}
