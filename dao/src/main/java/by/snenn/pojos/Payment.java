package by.snenn.pojos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
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
    @Column
    private int idCreditCard;
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

    public int getIdCreditCard() {
        return idCreditCard;
    }

    public void setIdCreditCard(int idCreditCard) {
        this.idCreditCard = idCreditCard;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Payment(int sum, int idCreditCard) {
        this.sum = sum;
        this.idCreditCard = idCreditCard;
    }

    public Payment() {

    }
}