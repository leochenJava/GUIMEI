package cn.com.guimei.dao;

import cn.com.guimei.pojo.Superuser;
import org.apache.ibatis.annotations.Param;

public interface SupperUserMapper {
    Superuser superUserLogin(Superuser superuser);
    Superuser queryById(String id);
    int updateUser(@Param("userName")String userName,@Param("userPassword")String userPassword);
}
