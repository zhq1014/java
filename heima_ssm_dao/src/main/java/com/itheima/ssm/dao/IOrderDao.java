package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {
    @Select("select * from orders")
    /**
     * 多表查询
     * */
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),

    })
    public List<Orders>findAll()throws Exception;
    //        通过id返回产品详情
@Select("select * from orders where id=#{ordersId}")
//    多表查询
@Results({
        @Result(id=true,property = "id",column = "id"),
        @Result(property = "orderNum",column = "orderNum"),
        @Result(property = "orderTime",column = "orderTime"),
        @Result(property = "orderStatus",column = "orderStatus"),
        @Result(property = "peopleCount",column = "peopleCount"),
        @Result(property = "payType",column = "payType"),
        @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
        @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.itheima.ssm.dao.IMemberDao.findById")),
        @Result(property = "travellers",column = "id",javaType = java.util.List.class,many =@Many(select = "com.itheima.ssm.dao.ITravellerDao.findByOrdersId"))

})
    public Orders findById(String ordersId)throws Exception;
}
