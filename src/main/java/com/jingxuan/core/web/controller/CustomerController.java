package com.jingxuan.core.web.controller;

import com.jingxuan.common.utils.Page;
import com.jingxuan.core.po.BaseDict;
import com.jingxuan.core.po.Customer;
import com.jingxuan.core.po.User;
import com.jingxuan.core.service.BaseDictService;
import com.jingxuan.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDictService baseDictService;
    //客户来源
    @Value("${customer.from.type}")
    private String FROM_TYPE;
    //客户所属行业
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;
    /**
     * 客户列表
     */
    @RequestMapping("/customer/list.action")
    public String list(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer rows, String custName, String custSource, String custIndustry,
                       String custLevel, Model model){
        //条件查询所有客户
        Page<Customer>customers=customerService.findCustomerList(page,rows,custName,custSource,custIndustry,custLevel);
        model.addAttribute("page",customers);

        //客户来源
        List<BaseDict>fromType=baseDictService.findBaseDictByTypeCode(FROM_TYPE);
        //客户所属行业
        List<BaseDict>industryType=baseDictService.findBaseDictByTypeCode(INDUSTRY_TYPE);
        //客户级别
        List<BaseDict>levelType=baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);
        //添加参数
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);
        model.addAttribute("custName",custName);
        model.addAttribute("custSource",custSource);
        model.addAttribute("custIndustry",custIndustry);
        model.addAttribute("custLevel",custLevel);
        return "customer";

    }

    /**
     * 创建客户
     */
    @RequestMapping("/customer/create.action")
    @ResponseBody
    public String customerCreate(Customer customer, HttpSession session){
        User user= (User) session.getAttribute("USER_SESSION");
        customer.setCust_create_id(user.getUser_id());
        Date date=new Date();
        Timestamp timestamp=new Timestamp(date.getTime());
        customer.setCust_createtime(timestamp);
        int row=customerService.createCuetomer(customer);
        if(row>0){
            return "OK";
        }else{
            return "FALL";
        }
    }

    /**
     * 通过id获取客户信息
     * @param id
     * @return
     */
    @RequestMapping("/customer/getCustomerById.action")
    @ResponseBody
    public Customer getCustomerById(Integer id){
        Customer customer=customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping("/customer/update.action")
    @ResponseBody
    public String updateCustomer(Customer customer){
        int rows=customerService.updateCustomer(customer);
        if(rows>0){
            return "OK";
        }else{
            return "FALL";
        }

    }
    @RequestMapping("/customer/delete.action")
    @ResponseBody
    public String customerDelete(Integer id){
        int rows=customerService.deleteCustomer(id);
        if(rows>0){
            return "OK";
        }else{
            return "FALL";
        }

    }

}
