/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

/**
 *
 * @author jawhar
 */
public class Employee extends User {
    private String complain, salaryMonth, salaryTransactionMethod;
    private float salaryAmount, salaryBonus;
        
    public void fileComplain(TableView<Owner> memberTableView, TextArea complainTextArea) throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        
        File f =  null;
        
        FileWriter  fw = null;
        
        
        //unchecked exception
        
        try
        {
            f = new File("ComEmpGmComplains.txt");
        
        if(f.exists())
        {
            fw = new FileWriter(f,true); //APPEND MODE
        }
        else
        {
            fw = new FileWriter(f); //file creating
        }
        
        complain = complainTextArea.getText();
        
        //file created
        String str = memberTableView.getSelectionModel().getSelectedItem().getName() + "," + complain + "\n";
        fw.write(str); 

        a.setTitle("Complain");
        a.setHeaderText("Send successfull");
        a.setContentText("Complain has been filed successfully");
        a.showAndWait();
       
        
        
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
    
    
    

    
    
    public void getNotifiedAboutWorks(TableView<OngoingWork> ongoingWorksTableView) throws IOException {
        File f =  null;
        
        FileWriter  fw = null;
        
        //unchecked exception
        
        
        try
        {
            f = new File("empWorkStatus.txt");
        
        if(f.exists())
        {
            fw = new FileWriter(f,true); //APPEND MODE
        }
        else
        {
            fw = new FileWriter(f); //file ta creating
        }
        
        //file created
        
        OngoingWork o =   ongoingWorksTableView.getSelectionModel().getSelectedItem();
        
        String str =  o.toString()+ "," + "(Done)" + "\n";
        
       
        fw.write(str);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Work");
        a.setHeaderText("Done");
        a.setContentText("Work status updated");
        a.showAndWait();
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
