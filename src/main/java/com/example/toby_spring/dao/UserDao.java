package com.example.toby_spring.dao;

import com.example.toby_spring.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        // JDBC를 사용하여 MySQL 데이터베이스에 연결하기 위해 사용되는 코드이다.
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/tobySpring","root",""
        );

        PreparedStatement ps = c.prepareStatement("insert into users(id, name, passowrd) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.clearParameters();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/tobySpring", "root", "");

        PreparedStatement ps = c.prepareStatement("select * from users where id=?");
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next(); // 행 순차 탐색
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
