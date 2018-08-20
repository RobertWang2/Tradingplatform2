package com.tradingplatform.controller;

import biz.UserService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import dao.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.*;


/**
 * @program: Tradingplatform
 * @description:
 * @author: Robert_Wang
 * @create: 2018-08-18 10:30
 **/
@Controller
@RequestMapping("/")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "judge", method = RequestMethod.POST)
    public String judge(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        ResultSet rs = userService.usernameIsEmpty(request);
        //用户名不空
        if(rs!=null)
        {
            User user = userService.queryByUsername(username);
            String password = request.getParameter("password");
            if(!password.equals(user.getPassword())) return "fail";
            else {//密码正确，则请求转发
//                request.setAttribute("forward",user);可以不要
                return "forward:index";
            }
        }
        else return  "fail";
    }
    @RequestMapping("index")
    public String helloSay(){
        return "index";
    }
    // /query?id=xx
    @RequestMapping(value = "query")
    public String query(@RequestParam("id") Integer id, Model model){
        log.debug("Query user id:" + id);
        User user = userService.queryById(id);
        System.out.println("username :" + user.getUsername());
        model.addAttribute(user);
        return "home";
    }

    /**
     * @Description: 返回用户信息到前台
     * @Param: [request, model]
     * @return: java.lang.String
     * @Author: Robert_Wang
     * @Date: 2018/8/18
     */
    @RequestMapping("list")
    public String list(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        User user = userService.queryByUsername(username);
        model.addAttribute(user);
        return "list";
    }
//    @RequestMapping(value = "list", method = RequestMethod.POST)
//    public String list(@RequestParam("username") String username, Model model){
//        User user = userService.queryByUsername(username);
//        model.addAttribute(user);
//        return "list";
//    }

}
