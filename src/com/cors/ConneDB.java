package com.cors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConneDB {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    //获取返回集
    public static ResultSet getResultSet(String sql){
        connection = JDBCUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //释放对象资源
    public static void release(){
        JDBCUtil.releaseDBconnection(resultSet,preparedStatement,connection);
    }





}
