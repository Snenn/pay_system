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
@Table(name = "ORDER")
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int sum;
    @Column
    private int orderByUsers;


    public Order(int sum, int orderByUsers) {
        this.sum = sum;
        this.orderByUsers = orderByUsers;
    }

    public Order() {

    }
}
