package com.pluralsight;

import java.math.BigDecimal;

public class FamilyMembership extends Membership{
    private int extraMembers;

    public FamilyMembership(String memberName, int months, BigDecimal baseRate, int extraMembers) {
        super(memberName, months, baseRate);
        this.extraMembers = extraMembers;
    }

    @Override
    public BigDecimal getMonthlyPrice() {
        BigDecimal familyBaseRate = getBaseRate().add(new BigDecimal("12.50").multiply(BigDecimal.valueOf(extraMembers)));

        return extraMembers >= 3 ? familyBaseRate.multiply(new BigDecimal("0.9")) : familyBaseRate;
    }
}
