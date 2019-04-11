package com.qf.mapper;

import com.qf.Entity.User;

import java.util.List;

public interface baseMapper<T> {
    public List<T> queryAll(int id);
    public Integer insertInfo(T t);
    public List<T>  query(String name);
}
