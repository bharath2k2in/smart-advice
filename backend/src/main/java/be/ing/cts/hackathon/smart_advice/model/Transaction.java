package be.ing.cts.hackathon.smart_advice.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Table(name = "TRANSACTION", uniqueConstraints = {@UniqueConstraint(columnNames = {"TRANSACTION_ID"})})
public class Transaction {

  private long txnId;
  private String customerName;
  private String merchantName;
  private String txnType;
  private double amount;
  private Date txnDate;

  public Transaction() {
  }

  public Transaction(long txnId, String customerName, String merchantName, String txnType, double amount, Date txnDate) {
    this.txnId = txnId;
    this.customerName = customerName;
    this.merchantName = merchantName;
    this.txnType = txnType;
    this.amount = amount;
    this.txnDate = txnDate;
  }

  @Id
  @Column(name = "TRANSACTION_ID")
  public long getTxnId() {
    return txnId;
  }

  public void setTxnId(long txnId) {
    this.txnId = txnId;
  }

  @Column(name = "CUSTOMER_NAME")
  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  @Column(name = "MERCHANT_NAME")
  public String getMerchantName() {
    return merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  @Column(name = "TXN_TYPE")
  public String getTxnType() {
    return txnType;
  }

  public void setTxnType(String txnType) {
    this.txnType = txnType;
  }

  @Column(name = "AMOUNT")
  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  @Column(name = "TXN_DATE")
  public Date getTxnDate() {
    return txnDate;
  }

  public void setTxnDate(Date txnDate) {
    this.txnDate = txnDate;
  }

  @Override
  public String toString() {
    return "Transaction [id=" + txnId + ", customerName=" + customerName + ", merchantName=" + merchantName
      + ", txnType=" + txnType + ", amount=" + amount + ", date=" + txnDate + "]";
  }

}
