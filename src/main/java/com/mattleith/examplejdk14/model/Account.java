package com.mattleith.examplejdk14.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    private Long accountId;

    private BigDecimal amount;

    public static class Builder {
        private Account account;

        public Builder() {
            this.account = new Account();
        }

        public Builder withAmount(BigDecimal amount) {
            this.account.setAmount(amount);
            return this;
        }

        public Builder withAccountId(Long accountId) {
            this.account.setAccountId(accountId);
            return this;
        }

        public Account build() {
            return this.account;
        }
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
