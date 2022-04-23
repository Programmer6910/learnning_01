package com.localhost.springmvc.controller;

import com.localhost.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 * 控制器类
 * */
@Controller
public class UserController {
    /***
     * 控制器（处理器）的方法接收请求的数据，与前端name值保持一致
     * value:指定能执行处理方法的映射路径，告诉DispatcherServlet（中央调度器）
     * 该映射路径的请求对应交给UserController控制器对象的doRegist()方法来处理请求
     * method：指定要处理的请求的方式，比如doRegist()处理方法要求请求方式为post才会执行
     * */
    @RequestMapping(value = "/regist.do",method = RequestMethod.POST)
    public ModelAndView doRegist(String username, String password, String telephone){
        //本次请求的处理结果，保存至ModelAndView对象中
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userName",username);
        modelAndView.addObject("telePhone",telephone);
        //框架执行转发
        modelAndView.setViewName("/WEB-INF/view/show.jsp");
        return  modelAndView;
    }
    /**
     * 此处不返回数据，可以使用String类型返回值，只返回视图
     * */
    @RequestMapping(value = "/view.do")
    public String doView(){
        return "/WEB-INF/view/regist.jsp";
    }
    /***
     * 以对象形式返回数据model，并使用转换成json格式响应(由框架自动处理)
     */
    @RequestMapping(value = "/getInfor.do")
    @ResponseBody
    public User doFind(String name){
        User user=new User();
        user.setTelePhone("666666");
        user.setName(name);
        return user;
    }
}
