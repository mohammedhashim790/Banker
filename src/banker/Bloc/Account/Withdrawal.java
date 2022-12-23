package banker.Bloc.Account;

import java.util.Date;
import java.util.Random;

public class Withdrawal extends Transaction{

    private Integer userId;
    private Integer id = new Random().nextInt(10000);

    private Date createdAt = new Date();

    private Double amount;

    public Withdrawal(Integer userId, Double amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public Withdrawal(Integer userId) {
        this.userId = userId;
    }

    public Withdrawal() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }



    @Override
    public String toString() {
        return "Withdrawal{" +
                "userId=" + userId +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                '}';
    }

    @Override
    protected void doExecute() throws Exception {

    }
}
