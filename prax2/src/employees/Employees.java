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

    public int pay(int workHours) {
        int totalPayment = 0;
        if (workHours > normalWorkHours) {
            if (seniority >= SENIORITY_PAY_THRESHOLD) {
                totalPayment += triplePay(workHours);
            } else {
                totalPayment += doublePay(workHours);
            }
        } else {
            totalPayment += payPerHour * workHours;
        }
        if (workHours > HERO_WORK_HOURS) {
            totalPayment += HERO_BASE_BONUS * seniority;
        }
        return totalPayment;
    }
}
