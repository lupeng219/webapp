package com.baibao.core.security.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutHandler extends SimpleUrlLogoutSuccessHandler {

	private String defaultTargetUrl ;
	@Override
	public void onLogoutSuccess(HttpServletRequest request,   
			HttpServletResponse response,   
			Authentication authentication  
			) throws IOException, ServletException {  
		
			response.sendRedirect(request.getContextPath() + defaultTargetUrl);  
	}
	
	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}  
	
}
