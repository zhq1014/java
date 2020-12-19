package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission")
    List<Permission> findAll()throws Exception;
//    资源权限的添加
    @Insert("insert into permission(id,permissionName,url)values(#{id},#{permissionName},#{url})")
    void save(Permission permission)throws Exception;
//    根据id查找所有的职位
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    public List<Permission>findPermissionById(String id)throws  Exception;
}
