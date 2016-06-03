package com.taojt.db;

import java.sql.*;

/**
 * Created by taojt on 2016/6/3.
 */
public class DBUtil {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_test?characterEncoding=utf-8";
    private static final String user = "root";
    private static final String password = "12345";

    private static Connection connection = null;

    static {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2. 创建连接
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
