package cn.com.guimei.service.impl;

import cn.com.guimei.dao.SupperUserMapper;
import cn.com.guimei.pojo.Superuser;
import cn.com.guimei.service.SupperUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SupperUserServiceImpl implements SupperUserService {
    @Resource
    private SupperUserMapper supperUserMapper;
    public Superuser superUserLogin(Superuser superuser) {
        return supperUserMapper.superUserLogin(superuser);
    }

    public Superuser queryById(String id) {
        return supperUserMapper.queryById(id);
    }

    public int updateUser(String userName, String userPassword) {
        return supperUserMapper.updateUser(userName,userPassword);
    }
}
