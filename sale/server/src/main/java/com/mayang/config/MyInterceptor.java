package com.mayang.config;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mayang.entity.dto.LoginUserInfoDTO;
import com.mayang.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Resource
    private LoginService loginService;

    /**
     *  在请求处理之前进行调用（Controller方法调用之前）
     *  返回true表示继续流程（如调用下一个拦截器或处理器）；返回false表示流程中断，通过response给客户端返回响应信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户token进行校验
        LoginUserInfoDTO loginUserInfoDTO = loginService.checkToken(request);
        if (Objects.isNull(loginUserInfoDTO)){
            return false;
        }
        return true;

    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图执行之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}