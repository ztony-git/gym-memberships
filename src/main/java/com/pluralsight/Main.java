package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //'Membership' is abstract; cannot be instantiated
//        Membership henryClark = new Membership("Henry Clark", 3, new BigDecimal("30.00"));
        BasicMembership aliceJohnson = new BasicMembership("Alice Johnson", 6, new BigDecimal("30.00"), true);
        BasicMembership bobSmith = new BasicMembership("Bob Smith", 2, new BigDecimal("27.50"), false);
        PremiumMembership carolWhite = new PremiumMembership("Carol White", 12, new BigDecimal("30.00"), 2);
        PremiumMembership frankMiller = new PremiumMembership("Frank Miller", 3, new BigDecimal("30.00"), 0);
        FamilyMembership graceLee = new FamilyMembership("Grace Lee", 12, new BigDecimal("30.00"), 3);
        FamilyMembership emmaWatson =  new FamilyMembership("Emma Watson", 6, new BigDecimal("30.00"), 1);

        ArrayList<Membership> memberships = new ArrayList<>();
//        memberships.add(henryClark);
        memberships.add(aliceJohnson);
        memberships.add(bobSmith);
        memberships.add(carolWhite);
        memberships.add(frankMiller);
        memberships.add(graceLee);
        memberships.add(emmaWatson);

        System.out.println("=== Gym Memberships ===");
        BigDecimal monthlyIncome = BigDecimal.ZERO;
        BigDecimal allContracts =  BigDecimal.ZERO;

        for (Membership membership : memberships) {
            System.out.println(membership);
            printCosts(membership);
            monthlyIncome = monthlyIncome.add(membership.getMonthlyPrice());
            allContracts = allContracts.add(membership.getContractTotal());
        }

        System.out.println("--- Totals ---");
        System.out.println("Memberships: " + memberships.size());
        System.out.printf("Monthly Income: $%.2f%n", monthlyIncome);
        System.out.printf("All Contracts: $%.2f%n", allContracts);

        System.out.println("--- Front desk notes ---");
        for (Membership membership : memberships) {
            if (membership instanceof BasicMembership) {
                if (((BasicMembership) membership).isOffPeakOnly()) {
                    System.out.printf("%s: entry between 10:00 and 16:00 only%n", membership.getMemberName());
                }
            } else if (membership instanceof PremiumMembership) {
                ((PremiumMembership) membership).useGuestPass();
            } else if (membership instanceof FamilyMembership) {
                System.out.printf("%s: prints %d key cards%n", membership.getMemberName(), ((FamilyMembership) membership).getExtraMembers() + 1);
            }
        }

        System.out.println("--- Kinds ---");
        for (Membership membership : memberships) {
            System.out.printf("%s: %s%n", membership.getMemberName(), membership.getClass().getSimpleName());
        }
    }
    public static void printCosts(Membership membership) {
        System.out.printf("\tMonthly Price: $%.2f, sign-up fee: $%.2f, contract total: $%.2f%n", membership.getMonthlyPrice(), membership.getSignUpFee(), membership.getContractTotal());
    }
}
