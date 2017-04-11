package by.snenn.services.daoImpl;


import by.snenn.dao.ITransferDao;
import by.snenn.pojos.Transfer;
import by.snenn.services.ITransferService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
@Service
@Transactional
public class TransferService implements ITransferService{


    @Autowired
    private ITransferDao dao ;

    private Logger logger= Logger.getLogger(CreditCardService.class.getName());
    private String messages = null;

    @Override
    public List getAllTransfers() {
        List<Transfer> transfers=dao.getAll();
        return transfers;
    }

    @Override
    public String createTransfer(int idCardSender, int idCardRecipient, int sum) {
        try {
            Transfer transfer=new Transfer();
            transfer.setSum(sum);
            transfer.setIdCardSender(idCardSender);
            transfer.setIdCardRecipient(idCardRecipient);
            transfer.setData(Calendar.getInstance().getTime());
            dao.saveOrUpdate(transfer);
            messages="transfer save";
        } catch (Exception e) {
            messages="transfer error, please try again";
        }
        return messages;
    }

    @Override
    public List getTransfersLimit(int startNumber, int countFields) {
        return (List<Transfer>) dao.getAllLimit(startNumber, countFields);
    }

    @Override
    public int getCountTransfers() {
        return dao.getCount();
    }
}
