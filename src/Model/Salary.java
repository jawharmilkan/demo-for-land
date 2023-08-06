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
public class Salary 
{
    private String name; 
    private float salary, bonusAmount;

    public Salary(String name, float salary, float bonusAmount) {
        this.name = name;
        this.salary = salary;
        this.bonusAmount = bonusAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(float bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    @Override
    public String toString() {
        return "Salary{" + "name=" + name + ", salary=" + salary + ", bonusAmount=" + bonusAmount + '}';
    }
    
    
    
}
