package com.pluralsight;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Membership henryClark = new Membership("Henry Clark", 3, new BigDecimal("30.00"));
        Membership aliceJohnson = new BasicMembership("Alice Johnson", 6, new BigDecimal("30.00"), true);
        Membership bobSmith = new BasicMembership("Bob Smith", 2, new BigDecimal("27.50"), false);
        PremiumMembership carolWhite = new PremiumMembership("Carol White", 12, new BigDecimal("30.00"), 2);
        PremiumMembership frankMiller = new PremiumMembership("Frank Miller", 3, new BigDecimal("30.00"), 0);


        System.out.println("=== Gym Memberships ===");
        System.out.printf("%s, %d months, $%.2f per month%n", henryClark.getMemberName(), henryClark.getMonths(), henryClark.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", aliceJohnson.getMemberName(), aliceJohnson.getMonths(), aliceJohnson.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", bobSmith.getMemberName(), bobSmith.getMonths(), bobSmith.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", carolWhite.getMemberName(), carolWhite.getMonths(), carolWhite.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", frankMiller.getMemberName(), frankMiller.getMonths(), frankMiller.getMonthlyPrice());

        System.out.println("--- Guest passes ---");
        carolWhite.useGuestPass();
        carolWhite.useGuestPass();
        carolWhite.useGuestPass();
        frankMiller.useGuestPass();
    }
}
