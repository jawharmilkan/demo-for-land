/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.TableView;

/**
 *
 * @author jawhar
 */
public class FinanceDepartment extends User{
    
    private String fcName, feesDetails, empName, empPaymentStatus;
    private float fcSalary, fcBonus;

    
    
    public void collectFunds(String details) throws IOException {
       feesDetails = details;
        File f =  null;
        
        FileWriter  fw = null;
        
        //unchecked exception
        
        
        try
        {
            f = new File("fcFeesCollection.txt");
        
        if(f.exists())
        {
            fw = new FileWriter(f,true); //APPEND MODE
        }
        else
        {
            fw = new FileWriter(f); //file creating
        }
        
        //file created
        
        String str = feesDetails+"\n";
        
       
        fw.write(str);
        
        
        }
        catch(IOException e)
        {
            System.out.println("Exception : "+e);
            
        }
        finally
        {
            fw.close();
        }
        
        
        
        
        
        
    }

    public void arrangeSalary(TableView<Salary> salaryTableView, String name, float salary, float bonus) 
    {
        fcName = name;
        fcSalary = salary;
        fcBonus = bonus;
        Salary s = new Salary(fcName,
                              fcSalary,
                              fcBonus
                              );
        salaryTableView.getItems().add(s);
        
        
        
        File f = null;
        FileWriter fw = null;
        try {
            f = new File("fcSalary.txt");
            //fw = new FileWriter(f);
            if(f.exists()) fw = new FileWriter(f,true);
            else fw = new FileWriter(f);
           
            fw.write(
            	name+","+salary+","+bonus+"\n"
            );           
  
        } catch (IOException ex) {
            //Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
            } catch (IOException ex) {
                //Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    public void paymentsDue(TableView<EmployeePayment> paymentTableView, String name, String status) throws IOException {
        empName = name;
        empPaymentStatus = status;
        
        File f =  null;
        
        FileWriter  fw = null;
        
        //unchecked exception
        
        paymentTableView.getItems().add(new EmployeePayment(empName,empPaymentStatus));
        
        
        
        try
        {
            f = new File("fcDuePayment.txt");
        
        if(f.exists())
        {
            fw = new FileWriter(f,true); //APPEND MODE
        }
        else
        {
            fw = new FileWriter(f); //file creating
        }
        
        //file created
        
        String str = empName+","+empPaymentStatus+"\n";
        
       
        fw.write(str);
        
       
        
        }
        catch(IOException e)
        {
            System.out.println("Exception : "+e);
            
        }
        finally
        {
            fw.close();
        }
    }
    
    
    
}
