package com.yun.test;

import com.yun.dao.BadeDao;
import com.yun.dao.UserDao;
import com.yun.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestUser {
    //测试BadeDao的方法连接是否正确
    //用户查询
    @Test
    public void tesecea(){
        UserDao userDao = new UserDao();
        User admin = userDao.cea("admin");
        System.out.println(admin.getUpwd());
    }
    //用户查询
    @Test
    public void testQueryUserByName() {
        UserDao userDao = new UserDao();
        User user = userDao.queryUserByName("admin");
        System.out.println(user.getUpwd());
    }
    //添加用户
    @Test
    public void testAdd(){
        String sql="insert into tb_user(uname,upwd,nick,head,mood)values(?,?,?,?,?)";
        List<Object> list=new ArrayList<>();
        list.add("fg0");
        list.add("e10adc3949ba59abbe56e057f20f883e");
        list.add("ni");
        list.add("404.jpg");
        list.add("hao");
        int i = BadeDao.executeUpdate(sql, list);
        System.out.println(i);
    }
    @Test
    public void Short() {
            StringBuffer s = new StringBuffer("Hello");
            if ((s.length() > 5) && (s.append("there").equals("False")));
            System.out.println("value is " + s);

    }
}
