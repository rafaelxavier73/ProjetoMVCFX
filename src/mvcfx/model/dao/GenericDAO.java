package mvcfx.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface GenericDAO<T> {
    
    public abstract boolean insert(T object);
    public abstract boolean update(T object);
    public abstract boolean delete(int id);
    public abstract ArrayList<T> list();
    public abstract T findbyFilter(T object);
    public abstract T getbyId(int id);
    
}
