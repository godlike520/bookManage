package com.cors;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.*;

//数据库连接池c3p0
public class JDBCUtil {
    //连接池对象
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    //获取连接池
    public static ComboPooledDataSource getComboPooledDataSource(){
        return comboPooledDataSource;
    }

    //获取连接池中连接对象
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //释放资源
    public static void releaseDBconnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        closeresultSet(resultSet);
        closepreparedStatement(preparedStatement);
        closeConnection(connection);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection = null;
            }
        }
    }

    public static void closepreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                preparedStatement = null;
            }
        }
    }

    public static void closeresultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                resultSet = null;
            }
        }
    }


}
