package com.yunlian.changgou.service.admin.service;

import com.yunlian.changgou.core.CoreService;
import com.yunlian.changgou.goods.model.Admin;
import com.yunlian.changgou.service.admin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService extends CoreService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminMapper baseMapper) {
        super(baseMapper, Admin.class);
    }

    public boolean login(String userId,String password){
        Admin admin = adminMapper.selectByPrimaryKey(userId);
        if(admin==null){
            return false;
        }else {
            return BCrypt.checkpw(password,admin.getPassword())?true:false;
        }
    }

    public boolean register(String userId,String password){
        Admin admin = new Admin();

        admin.setLoginName(userId);
        List list = adminMapper.select(admin);
        if(list.size()==0){
            String salt = BCrypt.gensalt();
            String pass = BCrypt.hashpw(password,salt);
            admin.setPassword(pass);
            admin.setStatus("1");
            adminMapper.insert(admin);
            return true;
        }
        return false;
    }
}
