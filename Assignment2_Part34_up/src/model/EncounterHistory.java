/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author admin
 */
public class EncounterHistory {
  
    
    private VitalSigns vitalSigns;
    private final LocalDateTime timeStamp = LocalDateTime.now();  
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
    String formattedDateTime = timeStamp.format(format); 

    public EncounterHistory(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }
    
    
    
}
