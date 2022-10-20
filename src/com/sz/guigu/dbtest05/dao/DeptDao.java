package com.sz.guigu.dbtest05.dao;

import com.sz.guigu.dbtest05.pojo.Dept;

import java.util.List;

public interface DeptDao {

    int insertCount(Dept dept);

    int deleteById(int did);

    int updateAccount(Dept dept);

    List<Dept> selectAllDept();
}
