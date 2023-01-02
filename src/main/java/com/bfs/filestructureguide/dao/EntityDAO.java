package com.bfs.filestructureguide.dao;


import com.bfs.filestructureguide.domain.Entity;

import java.sql.SQLException;
import java.util.ArrayList;


public interface EntityDAO<T extends Entity> {

    public abstract int save(T entity) throws SQLException;

    public abstract ArrayList<T> findAll();

    public abstract T findById(Integer id);

    public abstract void update(T entity);

    public abstract void delete(Integer id);
    
}
