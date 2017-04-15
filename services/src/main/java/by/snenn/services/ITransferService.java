package by.snenn.services;


import java.util.List;

public interface ITransferService {

    List getAllTransfers();

    String createTransfer(int idCardSender, int idCardRecepient, int sum );

    List getTransfersLimit(int startNumber, int countFields);

    List getTransfersLimitByUser(int startNumber, int countFields, int idUser);

    int getCountTransfers();
}
