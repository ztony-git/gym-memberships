package com.pluralsight;

import java.math.BigDecimal;

public abstract class Membership {
    private String memberName;
    private int months;
    private BigDecimal baseRate;

    public Membership(String memberName, int months, BigDecimal baseRate) {
        this.memberName = memberName;
        this.months = months;
        this.baseRate = baseRate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    public abstract BigDecimal getMonthlyPrice();

    public BigDecimal getSignUpFee() {
        return new BigDecimal("49.00");
    }

    public BigDecimal getContractTotal() {
        return getMonthlyPrice().multiply(BigDecimal.valueOf(months)).add(getSignUpFee());
    }

    @Override
    public String toString() {
        return String.format("Membership | %s | %d months",  memberName, months);
    }
}
