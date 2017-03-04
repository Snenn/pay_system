package by.snenn.dao;


import java.util.List;

public interface IUserRoleDao<T> extends IDao<T> {
    List getAll();
}
