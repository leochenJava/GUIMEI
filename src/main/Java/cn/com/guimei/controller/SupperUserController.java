package cn.com.guimei.controller;

import cn.com.guimei.pojo.Superuser;
import cn.com.guimei.service.SupperUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/supperUser")
public class SupperUserController {
    @Resource
    private SupperUserService supperUserService;
    @RequestMapping(value = "/login")
    public String doSupperUserLogin(Superuser superuser, HttpServletRequest request){
        Superuser user = supperUserService.superUserLogin(superuser);
        if (user == null){
            request.setAttribute("error","用户名或者密码错误!");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/Login.jsp";
        }
        request.setAttribute("supperUser",user);
        return "index";
    }
    @RequestMapping(value = "/queryById")
    public String doShowInfo(String id, HttpServletRequest request){
        Superuser user = supperUserService.queryById(id);
        request.setAttribute("user",user);
        return "updateUser";
    }

    @RequestMapping(value = "/updateUser")
    public String doUpdate(String userName,String userPassword,HttpServletRequest request){
        int n = supperUserService.updateUser(userName,userPassword);
        if (n<=0){
            request.setAttribute("error","修改失败!");
            return "updateUser";
        }

        return "index";
    }

}
