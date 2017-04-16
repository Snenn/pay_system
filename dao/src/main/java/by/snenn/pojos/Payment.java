package by.snenn.pojos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString (exclude = {"creditCardPayment"})
@EqualsAndHashCode
@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int sum;
    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private CreditCard creditCardPayment;
    @Column
    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public CreditCard getCreditCard() {
        return creditCardPayment;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCardPayment = creditCard;
    }

    public Payment() {

    }
}