package be.ing.cts.hackathon.smart_advice.impl;

import be.ing.cts.hackathon.smart_advice.dao.TransactionDao;
import be.ing.cts.hackathon.smart_advice.model.Transaction;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TransactionDaoImpl implements TransactionDao {

  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public Transaction getTransaction(long transactionId) {
    Session session = this.sessionFactory.getCurrentSession();
    Query query = session.createQuery("from Transaction where transaction_id = :txnId");
    query.setParameter("txnId", transactionId);
    return (Transaction) query.uniqueResult();
  }

  public List<Transaction> listAllTransactions() {
    Session session = this.sessionFactory.getCurrentSession();
    Query query = session.createQuery("from Transaction");
    return query.list();
  }
}
