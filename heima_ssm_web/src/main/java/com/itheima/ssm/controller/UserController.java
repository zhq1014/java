package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import com.itheima.ssm.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll()throws Exception{
        ModelAndView mv =new ModelAndView();
        List<UserInfo> userlist=userService.findAll();
        mv.setViewName("user-list");
        mv.addObject("userList",userlist);
        return mv;
    }
//    新建用户
    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username=='tom'")
    public String save(UserInfo userInfo)throws Exception{
        userInfo.setId(UuidUtil.getUuid());
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
//    查询指定id的用户
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id)throws Exception{
        ModelAndView mv =new ModelAndView();
        UserInfo userInfo=userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");
        return mv;
    }
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId) throws Exception {
        ModelAndView mv =new ModelAndView();
//        1、根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
//        2、根据用户id查询可以添加的角色
       List<Role> otherRoles= userService.findOtherRole(userId);
       mv.addObject("user",userInfo);
       mv.addObject("roleList",otherRoles);
       mv.setViewName("user-role-add");
        return mv;

    }
//    给用户添加角色
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds)throws Exception{
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

}
