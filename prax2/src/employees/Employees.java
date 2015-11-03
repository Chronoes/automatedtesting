package employees;

/**
 * Created by chronoes on 11/1/15.
 */
public enum Employees {
    Junior(8, 1, 10),
    Senior(8, 2, 15),
    Specialist(9, 3, 22);

    public static int HERO_BASE_BONUS = 10;
    public static int HERO_WORK_HOURS = 20;
    public static int SENIORITY_PAY_THRESHOLD = 3;

    public int normalWorkHours;
    public int seniority;
    public int payPerHour;

    Employees(int normalWorkHours, int seniority, int payPerHour) {
        this.normalWorkHours = normalWorkHours;
        this.seniority = seniority;
        this.payPerHour = payPerHour;
    }

    public int doublePay(int workHours) {
        return payPerHour * ( 2 * workHours - normalWorkHours);
    }

    public int triplePay(int workHours) {
        return payPerHour * ( 3 * workHours - normalWorkHours);
    }

    public int payForOvertime(int workHours) {
        return seniority >= SENIORITY_PAY_THRESHOLD ? triplePay(workHours) : doublePay(workHours);
    }

    public int payHeroBonus(int workHours) {
        return workHours > HERO_WORK_HOURS ? HERO_BASE_BONUS * seniority : 0;
    }

    public int pay(int workHours) {
        int totalPayment = workHours > normalWorkHours ? payForOvertime(workHours) : payPerHour * workHours;
        totalPayment += payHeroBonus(workHours);
        return totalPayment;
    }
}
