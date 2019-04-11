package com.qf.service;

import com.qf.Entity.User;

import java.util.List;

public interface baseService<T> {
    public List<T> queryAll(int id);
    public Integer insertUser(T t);
    public List<T>  query(String username);
}
