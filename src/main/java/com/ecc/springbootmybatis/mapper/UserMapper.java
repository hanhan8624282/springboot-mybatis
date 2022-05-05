package com.ecc.springbootmybatis.mapper;

import com.ecc.springbootmybatis.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * @author sunyc
 * @create 2022-04-27 10:31
 */
@Mapper
public interface UserMapper {

    @Select("select * from user_temp where id=${id}")
    public User getUserId(Integer id);

    @Delete("delete from user_temp where id=${id}")
    public int delete(Integer id);

    @Update("update user_temp set name=#{name},email=#{email} where id=#{id}")
    public int update(User user);

    @Insert("insert into user_temp(name,email) values(#{name},#{email})")
    public int insert(User user);

    @Select("select * from user_temp where id>#{id}")
    public List<User> queryAll(Integer id);
}

