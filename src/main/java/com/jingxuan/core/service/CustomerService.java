package com.jingxuan.core.service;

import com.jingxuan.common.utils.Page;
import com.jingxuan.core.po.Customer;

public interface CustomerService {

    //查询客户列表
    public Page<Customer>findCustomerList(Integer page,Integer rows,String custName,String custSource,String custIndustry,String custLevel);

    public int createCuetomer(Customer customer);

    public Customer getCustomerById(Integer id);

    public int updateCustomer(Customer customer);

    int deleteCustomer(Integer id);
}
