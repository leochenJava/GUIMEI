package cn.com.guimei.service;

import cn.com.guimei.pojo.Customer;
import cn.com.guimei.pojo.Page;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    Page<Customer> customerList(String num);
    Page<Customer>unionCustomerList(String num,Customer customer);
    int deleteById(String id);
    Customer queryById(String id);
    int doUpdate(Customer customer);
}
