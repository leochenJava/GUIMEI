package cn.com.guimei.dao;

import cn.com.guimei.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    List<Customer>customerListPage(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize);//查询客户数据
    int totalRecord();//查询客户数量
    List<Customer>unionCustomerList(Map map);
    int unionRecord(Customer customer);
    int deleteById(String id);
    Customer queryById(String id);
    int doUpdate(Customer customer);
}
