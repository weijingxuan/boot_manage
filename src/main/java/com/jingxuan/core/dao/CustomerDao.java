package com.jingxuan.core.dao;

import com.jingxuan.common.utils.Page;
import com.jingxuan.core.po.Customer;

import java.util.List;

public interface CustomerDao {

    //客户列表
    public List<Customer> selectCustomerList(Customer customer);
    //客户数
    public Integer selectCustomerListAccount(Customer customer);

    public int createCustomer(Customer customer);

    public Customer getCustomerById(Integer id);

    public int updateCustomer(Customer customer);

    public int deleteCustomer(Integer id);
}
