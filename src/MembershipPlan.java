public abstract class MembershipPlan implements Billable {
    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    private static final double VAT = 0.23;

    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public String getPlanCode() { return planCode; }
    public String getClientName() { return clientName; }
    public int getMonths() { return months; }
    public double getBaseMonthlyFee() { return baseMonthlyFee; }
    public boolean isAutoRenew() { return autoRenew; }

    public abstract String getPlanType();

    @Override
    public abstract double calculateMonthlyNetPrice();

    @Override
    public double calculateMonthlyGrossPrice() {
        return round(calculateMonthlyNetPrice() * (1 + VAT));
    }

    public double calculateTotalNetPrice() {
        return round(calculateMonthlyNetPrice() * months);
    }

    public final void printSummary() {
        System.out.println("Code: " + planCode);
        System.out.println("Client: " + clientName);
        System.out.println("Type: " + getPlanType());
        System.out.println("Months: " + months);
        System.out.println("Net monthly: " + calculateMonthlyNetPrice());
        System.out.println("Gross monthly: " + calculateMonthlyGrossPrice());
        System.out.println("Total net: " + calculateTotalNetPrice());
    }

    protected double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "MembershipPlan{" +
                "code='" + planCode + '\'' +
                ", client='" + clientName + '\'' +
                ", months=" + months +
                '}';
    }
}
