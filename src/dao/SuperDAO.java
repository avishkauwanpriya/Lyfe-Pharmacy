package dao;

import entity.Company;

import java.util.List;

public interface SuperDAO <T,ID>{
     List<T> getAll();
     T get(ID pk);
     boolean save(T object);
     boolean delete(ID pk);
     boolean update(T object);
}
