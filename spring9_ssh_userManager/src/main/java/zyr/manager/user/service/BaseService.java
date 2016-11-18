package zyr.manager.user.service;

import java.util.List;
import java.util.Objects;

/**
 * Created by zhouweitao on 2016/11/15.
 *
 */
public class BaseService<T> implements IBaseService<T> {
    @Override
    public void add(T T) {

    }

    @Override
    public void del(int id) {

    }

    @Override
    public void update(T T) {

    }

    @Override
    public T findOne(int id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> list(String hql, Objects... obj) {
        return null;
    }
}
