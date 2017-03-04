package by.snenn.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int sum;
    @Column
    private int paymentByCreditCard;


    public Payment(int sum, int paymentByCreditCard) {
        this.sum = sum;
        this.paymentByCreditCard = paymentByCreditCard;
    }

    public Payment() {

    }
}
