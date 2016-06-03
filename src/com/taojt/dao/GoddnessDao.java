package com.taojt.dao;

import com.taojt.db.DBUtil;
import com.taojt.model.Goddness;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by taojt on 2016/6/3.
 */
public class GoddnessDao {
    public void addGoddness(Goddness goddness) throws Exception {
        Connection connection = DBUtil.getConnection();
        String sql = "" + "insert into goddness" + "(username,sex,age,"
                + "birthday,email,mobile,create_user,update_user,create_date,update_date,isdel)"
                + "values(" + "?,?,?,?,?,?,?,?,current_date(),current_date(),?);";

        // 预编译SQL语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, goddness.getUsername());
        preparedStatement.setInt(2, goddness.getSex());
        preparedStatement.setInt(3, goddness.getAge());
        // 其中有Java Date 与SQL Date的转换
        preparedStatement.setDate(4, new Date(goddness.getBirthday().getTime()));
        preparedStatement.setString(5, goddness.getEmail());
        preparedStatement.setString(6, goddness.getMobile());
        preparedStatement.setString(7, goddness.getCreate_user());
        preparedStatement.setString(8, goddness.getUpdate_user());
        preparedStatement.setInt(9, goddness.getIsdel());

        // 执行sql语句
        preparedStatement.execute();

    }

    public void updateGoddness(Goddness goddness) throws Exception {
        Connection connection = DBUtil.getConnection();
        String sql = "" + " update goddness" + " set username=?,sex=?,age=?,"
                + "birthday=?,email=?,mobile=?,update_user=?,update_date=current_date(),isdel=?" + " where id=?";

        // 预编译SQL语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, goddness.getUsername());
        preparedStatement.setInt(2, goddness.getSex());
        preparedStatement.setInt(3, goddness.getAge());
        // 其中有Java Date 与SQL Date的转换
        preparedStatement.setDate(4, new Date(goddness.getBirthday().getTime()));
        preparedStatement.setString(5, goddness.getEmail());
        preparedStatement.setString(6, goddness.getMobile());
        preparedStatement.setString(7, goddness.getCreate_user());
        preparedStatement.setInt(8, goddness.getIsdel());
        preparedStatement.setInt(9, goddness.getId());

        // 执行sql语句
        preparedStatement.execute();

    }

    public void delGoddness(int id) throws Exception {
        Connection connection = DBUtil.getConnection();
        String sql = "" + " DELETE FROM " + " goddness" + " where id=?";

        // 预编译SQL语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);

        // 执行sql语句
        preparedStatement.execute();

    }

    public List<Goddness> query() throws Exception {
        Connection connection = DBUtil.getConnection();
        //3.操作数据库
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM goddness");
        List<Goddness> gs = new ArrayList<Goddness>();
        Goddness g = null;
        while (resultSet.next()) {
            g = new Goddness();
            g.setUsername(resultSet.getString("username"));
            g.setAge(resultSet.getInt("age"));
            gs.add(g);
        }
        return gs;
    }

    public List<Goddness> query(String name) throws Exception {
        List<Goddness> result = new ArrayList<Goddness>();
        Connection connection = DBUtil.getConnection();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from goddness ");
        stringBuilder.append(" where username=?");

        PreparedStatement preparedStatement = connection.prepareStatement(stringBuilder.toString());
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        Goddness g = null;
        while (resultSet.next()) {
            g = new Goddness();
            g.setUsername(resultSet.getString("username"));
            g.setAge(resultSet.getInt("age"));
            g.setSex(resultSet.getInt("sex"));
            g.setBirthday(resultSet.getDate("birthday"));
            g.setEmail(resultSet.getString("email"));
            g.setMobile(resultSet.getString("mobile"));
            g.setCreate_user(resultSet.getString("create_user"));
            g.setUpdate_user(resultSet.getString("update_user"));
            g.setCreate_date(resultSet.getDate("update_date"));
            g.setUpdate_date(resultSet.getDate("update_date"));
            g.setIsdel(resultSet.getInt("isdel"));
            result.add(g);
        }
        return result;

    }


    public List<Goddness> query(List<Map<String, Object>> params) throws Exception {
        List<Goddness> result = new ArrayList<Goddness>();
        Connection connection = DBUtil.getConnection();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from goddness where 1=1");

        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                Map<String, Object> map = params.get(i);
                stringBuilder.append(" and " + map.get("name") + " " + map.get("real") + " " + map.get("value"));
            }
        }

        PreparedStatement preparedStatement = connection.prepareStatement(stringBuilder.toString());
        ResultSet resultSet = preparedStatement.executeQuery();

        Goddness g = null;
        while (resultSet.next()) {
            g = new Goddness();
            g.setUsername(resultSet.getString("username"));
            g.setAge(resultSet.getInt("age"));
            g.setSex(resultSet.getInt("sex"));
            g.setBirthday(resultSet.getDate("birthday"));
            g.setEmail(resultSet.getString("email"));
            g.setMobile(resultSet.getString("mobile"));
            g.setCreate_user(resultSet.getString("create_user"));
            g.setUpdate_user(resultSet.getString("update_user"));
            g.setCreate_date(resultSet.getDate("update_date"));
            g.setUpdate_date(resultSet.getDate("update_date"));
            g.setIsdel(resultSet.getInt("isdel"));
            result.add(g);
        }
        return result;

    }

    public Goddness get(int id) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql = "" + " SELECT * FROM " + " goddness" + " where id=?";

        // 预编译SQL语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);

        // 执行sql语句
        ResultSet resultSet = preparedStatement.executeQuery();
        Goddness g = null;
        while (resultSet.next()) {
            g = new Goddness();
            g.setUsername(resultSet.getString("username"));
            g.setAge(resultSet.getInt("age"));
            g.setSex(resultSet.getInt("sex"));
            g.setBirthday(resultSet.getDate("birthday"));
            g.setEmail(resultSet.getString("email"));
            g.setMobile(resultSet.getString("mobile"));
            g.setCreate_user(resultSet.getString("create_user"));
            g.setUpdate_user(resultSet.getString("update_user"));
            g.setCreate_date(resultSet.getDate("update_date"));
            g.setUpdate_date(resultSet.getDate("update_date"));
            g.setIsdel(resultSet.getInt("isdel"));
        }
        return g;
    }

}
