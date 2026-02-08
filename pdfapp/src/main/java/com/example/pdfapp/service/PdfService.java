package com.example.pdfapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pdfapp.dao.Neet;
import com.example.pdfapp.dao.Aktu;

@Service
public interface PdfService {
	
	// void addTableHeader(PdfPTable table);
	 
	// void addRows(PdfPTable table,List<Neet> result);
	 
	 byte[] createPDF(List<Neet> result); 
	 public byte[] createNeetPDF(List<Neet> result);
	 public byte[] createAktuPDF(List<Aktu> nirf,List<Aktu> placement,List<Aktu> recommended);
	// public byte[] generateConditionalPDF(String exam, List<?> entries);
	 
}