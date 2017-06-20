package com.baibao.core.security.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.service.UserService;

/**
 * 用户验权过滤器
 * 
 * @author Denny
 * @date 2016年6月21日
 */
public class P2PUsernamePasswordAuthenticationFilter
	extends UsernamePasswordAuthenticationFilter
{
    @Autowired
    private UserService userService;

    @Autowired
    private Md5PasswordEncoder passwordEncoder;

    public static final String PUMOBILE = "puMobile";
    public static final String PASSWORD = "puPassword";
    public static final String BREAKVCODE = "validateCode";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException
    {
        if (!request.getMethod().equals("POST"))
        {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        
        String puMobile = request.getParameter(PUMOBILE);
        String password = request.getParameter(PASSWORD);
        P2p_user loginUser = userService.getByLoginName(puMobile);
        if (loginUser == null)
        {
            throw new UsernameNotFoundException("用户名或密码不正确");
        }
                        
        String temp_str = passwordEncoder.encodePassword(password, loginUser.getPuCustNo());
        if (!temp_str.equals(loginUser.getPassword()))
        {
            throw new UsernameNotFoundException("用户名或密码不正确");
        }
        
        // UsernamePasswordAuthenticationToken实现 Authentication
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(puMobile, password);
        // 允许子类设置详细属性
        setDetails(request, authRequest);
        // 运行UserDetailsService的loadUserByUsername 再次封装Authentication
        return this.getAuthenticationManager().authenticate(authRequest);
    }

}
