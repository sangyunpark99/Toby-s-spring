package com.example.toby_spring;

import com.example.toby_spring.dao.UserDao;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TobySpringApplication {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //SpringApplication.run(TobySpringApplication.class, args);
        UserDao userDao = new UserDao();

        User user = new User();
        user.setId("gloria");
        user.setName("박상윤");
        user.setPassword("abc");

        userDao.add(user);

        System.out.println(user.getId() +  " 등록 성공");

        User user2 = userDao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
    }

}
