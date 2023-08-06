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
public class Record {
    private String date, description, expense;

    public Record(String date, String description, String expense) {
        this.date = date;
        this.description = description;
        this.expense = expense;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpenses() {
        return expense;
    }

    public void setExpenses(String expense) {
        this.expense = expense;
    }

    @Override
    public String toString() {
        return date + "," + description + "," + expense + "\n";
    }
    
    
}
