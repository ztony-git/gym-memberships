package com.pluralsight;

import java.math.BigDecimal;

public class PremiumMembership extends Membership {
    private int guestPasses;

    public PremiumMembership(String memberName, int months, BigDecimal baseRate, int guestPasses) {
        super(memberName, months, baseRate);
        this.guestPasses = guestPasses;
    }

    @Override
    public BigDecimal getMonthlyPrice() {
        return getBaseRate().add(new BigDecimal("18.50"));
    }

    @Override
    public BigDecimal getSignUpFee() {
        return getMonths() >= 12 ? new BigDecimal("0.00") : super.getSignUpFee();
    }

    public void useGuestPass() {
        if (guestPasses <= 0) {
            System.out.printf("%s has no guest passes left%n", getMemberName());
            return;
        }

        System.out.printf("%s used a guest pass. Passes left: %d%n", getMemberName(), --guestPasses);
    }

    @Override
    public String toString() {
        return String.format("Premium | %s | %d months | guest passes: %d",  getMemberName(), getMonths(), guestPasses);
    }
}
