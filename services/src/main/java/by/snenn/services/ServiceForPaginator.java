package by.snenn.services;




import by.snenn.dao.ICreditCardDao;
import by.snenn.dao.ICreditCardStatusDao;
import by.snenn.pojos.CreditCard;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceForPaginator implements IServiceForPaginator {

    private Logger logger = Logger.getLogger(ServiceForPaginator.class.getName());

    @Autowired
    private ICreditCardDao creditCardDao;
    @Autowired
    private ICreditCardStatusDao creditCardStatusDao;


    public List creditCardsForPaginator(int startNumber, int countFields) {
        return (List<CreditCard>) creditCardDao.getAllLimit(startNumber, countFields);
    }

    public List creditCardsStatusForPaginator() {
        return creditCardStatusDao.getAll();
    }

    public int creditCardsCountForPaginator() {
        return creditCardDao.getCount();
    }

}
