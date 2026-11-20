package com.pluralsight;

import java.math.BigDecimal;

public class CorporateMembership extends Membership {
    private BigDecimal employerShare;

    public CorporateMembership(String memberName, int months, BigDecimal baseRate, BigDecimal employerShare) {
        super(memberName, months, baseRate);
        this.employerShare = employerShare;
    }

    @Override
    public BigDecimal getSignUpFee() {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getMonthlyPrice() {
        BigDecimal multiplier = BigDecimal.ONE.subtract(employerShare);
        return getBaseRate().multiply(multiplier);
    }

    @Override
    public String toString() {
        return String.format("Corporate | %s | %d months | employer share: %.2f",  getMemberName(), getMonths(), employerShare);
    }
}
