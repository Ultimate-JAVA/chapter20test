package com.sz.guigu.test03.dao;

import org.junit.Test;
import com.sz.guigu.test03.entry.Department;

import java.sql.*;

public class DepartmentDao {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root", "zhaiwenhai");
        String sql = "select * from t_department where did = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setObject(1,3);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Integer object = (Integer) resultSet.getObject(1);
            String object1 = (String) resultSet.getObject(2);
            String object2 = (String) resultSet.getObject(3);
            Department department = new Department(object,object1,object2);
            System.out.println(department);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
