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
@Table(name = "TRANSFER")
public class Transfer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int sum;
    @Column
    private int idCardSender;
    @Column
    private int idCardRecipient;
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

    public int getIdCardSender() {
        return idCardSender;
    }

    public void setIdCardSender(int idCardSender) {
        this.idCardSender = idCardSender;
    }

    public int getIdCardRecipient() {
        return idCardRecipient;
    }

    public void setIdCardRecipient(int idCardRecipient) {
        this.idCardRecipient = idCardRecipient;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Transfer(int sum, int idCardSender, int idCardRecipient ) {
        this.sum = sum;
        this.idCardSender = idCardSender;
        this.idCardRecipient =idCardRecipient;
    }

    public Transfer() {

    }
}