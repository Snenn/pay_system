package by.snenn.pojos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString (exclude = {"account"})
@EqualsAndHashCode(exclude = {"creditCardStatus", "account"})
@Entity
@Table(name = "CREDIT_CARD")
public class CreditCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private int creditCardStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Account account;
    @Column
    private int viewNumber;



    public CreditCard(int creditCardStatus, Account account, int viewNumber) {
        this.creditCardStatus = creditCardStatus;
        this.account = account;
        this.viewNumber = viewNumber;
    }


    public CreditCard() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreditCardStatus() {
        return creditCardStatus;
    }

    public void setCreditCardStatus(int creditCardStatus) {
        this.creditCardStatus = creditCardStatus;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }
}
