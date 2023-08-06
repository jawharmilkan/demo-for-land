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
public class Expense {
    private String sector, expense, month, year;

    public Expense(String sector, String expense, String month, String year) {
        this.sector = sector;
        this.expense = expense;
        this.month = month;
        this.year = year;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Expense{" + "sector=" + sector + ", expense=" + expense + ", month=" + month + ", year=" + year + '}';
    }
    
    
}
