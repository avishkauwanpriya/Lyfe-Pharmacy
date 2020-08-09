package dao.impl;

import dao.CompanyDAO;
import db.DBConnection;
import entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {
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
    public List<CompanyDAO> getAll() {
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

    @Override
    public CompanyDAO get(String pk) {
        return null;
    }

    @Override
    public boolean save(CompanyDAO object) {
        return false;
    }

    @Override
    public boolean delete(String pk) {
        return false;
    }

    @Override
    public boolean update(CompanyDAO object) {
        return false;
    }

    public  String getLastCompanyId(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company ORDER BY companyId DESC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString(1);

            }

            return "C001";



        } catch (SQLException e) {
            e.printStackTrace();
            return null;


        }


    }
}
