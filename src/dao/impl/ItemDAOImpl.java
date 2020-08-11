package dao.impl;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import dao.CrudUtil;
import dao.ItemDAO;
import db.DBConnection;
import entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
 /*   public  List<Object> getAll(){
        ArrayList<Object> items = new ArrayList<>();
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                items.add(new Item(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getBigDecimal(8),
                        resultSet.getBigDecimal(9),
                        resultSet.getBigDecimal(10),
                        resultSet.getBigDecimal(11)


                ));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;


    }
    public  Object get(Object key){
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *  FROM lyfepharmacy.item WHERE itemCode=(?)");
            preparedStatement.setObject(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Item(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getBigDecimal(8),
                        resultSet.getBigDecimal(9),
                        resultSet.getBigDecimal(10),
                        resultSet.getBigDecimal(11)
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public  boolean save(Object item){
        Item item1 = (Item)item;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO lyfepharmacy.item VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setObject(1,item1.getItemCode());
            preparedStatement.setObject(2,item1.getDescription());
            preparedStatement.setObject(3,item1.getCategory());
            preparedStatement.setObject(4,item1.getManufacturer());
            preparedStatement.setObject(5,item1.getProductionDate());
            preparedStatement.setObject(6,item1.getExpiryDate());
            preparedStatement.setObject(7,item1.getBuyingPrice());
            preparedStatement.setObject(8,item1.getSellingPrice());
            preparedStatement.setObject(9,item1.getMinimumStockLevel());
            preparedStatement.setObject(9,item1.getQtyOnHand());
            preparedStatement.setObject(9,item1.getUnitPrice());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public  boolean delete(Object key){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM lyfepharmacy.item WHERE lyfepharmacy.item.itemCode=(?)");
            preparedStatement.setObject(1, key);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public  boolean update(Object item){
        Item item1 = (Item) item;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item SET description=(?),category=(?),manufacturer=(?),productionDate=(?),expiryDate=(?),buyingPrice=(?),sellingPrice=(?),minimumStockLevel=(?),qtyOnHand=(?),unitPrice=(?) WHERE itemCode=(?)");
            preparedStatement.setObject(11,item1.getItemCode());
            preparedStatement.setObject(1,item1.getDescription());
            preparedStatement.setObject(2,item1.getCategory());
            preparedStatement.setObject(3,item1.getManufacturer());
            preparedStatement.setObject(4,item1.getProductionDate());
            preparedStatement.setObject(5,item1.getExpiryDate());
            preparedStatement.setObject(6,item1.getBuyingPrice());
            preparedStatement.setObject(7,item1.getSellingPrice());
            preparedStatement.setObject(8,item1.getMinimumStockLevel());
            preparedStatement.setObject(9,item1.getQtyOnHand());
            preparedStatement.setObject(10,item1.getUnitPrice());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }*/


    @Override
    public List<Item> getAll() {
        ArrayList<Item> items = new ArrayList<>();
        try {

           /* Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet = preparedStatement.executeQuery();*/
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM item");
            while (resultSet.next()) {
                items.add(new Item(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getBigDecimal(8),
                        resultSet.getBigDecimal(9),
                        resultSet.getBigDecimal(10),
                        resultSet.getBigDecimal(11)


                ));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;


    }

    @Override
    public Item get(String pk) {
        try {

           /* Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *  FROM lyfepharmacy.item WHERE itemCode=(?)");
            preparedStatement.setObject(1, pk);
            ResultSet resultSet = preparedStatement.executeQuery();*/
            ResultSet resultSet = CrudUtil.execute("SELECT *  FROM lyfepharmacy.item WHERE itemCode=(?)",pk);
            if (resultSet.next()) {
                return new Item(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getBigDecimal(8),
                        resultSet.getBigDecimal(9),
                        resultSet.getBigDecimal(10),
                        resultSet.getBigDecimal(11)
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean save(Item object) {
        Item item1 = (Item)object;
        try {
          /*  Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO lyfepharmacy.item VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setObject(1,item1.getItemCode());
            preparedStatement.setObject(2,item1.getDescription());
            preparedStatement.setObject(3,item1.getCategory());
            preparedStatement.setObject(4,item1.getManufacturer());
            preparedStatement.setObject(5,item1.getProductionDate());
            preparedStatement.setObject(6,item1.getExpiryDate());
            preparedStatement.setObject(7,item1.getBuyingPrice());
            preparedStatement.setObject(8,item1.getSellingPrice());
            preparedStatement.setObject(9,item1.getMinimumStockLevel());
            preparedStatement.setObject(9,item1.getQtyOnHand());
            preparedStatement.setObject(9,item1.getUnitPrice());

            return preparedStatement.executeUpdate() > 0;*/
          return CrudUtil.execute("INSERT INTO lyfepharmacy.item VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                  item1.getItemCode(),
                  item1.getDescription(),
                  item1.getCategory(),
                  item1.getManufacturer(),
                  item1.getProductionDate(),
                  item1.getExpiryDate(),
                  item1.getBuyingPrice(),
                  item1.getSellingPrice(),
                  item1.getMinimumStockLevel(),
                  item1.getQtyOnHand(),
                  item1.getUnitPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    @Override
    public boolean delete(String pk) {
        try {
           /* Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM lyfepharmacy.item WHERE lyfepharmacy.item.itemCode=(?)");
            preparedStatement.setObject(1, pk);
            return preparedStatement.executeUpdate()>0;*/
           return CrudUtil.execute("DELETE FROM lyfepharmacy.item WHERE lyfepharmacy.item.itemCode=(?)",pk);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean update(Item object) {
        Item item1 = (Item) object;
        try {
          /*  Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item SET description=(?),category=(?),manufacturer=(?),productionDate=(?),expiryDate=(?),buyingPrice=(?),sellingPrice=(?),minimumStockLevel=(?),qtyOnHand=(?),unitPrice=(?) WHERE itemCode=(?)");
            preparedStatement.setObject(11,item1.getItemCode());
            preparedStatement.setObject(1,item1.getDescription());
            preparedStatement.setObject(2,item1.getCategory());
            preparedStatement.setObject(3,item1.getManufacturer());
            preparedStatement.setObject(4,item1.getProductionDate());
            preparedStatement.setObject(5,item1.getExpiryDate());
            preparedStatement.setObject(6,item1.getBuyingPrice());
            preparedStatement.setObject(7,item1.getSellingPrice());
            preparedStatement.setObject(8,item1.getMinimumStockLevel());
            preparedStatement.setObject(9,item1.getQtyOnHand());
            preparedStatement.setObject(10,item1.getUnitPrice());

            return preparedStatement.executeUpdate()>0;*/

         return CrudUtil.execute("UPDATE item SET description=(?),category=(?),manufacturer=(?),productionDate=(?),expiryDate=(?),buyingPrice=(?),sellingPrice=(?),minimumStockLevel=(?),qtyOnHand=(?),unitPrice=(?) WHERE itemCode=(?)",
                  item1.getDescription(),
                  item1.getCategory(),
                  item1.getManufacturer(),
                  item1.getProductionDate(),
                  item1.getExpiryDate(),
                  item1.getBuyingPrice(),
                  item1.getSellingPrice(),
                  item1.getMinimumStockLevel(),
                  item1.getQtyOnHand(),
                  item1.getUnitPrice(),
                  item1.getItemCode()








                  );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    public  String getLastItemCode(){
        try {
         /*   Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lyfepharmacy.item ORDER BY itemCode DESC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();*/
            ResultSet resultSet =  CrudUtil.execute("SELECT * FROM lyfepharmacy.item ORDER BY itemCode DESC LIMIT 1");
            if(resultSet.next()){
                return resultSet.getString(1);

            }

            return "I001";



        } catch (SQLException e) {
            e.printStackTrace();
            return null;


        }


    }
}
