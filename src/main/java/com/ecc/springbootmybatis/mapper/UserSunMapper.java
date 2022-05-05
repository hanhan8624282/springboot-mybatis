package com.ecc.springbootmybatis.mapper;

import com.ecc.springbootmybatis.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunyc
 * @create 2022-04-27 16:27
 */
@Mapper
public interface UserSunMapper {

    @Select("select * from user_sun where id=#{id}")
    public User getUserId(Integer id);
    @Delete("delete from user_sun where id=#{id}")
    public int delete(Integer id);
    @Update("update user_sun set name=#{name},email=#{email} where id=#{id}")
    public int update(User user);
    @Insert("insert into user_sun(id,name,email) values(user_sun_squence.nextval,#{name},#{email})")
    public int insert(User user);
    @Select("select * from user_sun where id>#{id}")
    public List<User> queryAll(Integer id);
    //多表联合查询 返回多条记录
    @Select("select card_id 卡号,a.customer_code 账户,card_status 卡状态 " +
            "from ecc_bj.ecc_card a, " +
            "ecc_bj.ecc_account b " +
            "where a.customer_code=b.customer_id "  +
            "and a.card_id in (#{card_id},#{card_id1}) ")
    public List<Map<String ,Object>> getCardId(String card_id,String card_id1);
    //返回多条记录
    @Select("select card_id 卡号,customer_code 账户号 from ecc_bj.ecc_card where rownum<#{num}")
    public List<Map<String,Object>> getAll(Integer num);

    //返回多条记录2
    @Select("select card_id 卡号,customer_code 账户号 from ecc_bj.ecc_card where rownum<#{num}")
    public List<Object> getAll2(Integer num);

}

