/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author jawhar
 */
public class ExecutiveCommittee extends User{
    private String meetingDate, meetingType, meetingTime, meetingLocation, meetingLink, meetingSetBy, complainPriority, complainComments;

    public void setUpMeeting(String date,String type,String time,String location,String link,String setBy) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        File f = null;
        FileWriter fw = null;
        
        meetingDate = date;
        meetingType = type;
        meetingTime = time;
        meetingLocation = location;
        meetingLink = link;
        meetingSetBy = setBy;
        
        try 
        {
            f = new File("execComGmHrMeetingInfo.txt");
            
            fw = new FileWriter(f);
            
            String generatedString = meetingDate+","+ meetingType+","+meetingTime+","+meetingLocation+","+meetingLink+","+meetingSetBy+"\n";
           
            fw.write(generatedString);
            
            a.setTitle("Meeting");
            a.setHeaderText("Creation successfull");
            a.setContentText("Meeting has been set successfully");
            a.showAndWait();
  
        } 
        catch (IOException e) 
        {
            a.setTitle("Meeting");
            a.setHeaderText("Creation failure");
            a.setContentText("There has been an error");
            a.showAndWait();
        } 
        finally 
        {
            try 
            {
                if(fw != null)
                {
                    fw.close();
                }
            } 
            catch (IOException e) 
            {
                System.out.println(e);
            }
        }
    }
    
    public void participateInMeeting(TextField meetingDateTextField, TextField meetingTypeTextField, TextField meetingTimeTextField, TextField meetingLocationTextField, TextField meetingLinkTextField) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        File f = null;
        Scanner sc  = null;
        
        String str; String[] tokens;
        
        try
        {
            f = new File("execComGmHrMeetingInfo.txt");
            
            sc = new Scanner(f);
            
            if(f.exists())
            {
                
                while(sc.hasNextLine())
                {
                  str = sc.nextLine();
                    
                  tokens  = str.split(",");
                  meetingDate = tokens[0];
                  meetingType = tokens[1];
                  meetingTime = tokens[2];
                  meetingLocation = tokens[3];
                  meetingLink = tokens[4];
                  
                  
                  meetingDateTextField.setText(meetingDate);
                  meetingTypeTextField.setText(meetingType);
                  meetingTimeTextField.setText(meetingTime);
                  meetingLocationTextField.setText(meetingLocation);
                  meetingLinkTextField.setText(meetingLink);
                }
 
            }
            else
            {
                a.setTitle("Meeting");
                a.setHeaderText("Join failure");
                a.setContentText("File does not exist");
                a.showAndWait();
            }
            
             
            
            
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Exception  : "+e);
        } 
        finally{
            sc.close();
        }
        
        
    }
     
    public void accessAndSendFiledComplain(TableView<Complain> complainsTableView, String priority, String comments) throws IOException {
       complainPriority = priority;
       complainComments = comments;
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        
        File f =  null;
        
        FileWriter  fw = null;
        
        //unchecked exception
        
        try
        {
            f = new File("execComEmpGmSentComplain.txt");
        
        if(f.exists())
        {
            fw = new FileWriter(f,true); //APPEND MODE
        }
        else
        {
            fw = new FileWriter(f); //file creating
        }
        
        //file created
        
        String str = complainsTableView.getSelectionModel().getSelectedItem().toString() + "," + complainPriority + ","+ complainComments + "\n";
        fw.write(str); 

        a.setTitle("Complain");
        a.setHeaderText("Send successfull");
        a.setContentText("Complain has been sent successfully");
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
