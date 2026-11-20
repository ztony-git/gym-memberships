package com.pluralsight;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Membership henryClark = new Membership("Henry Clark", 3, new BigDecimal("30.00"));
        Membership aliceJohnson = new BasicMembership("Alice Johnson", 6, new BigDecimal("30.00"), true);
        Membership bobSmith = new BasicMembership("Bob Smith", 2, new BigDecimal("27.50"), false);


        System.out.println("=== Gym Memberships ===");
        System.out.printf("%s, %d months, $%.2f per month%n", henryClark.getMemberName(), henryClark.getMonths(), henryClark.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", aliceJohnson.getMemberName(), aliceJohnson.getMonths(), aliceJohnson.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", bobSmith.getMemberName(), bobSmith.getMonths(), bobSmith.getMonthlyPrice());
    }
}
