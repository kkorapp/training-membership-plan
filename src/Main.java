public class Main {
    public static void main(String[] args) {
        MembershipPlan[] plans = new MembershipPlan[] {
                new GymMembershipPlan("GYM-100", "Anna Kowalska", 3, 99.0, true, 12, false),
                new GymMembershipPlan("GYM-101", "Piotr Nowak", 6, 109.0, false, 18, true),
                new PersonalTrainingPlan("PT-200", "Marta Zielinska", 4, 140.0, true, 4, 2, false),
                new PersonalTrainingPlan("PT-201", "Jan Malinowski", 6, 150.0, false, 8, 3, true),
                new OnlineCoachingPlan("ONL-300", "Karolina Wisniewska", 6, 89.0, true, 2, true, true),
                new OnlineCoachingPlan("ONL-301", "Pawel Adamski", 3, 79.0, false, 1, false, true),
                new CorporateWellnessPlan("CORP-400", "TechNova Sp. z o.o.", 12, 350.0, true, 25, 2, true),
                new CorporateWellnessPlan("CORP-401", "SoftLine S.A.", 6, 320.0, false, 14, 0, false)
        };

        double totalMonthlyNet = 0.0;
        double totalMonthlyGross = 0.0;
        double totalContractNet = 0.0;

        System.out.println("=== MEMBERSHIP PLANS ===");

        for (MembershipPlan plan : plans) {
            plan.printSummary();

            totalMonthlyNet += plan.calculateMonthlyNetPrice();
            totalMonthlyGross += plan.calculateMonthlyGrossPrice();
            totalContractNet += plan.calculateTotalNetPrice();

            if (plan instanceof RemoteAccess) {
                RemoteAccess remoteAccess = (RemoteAccess) plan;
                System.out.println("Online access: " + remoteAccess.hasOnlineAccess());
            }

            if (plan instanceof Freezable) {
                Freezable freezable = (Freezable) plan;
                System.out.println("Can freeze: " + freezable.canFreeze());
            }

            System.out.println(plan);
            System.out.println("-----");
        }

        System.out.println("Total monthly net: " + totalMonthlyNet);
        System.out.println("Total monthly gross: " + totalMonthlyGross);
        System.out.println("Total contract net: " + totalContractNet);

        Billable billable = new OnlineCoachingPlan("ONL-999", "Test Client", 2, 70.0, true, 1, false, true);
        System.out.println("Billable net: " + billable.calculateMonthlyNetPrice());
        System.out.println("Billable gross: " + billable.calculateMonthlyGrossPrice());
    }
}
