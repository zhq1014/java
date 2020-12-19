package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrderDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrderDao orderDao;
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
//        参数pageNum是页码值，参数pageSize代表是:每页显示条数
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }
//         通过产品id返回产品详情
    @Override
    public Orders findById(String ordersId) throws Exception {
        return orderDao.findById(ordersId);
    }
}
