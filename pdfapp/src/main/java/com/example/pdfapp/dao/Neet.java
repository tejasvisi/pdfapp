package com.example.pdfapp.dao;




import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor


public class Neet {
	
	private String id;
	private String QuotaName;
	private double AIR;
	private String Category;
	private String SubCategory;
	
	private int InstituteCode;
	private String Institute;
	private String Subject;
	private String AllottedCategory;
	private String Allottedph;
	private String AdmittedRound;

	
}


