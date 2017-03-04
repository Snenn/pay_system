package by.snenn.pojos;



import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@ToString (exclude = {"creditCards", "user"})
@EqualsAndHashCode(exclude = {"creditCards", "user"})
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private int balance;
    @JoinColumn
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "account", orphanRemoval = true)
    private List<CreditCard> creditCards = new ArrayList<>();

    public Account(int balance, User user, List<CreditCard> creditCards) {
        this.balance = balance;
        this.user = user;
        this.creditCards = creditCards;
    }

    public Account() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
