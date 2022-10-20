package com.sz.guigu.dbtest05;

import com.sz.guigu.dbtest05.dao.DeptDao;
import com.sz.guigu.dbtest05.dao.impl.DeptDaoImpl;
import com.sz.guigu.dbtest05.pojo.Account;
import com.sz.guigu.dbtest05.pojo.Dept;
import com.sz.guigu.test04.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class Test01 {
    public static void main(String[] args) throws Exception {
        //增
        QueryRunner runner = new QueryRunner();
        runner.update(JDBCUtils.getConnection(),"insert into account values(?,?,?)",null,"ww",9999);
    }
    @Test
    public void test01() throws Exception {
        //删
        new QueryRunner().update(JDBCUtils.getConnection(),
                "delete from account where id = ?",5);
    }
    @Test
    public void test02() throws Exception {
        //改
        new QueryRunner().update(JDBCUtils.getConnection(),
                "update account set balance = 9999 where id = 4");
    }

    @Test
    public void test03() throws Exception {
        Account query = new QueryRunner()
                .query(JDBCUtils.getConnection(),
                        "select * from account where id = ?", new BeanHandler<>(Account.class), 1);
        System.out.println(query);
    }
    @Test
    public void test04() throws Exception {
        List<Account> list = new QueryRunner()
                .query(JDBCUtils.getConnection(),
                        "select * from account", new BeanListHandler<Account>(Account.class));
        list.forEach(System.out::println);
    }
    @Test
    public void test05() throws Exception {
        Object query = new QueryRunner()
                .query(JDBCUtils.getConnection()
                        ,"select max(balance),count(*) from account"
                        , new ScalarHandler<>(2));
        System.out.println(query);
    }
    DeptDao dao ;

    @Test
    public void test06() {
        dao = new DeptDaoImpl();
        int i = dao.insertCount(new Dept(10, "huangxi", "测试部门"));
        System.out.println(i != 0 ? "插入成功" : "插入失败");
        int i1 = dao.updateAccount(new Dept(10, "翟文海", "啊啊啊"));
        System.out.println(i1 != 0 ? "更新成功" : "更新失败");
        List<Dept> depts = dao.selectAllDept();
        depts.forEach(System.out::println);


    }
}
