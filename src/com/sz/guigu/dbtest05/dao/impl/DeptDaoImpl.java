package com.sz.guigu.dbtest05.dao.impl;

import com.sz.guigu.dbtest05.dao.DeptDao;
import com.sz.guigu.dbtest05.pojo.Dept;
import com.sz.guigu.test04.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class DeptDaoImpl implements DeptDao {
    QueryRunner runner = new QueryRunner();

    @Override
    public int insertCount(Dept dept) {
        try {
            int add = runner.update(JDBCUtils.getConnection(),
                    "insert into dept values(?,?,?)",
                    dept.getDid(), dept.getDname(), dept.getDescription());
            return add;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int deleteById(int did) {
        try {
            int delete = runner.update(JDBCUtils.getConnection(),
                    "delete from dept where did = ?",
                    did);
            return delete;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int updateAccount(Dept dept) {
        try {

            int update = runner.update(JDBCUtils.getConnection(),
                    "update dept set dname=?,description=? where did = ?",
                    dept.getDname(),dept.getDescription(),dept.getDid());
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Dept> selectAllDept() {
        try {
            List<Dept> list = runner.query(JDBCUtils.getConnection(),
                    "select * from dept",
                    new BeanListHandler<>(Dept.class));
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
