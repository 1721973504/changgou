package com.yunlian.changgou.service.admin.controller;

import com.yunlian.changgou.common.Result;
import com.yunlian.changgou.common.StatusCode;
import com.yunlian.changgou.core.AbstractCoreController;
import com.yunlian.changgou.core.CoreService;
import com.yunlian.changgou.goods.model.Admin;
import com.yunlian.changgou.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController extends AbstractCoreController<Admin> {

    @Autowired
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        super(adminService);
    }

    @PostMapping("/login/{userId}/{password}")
    public Result login(@PathVariable("userId") String userId, @PathVariable("password") String password){
        boolean bo = adminService.login(userId,password);
        if(bo){
            return new Result(true, StatusCode.OK,"登录成功");
        }
        return new Result(false,StatusCode.LOGINERROR,"登录失败");
    }

    @PostMapping("/register/{userId}/{password}")
    public Result register(@PathVariable("userId") String userId,@PathVariable("password") String password){
        boolean bo = adminService.register(userId,password);
        if(bo){
            return new Result(true,StatusCode.OK,"注册成功");
        }
        return new Result(false,StatusCode.ERROR,"注册失败");
    }

}
