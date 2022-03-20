package com.yun.service;

import com.yun.dao.NoteTypeDao;
import com.yun.entity.NoteType;

import java.util.List;

public class NoteTypeService {
    private NoteTypeDao typeDao = new NoteTypeDao();

    /*通过id查询类型列表
    * 1. 调用Dao层的查询方法，通过用户ID查询类型集合
      2. 返回类型集合*/
    public List<NoteType> findTypeList(Integer userId) {
        List<NoteType> typeList = typeDao.findTypeListByUserId(userId);
        return typeList;
    }
}
