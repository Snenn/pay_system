package by.snenn.services;


import java.util.List;

public interface IServiceForPaginator {

    List creditCardsForPaginator(int startNumber, int countFields);

    List creditCardsStatusForPaginator();

    int creditCardsCountForPaginator();
}
