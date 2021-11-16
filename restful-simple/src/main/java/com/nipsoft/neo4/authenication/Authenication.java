package com.nipsoft.neo4.authenication;

import com.alibaba.fastjson.JSON;
import com.nipsoft.neo4.bean.ResponseBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class Authenication  extends BasicAuthenticationEntryPoint {

    @Override
    public void afterPropertiesSet()  {
        setRealmName("liwei");
        super.afterPropertiesSet();
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.println(JSON.toJSONString(ResponseBean.builder().message("用户名密码错误").status("201").build()));
    }
}
