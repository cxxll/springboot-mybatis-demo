package com.cxl.springboot.controller;

import com.cxl.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ShiroController {

    //service注入
    @Autowired
    private UserService userService;

    @RequestMapping("/shiro/shiroAdd")
    public String shiroAdd(){
        return "/user/add";
    }

    @RequestMapping("/shiro/shiroUpdate")
    public String shiroUpdate(){
        return "/user/update";
    }

    @RequestMapping("/shiro/login")
    public String login(String name, String password,Model model){
        /*
        *  使用shiro编写认证操作
        * */
        System.out.print("121");

        //1.获取subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        System.out.print("131");

        //3.执行登录方法
        try{
            subject.login(token);
            System.out.print("411");
            model.addAttribute("msg","登陆成功");
            return "redirect：template";
            //登陆成功
        }catch (UnknownAccountException e){
            //登陆失败：用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            //登陆失败：密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @RequestMapping("/shiro/templates")
    public String templates(){
        return "/login";
    }
    @RequestMapping("/shiro/template")
    public String template(){
        return "/user/update";
    }

    @RequestMapping("/shiro/noAuth")
    public String noAuth(){
        return "/test";
    }

}