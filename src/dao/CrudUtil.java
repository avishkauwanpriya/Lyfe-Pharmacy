package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CrudUtil {
    /*public static Boolean executeUpdate(String sql,Object...params) throws SQLException {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int i=0;
            for(Object object:params){
                preparedStatement.setObject((i+1),object);
                i++;
            }
            return preparedStatement.executeUpdate()>0;



    }
    public static ResultSet executeQuery(String sql, Object...params) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i=0;
        for (Object object:params) {
            preparedStatement.setObject((i+1),object);
            i++;

        }
        return  preparedStatement.executeQuery();


    }*/
    public static<T> T execute(String sql,Object...params) throws SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i=1;
        for (Object object:params) {
            preparedStatement.setObject(i,object);
            i++;
        }
        if(sql.startsWith("SELECT")){
            ResultSet resultSet = preparedStatement.executeQuery();
            return (T)resultSet;
        }
        else{
            return (T)((Boolean)(preparedStatement.executeUpdate()>0));
        }


    }
}
