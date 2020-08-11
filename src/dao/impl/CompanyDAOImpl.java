package dao.impl;

import dao.CompanyDAO;
import dao.CrudUtil;
import db.DBConnection;
import entity.Company;
import entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO{
    /*public  List<Object> getAll(){
        ArrayList<Object> companies = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                companies.add(new Company(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  companies;

    }
    public  Company get(Object key){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company WHERE companyId=(?)");
            preparedStatement.setObject(1,key);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Company(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;

    }
    public  boolean save(Object company){
        Company company1 = (Company)company;

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO company VALUES (?,?,?,?,?)");
            preparedStatement.setObject(1, company1.getCompanyId());
            preparedStatement.setObject(2, company1.getCompanyName());
            preparedStatement.setObject(3, company1.getEntryDate());
            preparedStatement.setObject(4, company1.getCompanyPhoneNo());
            preparedStatement.setObject(5, company1.getCompanyEmail());

            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }


    }
    public  boolean delete(Object key){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM company WHERE companyId=(?)");
            preparedStatement.setObject(1, key);
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean update(Object company){
        Company company1 = (Company)company;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE company SET companyName=(?),entryDate=(?),companyPhoneNo=(?),companyEmail=(?) WHERE companyId=(?)");

            preparedStatement.setObject(1, company1.getCompanyName());
            preparedStatement.setObject(2, company1.getEntryDate());
            preparedStatement.setObject(3, company1.getCompanyPhoneNo());
            preparedStatement.setObject(4, company1.getCompanyEmail());
            preparedStatement.setObject(5, company1.getCompanyId());
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }*/


    @Override
    public List<Company> getAll() throws SQLException {
        ArrayList<Company> companies = new ArrayList<>();

            ResultSet resultSet = CrudUtil.execute("SELECT * FROM company");
            while(resultSet.next()){
                companies.add(new Company(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));

            }

        return  companies;


    }

    @Override
    public Company get(String pk) throws SQLException {

            /*Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company WHERE companyId=(?)");
            preparedStatement.setObject(1,pk);
            ResultSet resultSet = preparedStatement.executeQuery();*/
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM company WHERE companyId=(?)",pk);
            if(resultSet.next()){
                return new Company(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }



        return  null;



    }

    @Override
    public boolean save(Company object) throws SQLException {
        Company company1 = (Company)object;


        /*    Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO company VALUES (?,?,?,?,?)");
            preparedStatement.setObject(1, company1.getCompanyId());
            preparedStatement.setObject(2, company1.getCompanyName());
            preparedStatement.setObject(3, company1.getEntryDate());
            preparedStatement.setObject(4, company1.getCompanyPhoneNo());
            preparedStatement.setObject(5, company1.getCompanyEmail());

            return preparedStatement.executeUpdate()>0;*/
            return CrudUtil.execute("INSERT INTO company VALUES (?,?,?,?,?)", company1.getCompanyId(), company1.getCompanyName(), company1.getEntryDate(), company1.getCompanyPhoneNo(), company1.getCompanyEmail());




    }

    @Override
    public boolean delete(String pk) throws SQLException {

           /* Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM company WHERE companyId=(?)");
            preparedStatement.setObject(1, pk);
            return preparedStatement.executeUpdate()>0;*/
           return CrudUtil.execute("DELETE FROM company WHERE companyId=(?)",pk);




    }

    @Override
    public boolean update(Company object) throws SQLException {

        Company company1 = (Company)object;

           /* Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE company SET companyName=(?),entryDate=(?),companyPhoneNo=(?),companyEmail=(?) WHERE companyId=(?)");

            preparedStatement.setObject(1, company1.getCompanyName());
            preparedStatement.setObject(2, company1.getEntryDate());
            preparedStatement.setObject(3, company1.getCompanyPhoneNo());
            preparedStatement.setObject(4, company1.getCompanyEmail());
            preparedStatement.setObject(5, company1.getCompanyId());
            return preparedStatement.executeUpdate()>0;*/

           return CrudUtil.execute("UPDATE company SET companyName=(?),entryDate=(?),companyPhoneNo=(?),companyEmail=(?) WHERE companyId=(?)",company1.getCompanyName(), company1.getEntryDate(),company1.getCompanyPhoneNo(),company1.getCompanyEmail(),company1.getCompanyId());







    }

    public  String getLastCompanyId() throws SQLException {

          /*  Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company ORDER BY companyId DESC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();*/
          ResultSet resultSet = CrudUtil.execute("SELECT * FROM company ORDER BY companyId DESC LIMIT 1");
            if(resultSet.next()){
                return resultSet.getString(1);

            }

            return "C001";






    }
}
