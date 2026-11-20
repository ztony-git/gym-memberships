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
        System.out.println(henryClark);
        System.out.println(aliceJohnson);
        System.out.println(bobSmith);
        System.out.println(carolWhite);
        System.out.println(frankMiller);
        System.out.println(graceLee);
        System.out.println(emmaWatson);

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
