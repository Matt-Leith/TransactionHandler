package com.mattleith.examplejdk14.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private Long fromAccountId;
    private Long toAccountId;
    private String description;
    private BigDecimal amount;

    public static class Builder {
        private Transaction transaction;

        public Builder() {
            this.transaction = new Transaction();
        }

        public Builder withFromAccountId(Long fromAccountId) {
            this.transaction.setFromAccountId(fromAccountId);
            return this;
        }

        public Builder withToAccountId(Long toAccountId) {
            this.transaction.setToAccountId(toAccountId);
            return this;
        }

        public Builder withDescription(String description) {
            this.transaction.setDescription(description);
            return this;
        }

        public Builder withAmount(BigDecimal amount) {
            this.transaction.setAmount(amount);
            return this;
        }

        public Transaction build() {
            return this.transaction;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
