package dao.impl;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import db.DBConnection;
import entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO{
 /*   public  List<Object> getAll(){
        ArrayList<Object> orders = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `order`");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                orders.add(new Order(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3)

                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  orders;

    }
    public  Order get(Object orderId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `order` WHERE orderId=(?)");
            preparedStatement.setObject(1,orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Order(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3)

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;

    }
    public  boolean save(Object order){
        Order order1 = (Order)order;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `order` VALUES (?,?,?)");
            preparedStatement.setObject(1, order1.getOrderId());
            preparedStatement.setObject(2, order1.getEmpId());
            preparedStatement.setObject(3, order1.getOrderDate());



            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
    public  boolean delete(Object orderId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `order` WHERE orderId=(?)");
            preparedStatement.setObject(1, orderId);
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean update(Object order){
        Order order1 = (Order)order;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `order` SET empId=(?),orderDate=(?) WHERE orderId=(?)");
            preparedStatement.setObject(1, order1.getEmpId());
            preparedStatement.setObject(2, order1.getOrderDate());
            preparedStatement.setObject(3, order1.getOrderId());


            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }*/



    @Override
    public List<Order> getAll(){
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `order`");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                orders.add(new Order(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3)

                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  orders;

    }

    @Override
    public Order get(String pk) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `order` WHERE orderId=(?)");
            preparedStatement.setObject(1,pk);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Order(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3)

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;


    }

    @Override
    public boolean save(Order object) {
        Order order1 = (Order)object;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `order` VALUES (?,?,?)");
            preparedStatement.setObject(1, order1.getOrderId());
            preparedStatement.setObject(2, order1.getEmpId());
            preparedStatement.setObject(3, order1.getOrderDate());



            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }


    }

    @Override
    public boolean delete(String pk) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `order` WHERE orderId=(?)");
            preparedStatement.setObject(1, pk);
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }


    }

    @Override
    public boolean update(Order object) {
        Order order1 = (Order)object;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `order` SET empId=(?),orderDate=(?) WHERE orderId=(?)");
            preparedStatement.setObject(1, order1.getEmpId());
            preparedStatement.setObject(2, order1.getOrderDate());
            preparedStatement.setObject(3, order1.getOrderId());


            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    public  String getLastOrderId(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `order` ORDER BY orderId DESC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString(1);

            }

            return "O001";



        } catch (SQLException e) {
            e.printStackTrace();
            return null;


        }


    }
}
