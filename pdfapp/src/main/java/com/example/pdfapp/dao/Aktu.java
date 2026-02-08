package com.example.pdfapp.dao;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Aktu {
  
    private String id;
    
    private String Institute;
    
    private String Program;
    
    private String Round;
   
    private String Quota;
   
    private String Category;
    
    private String Gender;
   
    private Integer OpeningRank;
   
    private Integer ClosingRank;

    // Getters and Setters
}
