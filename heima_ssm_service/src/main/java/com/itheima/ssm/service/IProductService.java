package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductService {
//    查询所有的产品信息
    public List<Product>findAll()throws Exception;
//保存商品信息
    void save(Product product)throws Exception;

}
