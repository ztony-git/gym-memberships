package com.pluralsight;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Membership henryClark = new Membership("Henry Clark", 3, new BigDecimal("30.00"));
        Membership aliceJohnson = new BasicMembership("Alice Johnson", 6, new BigDecimal("30.00"), true);
        Membership bobSmith = new BasicMembership("Bob Smith", 2, new BigDecimal("27.50"), false);
        PremiumMembership carolWhite = new PremiumMembership("Carol White", 12, new BigDecimal("30.00"), 2);
        PremiumMembership frankMiller = new PremiumMembership("Frank Miller", 3, new BigDecimal("30.00"), 0);
        FamilyMembership graceLee = new FamilyMembership("Grace Lee", 12, new BigDecimal("30.00"), 3);
        FamilyMembership emmaWatson =  new FamilyMembership("Emma Watson", 6, new BigDecimal("30.00"), 1);


        System.out.println("=== Gym Memberships ===");
        System.out.printf("%s, %d months, $%.2f per month%n", henryClark.getMemberName(), henryClark.getMonths(), henryClark.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", aliceJohnson.getMemberName(), aliceJohnson.getMonths(), aliceJohnson.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", bobSmith.getMemberName(), bobSmith.getMonths(), bobSmith.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", carolWhite.getMemberName(), carolWhite.getMonths(), carolWhite.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", frankMiller.getMemberName(), frankMiller.getMonths(), frankMiller.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", graceLee.getMemberName(), graceLee.getMonths(), graceLee.getMonthlyPrice());
        System.out.printf("%s, %d months, $%.2f per month%n", emmaWatson.getMemberName(), emmaWatson.getMonths(), emmaWatson.getMonthlyPrice());

        System.out.println("--- Guest passes ---");
        carolWhite.useGuestPass();
        carolWhite.useGuestPass();
        carolWhite.useGuestPass();
        frankMiller.useGuestPass();


        System.out.println("--- Sign-up fee and contract total ---");
        /*
        Carol White & Grace Lee have differing answers due to inheritance and method overwriting. PremiumMembership overwrites
        the getSignUpFee() method, where contracts > 12 months have no sign up fee. Since this is overwritten, when calling the
        getContractTotal() method of the PremiumClass, it will use its own getSignUpFee() rather than the parents.
         */
        System.out.printf("%s: fee $%.2f, total $%.2f%n", henryClark.getMemberName(), henryClark.getSignUpFee(), henryClark.getContractTotal());
        System.out.printf("%s: fee $%.2f, total $%.2f%n", carolWhite.getMemberName(), carolWhite.getSignUpFee(), carolWhite.getContractTotal());
        System.out.printf("%s: fee $%.2f, total $%.2f%n", frankMiller.getMemberName(), frankMiller.getSignUpFee(), frankMiller.getContractTotal());
        System.out.printf("%s: fee $%.2f, total $%.2f%n", graceLee.getMemberName(), graceLee.getSignUpFee(), graceLee.getContractTotal());
    }
}
