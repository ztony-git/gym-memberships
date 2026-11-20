package com.pluralsight;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Membership membership = new Membership("Henry Clark", 3, new BigDecimal("30.00"));

        System.out.println("=== Gym Memberships ===");
        System.out.printf("%s, %d months, $%.2f per month%n", membership.getMemberName(), membership.getMonths(), membership.getBaseRate());
    }
}
