public class OnlineCoachingPlan extends MembershipPlan implements RemoteAccess {
    private int videoConsultations;
    private boolean mealPlanIncluded;
    private boolean recordedLibraryAccess;

    public OnlineCoachingPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int videoConsultations, boolean mealPlanIncluded, boolean recordedLibraryAccess) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.videoConsultations = videoConsultations;
        this.mealPlanIncluded = mealPlanIncluded;
        this.recordedLibraryAccess = recordedLibraryAccess;
    }

    @Override
    public String getPlanType() {
        return "Online Coaching";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = getBaseMonthlyFee();

        price += videoConsultations * 45;

        if (mealPlanIncluded) price += 60;
        if (recordedLibraryAccess) price += 20;
        if (isAutoRenew()) price -= 12;

        return round(price);
    }

    @Override
    public boolean hasOnlineAccess() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", video=" + videoConsultations;
    }
}