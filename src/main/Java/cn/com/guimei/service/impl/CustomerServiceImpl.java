package cn.com.guimei.service.impl;

import cn.com.guimei.dao.CustomerMapper;
import cn.com.guimei.pojo.Customer;
import cn.com.guimei.pojo.Page;
import cn.com.guimei.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    CustomerMapper customerMapper;
    public Page<Customer> customerList(String num) {
        Page<Customer>page = new Page<Customer>();
        int pageNumber = 1;
        if (num!=null){
            pageNumber=Integer.parseInt(num);
        }
        int pageSize = 3;
        int totalRecord = customerMapper.totalRecord();
        int pageIndex = (pageNumber-1)*pageSize;
        List<Customer> customerList = customerMapper.customerListPage(pageIndex,pageSize);
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        page.setTotalRecord(totalRecord);
        page.setPageData(customerList);
        return page;
    }

    public Page<Customer> unionCustomerList(String num, Customer customer) {
        Page<Customer> page = new Page<Customer>();
        Map<String,Object>map = new HashMap<String, Object>();
        int pageNumber = 1;
        if (num!=null){
            pageNumber=Integer.parseInt(num);
        }
        System.out.println(customer.toString()+"**************************************************************");
        int pageSize = 3;
        int totalRecord = customerMapper.unionRecord(customer);
        int pageIndex = (pageNumber-1)*pageSize;
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        map.put("customer",customer);

        List<Customer> customerList = customerMapper.unionCustomerList(map);
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        page.setTotalRecord(totalRecord);
        page.setPageData(customerList);
        return page;
    }

    public int deleteById(String id) {
        return customerMapper.deleteById(id);
    }

    public Customer queryById(String id) {
        return customerMapper.queryById(id);
    }

    public int doUpdate(Customer customer) {
        return customerMapper.doUpdate(customer);
    }
}
