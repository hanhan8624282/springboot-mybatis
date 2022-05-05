package com.ecc.springbootmybatis.controller;

import com.ecc.springbootmybatis.bean.User;
import com.ecc.springbootmybatis.mapper.UserMapper;
import com.ecc.springbootmybatis.mapper.UserSunMapper;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunyc
 * @create 2022-04-27 11:08
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserSunMapper userSunMapper;

    @RequestMapping("/")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");//设置返回的页面
        modelAndView.addObject("user","获取modelandview的值");
        System.out.println("35vio");
        System.out.println(1234);
        System.out.println(1234);
        System.out.println(1234);
        System.out.println("这是hot-fix分支");
        System.out.println("这是hot-fix分支");
        System.out.println("这是hot-fix分支");
        System.out.println("wcao");


        return modelAndView;
    }
    //mysql
    @GetMapping("/user/{id}")
    public ModelAndView getId(@PathVariable("id") Integer id,ModelAndView modelAndView){
        modelAndView.setViewName("success");
        User userId = userMapper.getUserId(id);
        modelAndView.addObject("user",userId);
        return modelAndView;
    }
    //mysql
    @GetMapping("/user")
    @Transactional
    public int insert(User user){
        return userMapper.insert(user);
    }
    //mysql
    @GetMapping("/userd/{id}")
    @Transactional
    public int delete(@PathVariable("id") Integer id){
        return userMapper.delete(id);
    }
    //mysql
    @GetMapping("/userp")
    @Transactional
    public int update1(User user){
        return userMapper.update(user);
    }
    //mysql
    @GetMapping("/userall/{id}")
    public ModelAndView queryAll(@PathVariable("id") Integer id,ModelAndView modelAndView){
        List<User> users = userMapper.queryAll(id);
        modelAndView.setViewName("list");
        modelAndView.addObject("user",users);
        for (User user : users) {
            System.out.println(user);
        }
        return modelAndView;
    }
    //oracle
    @GetMapping("/queryall/{id}")
    public List<User> queryAll1(@PathVariable("id") Integer id){
        List<User> users = userSunMapper.queryAll(id);
        for (User user : users) {
            System.out.println(user);
        }

        return users;
    }
    //oracle
    @GetMapping("/update")
    @Transactional
    public int update(User user){
        return userSunMapper.update(user);
    }
    //oracle
    @GetMapping("/delete/{id}")
    @Transactional
    public User delete1(@PathVariable("id") Integer id){
        User userId = userSunMapper.getUserId(id);
         userSunMapper.delete(id);
         return userId;
    }
    //oracle
    @GetMapping("/insert")
    @Transactional
    public User insert1(User userSun){
         userSunMapper.insert(userSun);
         return userSun;
    }
    //oracle
    @GetMapping("/get/{id}")
    public User getId1(@PathVariable("id") Integer id){
        System.out.println("id="+id);
        return userSunMapper.getUserId(id);

    }
    //多表联合查询 返回多条记录
    @GetMapping("/cardid/{card_id}/{card_id1}")

    public List<Map<String ,Object>> getCardId(@PathVariable("card_id") String card_id,
                                         @PathVariable("card_id1") String card_id1)
    {
        System.out.println("card_id="+card_id);
        List<Map<String ,Object>> cardId = userSunMapper.getCardId(card_id,card_id1);
        return cardId;
    }
    @GetMapping("/num/{num}") //返回多条记录
    public List<Map<String,Object>> getCardId(@PathVariable("num") Integer num)
    {
        System.out.println("card_id="+num);
        List<Map<String,Object>> cardId = userSunMapper.getAll(num);
        return cardId;
    }
    @GetMapping("/num1/{num}") //返回多条记录
    public List<Object> getCardId12(@PathVariable("num") Integer num)
    {
        System.out.println("card_id="+num);
        List<Object> all2 = userSunMapper.getAll2(num);
        return all2;
    }


}
