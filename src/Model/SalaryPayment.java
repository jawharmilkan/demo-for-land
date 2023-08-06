/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jawhar
 */
public class SalaryPayment 
{
    protected String month, paidAmount, bonus, transactionMethod;

    
    public SalaryPayment(String month, String paidAmount, String bonus, String transactionMethod) {
        this.month = month;
        this.paidAmount = paidAmount;
        this.bonus = bonus;
        this.transactionMethod = transactionMethod;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getTransactionMethod() {
        return transactionMethod;
    }

    public void setTransactionMethod(String transactionMethod) {
        this.transactionMethod = transactionMethod;
    }

    @Override
    public String toString() {
        return "SalaryPayment{" + "month=" + month + ", paidAmount=" + paidAmount + ", bonus=" + bonus + ", transactionMethod=" + transactionMethod + '}';
    }

    
    
}
