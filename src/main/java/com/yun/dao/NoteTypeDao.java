package com.yun.dao;

import com.yun.entity.NoteType;

import java.util.ArrayList;
import java.util.List;

public class NoteTypeDao {
    /*通过用户ID查询类型集合
            1. 定义SQL语句
                String sql = "select typeId,typeName,userId from tb_note_type where userId = ? ";
            2. 设置参数列表
            3. 调用BaseDao的查询方法，返回集合
            4. 返回集合*/
    public List<NoteType> findTypeListByUserId(Integer userId) {
        //1. 定义SQL语句
        String sql = "select typeId,typeName,userId from tb_note_type where userId = ? ";
        //2. 设置参数列表
        List<Object> params=new ArrayList<>();
        params.add(userId);
        //3. 调用BaseDao的查询方法，返回集合
        List<NoteType> list=BadeDao.queryRows(sql,params,NoteType.class);
        //4. 返回集合
        return list;
    }
}
