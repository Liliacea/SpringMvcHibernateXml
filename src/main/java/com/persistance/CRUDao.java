package com.persistance;

import java.util.List;

public interface CRUDao <T,R> {
    T insert(T t);
    T update(T t);
    List<T> select();
    T findById(R id);
    T delete(T t);


}
