package com.mattleith.examplejdk14.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class AccountModification {
    @Id
    @GeneratedValue
    private Long id;

    private Long accountId;
    private BigDecimal changeAmount;

    public static class Builder {
        private AccountModification accountModificationEvent;

        public Builder() {
            this.accountModificationEvent = new AccountModification();
        }

        public Builder withAccountId(Long accountId) {
            this.accountModificationEvent.setAccountId(accountId);
            return this;
        }

        public Builder withChangeAmount(BigDecimal changeAmount) {
            this.accountModificationEvent.setChangeAmount(changeAmount);
            return this;
        }

        public AccountModification build() {
            return this.accountModificationEvent;
        }
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }
}
