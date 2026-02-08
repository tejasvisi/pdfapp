package com.example.pdfapp.dao;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class NeetRequest {

	    private List<Neet> nirf;
	  
	    String userId;
	    String fileName;


}
