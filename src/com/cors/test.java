package com.cors;


import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {

        ResultSet resultSet = null;
        ConneDB conneDB = new ConneDB();
        try {
               resultSet = conneDB.getResultSet("select * from student");
            while (resultSet.next()){
                int id = resultSet.getInt("stuid");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(id+name+age);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conneDB.release();
            JDBCUtil.closeresultSet(resultSet);
        }
    }
}
