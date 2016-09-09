package be.ing.cts.hackathon.smart_advice.controller;

import be.ing.cts.hackathon.smart_advice.dao.TransactionDao;
import be.ing.cts.hackathon.smart_advice.model.Transaction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SmartAdviceRestController {

  private TransactionDao transactionDao;

  @Autowired
  public SmartAdviceRestController(final TransactionDao transactionDao) {
    this.transactionDao = transactionDao;
  }

  @RequestMapping(value = "/transaction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Transaction>> listAllTransactions() {
    List<Transaction> transactions = transactionDao.listAllTransactions();
    if (transactions.isEmpty()) {
      return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
  }

  @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Transaction> getTransaction(@PathVariable("id") long id) {
    System.out.println("Fetching Transaction with id " + id);
    Transaction transaction = transactionDao.getTransaction(id);
    System.out.println("Fetching Transaction " + transaction.toString());
    if (transaction == null) {
      System.out.println("Transaction with id " + id + " not found");
      return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
  }
}
