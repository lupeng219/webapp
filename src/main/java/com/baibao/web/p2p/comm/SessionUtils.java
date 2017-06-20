package com.baibao.web.p2p.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.baibao.web.p2p.generator.bean.P2p_user;

/**
 * 操作session工具类
 * 操作session存取键值对
 * @author w.s
 *
 */
public class SessionUtils {
	
	/**
	 * 把键值对放入session中
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void putAttrInSession(HttpServletRequest request,String key,Object value){
		request.getSession().setAttribute(key, value);
	}
	
	/**
	 * 从session中使用键取出值
	 * @param request
	 * @param key
	 * @return
	 */
	public static Object getAttrFromSession(HttpServletRequest request,String key){
		Object obj = request.getSession().getAttribute(key);
		return obj;
	}
	
	/**
	 * 从session中移除 所记录的键值对
	 * @param request
	 * @param keys
	 */
	public static void removeFromSession(HttpServletRequest request,String ... keys){
		HttpSession session = request.getSession();
		for (String oneOfKey : keys) {
			session.removeAttribute(oneOfKey);
		}
	}
	
	/**
	 * 将当前登录的平台账户放入session中
	 * @param request
	 * @param platAccount
	 */
	public static void setCurrentUser(HttpServletRequest request,P2p_user user){
		putAttrInSession(request, Const.CURRENT_LOGIN_USER, user);
	}
	
	/**
	 * 获取当前登录的用户的平台账户
	 * @param request
	 * @param platAccount
	 * @return
	 */
	public static P2p_user getCurrentUser(HttpServletRequest request){
		return (P2p_user)getAttrFromSession(request, Const.CURRENT_LOGIN_USER);
	}
	
}
