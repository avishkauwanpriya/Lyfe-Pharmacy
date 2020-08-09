package dao.impl;

import dao.EmployeeDAO;
import db.DBConnection;
import entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
      /* public  List<Object> getAll(){
        ArrayList<Object> employees = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                employees.add(new Employee(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getString(8)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  employees;


    }
    public  Object get(Object key){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE empId=(?)");
            preparedStatement.setObject(1,key);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Employee(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getString(8)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;


    }
    public  boolean save(Object employee){
        Employee employee1 = (Employee)employee;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setObject(1, employee1.getEmpId());
            preparedStatement.setObject(2, employee1.getEmpName());
            preparedStatement.setObject(3, employee1.getEmpAddress());
            preparedStatement.setObject(4, employee1.getEmail());
            preparedStatement.setObject(5, employee1.getContactNo());
            preparedStatement.setObject(4, employee1.getDateOfBirth());
            preparedStatement.setObject(4, employee1.getJoinedDate());
            preparedStatement.setObject(4, employee1.getSalary());
            preparedStatement.setObject(4, employee1.getGender());


            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean delete(Object key){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE empId=(?)");
            preparedStatement.setObject(1, key);
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean update(Object employee){
        Employee employee1 = (Employee)employee;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET empName=(?),empAddress=(?),email=(?),contactNo=(?),dateOfBirth=(?),joinedDate=(?),salary=(?),gender=(?) WHERE empId=(?)");
            preparedStatement.setObject(9, employee1.getEmpId());
            preparedStatement.setObject(1, employee1.getEmpName());
            preparedStatement.setObject(2, employee1.getEmpAddress());
            preparedStatement.setObject(3, employee1.getEmail());
            preparedStatement.setObject(4, employee1.getContactNo());
            preparedStatement.setObject(5, employee1.getDateOfBirth());
            preparedStatement.setObject(6, employee1.getJoinedDate());
            preparedStatement.setObject(7, employee1.getSalary());
            preparedStatement.setObject(8, employee1.getGender());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }*/


    @Override
    public List<Employee> getAll() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                employees.add(new Employee(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getString(8)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  employees;


    }

    @Override
    public Employee get(String pk) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE empId=(?)");
            preparedStatement.setObject(1,pk);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Employee(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getString(8)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;



    }

    @Override
    public boolean save(Employee object) {
        Employee employee1 = (Employee)object;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setObject(1, employee1.getEmpId());
            preparedStatement.setObject(2, employee1.getEmpName());
            preparedStatement.setObject(3, employee1.getEmpAddress());
            preparedStatement.setObject(4, employee1.getEmail());
            preparedStatement.setObject(5, employee1.getContactNo());
            preparedStatement.setObject(4, employee1.getDateOfBirth());
            preparedStatement.setObject(4, employee1.getJoinedDate());
            preparedStatement.setObject(4, employee1.getSalary());
            preparedStatement.setObject(4, employee1.getGender());


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
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE empId=(?)");
            preparedStatement.setObject(1, pk);
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }


    }

    @Override
    public boolean update(Employee object) {
        Employee employee1 = (Employee)object;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET empName=(?),empAddress=(?),email=(?),contactNo=(?),dateOfBirth=(?),joinedDate=(?),salary=(?),gender=(?) WHERE empId=(?)");
            preparedStatement.setObject(9, employee1.getEmpId());
            preparedStatement.setObject(1, employee1.getEmpName());
            preparedStatement.setObject(2, employee1.getEmpAddress());
            preparedStatement.setObject(3, employee1.getEmail());
            preparedStatement.setObject(4, employee1.getContactNo());
            preparedStatement.setObject(5, employee1.getDateOfBirth());
            preparedStatement.setObject(6, employee1.getJoinedDate());
            preparedStatement.setObject(7, employee1.getSalary());
            preparedStatement.setObject(8, employee1.getGender());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;



    }

    public  String getLastEmployeeId(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee ORDER BY empId DESC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString(1);

            }

            return "E001";



        } catch (SQLException e) {
            e.printStackTrace();
            return null;


        }


    }


}
