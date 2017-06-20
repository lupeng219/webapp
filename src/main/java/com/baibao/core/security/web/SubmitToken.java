package com.baibao.core.security.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 防止重复提交注解，用于方法上<br/>
 * 在新建页面方法上，设置setToken()为true，此时拦截器会在Session中保存一个token，
 * 同时需要在新建的页面中添加
 * <input type="hidden" name="_TOKEN_SESSION" value="${_TOKEN_SESSION}">
 * <br/>
 * 保存方法需要验证重复提交的，设置checkToken()为true
 * 此时会在拦截器中验证是否重复提交
 * </p>
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SubmitToken {
    boolean setToken() default false;
    boolean checkToken() default false;
}
