package employees;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chronoes on 10/20/15.
 */
public class EmployeesTest {
    @Test
    public void testJuniorPaymentNormalHours() throws Exception {
        assertEquals(Employees.Junior.payPerHour * 6, Employees.Junior.pay(6));
    }

    @Test
    public void testSeniorPaymentNormalHours() throws Exception {
        assertEquals(Employees.Senior.payPerHour * 3, Employees.Senior.pay(3));
    }

    @Test
    public void testSpecialistPaymentNormalHours() throws Exception {
        assertEquals(Employees.Specialist.payPerHour, Employees.Specialist.pay(1));
    }

    @Test
    public void testJuniorPaymentLongHours() throws Exception {
        assertEquals(Employees.Junior.doublePay(12), Employees.Junior.pay(12));
    }

    @Test
    public void testSeniorPaymentLongHours() throws Exception {
        assertEquals(Employees.Senior.doublePay(16), Employees.Senior.pay(16));
    }

    @Test
    public void testSpecialistPaymentLongHours() throws Exception {
        assertEquals(Employees.Specialist.triplePay(10), Employees.Specialist.pay(10));
    }

    @Test
    public void testJuniorPaymentWithHeroBonus() throws Exception {
        int expected = Employees.Junior.doublePay(30) + Employees.Junior.seniority * Employees.HERO_BASE_BONUS;
        assertEquals(expected, Employees.Junior.pay(30));
    }

    @Test
    public void testSeniorPaymentWithHeroBonus() throws Exception {
        int expected = Employees.Senior.doublePay(38) + Employees.Senior.seniority * Employees.HERO_BASE_BONUS;
        assertEquals(expected, Employees.Senior.pay(38));
    }

    @Test
    public void testSpecialistPaymentWithHeroBonus() throws Exception {
        int expected = Employees.Specialist.triplePay(25) + Employees.Specialist.seniority * Employees.HERO_BASE_BONUS;
        assertEquals(expected, Employees.Specialist.pay(25));
    }
}
