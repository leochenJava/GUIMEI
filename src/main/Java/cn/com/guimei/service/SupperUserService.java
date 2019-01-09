package cn.com.guimei.service;

import cn.com.guimei.pojo.Superuser;

public interface SupperUserService {
    Superuser superUserLogin(Superuser superuser);
    Superuser queryById(String id);
    int updateUser(String userName,String userPassword);
}
