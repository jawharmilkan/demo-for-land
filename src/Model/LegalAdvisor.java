/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;

/**
 *
 * @author jawhar
 */
public class LegalAdvisor extends User{

    private String complainID,meetingDate, meetingType, meetingTime, meetingLocation, meetingLink, meetingSetBy;
    public void seeProgress(String id) {
        this.complainID = id;
        Alert a = new Alert(Alert.AlertType.INFORMATION);
         a.setTitle("Complain");
         a.setHeaderText("Progress");
         a.setContentText("Complain "+ complainID+ " is going good");
         a.showAndWait();
    }

    public void setEmergencyMeeting(String date, String type, String time, String location, String link, String setBy) throws IOException {
        meetingDate = date;
        meetingType = type;
        meetingTime = time;
        meetingLocation = location;
        meetingLink = link;
        meetingSetBy = setBy;
        
        File f =  null;
        
        FileWriter  fw = null;
		
        String str = null;
        
        //unchecked exception
        
        
        try
        {
            f = new File("execComGmHrMeetingInfo.txt");
        
        if(f.exists())
        {
            fw = new FileWriter(f,true); //APPEND MODE
        }
        else
        {
            fw = new FileWriter(f); //file creating
        }
        
        //file created
        
        
            str =meetingDate+","+meetingType+","+meetingTime+","
                       +meetingLocation+","+meetingLink+","+meetingSetBy+"\n";
        
       
        
       
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
       
       
    
    

