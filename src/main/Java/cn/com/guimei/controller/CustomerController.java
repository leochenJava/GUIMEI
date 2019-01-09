package cn.com.guimei.controller;

import cn.com.guimei.pojo.Customer;
import cn.com.guimei.pojo.Page;
import cn.com.guimei.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Resource
    CustomerService customerService;
    @RequestMapping(value = "/customerPageList")
    public String showCustomerInfo(String pageNumber, HttpServletRequest request){
        Page<Customer> page = customerService.customerList(pageNumber);
        String url = "/customer/customerPageList?pageNumber=";
        page.setServletURL(url);
        request.setAttribute("Page",page);
        return "showCustomer";
    }
    @RequestMapping(value = "/customerUnionList")
    public String unionList(String pageNumber,Customer customer,HttpServletRequest request){
        Page<Customer> page = customerService.unionCustomerList(pageNumber,customer);
        Long id = customer.getId()!=null?customer.getId():0;
       //String url = "/customer/customerUnionList?cusId="+customer.getId()+"&cusName="+customer.getCusName()+"&cusSex="+customer.getCusSex()+"pageNumber=";
       String url = "/customer/customerUnionList?id="+id+"&cusName="+customer.getCusName()+"&cusSex="+customer.getCusSex()+"&pageNumber=";

        page.setServletURL(url);
        request.setAttribute("Page",page);
        return "showCustomer";
    }

    @RequestMapping(value = "/doDelById")
    public String doDelete(String cusId,HttpServletRequest request){
        String id = cusId!=null?cusId:"0";
        int n = customerService.deleteById(id);
        if (n==0){
            request.setAttribute("error","删除失败!");
        }
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/customer/customerUnionList";
    }

    @RequestMapping(value = "/doQueryById")
    public String doQuery(String id,HttpServletRequest request){
        String cusId = id!=null?id:"0";
        Customer customer = customerService.queryById(cusId);
        request.setAttribute("cus",customer);
        return "updateCusInfo";
    }

    @RequestMapping(value = "/doUpdateById")
    public String doUpdate(Customer customer,HttpServletRequest request){
        int n = customerService.doUpdate(customer);
        if (n==0){
            request.setAttribute("error","修改失败!");
        }
        return "showCustomer";
    }
}
