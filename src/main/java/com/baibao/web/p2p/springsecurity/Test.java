package com.baibao.web.p2p.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
public class Test {
	/**
	 * passwordEncoder，用来给密码加密，以保证数据库中存储的密码是密文
	 *
	 * @return {@link ShaPasswordEncoder}
	 *
	 */
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new ShaPasswordEncoder();
	}
	
	@Bean
	public SaltSource saltSource(){
		ReflectionSaltSource saltSource = new ReflectionSaltSource();
		saltSource.setUserPropertyToUse("id");
		return saltSource;
	}
	
	
	public static void main(String[] agrs)
	{
//		ReflectionSaltSource saltSource = new ReflectionSaltSource();
//		saltSource.setUserPropertyToUse("id");
//		Md5PasswordEncoder md5=new Md5PasswordEncoder();  
		ShaPasswordEncoder encode = new ShaPasswordEncoder();
//		
		//System.out.println(md5.encodePassword("adminsld", "1"));  
//		System.out.println( md5.isPasswordValid("2f17ad69a6793c7d09da8c4ea3a5054c", "adminsld", "1"));
		System.out.println(encode.encodePassword("adminloan","20150102"));
		System.out.println( encode.isPasswordValid("a64928322e2b92b1256b3ce04d53514ef62ba79a","adminloan", "20150102"));
		System.out.println(encode.encodePassword("adminloanadmin","20150103"));
		System.out.println( encode.isPasswordValid("4431f7ddaf9ac6dde094caa1e07d358d37f29481","adminloanadmin", "20150103"));
////		String role_admin = "role_admin";
////		System.out.println( role_admin.toUpperCase() );
//		System.out.println(Class.class.getClass().getResource("/"));
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println(SecurityConfig.class.getResource("/"));
//		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
//		System.out.println(ClassLoader.getSystemResource(""));
		
//		File file1 = new File("D://639655001409911556.gif");
//		File file2 = new File("e://639655001409911556.gif");
//		fileChannelCopy(file1,file2);
		
		//System.out.println((int)(Math.random()*10));
		
//		BigDecimal object = new BigDecimal("10");
//		BigDecimal object1 = new BigDecimal("14.27");
//		BigDecimal object2 = new BigDecimal("3");
//		System.out.println( object1.divide( object2,2,RoundingMode.DOWN) );
//		
//		System.out.println( object1.divide(object2,2,BigDecimal.ROUND_DOWN));

	}
	
}
