package by.snenn.dao;




import java.util.List;

public interface ICreditCardDao<TYPE> extends IDao<TYPE> {

    List<TYPE> getAll() ;

    List getAllByIdAccount(int id) ;

    List<TYPE> getAllLimit(int startNumber, int endNumber) ;

    int getCount();

    int getCountByUser(int id);

    TYPE getLastPost() ;

}
