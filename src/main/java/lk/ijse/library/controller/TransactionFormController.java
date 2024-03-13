package lk.ijse.library.controller;

import lk.ijse.library.service.BoFactory;
import lk.ijse.library.service.TransactionService;

public class TransactionFormController {
    TransactionService transactionService= (TransactionService) BoFactory.getBoFactory().getBo(BoFactory.BOType.TRANSACTION);

}
