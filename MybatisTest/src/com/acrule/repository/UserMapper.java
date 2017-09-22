package com.acrule.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.acrule.model.User;

/**
 * @author xuningkai
 * @Description: TODO(描述)
 * @date 2017年9月22日 上午9:54:25
 *
 */
public interface UserMapper {
    
    @Insert("insert into person(name,age) values(#{name},#{age})")
    public void insertT(User user);
    
    @Delete("delete from person where id=#{id}")
    public void deleteById(int id);
    
    @Update("update person set name=#{name},age=#{age} where id=#{id}")
    public void updateT(User user);
    
    @Select("select * from person where id=#{id}")
    public User getUser(int id);
    
    @Select("select * from person")
    public List<User> getAllUsers();
}

