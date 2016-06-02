package com.taojt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by taojt on 2016/6/3.
 */
public class DBUtil {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_test";
    private static final String user = "root";
    private static final String password = "12345";

    public static void  main(String[] args) throws Exception{

        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 创建连接
        Connection connection = DriverManager.getConnection(url,user,password);
        //3.操作数据库
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM godness");

        while (resultSet.next()){
            System.out.println(resultSet.getString("username"));
        }


    }
}
