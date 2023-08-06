/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sakib
 */
public class EmployeePayment{
    private String employeeName, paymentStatus;


    public EmployeePayment(String employeeName, String paymentStatus) {
        this.employeeName = employeeName;
        this.paymentStatus = paymentStatus;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "EmployeePayment{" + "employeeName=" + employeeName + ", paymentStatus=" + paymentStatus + '}';
    }
   
}
