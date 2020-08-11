package dao;

import entity.Company;

import java.sql.SQLException;
import java.util.List;

public interface SuperDAO <T,ID>{
     List<T> getAll() throws SQLException;
     T get(ID pk) throws SQLException;
     boolean save(T object) throws SQLException;
     boolean delete(ID pk) throws SQLException;
     boolean update(T object) throws SQLException;
}
