package com.pluralsight;

import java.math.BigDecimal;

public class BasicMembership extends Membership{
    private boolean offPeakOnly;

    public BasicMembership(String memberName, int months, BigDecimal baseRate, boolean offPeakOnly) {
        super(memberName, months, baseRate);
        this.offPeakOnly = offPeakOnly;
    }

    public boolean isOffPeakOnly() {
        return offPeakOnly;
    }

    public void setOffPeakOnly(boolean offPeakOnly) {
        this.offPeakOnly = offPeakOnly;
    }

    @Override
    public BigDecimal getMonthlyPrice() {
        return offPeakOnly ? getBaseRate().subtract(new BigDecimal("5.00")) : getBaseRate();
    }

    @Override
    public String toString() {
        return String.format("Basic | %s | %d months | off-peak only: %s",  getMemberName(), getMonths(), offPeakOnly);
    }
}
