package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
//    根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id)throws Exception;
    //查询所有产品信息
    @Select("select * from product")
    public List<Product>findAll()throws Exception;
//    保存产品信息
    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "value(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})"
    )
    void save(Product product);
}
