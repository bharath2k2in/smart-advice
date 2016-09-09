package be.ing.cts.hackathon.smart_advice.dao;

import be.ing.cts.hackathon.smart_advice.model.Transaction;
import java.util.List;

public interface TransactionDao {

  Transaction getTransaction(long transactionId);

  List<Transaction> listAllTransactions();
}
