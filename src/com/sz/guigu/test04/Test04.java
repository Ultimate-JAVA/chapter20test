package com.sz.guigu.test04;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class Test04 {
    @Test
    public void test01() throws ClassNotFoundException, SQLException, FileNotFoundException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "zhaiwenhai");
        //3.准备sql
        String sql = "insert into t_blob values(?)";
        //4.创建命令发射器
        PreparedStatement ps = connection.prepareStatement(sql);
        //5.填充数据
        ps.setObject(1,new FileInputStream("C:\\Users\\Dell\\Pictures\\爱壁纸UWP\\美女\\美女 - 137.jpg"));

        //6.执行sql并展示结果
        int result = ps.executeUpdate();
        System.out.println(result == 0 ? "插入成功" : "插入失败");
    }

    //批处理
    @Test
    public void test02() throws ClassNotFoundException, SQLException {
        long start = System.currentTimeMillis();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "zhaiwenhai");
        String sql = "insert into student values(null,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 1; i <= 10000; i++) {
            ps.setObject(1, "张三" + i);
            ps.executeLargeUpdate();
        }
        ps.close();
        connection.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test() throws ClassNotFoundException, SQLException {
        long start = System.currentTimeMillis();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu?rewriteBatchedStatements=true", "root", "zhaiwenhai");
        String sql = "insert into student values(null,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 1; i <= 10000; i++) {
            ps.setObject(1, "张三" + i);
            ps.addBatch();
        }
        ps.executeBatch();
        ps.close();
        connection.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    @Test
    public void test03() throws SQLException {
        PreparedStatement ps=null;
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "zhaiwenhai");
            connection.setAutoCommit(false);
            String sql = "update account set balance = balance + ? where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1, -1000);
            ps.setObject(2, 1);
            ps.executeUpdate();
            ps.setObject(1, 1000);
            ps.setObject(2, 2);
            ps.executeUpdate();
            System.out.println("转账成功");
            connection.commit();
        } catch (Exception e) {
            System.out.println("转账失败");
            connection.rollback();
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test04() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "zhaiwenhai");
        String sql = "insert into account values(null,'ww',2000)";
        PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        ResultSet generatedKeys = ps.getGeneratedKeys();
        while (generatedKeys.next()){
            Object object = generatedKeys.getObject(1);
            System.out.println(object);

        }
    }
}
