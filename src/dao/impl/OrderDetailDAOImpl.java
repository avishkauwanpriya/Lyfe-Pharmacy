package dao.impl;

import dao.CrudUtil;
import dao.OrderDetailDAO;
import dao.SuperDAO;
import db.DBConnection;
import entity.OrderDetail;
import entity.OrderDetailPK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    /* public  List<Object> getAll(){
       ArrayList<Object> ordersDetails = new ArrayList<>();
       try {
           Connection connection = DBConnection.getInstance().getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orderdetail");
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next()){
               ordersDetails.add(new OrderDetail(resultSet.getString(1),
                       resultSet.getString(2),
                       resultSet.getBigDecimal(3),
                       resultSet.getBigDecimal(4)

               ));

           }
       } catch (SQLException e) {
           e.printStackTrace();
           return  null;
       }
       return  ordersDetails;


   }
   public  Object get(Object orderDetailPK){
       OrderDetailPK orderDetailPK1 = (OrderDetailPK) orderDetailPK;
       try {
           Connection connection = DBConnection.getInstance().getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orderdetail WHERE orderId=(?) AND itemCode=(?)");
           preparedStatement.setObject(1,orderDetailPK1.getOrderId());
           preparedStatement.setObject(2,orderDetailPK1.getItemCode());

           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               return new OrderDetail(resultSet.getString(1),
                               resultSet.getString(2),
                               resultSet.getBigDecimal(3),
                               resultSet.getBigDecimal(4)

               );
           }
       } catch (SQLException e) {
           e.printStackTrace();
           return  null;
       }
       return  null;

   }
   public  boolean save(Object orderDetail){
       OrderDetail orderDetail1 = (OrderDetail)orderDetail;
       try {
           Connection connection = DBConnection.getInstance().getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orderdetail VALUES (?,?,?,?)");
           preparedStatement.setObject(1, orderDetail1.getOrderDetailPK().getOrderId());
           preparedStatement.setObject(2, orderDetail1.getOrderDetailPK().getItemCode());
           preparedStatement.setObject(3,orderDetail1.getQty());
           preparedStatement.setObject(4,orderDetail1.getUnitPrice());

           return preparedStatement.executeUpdate()>0;

       } catch (SQLException e) {
           e.printStackTrace();
           return false;

       }

   }
   public  boolean delete(Object orderDetailPK){
       OrderDetailPK orderDetailPK1 = (OrderDetailPK)orderDetailPK;
       try {
           Connection connection = DBConnection.getInstance().getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orderdetail WHERE orderId=(?) AND itemCode=(?)");
           preparedStatement.setObject(1, orderDetailPK1.getOrderId());
           preparedStatement.setObject(1, orderDetailPK1.getItemCode());

           return preparedStatement.executeUpdate()>0;

       } catch (SQLException e) {
           e.printStackTrace();
           return false;

       }


   }
   public  boolean update(Object orderDetail){
       OrderDetail orderDetail1 = (OrderDetail)orderDetail;
       try {
           Connection connection = DBConnection.getInstance().getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orderdetail SET qty=(?),unitPrice=(?) WHERE orderId=(?) AND itemCode=(?)");
           preparedStatement.setObject(1, orderDetail1.getQty());
           preparedStatement.setObject(2, orderDetail1.getUnitPrice());
           preparedStatement.setObject(3, orderDetail1.getOrderDetailPK().getOrderId());
           preparedStatement.setObject(3, orderDetail1.getOrderDetailPK().getItemCode());


           return preparedStatement.executeUpdate()>0;
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return false;


   }
*/
    @Override
    public List<OrderDetail> getAll() {
        ArrayList<OrderDetail> ordersDetails = new ArrayList<>();
        try {
        /*    Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orderdetail");
            ResultSet resultSet = preparedStatement.executeQuery();*/
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM orderdetail");
            while(resultSet.next()){
                ordersDetails.add(new OrderDetail(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getBigDecimal(3),
                        resultSet.getBigDecimal(4)

                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  ordersDetails;


    }

    @Override
    public OrderDetail get(OrderDetailPK pk) {
        OrderDetailPK orderDetailPK1 = (OrderDetailPK) pk;
        try {
            /*Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orderdetail WHERE orderId=(?) AND itemCode=(?)");
            preparedStatement.setObject(1,orderDetailPK1.getOrderId());
            preparedStatement.setObject(2,orderDetailPK1.getItemCode());

            ResultSet resultSet = preparedStatement.executeQuery();*/
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM orderdetail WHERE orderId=(?) AND itemCode=(?)",pk);
            if(resultSet.next()){
                return new OrderDetail(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getBigDecimal(3),
                        resultSet.getBigDecimal(4)

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;


    }

    @Override
    public boolean save(OrderDetail object) {
        OrderDetail orderDetail1 = (OrderDetail) object;
        try {
          /*  Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orderdetail VALUES (?,?,?,?)");
            preparedStatement.setObject(1, orderDetail1.getOrderDetailPK().getOrderId());
            preparedStatement.setObject(2, orderDetail1.getOrderDetailPK().getItemCode());
            preparedStatement.setObject(3, orderDetail1.getQty());
            preparedStatement.setObject(4, orderDetail1.getUnitPrice());

            return preparedStatement.executeUpdate() > 0;*/
          return CrudUtil.execute("INSERT INTO orderdetail VALUES (?,?,?,?)",
                  orderDetail1.getOrderDetailPK().getOrderId(),
                  orderDetail1.getOrderDetailPK().getItemCode(),
                  orderDetail1.getQty(),
                  orderDetail1.getUnitPrice()
                  );

        } catch (SQLException e) {
            e.printStackTrace();
            return false;


        }
    }

    @Override
    public boolean delete(OrderDetailPK pk) {
        OrderDetailPK orderDetailPK1 = (OrderDetailPK)pk;
        try {
         /*   Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orderdetail WHERE orderId=(?) AND itemCode=(?)");
            preparedStatement.setObject(1, orderDetailPK1.getOrderId());
            preparedStatement.setObject(1, orderDetailPK1.getItemCode());

            return preparedStatement.executeUpdate()>0;*/
         return CrudUtil.execute("DELETE FROM orderdetail WHERE orderId=(?) AND itemCode=(?)",
                 orderDetailPK1.getOrderId(),
                 orderDetailPK1.getItemCode()
                 );

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }


    }

    @Override
    public boolean update(OrderDetail object) {
        OrderDetail orderDetail1 = (OrderDetail)object;
        try {
          /*  Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orderdetail SET qty=(?),unitPrice=(?) WHERE orderId=(?) AND itemCode=(?)");
            preparedStatement.setObject(1, orderDetail1.getQty());
            preparedStatement.setObject(2, orderDetail1.getUnitPrice());
            preparedStatement.setObject(3, orderDetail1.getOrderDetailPK().getOrderId());
            preparedStatement.setObject(3, orderDetail1.getOrderDetailPK().getItemCode());


            return preparedStatement.executeUpdate()>0;*/
          return CrudUtil.execute("UPDATE orderdetail SET qty=(?),unitPrice=(?) WHERE orderId=(?) AND itemCode=(?)",
                  orderDetail1.getQty(),
                  orderDetail1.getUnitPrice(),
                  orderDetail1.getOrderDetailPK().getOrderId(),
                  orderDetail1.getOrderDetailPK().getItemCode()



                  );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    }


